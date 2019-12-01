package com.feliser.models;

import java.util.List;

public class Acronym {
	String word;
	List<Integer> boldIndices; // Indices to be bolded on frontend for acronym breakdown

	public Acronym(String word, List<Integer> boldIndices) {
		this.word = word;
		this.boldIndices = boldIndices;
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public List<Integer> getBoldIndices() {
		return boldIndices;
	}

	public void setBoldIndices(List<Integer> boldIndices) {
		this.boldIndices = boldIndices;
	}
}