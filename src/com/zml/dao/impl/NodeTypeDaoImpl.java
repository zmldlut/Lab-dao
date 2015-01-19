package com.zml.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.zml.dao.NodeTypeDao;
import com.zml.model.NodeType;

public class NodeTypeDaoImpl extends BaseDaoImpl implements NodeTypeDao{

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
		ArrayList<NodeType> result = new ArrayList<NodeType>();
		String sql = "select * from node_type";
		try {
			this.pstmt = this.conn.prepareStatement(sql);
			ResultSet rs = this.pstmt.executeQuery();
			while(rs.next()){
				NodeType type = new NodeType();
				type.setId(rs.getInt(1));
				type.setType(rs.getString(2));
				result.add(type);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			try{
				this.pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}

}
