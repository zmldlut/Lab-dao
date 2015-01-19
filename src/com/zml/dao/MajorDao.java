package com.zml.dao;

import java.util.ArrayList;

import com.zml.model.Major;

public interface MajorDao extends BaseDao<Major>{
	ArrayList<Major> getMajors();
	String getNameFromID(int id);
	int getIDFromName(String name);
	int getMajorsSize();
}
