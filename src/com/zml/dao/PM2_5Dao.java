package com.zml.dao;

import java.util.ArrayList;
import java.util.Date;

import com.zml.model.PM2_5;

public interface PM2_5Dao extends BaseDao<PM2_5>{
	ArrayList<PM2_5> getPM2_5(Date start, Date end, int nodeID, int page, int pageCount);
	int getPM2_5Size(Date start, Date end, int nodeID);
}
