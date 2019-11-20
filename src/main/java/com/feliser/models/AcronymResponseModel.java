package com.feliser.models;

import java.util.List;

public class AcronymResponseModel {
	List<String> response;

	public AcronymResponseModel(List<String> response) {
		this.response = response;
	}

	public List<String> getResponse() {
		return response;
	}

	public void setResponse(List<String> response) {
		this.response = response;
	}

}
