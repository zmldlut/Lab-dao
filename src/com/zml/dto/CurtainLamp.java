package com.zml.dto;

import java.util.Date;

import com.zml.model.BaseModel;

public class CurtainLamp extends BaseModel {
	private static final long serialVersionUID = 8456309279799152980L;
	private int id;
	private String stdNum;
	private String stdName;
	private Date operate_date;
	private int node_id;
	private String nodeName;
	private int operate;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getStdNum() {
		return stdNum;
	}
	public void setStdNum(String stdNum) {
		this.stdNum = stdNum;
	}
	public String getStdName() {
		return stdName;
	}
	public void setStdName(String stdName) {
		this.stdName = stdName;
	}
	public Date getOperate_date() {
		return operate_date;
	}
	public void setOperate_date(Date operate_date) {
		this.operate_date = operate_date;
	}
	public int getNode_id() {
		return node_id;
	}
	public void setNode_id(int node_id) {
		this.node_id = node_id;
	}
	public String getNodeName() {
		return nodeName;
	}
	public void setNodeName(String nodeName) {
		this.nodeName = nodeName;
	}
	public int getOperate() {
		return operate;
	}
	public void setOperate(int operate) {
		this.operate = operate;
	}
}
