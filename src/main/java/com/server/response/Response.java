package com.server.response;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class Response<T> {

	private Set<T> data;
	private List<String> errors;
	

	public Response() {
	}

	public List<String> getErrors() {		
		return errors;
	}

	public void addErrorMessage(String errorMessage) {
		if (this.errors == null) {
			this.errors = new ArrayList<String>();
		}
		this.errors.add(errorMessage);
	}

	public Set<T> getData() {
		return data;
	}
	
	public void setData(List<T> list) {
		if(data == null) {
			data = new HashSet<T>(list);
		}else {
			data.retainAll(list);
		}
		
	}
	
	public void setData(T object) {
		if(data == null) {
			data = new HashSet<T>();
			data.add(object);
		}else {
			data.add(object);
		}
				
	}

}
