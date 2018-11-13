package com.infinitskills.mvc.data.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.infinitskills.mvc.data.entities.Project;

public class ProjectValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return Project.class.equals(clazz); 
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		Project project = (Project) target;
		if(project.getName().length() <5){
			errors.rejectValue("name", "project.name", "project name length is less than 5");
		}
	}

}
