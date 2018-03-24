package com.server.response;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class Response<T> {


	private List<T> data;
	private List<String> errors;
	

	public Response() {
		this.errors = new ArrayList<String>();
		this.data = new ArrayList<T>();
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
	
	public void setErrors(List<String> errors) {
		this.errors = errors;
	}

	public List<T> getData() {
		return data;
	}
	
	public void setData(List<T> list) {
			this.data = list;		
	}
	
	public void addData(T object) {
		if(data == null) {
			data = new ArrayList<T>();
			data.add(object);
		}else {
			data.add(object);
		}
	}
	
	public void addList(List<T> list) {
		
		if(data == null) {
			data = new ArrayList<T>();
			}
		
		for (int i = 0; i < list.size(); i++) {
			if( ! data.contains(list.get(i))) {
				data.add(list.get(i));
			}
		}
	}
	
	
	
}
