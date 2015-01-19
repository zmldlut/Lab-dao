package com.zml.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.zml.dao.NodeDao;
import com.zml.model.Node;

public class NodeDaoImpl extends BaseDaoImpl implements NodeDao{

	@Override
	public Node findDao(Node obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Node> getNodes(int type, int page, int pageCount) {
		ArrayList<Node> result = new ArrayList<Node>();
		String sql = "select * from node";
		
		try {
			if (type >= 0) {
				sql += " where type = ? ORDER BY stdnum asc LIMIT ?,?";
				this.pstmt = this.conn.prepareStatement(sql);
				this.pstmt.setInt(1, type);
				this.pstmt.setInt(2, page);
				this.pstmt.setInt(3, pageCount);
			} else {
				sql += "ORDER BY stdnum asc LIMIT ?,?";
				this.pstmt = this.conn.prepareStatement(sql);
				this.pstmt.setInt(1, page);
				this.pstmt.setInt(2, pageCount);
			}
			ResultSet rs = this.pstmt.executeQuery();
			while(rs.next()){
				Node node = new Node();
				node.setId(rs.getInt(1));
				node.setName(rs.getString(2));
				node.setDescription(rs.getString(3));
				node.setLocation(rs.getString(4));
				node.setStatus(rs.getInt(5));
				node.setType(rs.getInt(6));
				result.add(node);
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

	@Override
	public int getNodeSize(int type) {
		int result = 0;
		String sql = "select COUNT(*) from node where type = ?";
		try {
			this.pstmt = this.conn.prepareStatement(sql);
			this.pstmt.setInt(1, type);
			ResultSet rs = this.pstmt.executeQuery();
			if(rs.next()){
				result = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			try{
				this.pstmt.close();
			} catch (SQLException e){
				e.printStackTrace();
			}
		}
		return result;
	}

	@Override
	public boolean doCreate(Node node) {
		boolean result = false;
		String sql = "insert into node (id, name, description, location, status, type) values(?, ?, ?, ?, ?, ?)";
		try {
			this.pstmt = this.conn.prepareStatement(sql);
			this.pstmt.setInt(1, node.getId());
			this.pstmt.setString(2, node.getName());
			this.pstmt.setString(3, node.getDescription());
			this.pstmt.setString(4, node.getLocation());
			this.pstmt.setInt(5, node.getStatus());
			this.pstmt.setInt(6, node.getType());
			int rs = this.pstmt.executeUpdate();
			System.out.println(rs);
			if (rs > 0) {
				result = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			try{
				this.pstmt.close();
			} catch (SQLException e){
				e.printStackTrace();
			}
		}
		return result;
	}
	
	@Override
	public boolean delNode(int id) {
		boolean result = false;
		String sql = "delete from node where id = ?";
		try {
			this.pstmt = this.conn.prepareStatement(sql);
			this.pstmt.setInt(1, id);
			int rs = this.pstmt.executeUpdate();
			if (rs > 0) {
				result = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			try{
				this.pstmt.close();
			} catch (SQLException e){
				e.printStackTrace();
			}
		}
		return result;
	}

	@Override
	public boolean updateNode(Node node) {
		boolean result = true;
		String sql = "update node set name=?, description=?, location=?, status=?, type=? where id = ?";
		try {
			this.pstmt = this.conn.prepareStatement(sql);
			
			this.pstmt.setString(1, node.getName());
			this.pstmt.setString(2, node.getDescription());
			this.pstmt.setString(3, node.getLocation());
			this.pstmt.setInt(4, node.getStatus());
			this.pstmt.setInt(5, node.getType());
			this.pstmt.setInt(6, node.getId());
			int rs = this.pstmt.executeUpdate();
			System.out.println(rs);
			if(rs < 1) result = false;
		} catch (SQLException e) {
			e.printStackTrace();
			result = false;
		} finally{
			try{
				this.pstmt.close();
			} catch (SQLException e){
				e.printStackTrace();
			}
		}
		return result;
	}

}
