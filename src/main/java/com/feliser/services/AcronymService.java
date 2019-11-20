package com.feliser.services;

import org.springframework.stereotype.Service;

import com.feliser.models.AcronymRequestModel;
import com.feliser.models.AcronymResponseModel;

@Service
public class AcronymService 
{
	public AcronymResponseModel createAcronym(AcronymRequestModel acronymRequest)
	{
		for (int i = 0; i < acronymRequest.request.size(); i++)
		{
			acronymRequest.request.set(i, acronymRequest.request.get(i) + "s");
		}
		
		return new AcronymResponseModel(acronymRequest.request);
	}
}