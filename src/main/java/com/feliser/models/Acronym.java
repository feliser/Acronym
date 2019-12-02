package com.feliser.models;

import java.io.Serializable;
import java.util.ArrayList;

public class Acronym implements Serializable {
	private static final long serialVersionUID = 1L;
	public String word;
	public ArrayList<Integer> boldIndices; // Indices to be bolded on frontend for acronym breakdown

	public Acronym(String word, ArrayList<Integer> boldIndices) {
		setWord(word);
		setBoldIndices(boldIndices);
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public ArrayList<Integer> getBoldIndices() {
		return boldIndices;
	}

	public void setBoldIndices(ArrayList<Integer> boldIndices) {
		this.boldIndices = boldIndices;
	}
}