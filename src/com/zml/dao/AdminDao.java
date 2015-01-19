package com.zml.dao;

import java.util.ArrayList;

import com.zml.model.Admin;

public interface AdminDao extends BaseDao<Admin>{
	ArrayList<String> getNames();
	String getPasswordFromName(String name);
}
