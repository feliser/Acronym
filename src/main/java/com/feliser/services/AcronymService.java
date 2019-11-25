package com.feliser.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.feliser.models.AcronymRequestModel;
import com.feliser.models.AcronymResponseModel;

@Service
public class AcronymService {
	public AcronymResponseModel createAcronym(AcronymRequestModel acronymRequest) {
		return new AcronymResponseModel(generateAcronyms(acronymRequest));
	}

	public List<String> generateAcronyms(AcronymRequestModel acronymRequest) {
		for (int i = 0; i < acronymRequest.request.size(); i++) {
			acronymRequest.request.set(i, acronymRequest.request.get(i) + "s");
		}
		
		return acronymRequest.request;
	}
}