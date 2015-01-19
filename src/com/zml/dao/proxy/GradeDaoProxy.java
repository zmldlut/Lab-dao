package com.zml.dao.proxy;

import java.util.ArrayList;

import com.zml.dao.GradeDao;
import com.zml.dao.impl.GradeDaoImpl;
import com.zml.model.Grade;

public class GradeDaoProxy extends BaseDaoProxy implements GradeDao{
	
	public GradeDaoProxy() {
		super(GradeDaoImpl.class);
	}

	@Override
	public String getNameFromID(int id) {
		String result = null;
		result = ((GradeDaoImpl) super.dao).getNameFromID(id);
		connPool.returnConnection(conn);
		return result;
	}

	@Override
	public int getIDFromName(String name) {
		int result = -1;
		result = ((GradeDaoImpl) super.dao).getIDFromName(name);
		connPool.returnConnection(conn);
		return result;
	}

	@Override
	public ArrayList<Grade> getGrades() {
		ArrayList<Grade> result = null;
		result = ((GradeDaoImpl) super.dao).getGrades();
		connPool.returnConnection(conn);
		return result;
	}
	
	@Override
	public int getGradesSize() {
		int result = 0;
		result = ((GradeDaoImpl) super.dao).getGradesSize();
		connPool.returnConnection(conn);
		return result;
	}

	@Override
	public boolean doCreate(Grade obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Grade findDao(Grade obj) {
		// TODO Auto-generated method stub
		return null;
	}

}
