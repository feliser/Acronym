package com.feliser.services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.feliser.models.Acronym;
import com.feliser.models.AcronymRequestModel;
import com.feliser.models.AcronymResponseModel;

@Service
public class AcronymService {
	public AcronymResponseModel createAcronym(AcronymRequestModel acronymRequest) {
		return new AcronymResponseModel(generateAcronyms(acronymRequest.request));
	}

	public ArrayList<Acronym> generateAcronyms(ArrayList<String> terms) {
		ArrayList<Acronym> acronyms = new ArrayList<Acronym>();
		ArrayList<Integer> boldIndices = new ArrayList<Integer>(); 
		BufferedReader br = new BufferedReader(new InputStreamReader(getClass().getClassLoader().getResourceAsStream("words/corncob_caps.txt")));
		String word;
		try {
			while ((word = br.readLine()) != null) {
				int term = -1;
				int searchIndex = 0;
				int letterIndex = 0;
				boldIndices.clear();
				for (int i = 0; i < word.length(); i++) {
					if (term + 1 < terms.size()) {
							if (terms.get(term + 1).toUpperCase().indexOf(word.charAt(i)) != -1 ) {
							searchIndex = terms.get(term + 1).toUpperCase().indexOf(word.charAt(i)) + 1;
							boldIndices.add(letterIndex + searchIndex - 1 + (term + 1)); 
							letterIndex += terms.get(term + 1).length();
							term++;
						} else if (term > -1) {
							if (terms.get(term).toUpperCase().indexOf(word.charAt(i), searchIndex) != -1 && term > -1) {
								searchIndex = terms.get(term).toUpperCase().indexOf(word.charAt(i), searchIndex) + 1;
								boldIndices.add(letterIndex + searchIndex - 1 + (term + 1) - (terms.get(term).length() + 1));
							} else { break; }
						} else { break; }
					} else if (term > -1) {
						if (terms.get(term).toUpperCase().indexOf(word.charAt(i), searchIndex) != -1) {
							searchIndex = terms.get(term).toUpperCase().indexOf(word.charAt(i), searchIndex) + 1;
							boldIndices.add(letterIndex + searchIndex - 1 + (term + 1) - (terms.get(term).length() + 1));
						} else { break; }
					} else { break; }
					if (i == word.length() - 1 && term == terms.size() - 1) {
						acronyms.add(new Acronym(word, new ArrayList<Integer>(boldIndices)));
						break;
					}
				}
			}
		} catch (Exception e) { e.printStackTrace(); }
		return acronyms;
	}
}