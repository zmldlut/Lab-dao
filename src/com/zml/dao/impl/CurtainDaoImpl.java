package com.zml.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import com.zml.dao.CurtainDao;
import com.zml.dto.CurtainLamp;
import com.zml.model.CurtainRecord;

public class CurtainDaoImpl extends BaseDaoImpl implements CurtainDao{

	public CurtainDaoImpl() {
		
	}
	
	public CurtainDaoImpl(Connection conn) {
		this.conn = conn;
	}

	@Override
	public boolean doCreate(CurtainRecord curtain) {
		boolean result = false;
		String sql = "insert into curtain_record (stdnum, operate_time, node_id, operate) values (?, ?, ?, ?)";
		try {
			this.pstmt = this.conn.prepareStatement(sql);
			this.pstmt.setString(1, curtain.getStdNum());
			this.pstmt.setTimestamp(2, new java.sql.Timestamp(curtain.getOperate_date().getTime()));
			this.pstmt.setInt(3, curtain.getNode_id());
			this.pstmt.setInt(4, curtain.getOperate());
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
	public CurtainRecord findDao(CurtainRecord obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<CurtainLamp> getCurtains(Date start, Date end,
			String name, int nodeID, int page, int pageCount) {
		ArrayList<CurtainLamp> result = new ArrayList<CurtainLamp>();
		String sql = "select o.id, o.stdnum, s.name, o.operate_time, o.node_id, n.name, o.operate from curtain_record as o, student as s, node as n " + 
				"where operate_time between ? and ? " + 
				"and s.name like ? " +
				"and s.stdnum = o.stdnum and o.node_id = n.id ";
		try {
			if(nodeID > 0) {
				sql += "and node_id = ? ";
			} 
			sql += "ORDER BY operate_time desc LIMIT ?,?";
			
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
				Date operate_date = new Date();
				try {
					operate_date = date.parse(date.format((new Date(rs.getDate(4).getTime() + (rs.getTime(4).getTime())))));
				} catch (ParseException e) {
					e.printStackTrace();
				}
				CurtainLamp curtain = new CurtainLamp();
				curtain.setId(rs.getInt(1));
				curtain.setStdNum(rs.getString(2));
				curtain.setStdName(rs.getString(3));
				curtain.setOperate_date(operate_date);
				curtain.setNode_id(rs.getInt(5));
				curtain.setNodeName(rs.getString(6));
				curtain.setOperate(rs.getInt(7));
				result.add(curtain);
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
	public int getCurtainSize(Date start, Date end, String name, int nodeID) {
		int result = 0;
		String sql = "select count(*) from curtain_record as o, student as s, node as n " + 
				"where o.operate_time between ? and ? " + 
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
