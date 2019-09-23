package com.feliser.acronym.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import models.WordsModel;

@RestController
public class ApiController 
{
	@PostMapping("/api/")
	public ResponseEntity<WordsModel> getAcronym(@RequestBody WordsModel words)
	{
		return new ResponseEntity<WordsModel>(words, HttpStatus.OK);
	}
}
