package com.zml.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.zml.dao.StudentDao;
import com.zml.model.Student;

public class StudentDaoImpl extends BaseDaoImpl implements StudentDao{

	public StudentDaoImpl() {
		
	}
	
	public StudentDaoImpl(Connection conn) {
		this.conn = conn;
	}

	//电脑预约登录
	@Override
	public Student checkUser(String stdNum, String pwd) {
        Student result = null;
        if (findDao(stdNum, pwd)) {
            result = new Student();
            result.setStdnum(stdNum);
            result.setPassword(pwd);
        }
        return result;
    }
	
	//签到或开门身份验证
	@Override
	public boolean findDao(String cardID) {
		boolean result = false;
		String sql = "select * from student where cardID = ?";
		try {
			this.pstmt = this.conn.prepareStatement(sql);
			this.pstmt.setString(1, cardID);
			ResultSet rs = this.pstmt.executeQuery();
			if(rs.next()) {
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
	
	//电脑预约身份验证
	public boolean findDao(String stdNum, String password) {
        boolean result = false;
        String sql = "select * from student where stdNum = ? and password = ?";
        try {
            this.pstmt = this.conn.prepareStatement(sql);
            this.pstmt.setString(1, stdNum);
            this.pstmt.setString(2, password);
            ResultSet rs = this.pstmt.executeQuery();
            if(rs.next()) {
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
	public Student _findDao(String cardID) {
		Student result = null;
		String sql = "select stdnum from student where cardID = ?";
		try {
			this.pstmt = this.conn.prepareStatement(sql);
			this.pstmt.setString(1, cardID);
			ResultSet rs = this.pstmt.executeQuery();
			if(rs.next()) {
				result = new Student();
				result.setStdnum(rs.getString(1));
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
	
	//电脑预约更新密码
	@Override
	public boolean updatePass(String stdNum, String password) {
		boolean result = false;
        String sql = "update student set password = ? where stdNum = ?";
        try {
            this.pstmt = this.conn.prepareStatement(sql);
            this.pstmt.setString(1, password);
            this.pstmt.setString(2, stdNum);
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
	public String getPasswordFromStdnum(String stdnum) {
		String result = null;
		String sql = "select password from student where stdnum = ?";
		try {
			this.pstmt = this.conn.prepareStatement(sql);
			this.pstmt.setString(1, stdnum);
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
	public ArrayList<Student> getStudents() {
		ArrayList<Student> result = new ArrayList<Student>();
		String sql = "select stdnum,cardID,name,password,major_id,grade_id,phone,email,qq,is_here from student ORDER BY stdnum asc";
		try {
			this.pstmt = this.conn.prepareStatement(sql);
			ResultSet rs = this.pstmt.executeQuery();
			while(rs.next()){
				Student student = new Student();
				student.setStdnum(rs.getString(1));
				student.setCardID(rs.getString(2));
				student.setName(rs.getString(3));
				student.setPassword(rs.getString(4));
				student.setMajor_id(rs.getInt(5));
				student.setGrade_id(rs.getInt(6));
				student.setPhone(rs.getString(7));
				student.setEmail(rs.getString(8));
				student.setQQ(rs.getString(9));
				student.setIs_here(rs.getBoolean(10));
				result.add(student);
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
	public ArrayList<Student> getStudents(int page, int pageCount) {
		ArrayList<Student> result = new ArrayList<Student>();
		String sql = "select stdnum,cardID,name,password,major_id,grade_id,phone,email,qq,is_here from student ORDER BY stdnum asc LIMIT ?,?";
		try {
			this.pstmt = this.conn.prepareStatement(sql);
			this.pstmt.setInt(1, page * pageCount - pageCount);
			this.pstmt.setInt(2, pageCount);
			ResultSet rs = this.pstmt.executeQuery();
			while(rs.next()){
				Student student = new Student();
				student.setStdnum(rs.getString(1));
				student.setCardID(rs.getString(2));
				student.setName(rs.getString(3));
				student.setPassword(rs.getString(4));
				student.setMajor_id(rs.getInt(5));
				student.setGrade_id(rs.getInt(6));
				student.setPhone(rs.getString(7));
				student.setEmail(rs.getString(8));
				student.setQQ(rs.getString(9));
				student.setIs_here(rs.getBoolean(10));
				result.add(student);
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
	public int getStudentsSize() {
		int result = 0;
		String sql = "select COUNT(*) from student";
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
	public boolean doCreate(Student studentInfo) {
		boolean result = true;
		String sql = "insert into student (stdnum, cardID, name, password, major_id, grade_id, phone, email, qq, is_here) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		try {
			this.pstmt = this.conn.prepareStatement(sql);
			this.pstmt.setString(1, studentInfo.getStdnum());
			this.pstmt.setString(2, studentInfo.getCardID());
			this.pstmt.setString(3, studentInfo.getName());
			this.pstmt.setString(4, studentInfo.getPassword());
			this.pstmt.setInt(5, studentInfo.getMajor_id());
			this.pstmt.setInt(6, studentInfo.getGrade_id());
			this.pstmt.setString(7, studentInfo.getPhone());
			this.pstmt.setString(8, studentInfo.getEmail());
			this.pstmt.setString(9, studentInfo.getQQ());
			this.pstmt.setBoolean(10, false);
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

	@Override
	public Student findDao(Student obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Student> getStudents(Student student, int page, int pageCount) {
		ArrayList<Student> result = new ArrayList<Student>();
		String sql = "select stdnum,cardID,name,password,major_id,grade_id,phone,email,qq,is_here from student ";
		int cnt = 0;
		if(!student.getStdnum().equals("")){
			if((++cnt) == 1) sql += "where ";
			else sql += " and ";
			sql += "stdnum = ?";
		}
		if(!student.getCardID().equals("")){
			if((++cnt) == 1) sql += "where ";
			else sql += " and ";
			sql += "cardID = ?";
		}
		if(!student.getName().equals("")){
			if((++cnt) == 1) sql += "where ";
			else sql += " and ";
			sql += "name = ?";
		}
		if(student.getMajor_id() != 0){
			if((++cnt) == 1) sql += "where ";
			else sql += " and ";
			sql += "major_id = ?";
		}
		if(student.getGrade_id() != 0){
			if((++cnt) == 1) sql += "where ";
			else sql += " and ";
			sql += "grade_id = ?";
		}
		if(!student.getPhone().equals("")){
			if((++cnt) == 1) sql += "where ";
			else sql += " and ";
			sql += "phone = ?";
		}
		if(!student.getEmail().equals("")){
			if((++cnt) == 1) sql += "where ";
			else sql += " and ";
			sql += "email = ?";
		}
		if(!student.getQQ().equals("")){
			if((++cnt) == 1) sql += "where ";
			else sql += " and ";
			sql += "qq = ?";
		}
		sql += " ORDER BY stdnum asc LIMIT ?,?";
				
		cnt = 0;
		
		try {
			this.pstmt = this.conn.prepareStatement(sql);
			if(!student.getStdnum().equals("")){
				this.pstmt.setString(++cnt, student.getStdnum());
			}
			if(!student.getCardID().equals("")){
				this.pstmt.setString(++cnt, student.getCardID());
			}
			if(!student.getName().equals("")){
				this.pstmt.setString(++cnt, student.getName());
			}
			if(student.getMajor_id() != 0){
				this.pstmt.setInt(++cnt, student.getMajor_id());
			}
			if(student.getGrade_id() != 0){
				this.pstmt.setInt(++cnt, student.getGrade_id());
			}
			if(!student.getPhone().equals("")){
				this.pstmt.setString(++cnt, student.getPhone());
			}
			if(!student.getEmail().equals("")){
				this.pstmt.setString(++cnt, student.getEmail());
			}
			if(!student.getQQ().equals("")){
				this.pstmt.setString(++cnt, student.getQQ());
			}
			this.pstmt.setInt(++cnt, page * pageCount - pageCount);
			this.pstmt.setInt(++cnt, pageCount);
			ResultSet rs = this.pstmt.executeQuery();
			while(rs.next()){
				Student stu = new Student();
				stu.setStdnum(rs.getString(1));
				stu.setCardID(rs.getString(2));
				stu.setName(rs.getString(3));
				stu.setPassword(rs.getString(4));
				stu.setMajor_id(rs.getInt(5));
				stu.setGrade_id(rs.getInt(6));
				stu.setPhone(rs.getString(7));
				stu.setEmail(rs.getString(8));
				stu.setQQ(rs.getString(9));
				stu.setIs_here(rs.getBoolean(10));
				result.add(stu);
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
	public int getStudentsSize(Student student) {
		int result = 0;
		String sql = "select COUNT(*) from student ";
		int cnt = 0;
		if(!student.getStdnum().equals("")){
			if((++cnt) == 1) sql += "where ";
			else sql += " and ";
			sql += "stdnum = ?";
		}
		if(!student.getCardID().equals("")){
			if((++cnt) == 1) sql += "where ";
			else sql += " and ";
			sql += "cardID = ?";
		}
		if(!student.getName().equals("")){
			if((++cnt) == 1) sql += "where ";
			else sql += " and ";
			sql += "name = ?";
		}
		if(student.getMajor_id() != 0){
			if((++cnt) == 1) sql += "where ";
			else sql += " and ";
			sql += "major_id = ?";
		}
		if(student.getGrade_id() != 0){
			if((++cnt) == 1) sql += "where ";
			else sql += " and ";
			sql += "grade_id = ?";
		}
		if(!student.getPhone().equals("")){
			if((++cnt) == 1) sql += "where ";
			else sql += " and ";
			sql += "phone = ?";
		}
		if(!student.getEmail().equals("")){
			if((++cnt) == 1) sql += "where ";
			else sql += " and ";
			sql += "email = ?";
		}
		if(!student.getQQ().equals("")){
			if((++cnt) == 1) sql += "where ";
			else sql += " and ";
			sql += "qq = ?";
		}
				
		cnt = 0;
		
		
		try {
			this.pstmt = this.conn.prepareStatement(sql);
			if(!student.getStdnum().equals("")){
				this.pstmt.setString(++cnt, student.getStdnum());
			}
			if(!student.getCardID().equals("")){
				this.pstmt.setString(++cnt, student.getCardID());
			}
			if(!student.getName().equals("")){
				this.pstmt.setString(++cnt, student.getName());
			}
			if(student.getMajor_id() != 0){
				this.pstmt.setInt(++cnt, student.getMajor_id());
			}
			if(student.getGrade_id() != 0){
				this.pstmt.setInt(++cnt, student.getGrade_id());
			}
			if(!student.getPhone().equals("")){
				this.pstmt.setString(++cnt, student.getPhone());
			}
			if(!student.getEmail().equals("")){
				this.pstmt.setString(++cnt, student.getEmail());
			}
			if(!student.getQQ().equals("")){
				this.pstmt.setString(++cnt, student.getQQ());
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

	@Override
	public Student getStudentInfoFromStdnum(String stdnum) {
		Student result = new Student();
		String sql = "select stdnum,cardID,name,password,major_id,grade_id,phone,email,qq,is_here from student where stdnum = ?";
		try {
			this.pstmt = this.conn.prepareStatement(sql);
			this.pstmt.setString(1, stdnum);
			ResultSet rs = this.pstmt.executeQuery();
			if(rs.next()){
				result.setStdnum(rs.getString(1));
				result.setCardID(rs.getString(2));
				result.setName(rs.getString(3));
				result.setPassword(rs.getString(4));
				result.setMajor_id(rs.getInt(5));
				result.setGrade_id(rs.getInt(6));
				result.setPhone(rs.getString(7));
				result.setEmail(rs.getString(8));
				result.setQQ(rs.getString(9));
				result.setIs_here(rs.getBoolean(10));
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
	public boolean delStudent(String stdnum) {
		boolean result = false;
		String sql = "delete from student where stdnum = ?";
		try {
			this.pstmt = this.conn.prepareStatement(sql);
			this.pstmt.setString(1, stdnum);
			int rs = this.pstmt.executeUpdate();
			System.out.println(rs);
			if(rs > 0) {
				result = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				this.pstmt.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	@Override
	public boolean updateStudent(Student student) {
		boolean result = false;
		String sql = "update student set cardID =?, name=?, password=?, major_id=?, grade_id=?, phone=?, email=?, qq=?, is_here=? where stdnum = ?";
		try {
			this.pstmt = this.conn.prepareStatement(sql);
			this.pstmt.setString(1, student.getCardID());
			this.pstmt.setString(2, student.getName());
			this.pstmt.setString(3, student.getPassword());
			this.pstmt.setInt(4, student.getMajor_id());
			this.pstmt.setInt(5, student.getGrade_id());
			this.pstmt.setString(6, student.getPhone());
			this.pstmt.setString(7, student.getEmail());
			this.pstmt.setString(8, student.getQQ());
			this.pstmt.setBoolean(9, student.getIs_here());
			this.pstmt.setString(10, student.getStdnum());
			int rs = this.pstmt.executeUpdate();
			System.out.println(rs);
			if(rs > 0) {
				result = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				this.pstmt.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
}
