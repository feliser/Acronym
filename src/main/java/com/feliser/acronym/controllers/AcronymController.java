package com.feliser.acronym.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AcronymController {
	
	@GetMapping("/")
	public String index(){
		return "index";
	}
}