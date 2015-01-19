package com.zml.dao.proxy;

import java.util.ArrayList;

import com.zml.dao.MajorDao;
import com.zml.dao.impl.MajorDaoImpl;
import com.zml.model.Major;

public class MajorDaoProxy extends BaseDaoProxy implements MajorDao{
	
	public MajorDaoProxy() {
		super(MajorDaoImpl.class);
	}
	@Override
	public ArrayList<Major> getMajors() {
		ArrayList<Major> result = null;
		result = ((MajorDaoImpl) super.dao).getMajors();
		connPool.returnConnection(conn);
		return result;
	}


	@Override
	public String getNameFromID(int id) {
		String result = null;
		result = ((MajorDaoImpl) super.dao).getNameFromID(id);
		connPool.returnConnection(conn);
		return result;
	}

	@Override
	public int getIDFromName(String name) {
		int result = -1;
		result = ((MajorDaoImpl) super.dao).getIDFromName(name);
		connPool.returnConnection(conn);
		return result;
	}

	@Override
	public int getMajorsSize() {
		int result = 0;
		result = ((MajorDaoImpl) super.dao).getMajorsSize();
		connPool.returnConnection(conn);
		return result;
	}
	@Override
	public boolean doCreate(Major obj) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public Major findDao(Major obj) {
		// TODO Auto-generated method stub
		return null;
	}

}
