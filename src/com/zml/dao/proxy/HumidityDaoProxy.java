package com.zml.dao.proxy;

import java.util.ArrayList;
import java.util.Date;

import com.zml.dao.HumidityDao;
import com.zml.dao.impl.HumidityDaoImpl;
import com.zml.model.Humidity;

public class HumidityDaoProxy extends BaseDaoProxy implements HumidityDao{
	
	public HumidityDaoProxy() {
		super(HumidityDaoImpl.class);
	}

	@Override
	public boolean doCreate(Humidity humidity) {
		boolean result = false;
		result = ((HumidityDaoImpl) dao).doCreate(humidity);
		connPool.returnConnection(this.conn);
		return result;
	}

	@Override
	public Humidity findDao(Humidity obj) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public ArrayList<Humidity> getHumidity() {
		ArrayList<Humidity> result = null;
		result = ((HumidityDao) super.dao).getHumidity();
		connPool.returnConnection(conn);
		return result;
	}

	@Override
	public ArrayList<Humidity> getHumidity(int page, int pageCount) {
		ArrayList<Humidity> result = null;
		result = ((HumidityDao) super.dao).getHumidity(page, pageCount);
		connPool.returnConnection(conn);
		return result;
	}

	@Override
	public ArrayList<Humidity> getHumidity(Date start, Date end,
			int page, int pageCount) {
		ArrayList<Humidity> result = null;
		result = ((HumidityDao) super.dao).getHumidity(start, end, page, pageCount);
		connPool.returnConnection(conn);
		return result;
	}

	@Override
	public ArrayList<Humidity> getHumidityFromNodeID(int nodeID,
			int page, int pageCount) {
		ArrayList<Humidity> result = null;
		result = ((HumidityDao) super.dao).getHumidityFromNodeID(nodeID, page, pageCount);
		connPool.returnConnection(conn);
		return result;
	}

	@Override
	public int getHumiditySize() {
		int result = 0;
		result = ((HumidityDao) super.dao).getHumiditySize();
		connPool.returnConnection(conn);
		return result;
	}

	@Override
	public int getHumiditySize(Date start, Date end) {
		int result = 0;
		result = ((HumidityDao) super.dao).getHumiditySize(start, end);
		connPool.returnConnection(conn);
		return result;
	}

	@Override
	public int getHumiditySize(Humidity Humidity) {
		int result = 0;
		result = ((HumidityDao) super.dao).getHumiditySize(Humidity);
		connPool.returnConnection(conn);
		return result;
	}

	@Override
	public int getHumiditySizeFromNodeID(int nodeID) {
		int result = 0;
		result = ((HumidityDao) super.dao).getHumiditySizeFromNodeID(nodeID);
		connPool.returnConnection(conn);
		return result;
	}
}
