package com.infinitskills.mvc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.infinitskills.mvc.data.entities.Project;
import com.infinitskills.mvc.data.entities.Sponsor;
import com.infinitskills.mvc.data.services.ProjectService;

@Controller
public class HomeController {

	@Autowired
	ProjectService projectService;
	
	@RequestMapping("/home")
	public String goHome(Model model){
		
		Project project = new Project();
		project.setName("First Project");
		project.setSponsor(new Sponsor("NASA","555-555-555","nasa@nasa.com"));
		project.setDescription("this is a simple project sponsored by NASA	");
		
		model.addAttribute("currentProject", project);
		
		return "welcome";
	}
	
	@RequestMapping(value="/",params="projectId")
	public String goHomeAgain(Model model,@RequestParam("projectId") Long projectId){
		model.addAttribute("currentProject",this.projectService.find(projectId));
		return "home";
	}
	
}


