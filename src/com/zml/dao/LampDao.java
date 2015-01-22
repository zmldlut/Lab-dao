package com.zml.dao;

import java.util.ArrayList;
import java.util.Date;

import com.zml.dto.CurtainLamp;
import com.zml.model.LampRecord;

public interface LampDao extends BaseDao<LampRecord>{
	ArrayList<CurtainLamp> getLamps(Date start, Date end, String name, int nodeID, int page, int pageCount);
	int getLampSize(Date start, Date end, String name,int nodeID);
}
