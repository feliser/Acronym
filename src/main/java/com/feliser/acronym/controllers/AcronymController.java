package com.feliser.acronym.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class AcronymController {
	
	@GetMapping("/")
	public String index(){
		return "index";
	}
}