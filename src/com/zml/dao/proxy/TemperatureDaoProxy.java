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
	public ArrayList<Temperature> getTemperature(Date start, Date end, int nodeID, int page, int pageCount) {
		ArrayList<Temperature> result = null;
		result = ((TemperatureDao) super.dao).getTemperature(start, end, nodeID, page, pageCount);
		connPool.returnConnection(conn);
		return result;
	}

	@Override
	public int getTemperatureSize(Date start, Date end, int nodeID) {
		int result = 0;
		result = ((TemperatureDao) super.dao).getTemperatureSize(start, end, nodeID);
		connPool.returnConnection(conn);
		return result;
	}
}
