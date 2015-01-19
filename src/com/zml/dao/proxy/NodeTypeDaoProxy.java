package com.zml.dao.proxy;

import java.util.ArrayList;

import com.zml.dao.NodeTypeDao;
import com.zml.dao.impl.NodeTypeDaoImpl;
import com.zml.model.NodeType;

public class NodeTypeDaoProxy extends BaseDaoProxy implements NodeTypeDao{
	
	public NodeTypeDaoProxy() {
		super(NodeTypeDaoImpl.class);
	}

	@Override
	public boolean doCreate(NodeType obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public NodeType findDao(NodeType obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<NodeType> getTypes() {
		ArrayList<NodeType> result = null;
		result = ((NodeTypeDaoImpl) super.dao).getTypes();
		connPool.returnConnection(conn);
		return result;
	}
}
