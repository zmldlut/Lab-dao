package com.zml.model;

import java.io.Serializable;

import com.zml.model.BaseModel;

public class Device extends BaseModel implements Serializable{

	private static final long serialVersionUID = -1809975616660400794L;
	private String id;
	private String name;
	private String type;
	private String service_tag;
	private int status;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getService_tag() {
		return service_tag;
	}
	public void setService_tag(String service_tag) {
		this.service_tag = service_tag;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
}
