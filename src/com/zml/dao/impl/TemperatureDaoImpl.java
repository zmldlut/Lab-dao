package com.zml.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import com.zml.dao.TemperatureDao;
import com.zml.model.Temperature;

public class TemperatureDaoImpl extends BaseDaoImpl implements TemperatureDao{

	public TemperatureDaoImpl() {
		
	}
	
	public TemperatureDaoImpl(Connection conn) {
		this.conn = conn;
	}

	@Override
	public boolean doCreate(Temperature temp) {
		boolean result = false;
		String sql = "insert into temperature (node_id, temperature_value, acq_time) values (?, ?, ?)";
		try {
			this.pstmt = this.conn.prepareStatement(sql);
			this.pstmt.setInt(1, temp.getNode_id());
			this.pstmt.setInt(2, temp.getTemperature_value());
			this.pstmt.setTimestamp(3, new java.sql.Timestamp(temp.getAcq_time().getTime()));
			
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
	public Temperature findDao(Temperature obj) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public ArrayList<Temperature> getTemperature() {
		ArrayList<Temperature> result = new ArrayList<Temperature>();
		String sql = "select id,node_id,acq_time,temperature_value from temperature ORDER BY acq_time desc";
		try {
			this.pstmt = this.conn.prepareStatement(sql);
			ResultSet rs = this.pstmt.executeQuery();
			while(rs.next()){
				Temperature temperature = new Temperature();
				temperature.setId(rs.getInt(1));
				temperature.setNode_id(rs.getInt(2));
				temperature.setAcq_time(rs.getDate(3));
				temperature.setTemperature_value(rs.getInt(4));
				result.add(temperature);
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
	public ArrayList<Temperature> getTemperature(int page, int pageCount) {
		ArrayList<Temperature> result = new ArrayList<Temperature>();
		String sql = "select id,node_id,acq_time,temperature_value from temperature ORDER BY acq_time desc LIMIT ? ?";
		try {
			this.pstmt = this.conn.prepareStatement(sql);
			this.pstmt.setInt(1, page * pageCount - pageCount + 1);
			this.pstmt.setInt(2, pageCount);
			ResultSet rs = this.pstmt.executeQuery();
			while(rs.next()){
				Temperature temperature = new Temperature();
				temperature.setId(rs.getInt(1));
				temperature.setNode_id(rs.getInt(2));
				temperature.setAcq_time(new Date(rs.getDate(3).getTime()) );
				temperature.setTemperature_value(rs.getInt(4));
				result.add(temperature);
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
	public ArrayList<Temperature> getTemperature(Date start, Date end,
			int page, int pageCount) {
		ArrayList<Temperature> result = new ArrayList<Temperature>();
		String sql = "select id,node_id,acq_time,temperature_value from temperature " + 
				"where acq_time between ? and ? " + 
				"ORDER BY acq_time desc LIMIT ?,?";
		try {
			this.pstmt = this.conn.prepareStatement(sql);
			this.pstmt.setDate(1, new java.sql.Date(start.getTime()));
			this.pstmt.setDate(2, new java.sql.Date(end.getTime()));
			this.pstmt.setInt(3, page * pageCount - pageCount + 1);
			this.pstmt.setInt(4, pageCount);
			ResultSet rs = this.pstmt.executeQuery();
			while(rs.next()){
				SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				Date acq_time = new Date();
				try {
					acq_time = date.parse(date.format((new Date(rs.getDate(3).getTime() + (rs.getTime(3).getTime())))));
				} catch (ParseException e) {
					e.printStackTrace();
				}
				Temperature temperature = new Temperature();
				temperature.setId(rs.getInt(1));
				temperature.setNode_id(rs.getInt(2));
				temperature.setAcq_time(acq_time);
				temperature.setTemperature_value(rs.getInt(4));
				result.add(temperature);
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
	public ArrayList<Temperature> getTemperatureFromNodeID(int nodeID,
			int page, int pageCount) {
		ArrayList<Temperature> result = new ArrayList<Temperature>();
		String sql = "select id,node_id,acq_time,temperature_value from temperature where acq_time between ? and ? ORDER BY acq_time desc LIMIT ?,?";
		try {
			this.pstmt = this.conn.prepareStatement(sql);
			this.pstmt.setInt(1, nodeID);
			this.pstmt.setInt(2, page * pageCount - pageCount + 1);
			this.pstmt.setInt(3, pageCount);
			ResultSet rs = this.pstmt.executeQuery();
			while(rs.next()){
				Temperature temperature = new Temperature();
				temperature.setId(rs.getInt(1));
				temperature.setNode_id(rs.getInt(2));
				temperature.setAcq_time(rs.getDate(3));
				temperature.setTemperature_value(rs.getInt(4));
				result.add(temperature);
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
	public int getTemperatureSize() {
		int result = 0;
		String sql = "select count(*) from temperature";
		try {
			this.pstmt = this.conn.prepareStatement(sql);
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
	public int getTemperatureSize(Date start, Date end) {
		int result = 0;
		String sql = "select count(*) from temperature " + 
				"where UNIX_TIMESTAMP(acq_time) >  UNIX_TIMESTAMP(?) and " + 
				"UNIX_TIMESTAMP(acq_time) < UNIX_TIMESTAMP(?) ";
		try {
			this.pstmt = this.conn.prepareStatement(sql);
			this.pstmt.setDate(1, new java.sql.Date(start.getTime()) );
			this.pstmt.setDate(2, new java.sql.Date(end.getTime()));
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
	public int getTemperatureSize(Temperature temperature) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getTemperatureSizeFromNodeID(int nodeID) {
		int result = 0;
		String sql = "select count(*) from temperature where node_id = ?";
		try {
			this.pstmt = this.conn.prepareStatement(sql);
			this.pstmt.setInt(1, nodeID);
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
