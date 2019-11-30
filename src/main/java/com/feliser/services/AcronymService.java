package com.feliser.services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.feliser.models.Acronym;
import com.feliser.models.AcronymRequestModel;
import com.feliser.models.AcronymResponseModel;

@Service
public class AcronymService {
	public AcronymResponseModel createAcronym(AcronymRequestModel acronymRequest) {
		return new AcronymResponseModel(generateAcronyms(acronymRequest));
	}

	public List<Acronym> generateAcronyms(AcronymRequestModel acronymRequest) {
		// Acronym class contains the word and letters to bold on front end
		List<Acronym> acronyms = new ArrayList<Acronym>();
		// Load words list
		BufferedReader br = new BufferedReader(new InputStreamReader(getClass().getClassLoader().getResourceAsStream("words/corncob_caps.txt")));
		String word;
		try {
			while ((word = br.readLine()) != null) { // Loop through words
				int term = -1;
				int searchIndex = 0;
				for (int i = 0; i < word.length(); i++) {
					if (term + 1 < acronymRequest.request.size()) { // if letter i of word is contained in the next term
						if (acronymRequest.request.get(term + 1).toUpperCase().indexOf(word.charAt(i)) != -1) {
							searchIndex = acronymRequest.request.get(term + 1).toUpperCase().indexOf(word.charAt(i), searchIndex) + 1;
							term++;
						}
						else if (term > -1) { // if letter i of word is contained in the term starting from searchIndex
							if (acronymRequest.request.get(term).toUpperCase().indexOf(word.charAt(i), searchIndex) != -1 && term > -1) {
								searchIndex = acronymRequest.request.get(term).toUpperCase().indexOf(word.charAt(i), searchIndex) + 1;
							} else { break; }
						} else { break; }
					} else if (term > -1) {
						if (acronymRequest.request.get(term).toUpperCase().indexOf(word.charAt(i), searchIndex) != -1 && term > -1) {
							searchIndex = acronymRequest.request.get(term).toUpperCase().indexOf(word.charAt(i), searchIndex) + 1;
						} else { break; }
					} else { break; }
					if (i == word.length() - 1 && term == acronymRequest.request.size() - 1) { // acronym success
						acronyms.add(new Acronym());
						break;
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return acronyms;
	}
}