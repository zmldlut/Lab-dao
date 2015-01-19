package com.zml.model;

import java.util.Date;

public class Temperature {
	private int id;
	private int node_id;
	private int temperature_value;
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
	public int getTemperature_value() {
		return temperature_value;
	}
	public void setTemperature_value(int temperature_value) {
		this.temperature_value = temperature_value;
	}
	public Date getAcq_time() {
		return acq_time;
	}
	public void setAcq_time(Date acq_time) {
		this.acq_time = acq_time;
	}
	
	public Temperature() {
		
	}
	
	public Temperature(int node_id, int temperature_value, Date acq_time) {
		this.node_id = node_id;
		this.temperature_value = temperature_value;
		this.acq_time = acq_time;
	}
}
