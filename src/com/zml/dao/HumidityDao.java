package com.zml.dao;

import java.util.ArrayList;
import java.util.Date;

import com.zml.model.Humidity;

public interface HumidityDao extends BaseDao<Humidity>{
	ArrayList<Humidity> getHumidity(Date start, Date end, int nodeID, int page, int pageCount);
	int getHumiditySize(Date start, Date end, int nodeID);
}
