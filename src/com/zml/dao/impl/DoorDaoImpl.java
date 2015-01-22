package com.zml.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import com.zml.dao.DoorDao;
import com.zml.dto.Door;
import com.zml.model.DoorRecord;

public class DoorDaoImpl extends BaseDaoImpl implements DoorDao{

	public DoorDaoImpl() {
		
	}
	
	public DoorDaoImpl(Connection conn) {
		this.conn = conn;
	}
	
	@Override
	public boolean doCreate(DoorRecord record) {
		boolean result = false;
		String sql = "insert into open_record (stdnum, open_time, node_id) values (?, ?, ?)";
		try {
			this.pstmt = this.conn.prepareStatement(sql);
			this.pstmt.setString(1, record.getStdNum());
			this.pstmt.setTimestamp(2, new java.sql.Timestamp(record.getOpen_date().getTime()));
			this.pstmt.setInt(3, record.getNode_id());
			if(this.pstmt.executeUpdate() > 0) {
				result = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				this.pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
	@Override
	public DoorRecord findDao(DoorRecord obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Door> getDoors(Date start, Date end, String name,
			int nodeID, int page, int pageCount) {
		ArrayList<Door> result = new ArrayList<Door>();
		String sql = "select o.id, o.stdnum, s.name, o.open_time, o.node_id, n.name from open_record as o, student as s, node as n " + 
				"where open_time between ? and ? " + 
				"and s.name like ? " +
				"and s.stdnum = o.stdnum and o.node_id = n.id ";
		try {
			if(nodeID > 0) {
				sql += "and node_id = ? ";
			} 
			sql += "ORDER BY open_time desc LIMIT ?,?";
			
			this.pstmt = this.conn.prepareStatement(sql);
			this.pstmt.setDate(1, new java.sql.Date(start.getTime()));
			this.pstmt.setDate(2, new java.sql.Date(end.getTime()));
			this.pstmt.setString(3, name);
			if (nodeID > 0) {
				this.pstmt.setInt(4, nodeID);
				this.pstmt.setInt(5, page * pageCount - pageCount + 1);
				this.pstmt.setInt(6, pageCount);
			} else {
				this.pstmt.setInt(4, page * pageCount - pageCount + 1);
				this.pstmt.setInt(5, pageCount);
			}
			
			ResultSet rs = this.pstmt.executeQuery();
			while(rs.next()){
				SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				Date open_date = new Date();
				try {
					open_date = date.parse(date.format((new Date(rs.getDate(4).getTime() + (rs.getTime(4).getTime())))));
				} catch (ParseException e) {
					e.printStackTrace();
				}
				Door door = new Door();
				door.setId(rs.getInt(1));
				door.setStdNum(rs.getString(2));
				door.setStdName(rs.getString(3));
				door.setOpen_date(open_date);
				door.setNode_id(rs.getInt(5));
				door.setNodeName(rs.getString(6));
				result.add(door);
			}
			System.out.println(result.size());
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
	public int getDoorSize(Date start, Date end, String name, int nodeID) {
		int result = 0;
		String sql = "select count(*) from open_record as o, student as s, node as n " + 
				"where o.open_time between ? and ? " + 
				"and s.name like ? " +
				"and s.stdnum = o.stdnum "+
				"and o.node_id = n.id ";
		
		try {		
			if(nodeID > 0) {
				sql += "and node_id = ? ";
			}
			this.pstmt = this.conn.prepareStatement(sql);
			this.pstmt.setDate(1, new java.sql.Date(start.getTime()) );
			this.pstmt.setDate(2, new java.sql.Date(end.getTime()));
			this.pstmt.setString(3, name);
			if(nodeID > 0) {
				this.pstmt.setInt(4, nodeID);
			}
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
}
