package com.feliser.models;

import java.util.List;

public class AcronymResponseModel {
	List<Acronym> response;

	public AcronymResponseModel(List<Acronym> response) {
		this.response = response;
	}

	public List<Acronym> getResponse() {
		return response;
	}

	public void setResponse(List<Acronym> response) {
		this.response = response;
	}
}