package com.zml.dao.proxy;

import java.util.ArrayList;
import java.util.Date;

import com.zml.dao.DoorDao;
import com.zml.dao.impl.DoorDaoImpl;
import com.zml.dto.Door;
import com.zml.model.DoorRecord;

public class DoorDaoProxy extends BaseDaoProxy implements DoorDao{
	
	public DoorDaoProxy() {
		super(DoorDaoImpl.class);
	}
	
	@Override
	public boolean doCreate(DoorRecord record) {
		boolean result = false;
		result = ((DoorDaoImpl) dao).doCreate(record);
		connPool.returnConnection(this.conn);
		return result;
	}

	@Override
	public DoorRecord findDao(DoorRecord obj) {
		return null;
	}

	@Override
	public ArrayList<Door> getDoors(Date start, Date end, String name,
			int nodeID, int page, int pageCount) {
		ArrayList<Door> result = null;
		result = ((DoorDaoImpl) dao).getDoors(start, end, name, nodeID, page, pageCount);
		connPool.returnConnection(conn);
		return result;
	}

	@Override
	public int getDoorSize(Date start, Date end, String name, int nodeID) {
		int result = 0;
		result = ((DoorDaoImpl) dao).getDoorSize(start, end, name, nodeID);
		connPool.returnConnection(conn);
		return result;
	}

}
