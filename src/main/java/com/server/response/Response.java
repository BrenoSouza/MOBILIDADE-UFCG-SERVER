package com.server.response;

import java.util.ArrayList;
import java.util.List;

import com.server.entities.Form;

public class Response<T> {

	private T data;
	private List<T> dataList;
	private List<String> errors;
	private List<String> success;
	

	public Response() {
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data; 
	}

	public List<String> getErrors() {		
		return errors;
	}

	public void addErrorsMessage(String errorMessage) {
		if (this.errors == null) {
			this.errors = new ArrayList<String>();
		}
		this.errors.add(errorMessage);
	}

	public List<T> getDataList() {
		return dataList;
	}
	
	public void setData(List<T> findAll) {
		//List<T> interSectList = new ArrayList<T>();
		if(dataList == null) {
			this.dataList = findAll;
			return;
		}else {
			for (int i = 0; i < findAll.size(); i++) {
				if(! dataList.contains(findAll.get(i))) {
					dataList.add(findAll.get(i));
				}				
			}
		}
		
		/*if(tipo) {
			
		}else {
			for (int i = 0; i < findAll.size(); i++) {
				if(dataList.contains(findAll.get(i))) {
					interSectList.add(findAll.get(i));
				}
			}
			this.dataList = interSectList;
		}
		*/
		
	}
	
	public List<String> getSuccess() {
		return this.success;
	}

	public void addSuccessMessage(String successMessage) {
		if(this.getSuccess() == null) {
			this.success =  new ArrayList<String>();
		}
		this.success.add(successMessage);
	}

}
