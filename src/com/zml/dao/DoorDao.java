package com.zml.dao;

import java.util.ArrayList;
import java.util.Date;

import com.zml.dto.Door;
import com.zml.model.DoorRecord;

public interface DoorDao extends BaseDao<DoorRecord>{
	ArrayList<Door> getDoors(Date start, Date end, String name, int nodeID, int page, int pageCount);
	int getDoorSize(Date start, Date end, String name,int nodeID);
}
