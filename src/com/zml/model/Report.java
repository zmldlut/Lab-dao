package com.zml.model;

import java.io.Serializable;

import com.zml.model.BaseModel;

public class Report extends BaseModel implements Serializable{

	private static final long serialVersionUID = -1137902727720230837L;
	private String stdNum;
	private String report;
	public String getStdNum() {
		return stdNum;
	}
	public void setStdNum(String stdNum) {
		this.stdNum = stdNum;
	}
	public String getReport() {
		return report;
	}
	public void setReport(String report) {
		this.report = report;
	}
}
