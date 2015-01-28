package com.zml.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import com.zml.dao.SiginDao;
import com.zml.model.SgRecord;

public class SiginDaoImpl extends BaseDaoImpl implements SiginDao{

	public SiginDaoImpl() {
		
	}
	
	public SiginDaoImpl(Connection conn) {
		this.conn = conn;
	}
	
	@Override
	public boolean doCreate(SgRecord record) {
		boolean result = false;
		String sql = "insert into sg_record (stdnum, arrival_time, departure_time, node_id) values (?, ?, ?, ?)";
		try {
			this.pstmt = this.conn.prepareStatement(sql);
			this.pstmt.setString(1, record.getStdNum());
			this.pstmt.setTimestamp(2, new java.sql.Timestamp(record.getSgDate().getTime()));
			this.pstmt.setTimestamp(3, new java.sql.Timestamp(record.getSgDate().getTime()));
			this.pstmt.setInt(4, record.getNode_id());
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
	public SgRecord findDao(SgRecord obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<SgRecord> getSigins(Date start, Date end, String stdNum,
			int nodeID, int page, int pageCount) {
		// TODO Auto-generated method stub
		ArrayList<SgRecord> result = new ArrayList<SgRecord>();
		String sql = "SELECT stdnum, arrival_time, departure_time, node_id FROM sg_record " + 
				"where arrival_time between ? and ? " + 
				"and stdnum like ? ";
		try {
			if(nodeID > 0) {
				sql += "and node_id = ? ";
			} 
			sql += "ORDER BY arrival_time desc LIMIT ?,?";
			
			this.pstmt = this.conn.prepareStatement(sql);
			this.pstmt.setDate(1, new java.sql.Date(start.getTime()));
			this.pstmt.setDate(2, new java.sql.Date(end.getTime()));
			this.pstmt.setString(3, stdNum);
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
				Date sgDate = new Date();
				Date lvDate = new Date();
				try {
					sgDate = date.parse(date.format((new Date(rs.getDate(2).getTime() + (rs.getTime(2).getTime())))));
					lvDate = date.parse(date.format((new Date(rs.getDate(3).getTime() + (rs.getTime(3).getTime())))));
				} catch (ParseException e) {
					e.printStackTrace();
				}
				SgRecord sgRecord = new SgRecord(rs.getString(1), sgDate, lvDate, rs.getInt(4));
				result.add(sgRecord);
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
	public int getSiginsSize(Date start, Date end, String stdNum, int nodeID) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		int result = 0;
		String sql = "SELECT count(*) FROM sg_record " + 
				"where arrival_time between ? and ? " + 
				"and stdnum like ? ";
		try {
			if(nodeID > 0) {
				sql += "and node_id = ? ";
			} 
			sql += "ORDER BY arrival_time";
			
			this.pstmt = this.conn.prepareStatement(sql);
			this.pstmt.setDate(1, new java.sql.Date(start.getTime()));
			this.pstmt.setDate(2, new java.sql.Date(end.getTime()));
			this.pstmt.setString(3, stdNum);
			if (nodeID > 0) {
				this.pstmt.setInt(4, nodeID);
			}
			
			ResultSet rs = this.pstmt.executeQuery();
			if(rs.next()){
				result = rs.getInt(1);
			}
			System.out.println(result);
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
