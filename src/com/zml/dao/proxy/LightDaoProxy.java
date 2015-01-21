package com.zml.dao.proxy;

import java.util.ArrayList;
import java.util.Date;

import com.zml.dao.LightDao;
import com.zml.dao.impl.LightDaoImpl;
import com.zml.model.Light;

public class LightDaoProxy extends BaseDaoProxy implements LightDao{
	
	public LightDaoProxy() {
		super(LightDaoImpl.class);
	}

	@Override
	public boolean doCreate(Light light) {
		boolean result = false;
		result = ((LightDaoImpl) dao).doCreate(light);
		connPool.returnConnection(this.conn);
		return result;
	}

	@Override
	public Light findDao(Light obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Light> getLights(Date start, Date end, int nodeID,
			int page, int pageCount) {
		ArrayList<Light> result = null;
		result = ((LightDaoImpl) dao).getLights(start, end, nodeID, page, pageCount);
		connPool.returnConnection(conn);
		return result;
	}

	@Override
	public int getLightSize(Date start, Date end, int nodeID) {
		int result = 0;
		result = ((LightDaoImpl) dao).getLightSize(start, end, nodeID);
		connPool.returnConnection(conn);
		return result;
	}
}
