package com.subject.dao;

import java.util.List;

import com.login.exception.BusinessException;
import com.subject.model.Subject;

public interface subjectDAO {
	public List<Subject>listSubjectsByClass(int cid) throws BusinessException;
}
