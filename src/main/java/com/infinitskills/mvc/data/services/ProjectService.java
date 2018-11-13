package com.infinitskills.mvc.data.services;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import com.infinitskills.mvc.data.entities.Project;
import com.infinitskills.mvc.data.entities.Sponsor;

public class ProjectService {

	private List<Project> projects = new LinkedList<>();
	
	public ProjectService(){
		
		Project javaProject = this.createProject("Java Project" , "This is a java Project");
		Project javascriptProject = this.createProject("JavaScript Project" , "This is a javascript Project");
		Project htmlProject = this.createProject("HTML Project" , "This is a html Project");
		
		this.projects.addAll(Arrays.asList(new Project[]{javaProject,javascriptProject,htmlProject}));
	}
	
	public List<Project> findAll(){
		return this.projects;
	}
	
	public Project find(Long projectId){
		
		return this.projects.stream().filter( p -> {
			return p.getProjectId().equals(projectId);
		}).collect(Collectors.toList()).get(0);
		
	}
	
	private Project createProject(String title,String description){
		
		Project project = new Project();
		project.setName(title);
		project.setAuthorizedFunds(new BigDecimal("100000"));
		project.setAuthorizedHours(new BigDecimal("1000"));
		project.setProjectId(1L);
		project.setSpecial(false);
		project.setType("multi");
		project.setYear("2015");
		project.setDescription(description);
		project.setSponsor(new Sponsor("Oracle","555-555-555","test@gmail.com"));
		
		return project;
	}
	
	public Project saveProject(Project project){
		this.projects.add(project);
		return project;
	}
	
	
}
