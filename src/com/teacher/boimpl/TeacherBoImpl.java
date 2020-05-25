package com.teacher.boimpl;

import java.util.List;

import com.login.exception.BusinessException;
import com.teacher.bo.TeacherBO;
import com.teacher.daoimpl.TeacherDAOImpl;
import com.teacher.model.Teacher;

public class TeacherBoImpl implements TeacherBO{
	
	private TeacherDAOImpl teacherDao=new TeacherDAOImpl();

	@Override
	public Teacher addTeacher(Teacher teacher) throws BusinessException {
		int scode=0;
		if(teacher==null) {
			throw new BusinessException("Please provide teacher's details");
		}else if(!teacher.getFname().matches("[a-zA-Z]{3,15}")) {
			throw new BusinessException("Please provide valid First Name");
		}else if (!teacher.getLname().matches("[a-zA-Z]{3,15}")) {
			throw new BusinessException("Please provid valid Last Name");
		}else if (!(teacher.getScode()+"").matches("[0-9]{3}")) {
			throw new BusinessException("Please provide valid Subject code");
		}else {
			teacher=teacherDao.addTeacher(teacher);
		}
		return teacher;
	}
	private boolean isValidSubjectCode(int scode) throws BusinessException {
	if ((scode+"").matches ("[0-9]{3}")) {
		return true;
	}else {
			throw new BusinessException();
		}
	}

	@Override
	public Teacher updateTeacherBySubjectCode(int scode,int empid) throws BusinessException {
		Teacher teacher=null;
		if (isValidSubjectCode(scode)) {
			teacher=teacherDao.updateTeacherBySubjectCode(scode,empid);
		}else {
			throw new BusinessException("Subject Code"+ scode +" does not exist");
		}
				
		return teacher;
	}

	@Override
	public List<Teacher> listOfTeachers(int scode) throws BusinessException {
		
		return teacherDao.listOfTeachers();
	}

}
