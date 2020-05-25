package com.teacher.daoimpl;

import java.sql.CallableStatement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.dbutil.OracleConnection;
import com.login.exception.BusinessException;
import com.teacher.dao.TeacherDAO;
import com.teacher.model.Teacher;

public class TeacherDAOImpl implements TeacherDAO {
	private static Map<Integer, Teacher> teacherMap= new TreeMap<Integer, Teacher>();
	@Override
	public Teacher addTeacher(Teacher teacher) throws BusinessException {
		try (Connection connection = OracleConnection.getConnection()){
			String sql="{Call ADDTEACHER (?,?,?,?)}";
			CallableStatement callablStatement =connection.prepareCall(sql);
			callablStatement.setString(2, Integer.toString(teacher.getScode()));
			callablStatement.setString(3, teacher.getFname());
			callablStatement.setString(4, teacher.getLname());
//			System.out.println(teacher.getFname());
			
			callablStatement.registerOutParameter(1, java.sql.Types.NUMERIC);
			callablStatement.execute();
//			System.out.println(teacher.getScode());
			teacher.setEmpid(callablStatement.getInt(1));
			
//			System.out.println(teacher.getEmpid());
		} catch (ClassNotFoundException | SQLException e) {
			throw new BusinessException("Internal Error..Please contact SYSADMIN");
		}
		return teacher;
	}

	@Override
	public Teacher updateTeacherBySubjectCode(int scode,int empid) throws BusinessException {
		Teacher teacher =new Teacher();
		try (Connection connection = OracleConnection.getConnection()) {
			String sql="UPDATE teachermaster SET scode= ?, empid = ?";
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setInt(1, scode);
			preparedStatement.setInt(2, empid);
			int ups=preparedStatement.executeUpdate();
			if (ups!=0) {
			return teacher;
		}else {
			throw new BusinessException("Subject Code"+ scode+ " is not available");
		}
		}

 catch (ClassNotFoundException | SQLException e) {
	 throw new BusinessException("Internal Error...Please contact SYSADMIN");
}
	
	}

	@Override
	public List<Teacher> listOfTeachers() throws BusinessException {
		List<Teacher> teacherMaster=new ArrayList<Teacher>();
		try (Connection connection = OracleConnection.getConnection()){
			String sql= "select empid,scode,fname,lname from teachermaster";
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			ResultSet resultset=preparedStatement.executeQuery();
			
			while (resultset.next()) {
			Teacher teacher=new Teacher(resultset.getInt("empid"),resultset.getInt("scode"),resultset.getString("fname"),resultset.getString("lname"));
			teacherMaster.add(teacher);
			
			}if (teacherMaster.size()==0) {
				throw new BusinessException("No teacher has been added...Please contact SYSADMIN");
			}
			
			} catch (ClassNotFoundException | SQLException e) {
			throw new BusinessException("Internal Error...Please contact SYSADMIN");
		}
		return teacherMaster;
	}

}
