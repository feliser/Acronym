package com.feliser.models;

import java.util.List;

public class Acronym {
	String word;
	List<Integer> boldIndices; // Indices to be bolded on frontend for acronym breakdown

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