package com.zml.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.zml.dao.GradeDao;
import com.zml.model.Grade;

public class GradeDaoImpl extends BaseDaoImpl implements GradeDao{
	
	public GradeDaoImpl() {}
	
	public GradeDaoImpl(Connection conn) {
		super.conn = conn;
	}

	@Override
	public ArrayList<Grade> getGrades() {
		ArrayList<Grade> result = new ArrayList<Grade>();
		String sql = "select id,grade_name from grade ORDER BY id asc";
		try {
			this.pstmt = this.conn.prepareStatement(sql);
			ResultSet rs = this.pstmt.executeQuery();
			while(rs.next()){
				Grade grade = new Grade();
				grade.setId(rs.getInt(1));
				grade.setGrade_name(rs.getString(2));
				result.add(grade);
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
	public String getNameFromID(int id) {
		String result = null;
		String sql = "select grade_name from grade where id = ?";
		try {
			this.pstmt = this.conn.prepareStatement(sql);
			this.pstmt.setInt(1, id);
			ResultSet rs = this.pstmt.executeQuery();
			if(rs.next()){
				result = rs.getString(1);
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
	public int getIDFromName(String name) {
		int result = -1;
		String sql = "select id from grade where grade_name = ?";
		try {
			this.pstmt = this.conn.prepareStatement(sql);
			this.pstmt.setString(1, name);
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
	public int getGradesSize() {
		int result = 0;
		String sql = "select COUNT(*) from grade";
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
	public boolean doCreate(Grade obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Grade findDao(Grade obj) {
		// TODO Auto-generated method stub
		return null;
	}

}
