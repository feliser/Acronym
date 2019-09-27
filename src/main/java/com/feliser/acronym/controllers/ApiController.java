package com.feliser.acronym.controllers;

import java.util.Map;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController 
{
	@RequestMapping(value = "/api", method = RequestMethod.POST,consumes = "text/plain")
	public String getAcronym(@RequestBody String body)
	{
		return body;
	}
}
