package com.tka.StudentManagementSystemService;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import com.example.StudentManagementSystem.StudentDao.StudentDao;
import com.tka.StudentManagementSystemEntity.student;
import com.tka.StudentManagementSystemEntity.student;
@Service
public class StudentService {
	private static final StudentDao Studentdao = null;
	@Autowired
	StudentDao studentdao;
	public ArrayList<student> getallstudent() {
		ArrayList<student>a1=new ArrayList<student>();
		a1.add(new student(1,"pavan" ,1,"java"));
		return a1;
	}
	public void addpatient(student s) {
		Studentdao.addpatient(s);
	 }
	 public void deletepatient( student s) {
		 Studentdao.deletepatient(s);
	 }
	 public void updatepatient( student s) {
		 Studentdao.updatepatient(s);
	 }
	 public student IsExists(student s) {
		 if(Studentdao.IsExists(s)!=null) {
			 System.err.println("data is exists");
		 return Studentdao.IsExists(s);
		 }else {
			 System.err.println("data does not exists");
			 Studentdao.addpatient(s);
		 }
		 return null;
	

}
}
