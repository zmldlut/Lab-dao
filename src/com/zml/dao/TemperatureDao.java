package com.zml.dao;

import java.util.ArrayList;
import java.util.Date;

import com.zml.model.Temperature;

public interface TemperatureDao extends BaseDao<Temperature>{
	ArrayList<Temperature> getTemperature();
	ArrayList<Temperature> getTemperature(int page, int pageCount);
	ArrayList<Temperature> getTemperature(Date start, Date end, int page, int pageCount);
	ArrayList<Temperature> getTemperatureFromNodeID(int nodeID, int page, int pageCount);
	int getTemperatureSize();
	int getTemperatureSize(Date start, Date end);
	int getTemperatureSize(Temperature temperature);
	int getTemperatureSizeFromNodeID(int nodeID);
}
