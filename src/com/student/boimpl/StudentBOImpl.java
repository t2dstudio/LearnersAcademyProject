package com.student.boimpl;

import java.util.List;

import com.login.exception.BusinessException;
import com.student.bo.studentBO;
import com.student.daolimpl.StudentDAOImpl;
import com.student.model.Student;
import com.teacher.daoimpl.TeacherDAOImpl;

public class StudentBOImpl implements studentBO{
	
	private StudentDAOImpl studentDAO=new StudentDAOImpl();

	@Override
	public Student addStudent(Student student) throws BusinessException {
		int cid =0;
		if (student == null) {
			throw new BusinessException("Pleaae provide student details");
		}else if (!student.getFname().matches("[a-zA-Z]{3,20}") ) {
			throw new BusinessException("First name takes alphabets only");
		}else if (!student.getLname().matches("[a-zA-Z]{3,20}")) {
			throw new BusinessException("Lastname can only be alphabets");
		}else if (!(student.getCid()+"").matches("[0-9]{4}")) {
			throw new BusinessException("Please provide valid Course ID");
		}else {
			studentDAO.addStudent(student);
		}
			
		return student;
	}

	@Override
	public List<Student> listOfStudentbyCourse(int cid) throws BusinessException {
//		int cid=0;
return studentDAO.listOfStudentbyCourse(cid);
	}

}
