package com.student.daolimpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dbutil.OracleConnection;
import com.login.exception.BusinessException;
import com.student.dao.StudentDAO;
import com.student.model.Student;

public class StudentDAOImpl implements StudentDAO{

	@Override
	public Student addStudent(Student student) throws BusinessException {
		try(Connection connection=OracleConnection.getConnection()){
			String sql= "{Call ADDSTUDENT (?,?,?,?)}";
			CallableStatement callableStatement=connection.prepareCall(sql);
			callableStatement.setString(2, student.getFname());
			callableStatement.setString(3, student.getLname());
			callableStatement.setInt(4, student.getCid());
//		System.out.println(student.getFname());
			callableStatement.registerOutParameter(1, java.sql.Types.NUMERIC);
//			System.out.println(student.getStid());
			callableStatement.execute();
//			System.out.println(student.getCid());
			student.setStid(callableStatement.getInt(1));
//			System.out.println(student.getStid());
		} catch (ClassNotFoundException | SQLException e) {
			throw new BusinessException("Internal error please contact SYSADMIN");
		}
		return student;
	}

	@Override
	public List<Student> listOfStudentbyCourse(int cid) throws BusinessException {
		List<Student>listOfClassStudents=new ArrayList<Student>();
		Student student=null;
		try(Connection connection=OracleConnection.getConnection()){
		   String sql="select stid,fname,lname,cid from STUDENTMASTER where cid=?";
		   PreparedStatement preparedStatement=connection.prepareStatement(sql);
		   preparedStatement.setInt(1, cid);
		   ResultSet resultSet=preparedStatement.executeQuery();
		   while(resultSet.next()) {
			   Student student1=new Student(resultSet.getInt("stid"), resultSet.getString("fname"),
					   resultSet.getString("lname"), resultSet.getInt("cid"));
			   listOfClassStudents.add(student1);
		   }
		   if (listOfClassStudents.size()==0) {
			   throw new BusinessException("There is no student enrolled yet for class "+cid);
		   }
		
		} catch (ClassNotFoundException | SQLException e) {
			throw new BusinessException("Internal error please contact SYSADMIN");
		}
		return listOfClassStudents;
	}

}
