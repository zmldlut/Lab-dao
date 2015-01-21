package com.zml.model;

import java.util.Date;

public class Light {
	private int id;
	private int node_id;
	private int light_value;
	private Date acq_time;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getNode_id() {
		return node_id;
	}
	public void setNode_id(int node_id) {
		this.node_id = node_id;
	}
	public int getLight_value() {
		return light_value;
	}
	public void setLight_value(int light_value) {
		this.light_value = light_value;
	}
	public Date getAcq_time() {
		return acq_time;
	}
	public void setAcq_time(Date acq_time) {
		this.acq_time = acq_time;
	}
	
	public Light() {
		
	}
	
	public Light(int node_id, int light_value, Date acq_time) {
		this.node_id = node_id;
		this.light_value = light_value;
		this.acq_time = acq_time;
	}
}
