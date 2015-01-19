package com.zml.dao.proxy;

import java.util.ArrayList;

import com.zml.dao.StudentDao;
import com.zml.dao.impl.StudentDaoImpl;
import com.zml.model.Student;

public class StudentDaoProxy extends BaseDaoProxy implements StudentDao{
    
    public StudentDaoProxy() {
        super(StudentDaoImpl.class);
    }

    //电脑预约登录
    @Override
    public Student checkUser(String stdNum, String pwd) {
        Student result = null;
        result = ((StudentDaoImpl) dao).checkUser(stdNum, pwd);
        connPool.returnConnection(conn);
        return result;
    }

    //签到或开门验证身份
    @Override
    public boolean findDao(String cardID) {
        boolean result = false;
        result = ((StudentDaoImpl) dao).findDao(cardID);
        connPool.returnConnection(conn);
        return result;
    }
    
    @Override
    public Student _findDao(String cardID) {
		Student result = null;
		result = ((StudentDaoImpl) dao)._findDao(cardID);
		connPool.returnConnection(conn);
		return result;
	}
    
  //电脑预约登录
    @Override
    public boolean updatePass(String stdNum, String pwd) {
        boolean result = false;
        result = ((StudentDaoImpl) dao).updatePass(stdNum, pwd);
        connPool.returnConnection(conn);
        return result;
    }
	@Override
	public String getPasswordFromStdnum(String stdnum) {
		String result = null;
		result = ((StudentDao) super.dao).getPasswordFromStdnum(stdnum);
		connPool.returnConnection(conn);
		return result;
	}

	@Override
	public ArrayList<Student> getStudents() {
		ArrayList<Student> result = null;
		result = ((StudentDao) super.dao).getStudents();
		connPool.returnConnection(conn);
		return result;
	}

	@Override
	public ArrayList<Student> getStudents(int page, int pageCount) {
		ArrayList<Student> result = null;
		result = ((StudentDao) super.dao).getStudents(page, pageCount);
		connPool.returnConnection(conn);
		return result;
	}

	@Override
	public int getStudentsSize() {
		int result = 0;
		result = ((StudentDao) super.dao).getStudentsSize();
		connPool.returnConnection(conn);
		return result;
	}

	@Override
	public boolean doCreate(Student studentInfo) {
		boolean result = false;
		result = ((StudentDao) super.dao).doCreate(studentInfo);
		connPool.returnConnection(conn);
		return result;
	}

	@Override
	public Student findDao(Student obj) {
		return null;
	}

	@Override
	public ArrayList<Student> getStudents(Student student, int page,
			int pageCount) {
		ArrayList<Student> result = null;
		result = ((StudentDao) super.dao).getStudents(student, page, pageCount);
		connPool.returnConnection(conn);
		return result;
	}

	@Override
	public int getStudentsSize(Student student) {
		int result = 0;
		result = ((StudentDao) super.dao).getStudentsSize(student);
		connPool.returnConnection(conn);
		return result;
	}

	@Override
	public Student getStudentInfoFromStdnum(String stdnum) {
		Student result = null;
		result = ((StudentDao) super.dao).getStudentInfoFromStdnum(stdnum);
		connPool.returnConnection(conn);
		return result;
	}
	
	@Override 
	public boolean delStudent(String stdnum) {
		boolean result = false;
		result = ((StudentDao) super.dao).delStudent(stdnum);
		connPool.returnConnection(conn);
		return result;
	}
	
	@Override
	public boolean updateStudent(Student student) {
		boolean result = false;
		result = ((StudentDao) super.dao).updateStudent(student);
		connPool.returnConnection(conn);
		return result;
	}
}
