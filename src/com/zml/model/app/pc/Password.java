package com.zml.model.app.pc;

import java.io.Serializable;

import com.zml.model.BaseModel;

public class Password extends BaseModel implements Serializable{
	private static final long serialVersionUID = -1794901974320754607L;
	private String configPass;
	private String newPass;
	private String oldPass;
	private String stdNum;
    public String getConfigPass() {
		return configPass;
	}
    public String getNewPass() {
		return newPass;
	}
	public String getOldPass() {
		return oldPass;
	}
	public String getStdNum() {
		return stdNum;
	}
	public void setConfigPass(String configPass) {
		this.configPass = configPass;
	}
	public void setNewPass(String newPass) {
		this.newPass = newPass;
	}
	public void setOldPass(String oldPass) {
		this.oldPass = oldPass;
	}
	public void setStdNum(String stdNum) {
		this.stdNum = stdNum;
	}
}
