package com.zml.dao;

import java.util.ArrayList;
import java.util.Date;

import com.zml.model.Light;

public interface LightDao extends BaseDao<Light>{
	ArrayList<Light> getLights(Date start, Date end, int nodeID, int page, int pageCount);
	int getLightSize(Date start, Date end, int nodeID);
}
