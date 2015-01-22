package com.zml.dao;

import java.util.ArrayList;
import java.util.Date;

import com.zml.dto.CurtainLamp;
import com.zml.model.CurtainRecord;

public interface CurtainDao extends BaseDao<CurtainRecord>{
	ArrayList<CurtainLamp> getCurtains(Date start, Date end, String name, int nodeID, int page, int pageCount);
	int getCurtainSize(Date start, Date end, String name,int nodeID);
}
