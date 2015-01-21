package com.zml.dao.proxy;

import java.util.ArrayList;
import java.util.Date;

import com.zml.dao.PM2_5Dao;
import com.zml.dao.impl.PM2_5DaoImpl;
import com.zml.model.PM2_5;

public class PM2_5DaoProxy extends BaseDaoProxy implements PM2_5Dao{
	
	public PM2_5DaoProxy() {
		super(PM2_5DaoImpl.class);
	}

	@Override
	public boolean doCreate(PM2_5 pm) {
		boolean result = false;
		result = ((PM2_5DaoImpl) dao).doCreate(pm);
		connPool.returnConnection(this.conn);
		return result;
	}

	@Override
	public PM2_5 findDao(PM2_5 obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<PM2_5> getPM2_5(Date start, Date end, int nodeID,
			int page, int pageCount) {
		ArrayList<PM2_5> result = null;
		result = ((PM2_5DaoImpl) dao).getPM2_5(start, end, nodeID, page, pageCount);
		connPool.returnConnection(conn);
		return result;
	}

	@Override
	public int getPM2_5Size(Date start, Date end, int nodeID) {
		int result = 0;
		result = ((PM2_5DaoImpl) dao).getPM2_5Size(start, end, nodeID);
		connPool.returnConnection(conn);
		return result;
	}
}
