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
		return new AcronymResponseModel(generateAcronyms(acronymRequest.request));
	}

	public List<Acronym> generateAcronyms(List<String> terms) {
		// Acronym class contains the word and letters to bold on front end
		List<Acronym> acronyms = new ArrayList<Acronym>();
		List<Integer> boldIndices = new ArrayList<Integer>(); 
		// Load words list
		BufferedReader br = new BufferedReader(new InputStreamReader(getClass().getClassLoader().getResourceAsStream("words/corncob_caps.txt")));
		String word;

		try {
			while ((word = br.readLine()) != null) { // Loop through words
				int term = -1;
				int searchIndex = 0;
				int letterIndex = 0;
				boldIndices.clear(); // Get list ready for next word
				for (int i = 0; i < word.length(); i++) {
					if (term + 1 < terms.size()) { // if letter i of word is contained in the next term
						if (terms.get(term + 1).toUpperCase().indexOf(word.charAt(i)) != -1 ) {
							searchIndex = terms.get(term + 1).toUpperCase().indexOf(word.charAt(i)) + 1;
							boldIndices.add(letterIndex + searchIndex - 1); // stores the index of character that matched acronym
							letterIndex += terms.get(term + 1).length();
							term++;
						}
						else if (term > -1) { // if letter i of word is contained in the term starting from searchIndex
							if (terms.get(term).toUpperCase().indexOf(word.charAt(i), searchIndex) != -1 && term > -1) {
								searchIndex = terms.get(term).toUpperCase().indexOf(word.charAt(i), searchIndex) + 1;
								boldIndices.add(letterIndex + searchIndex - 1); // stores the index of character that matched acronym
							} else { break; }
						} else { break; }
					} else if (term > -1) {
						if (terms.get(term).toUpperCase().indexOf(word.charAt(i), searchIndex) != -1 && term > -1) {
							searchIndex = terms.get(term).toUpperCase().indexOf(word.charAt(i), searchIndex) + 1;
							boldIndices.add(letterIndex + searchIndex - 1); // stores the index of character that matched acronym
						} else { break; }
					} else { break; }
					if (i == word.length() - 1 && term == terms.size() - 1) { // acronym success
						acronyms.add(new Acronym(word, boldIndices));
						break;
					}
				}
			}
		} catch (IOException e) { e.printStackTrace(); }
		return acronyms;
	}
}