package com.zml.dao;

import java.util.ArrayList;
import java.util.Date;

import com.zml.model.Humidity;

public interface HumidityDao extends BaseDao<Humidity>{
	ArrayList<Humidity> getHumidity();
	ArrayList<Humidity> getHumidity(int page, int pageCount);
	ArrayList<Humidity> getHumidity(Date start, Date end, int page, int pageCount);
	ArrayList<Humidity> getHumidityFromNodeID(int nodeID, int page, int pageCount);
	int getHumiditySize();
	int getHumiditySize(Date start, Date end);
	int getHumiditySize(Humidity Humidity);
	int getHumiditySizeFromNodeID(int nodeID);
}
