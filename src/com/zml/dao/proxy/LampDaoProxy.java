package com.zml.dao.proxy;

import java.util.ArrayList;
import java.util.Date;

import com.zml.dao.LampDao;
import com.zml.dao.impl.LampDaoImpl;
import com.zml.dto.CurtainLamp;
import com.zml.model.LampRecord;

public class LampDaoProxy extends BaseDaoProxy implements LampDao{
	
	public LampDaoProxy() {
		super(LampDaoImpl.class);
	}

	@Override
	public boolean doCreate(LampRecord lamp) {
		boolean result = false;
		result = ((LampDaoImpl) dao).doCreate(lamp);
		connPool.returnConnection(this.conn);
		return result;
	}

	@Override
	public LampRecord findDao(LampRecord obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<CurtainLamp> getLamps(Date start, Date end, String name,
			int nodeID, int page, int pageCount) {
		ArrayList<CurtainLamp> result = null;
		result = ((LampDaoImpl) dao).getLamps(start, end, name, nodeID, page, pageCount);
		connPool.returnConnection(conn);
		return result;
	}

	@Override
	public int getLampSize(Date start, Date end, String name, int nodeID) {
		int result = 0;
		result = ((LampDaoImpl) dao).getLampSize(start, end, name, nodeID);
		connPool.returnConnection(conn);
		return result;
	}
}
