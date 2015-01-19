package com.zml.dao;

import java.util.ArrayList;

import com.zml.model.NodeType;


public interface NodeTypeDao extends BaseDao<NodeType>{
	ArrayList<NodeType> getTypes();
}
