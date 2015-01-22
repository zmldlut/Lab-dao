package com.zml.dao.proxy;

import java.util.ArrayList;
import java.util.Date;

import com.zml.dao.CurtainDao;
import com.zml.dao.impl.CurtainDaoImpl;
import com.zml.dto.CurtainLamp;
import com.zml.model.CurtainRecord;

public class CurtainDaoProxy extends BaseDaoProxy implements CurtainDao{
	
	public CurtainDaoProxy() {
		super(CurtainDaoImpl.class);
	}

	@Override
	public boolean doCreate(CurtainRecord curtain) {
		boolean result = false;
		result = ((CurtainDaoImpl) dao).doCreate(curtain);
		connPool.returnConnection(this.conn);
		return result;
	}

	@Override
	public CurtainRecord findDao(CurtainRecord obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<CurtainLamp> getCurtains(Date start, Date end,
			String name, int nodeID, int page, int pageCount) {
		ArrayList<CurtainLamp> result = null;
		result = ((CurtainDaoImpl) dao).getCurtains(start, end, name, nodeID, page, pageCount);
		connPool.returnConnection(conn);
		return result;
	}

	@Override
	public int getCurtainSize(Date start, Date end, String name, int nodeID) {
		int result = 0;
		result = ((CurtainDaoImpl) dao).getCurtainSize(start, end, name, nodeID);
		connPool.returnConnection(conn);
		return result;
	}
}
