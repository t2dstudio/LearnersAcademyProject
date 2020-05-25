package com.subject.boimpl;

import java.util.List;

import com.login.exception.BusinessException;
import com.subject.bo.subjectBO;
import com.subject.daoimpl.SubjectDAOImpl;
import com.subject.model.Subject;

public class SubjectBOImpl implements subjectBO{
	
	private SubjectDAOImpl subjectDAO=new SubjectDAOImpl();
	@Override
	public List<Subject> listSubjectsByClass(int cid) throws BusinessException {
		System.out.println("Boimpl here");
		return subjectDAO.listSubjectsByClass(cid);
	}

}
