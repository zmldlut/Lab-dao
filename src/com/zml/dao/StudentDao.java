package com.zml.dao;

import java.util.ArrayList;

import com.zml.model.Student;

public interface StudentDao extends BaseDao<Student>{
	
	Student checkUser(String stdNum, String pwd);
	boolean findDao(String cardID);
	Student _findDao(String cardID);
	boolean updatePass(String stdNum, String pwd);
	
	///
	ArrayList<Student> getStudents();
	ArrayList<Student> getStudents(int page, int pageCount);
	ArrayList<Student> getStudents(Student student, int page, int pageCount);
	String getPasswordFromStdnum(String stdnum);
	Student getStudentInfoFromStdnum(String stdnum);
	int getStudentsSize();
	int getStudentsSize(Student student);
	
	boolean delStudent(String stdnum);
	boolean updateStudent(Student std);
}
