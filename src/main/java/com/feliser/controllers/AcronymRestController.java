package com.feliser.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.feliser.models.AcronymRequestModel;
import com.feliser.models.AcronymResponseModel;
import com.feliser.services.AcronymService;

@RestController
public class AcronymRestController 
{
	@Autowired
	AcronymService acronymService;
	
	@PostMapping("/generate")
	@ResponseBody
	public AcronymResponseModel createAcronym(@RequestBody AcronymRequestModel acronymRequest)
	{
		return acronymService.createAcronym(acronymRequest);
	}
}
