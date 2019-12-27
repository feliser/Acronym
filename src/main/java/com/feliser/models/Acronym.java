package com.feliser.models;

import java.io.Serializable;
import java.util.ArrayList;

public class Acronym implements Serializable, Comparable<Acronym> {
	private static final long serialVersionUID = 1L;
	public String word;
	public ArrayList<Integer> boldIndices; // Indices to be bolded on frontend for acronym breakdown
	public double score; // Rating on how well the acronym fits the terms

	public Acronym(String word, ArrayList<Integer> boldIndices, double score) {
		setWord(word);
		setBoldIndices(boldIndices);
		setScore(score);
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}

	public ArrayList<Integer> getBoldIndices() {
		return boldIndices;
	}

	public void setBoldIndices(ArrayList<Integer> boldIndices) {
		this.boldIndices = boldIndices;
	}

	public int compareTo(Acronym a) {
		return Double.compare(score, a.score); // Compares score values of 2 acronyms
	}
}