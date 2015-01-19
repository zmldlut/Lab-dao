package com.zml.dao.proxy;

import java.util.ArrayList;
import java.util.Date;

import com.zml.dao.TemperatureDao;
import com.zml.dao.impl.TemperatureDaoImpl;
import com.zml.model.Temperature;

public class TemperatureDaoProxy extends BaseDaoProxy implements TemperatureDao{
	
	public TemperatureDaoProxy() {
		super(TemperatureDaoImpl.class);
	}

	@Override
	public boolean doCreate(Temperature temperature) {
		boolean result = false;
		result = ((TemperatureDaoImpl) dao).doCreate(temperature);
		connPool.returnConnection(this.conn);
		return result;
	}

	@Override
	public Temperature findDao(Temperature obj) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public ArrayList<Temperature> getTemperature() {
		ArrayList<Temperature> result = null;
		result = ((TemperatureDao) super.dao).getTemperature();
		connPool.returnConnection(conn);
		return result;
	}

	@Override
	public ArrayList<Temperature> getTemperature(int page, int pageCount) {
		ArrayList<Temperature> result = null;
		result = ((TemperatureDao) super.dao).getTemperature(page, pageCount);
		connPool.returnConnection(conn);
		return result;
	}

	@Override
	public ArrayList<Temperature> getTemperature(Date start, Date end,
			int page, int pageCount) {
		ArrayList<Temperature> result = null;
		result = ((TemperatureDao) super.dao).getTemperature(start, end, page, pageCount);
		connPool.returnConnection(conn);
		return result;
	}

	@Override
	public ArrayList<Temperature> getTemperatureFromNodeID(int nodeID,
			int page, int pageCount) {
		ArrayList<Temperature> result = null;
		result = ((TemperatureDao) super.dao).getTemperatureFromNodeID(nodeID, page, pageCount);
		connPool.returnConnection(conn);
		return result;
	}

	@Override
	public int getTemperatureSize() {
		int result = 0;
		result = ((TemperatureDao) super.dao).getTemperatureSize();
		connPool.returnConnection(conn);
		return result;
	}

	@Override
	public int getTemperatureSize(Date start, Date end) {
		int result = 0;
		result = ((TemperatureDao) super.dao).getTemperatureSize(start, end);
		connPool.returnConnection(conn);
		return result;
	}

	@Override
	public int getTemperatureSize(Temperature temperature) {
		int result = 0;
		result = ((TemperatureDao) super.dao).getTemperatureSize(temperature);
		connPool.returnConnection(conn);
		return result;
	}

	@Override
	public int getTemperatureSizeFromNodeID(int nodeID) {
		int result = 0;
		result = ((TemperatureDao) super.dao).getTemperatureSizeFromNodeID(nodeID);
		connPool.returnConnection(conn);
		return result;
	}
}
