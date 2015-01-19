package com.zml.dao.impl;

import java.sql.Connection;
import java.sql.SQLException;

import com.zml.dao.ReportDao;
import com.zml.model.Report;

public class ReportDaoImpl extends BaseDaoImpl implements ReportDao{

	public ReportDaoImpl() {
		
	}
	
	public ReportDaoImpl(Connection conn) {
		this.conn = conn;
	}

	@Override
	public boolean doCreate(Report report) {
		boolean result = false;
		String sql = "insert into report (stdNum,report) values (?,?)";
		try {
			this.pstmt = this.conn.prepareStatement(sql);
			this.pstmt.setString(1, report.getStdNum());
			this.pstmt.setString(2, report.getReport());
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
	public Report findDao(Report obj) {
		// TODO Auto-generated method stub
		return null;
	}
}
