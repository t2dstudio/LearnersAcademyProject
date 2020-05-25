package com.subject.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dbutil.OracleConnection;
import com.login.exception.BusinessException;
import com.subject.dao.subjectDAO;
import com.subject.model.Subject;

public class SubjectDAOImpl implements subjectDAO{

	@Override
	public List<Subject> listSubjectsByClass(int cid) throws BusinessException {
		List<Subject> listSubjectsByClass=new ArrayList<Subject>();
		System.out.println("DAOIMPL HERE");
		Subject subject=null;
		try (Connection connection = OracleConnection.getConnection()){
			System.out.println("connection ok");
			String sql= "select scode,subname, cid from SUBJECTS where cid=?";
			PreparedStatement preparedstatement = connection.prepareStatement(sql);
			preparedstatement.setInt(1, cid);
			
			System.out.println("connection ok2");
			System.out.println(cid);
		
			ResultSet resultSet =preparedstatement.executeQuery();
	
		
			while (resultSet.next()) {
				Subject subject1=new Subject(resultSet.getInt ("scode"), resultSet.getString("subname"), resultSet.getInt("cid"));
			    listSubjectsByClass.add(subject1);
			  
			}
			    if (listSubjectsByClass.size()==0) {
				throw new BusinessException(" No subject exist with"+ cid+"please conatct SYSADMIN");
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			throw new BusinessException("Internal Error Ocurred....Pls contact SYSADMIN");
		}
		return listSubjectsByClass;
	}

}
