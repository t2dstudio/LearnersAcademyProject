package com.subject.bo;

import java.util.List;

import com.login.exception.BusinessException;
import com.subject.model.*;
public interface subjectBO {
	public List<Subject>listSubjectsByClass(int cid) throws BusinessException;

}
