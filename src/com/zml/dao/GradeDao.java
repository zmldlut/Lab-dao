package com.zml.dao;

import java.util.ArrayList;

import com.zml.model.Grade;

public interface GradeDao extends BaseDao<Grade>{
	ArrayList<Grade> getGrades();
	String getNameFromID(int id);
	int getIDFromName(String name);
	int getGradesSize();
}
