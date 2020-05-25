package com.teacher.bo;

import java.util.List;

import com.login.exception.BusinessException;
import com.teacher.model.Teacher;

public interface TeacherBO {
	public Teacher addTeacher(Teacher teacher)throws BusinessException;
	public Teacher updateTeacherBySubjectCode(int scode,int empid)throws BusinessException;
	public List<Teacher>listOfTeachers(int scode)throws BusinessException;

}
