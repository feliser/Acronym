package com.feliser.models;

import java.util.ArrayList;
import java.util.List;

public class AcronymResponseModel {
	public ArrayList<Acronym> response;

	public AcronymResponseModel(ArrayList<Acronym> response) {
		this.response = response;
	}

	public List<Acronym> getResponse() {
		return response;
	}

	public void setResponse(ArrayList<Acronym> response) {
		this.response = response;
	}
}