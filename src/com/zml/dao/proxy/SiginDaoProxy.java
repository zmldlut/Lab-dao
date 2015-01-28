package com.zml.dao.proxy;

import java.util.ArrayList;
import java.util.Date;

import com.zml.dao.SiginDao;
import com.zml.dao.impl.CurtainDaoImpl;
import com.zml.dao.impl.SiginDaoImpl;
import com.zml.model.SgRecord;

public class SiginDaoProxy extends BaseDaoProxy implements SiginDao{

	public SiginDaoProxy() {
		super(SiginDaoImpl.class);
	}
	
	@Override
	public boolean doCreate(SgRecord record) {
		boolean result = false;
		result = ((SiginDaoImpl)dao).doCreate(record);
		connPool.returnConnection(this.conn);
		return result;
	}

	@Override
	public SgRecord findDao(SgRecord obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<SgRecord> getSigins(Date start, Date end, String stdNum,
			int nodeID, int page, int pageCount) {
		// TODO Auto-generated method stub
		ArrayList<SgRecord> result = null;
		result = ((SiginDaoImpl) dao).getSigins(start, end, stdNum, nodeID, page, pageCount);
		connPool.returnConnection(conn);
		return result;
	}

	@Override
	public int getSiginsSize(Date start, Date end, String stdNum, int nodeID) {
		// TODO Auto-generated method stub
		int result = 0;
		result = ((SiginDaoImpl) dao).getSiginsSize(start, end, stdNum, nodeID);
		connPool.returnConnection(conn);
		return result;
	}

}
