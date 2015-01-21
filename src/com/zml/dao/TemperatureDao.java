package com.zml.dao;

import java.util.ArrayList;
import java.util.Date;

import com.zml.model.Temperature;

public interface TemperatureDao extends BaseDao<Temperature>{
	ArrayList<Temperature> getTemperature(Date start, Date end, int nodeID, int page, int pageCount);
	int getTemperatureSize(Date start, Date end, int nodeID);
}
