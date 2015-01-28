package com.zml.dao;

import java.util.ArrayList;
import java.util.Date;

import com.zml.model.SgRecord;

public interface SiginDao extends BaseDao<SgRecord>{
	ArrayList<SgRecord> getSigins(Date start, Date end, String stdNum, int nodeID, int page, int pageCount);
	int getSiginsSize(Date start, Date end, String stdNum,int nodeID);
}
