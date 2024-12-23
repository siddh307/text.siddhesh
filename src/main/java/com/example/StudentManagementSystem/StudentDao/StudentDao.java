package com.example.StudentManagementSystem.StudentDao;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.spi.DirStateFactory.Result;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;


import com.tka.StudentManagementSystemEntity.student;
@Repository
public class StudentDao {
private static final String url="jdbc:mysql://localhost:8080/db_196";
private static final String username="root";
private static final String passward="root";
private static  Connection con=null;
private static PreparedStatement pstmt=null;
private static  Connection getDbcoConnection() {
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		con=DriverManager.getConnection(url,username,passward);
	} catch (Exception e) {
		e.printStackTrace();
	}
	return con;
	
}
	public ArrayList<student>getallstudent(){
		ArrayList<student>a1=new ArrayList<student>();
		String sql="select  * from  student";
		try {
			
		
		pstmt=getDbcoConnection().prepareStatement(sql);
	ResultSet	rs=pstmt.executeQuery();
	
	a1.add(new student(1,"pavan" ,1,"java"));
	while(rs.next()) {
		int id=rs.getInt(1);
		String name =rs.getNString(2);
		int  age=rs.getInt(3);
		String course=rs.getString(4);
		a1.add(new student (id,name,age,course));
	}
		} catch (SQLException e) {
			// TODO: handle exception
		}
		return a1;
	}
	public void addpatient(student s) {
		String sql ="insert into student values(?,?,?,?)";
		try {
			pstmt = getDbcoConnection().prepareStatement(sql);
			pstmt.setInt(1, s.getId());
			pstmt.setString(2, s.getName());
			pstmt.setInt(3, s.getAge());
			pstmt.setString(4, s.getCourse());
			
			pstmt.executeUpdate();
			System.err.println("data insert successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void deletepatient( student s) {
		String sql ="delete from student where id = ?";
		try {
			pstmt = getDbcoConnection().prepareStatement(sql);
			pstmt.setInt(1, s.getId());
			
			pstmt.executeUpdate();
			System.err.println("data delete successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void updatepatient( student s) {
		String sql ="update student set name =?,age=?,course=?, where id=?;";
		try {
			pstmt = getDbcoConnection().prepareStatement(sql);
			pstmt.setInt(1, s.getId());
			pstmt.setString(2, s.getName());
			pstmt.setInt(3, s.getAge());
			pstmt.setString(4, s.getCourse());
			
			pstmt.executeUpdate();
			System.err.println("data updated successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public student IsExists(student s) {
		String sql = "select * from student where id =?;";
		student ss = null;
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, s.getId());
			ResultSet rs=pstmt.executeQuery();
			  
			
			  while(rs.next()) 
			  { int id=rs.getInt(1);
			  String name=rs.getNString(2); 
			  int  age=rs.getInt(3);
			  String course = rs.getString(5);
			  
			ss=(new student(id, name, age, course));
			  }
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ss;
	


}
}