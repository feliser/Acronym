package com.feliser.services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
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
		List<String> acronyms = new ArrayList<String>();
		
		//Get words list
		BufferedReader br = new BufferedReader(new InputStreamReader(getClass().getClassLoader().getResourceAsStream("words/corncob_caps.txt")));
		
		String word;
		int beginIndex;
		try {
			while ((word = br.readLine()) != null) {
				//Checks if characters for word appear in order in query
				beginIndex = -1;
				for(int i = 0; i < word.length(); i++)
				{
					System.out.println(word + " " + acronymRequest.request.get(0) + " " + beginIndex + " " + i);
					if((beginIndex = (acronymRequest.request.get(0).toUpperCase().indexOf(word.charAt(i), beginIndex + 1))) == -1)
					{
						break;
					}
					if(i == word.length() - 1)
					{
						acronyms.add(word);
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return acronyms;
	}
}