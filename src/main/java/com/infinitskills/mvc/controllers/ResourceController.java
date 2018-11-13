package com.infinitskills.mvc.controllers;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;

import com.infinitskills.mvc.data.entities.Resource;
import com.infinitskills.mvc.data.services.ResourceService;

@Controller
@RequestMapping("/resource")
@SessionAttributes("resource")
public class ResourceController {

	@Autowired
	ResourceService service;
	
	@RequestMapping("/add")
	public String add(Model model){
		List<String> options = new LinkedList<>(Arrays.asList(new String[]{
				"Material","Other","Staff","Technical Equipment"
		}));
		
		/*List<String> radios = new LinkedList<>(Arrays.asList(new String[]{
				"Hours","Piece","Tons"
		}));*/
		
		/*List<String> checks = new LinkedList<>(Arrays.asList(new String[]{
				"Lead Time","Special Rate","Requires Approval"
		}));*/
		
		//model.addAttribute("radioOptions",radios);
		//model.addAttribute("checkOptions",checks);
		model.addAttribute("typeOptions",options); 
		//model.addAttribute("resource", new Resource());
		
		/*if(1==1){ 
			throw new RuntimeException("there was an error");
		} */  
		
		return "resource_add";
	}
	
	@RequestMapping("/test")
	public String testError(){
		String test=null;
		if(test == null){
			throw new NullPointerException();
		}
		return "resource_add";
	}
	
	/*@ExceptionHandler(NullPointerException.class)
	public String handleError(HttpServletRequest request){
		return "controller_error";
	}*/
	
	
	@RequestMapping("/{resourceId}")
	@ResponseBody
	public Resource findResource(@PathVariable("resourceId") Long resourceId){
		return service.find(resourceId);
	}
	
	@RequestMapping("/find")
	public String find(Model model){
		model.addAttribute("resources",service.findAll());
		return "resources";
	}
	
	@RequestMapping("/request")
	@ResponseBody
	public String request(@RequestBody String resource){
		System.out.println("invoking request method");
		System.out.println(resource); 
		return "request has been sent for approval";
	}
	
	@RequestMapping("/review")
	public String review(@ModelAttribute Resource resource){
		System.out.println("invoking review method");
		System.out.println(resource); 
		return "resource_review";
	}
	
	
	@RequestMapping("/save")
	public String save(@ModelAttribute Resource resource,SessionStatus status){
		System.out.println("invoking save method");
		System.out.println(resource); 
		status.setComplete();
		return "redirect:/resource/add";
	}
	
	@RequestMapping(value="/upload",method=RequestMethod.POST)
	@ResponseBody
	public String handleUpload(@RequestParam("file") MultipartFile file){
		
		if(!file.isEmpty()){
			return "file size is :"+file.getSize();
		}
		
		return "There is some problem";
	}
	
	@ModelAttribute("resource")
	public Resource getResource(){
		System.out.println("adding a new resource to model");
		return new Resource();
	}
	
	@ModelAttribute("radioOptions")
	public List<String> getRadios(){
		return new LinkedList<>(Arrays.asList(new String[]{
				"Hours","Piece","Tons"
		}));
	}
	
	@ModelAttribute("checkOptions")
	public List<String> getChecks(){
		return new LinkedList<>(Arrays.asList(new String[]{
				"Lead Time","Special Rate","Requires Approval"
		}));
	}
	
}
