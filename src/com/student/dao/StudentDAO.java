package com.student.dao;

import java.util.List;

import com.login.exception.BusinessException;
import com.student.model.Student;

public interface StudentDAO {
	public Student addStudent(Student student)throws BusinessException;
	public List<Student>listOfStudentbyCourse(int cid)throws BusinessException;


}
