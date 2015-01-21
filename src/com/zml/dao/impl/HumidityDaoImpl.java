package com.zml.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import com.zml.dao.HumidityDao;
import com.zml.model.Humidity;

public class HumidityDaoImpl extends BaseDaoImpl implements HumidityDao{

	public HumidityDaoImpl() {
		
	}
	
	public HumidityDaoImpl(Connection conn) {
		this.conn = conn;
	}

	@Override
	public boolean doCreate(Humidity humidity) {
		boolean result = false;
		String sql = "insert into humidity (node_id, humidity_value, acq_time) values (?, ?, ?)";
		
		try {
			this.pstmt = this.conn.prepareStatement(sql);
			this.pstmt.setInt(1, humidity.getNode_id());
			this.pstmt.setInt(2, humidity.getHumidity_value());
			this.pstmt.setTimestamp(3, new java.sql.Timestamp(humidity.getAcq_time().getTime()));
			
			if(this.pstmt.executeUpdate() > 0) {
				result = true;
			}
			System.out.println(sql);
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
	public Humidity findDao(Humidity obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Humidity> getHumidity(Date start, Date end, int nodeID,
			int page, int pageCount) {
		ArrayList<Humidity> result = new ArrayList<Humidity>();
		String sql = "select id,node_id,acq_time,Humidity_value from Humidity " + 
				"where acq_time between ? and ? " + 
				"and node_id = ? " +
				"ORDER BY acq_time desc LIMIT ?,?";
		try {
			this.pstmt = this.conn.prepareStatement(sql);
			this.pstmt.setDate(1, new java.sql.Date(start.getTime()));
			this.pstmt.setDate(2, new java.sql.Date(end.getTime()));
			this.pstmt.setInt(3, nodeID);
			this.pstmt.setInt(4, page * pageCount - pageCount + 1);
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
				Humidity humidity = new Humidity();
				humidity.setId(rs.getInt(1));
				humidity.setNode_id(rs.getInt(2));
				humidity.setAcq_time(acq_time);
				humidity.setHumidity_value(rs.getInt(4));
				result.add(humidity);
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
	public int getHumiditySize(Date start, Date end, int nodeID) {
		int result = 0;
		String sql = "select count(*) from humidity " + 
				"where acq_time between ? and ? " + 
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
