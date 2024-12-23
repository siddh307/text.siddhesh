package com.tka.StudentManagementSystemController;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.tka.StudentManagementSystemEntity.student;
import com.tka.StudentManagementSystemEntity.student;
import com.tka.StudentManagementSystemService.StudentService;

import ch.qos.logback.core.joran.event.SaxEvent;

public class StudentController {
	@Autowired
	StudentService studentservice;
	@GetMapping("getallstudent")
	public ArrayList<student>getallstudent(){
		//ArrayList<Student>a1=new ArrayList<Student>();
		//a1.add(new Student(1,"pavan" ,1,"java"));
		return studentservice.getallstudent();
	}
	@PostMapping("addstudent")
	public void addstudent(@RequestBody student s) {
		 studentservice.addpatient(s);
	}
	@DeleteMapping("deletestudent")
	public void deletstudent(@RequestBody student s) {
studentservice.deletepatient(s);	}
	@PutMapping("updatestudent")
	public void updatestudent(@RequestBody student s) {
		studentservice.updatepatient(s);
	}
	@GetMapping("IsExiest")
	 public student IsExists(@RequestBody student s) {
		student ss=	studentservice.IsExists(s);
		return ss;
	}


}
