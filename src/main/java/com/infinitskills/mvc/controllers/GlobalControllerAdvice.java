package com.infinitskills.mvc.controllers;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.infinitskills.mvc.data.validator.ProjectValidator;

@ControllerAdvice(annotations=Controller.class)
public class GlobalControllerAdvice {

	@ModelAttribute("currentDate")
	public Date getCurrentDate(){
		return new Date();
	}
	
	
	@ExceptionHandler(NullPointerException.class)
	public String handleError(HttpServletRequest request){
		return "controller_error";
	}
}
