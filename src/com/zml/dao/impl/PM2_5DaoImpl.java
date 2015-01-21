package com.zml.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import com.zml.dao.PM2_5Dao;
import com.zml.model.PM2_5;

public class PM2_5DaoImpl extends BaseDaoImpl implements PM2_5Dao{

	public PM2_5DaoImpl() {
		
	}
	
	public PM2_5DaoImpl(Connection conn) {
		this.conn = conn;
	}

	@Override
	public boolean doCreate(PM2_5 pm) {
		boolean result = false;
		String sql = "insert into pm2_5 (node_id, pm_value, acq_time) values (?, ?, ?)";
		try {
			this.pstmt = this.conn.prepareStatement(sql);
			this.pstmt.setInt(1, pm.getNode_id());
			this.pstmt.setInt(2, pm.getPm_value());
			this.pstmt.setTimestamp(3, new java.sql.Timestamp(pm.getAcq_time().getTime()));
			
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
	public PM2_5 findDao(PM2_5 pm) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<PM2_5> getPM2_5(Date start, Date end, int nodeID,
			int page, int pageCount) {
		
		ArrayList<PM2_5> result = new ArrayList<PM2_5>();
		String sql = "select id, node_id, acq_time, pm_value from pm2_5 " + 
				"where acq_time between ? and ? " + 
				"and node_id = ? " +
				"ORDER BY acq_time desc LIMIT ?,?";
		try {
			this.pstmt = this.conn.prepareStatement(sql);
			this.pstmt.setDate(1, new java.sql.Date(start.getTime()));
			this.pstmt.setDate(2, new java.sql.Date(end.getTime()));
			this.pstmt.setInt(3, nodeID);
			this.pstmt.setInt(4, page * pageCount - pageCount);
			this.pstmt.setInt(5, pageCount);
			ResultSet rs = this.pstmt.executeQuery();
			while(rs.next()){
				SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				Date acq_time = new Date();
				try {
					acq_time = date.parse(date.format((new Date(rs.getDate(3).getTime() + (rs.getTime(3).getTime())))));
				} catch (ParseException e) {
					e.printStackTrace();
				}
				PM2_5 pm = new PM2_5();
				pm.setId(rs.getInt(1));
				pm.setNode_id(rs.getInt(2));
				pm.setAcq_time(acq_time);
				pm.setPm_value(rs.getInt(4));
				result.add(pm);
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
	public int getPM2_5Size(Date start, Date end, int nodeID) {
		int result = 0;
		String sql = "select count(*) from pm2_5 " + 
				"where acq_time between ? and ? and " + 
				"node_id = ?";
		try {
			this.pstmt = this.conn.prepareStatement(sql);
			this.pstmt.setDate(1, new java.sql.Date(start.getTime()) );
			this.pstmt.setDate(2, new java.sql.Date(end.getTime()));
			this.pstmt.setInt(3, nodeID);
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
