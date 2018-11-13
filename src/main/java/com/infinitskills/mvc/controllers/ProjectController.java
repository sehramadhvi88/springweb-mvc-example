package com.infinitskills.mvc.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.infinitskills.mvc.data.entities.Project;
import com.infinitskills.mvc.data.services.ProjectService;
import com.infinitskills.mvc.data.validator.ProjectValidator;

@Controller
@RequestMapping("/project")
public class ProjectController {

	@Autowired
	private ProjectService projectService;
	
	@RequestMapping(value="/find/{projectId}")
	@ResponseBody
	public Project findProjectObject(@PathVariable("projectId") Long projectId){
		return this.projectService.find(projectId);
	}
	
	@RequestMapping(value="/{projectId}")
	public String findProject(Model model,@PathVariable Long projectId){
		model.addAttribute("project", this.projectService.find(projectId)); 
		return "project";
	}
	
	@RequestMapping("/find") 
	public String find(Model model){
		model.addAttribute("projects", this.projectService.findAll());
		return "projects";
	}
	
	@RequestMapping(value="/add" , method=RequestMethod.GET)
	public String addProject(HttpSession session,Model model){		
		session.setAttribute("token", "12345");
		List<String> types =  new ArrayList<>(Arrays.asList(new String[]{"","Single Year","Mutli Year"})); 
		model.addAttribute("types",types);
		model.addAttribute("project",new Project());
		System.out.println("invoking add project"); 
		return "project_add";
	}
	
	@InitBinder
	public void initBinder(WebDataBinder binder){
		binder.addValidators(new ProjectValidator());
	}

	@RequestMapping(value="/add" , method=RequestMethod.POST)
	public String saveProject(@RequestParam("name") String name,HttpServletRequest request, HttpSession session,
			@Valid @ModelAttribute Project project,BindingResult result,RedirectAttributes attribute){
		
		if(result.hasErrors()){
			System.out.println("project is not validated");
		}else{
			System.out.println("project is validated");
		}
		
		System.out.println("invoking save project");
		project.setProjectId(55L);
		projectService.saveProject(project);
		System.out.println(request.getParameter("name"));
		System.out.println("name using request param annotation:"+name); 
		System.out.println(session.getAttribute("token")); 
		System.out.println(project);
		// good approach is to redirect once we add any pbject 
		attribute.addAttribute("projectId", project.getProjectId().toString()); 
		//return "home";
		//return "redirect:/project/find";
		return "redirect:/";
	}
	
	@RequestMapping(value="/add" , method=RequestMethod.POST , params={"type=multi"})
	public String saveMultiYearProject(){
		System.out.println("invoking save multiyear project"); 
		return "project_add";
	}
	
	@RequestMapping(value="/add" , method=RequestMethod.POST , params={"type=multi","special"})
	public String saveSpecialProject(){
		System.out.println("invoking save special project"); 
		return "project_add";
	}
	
}
