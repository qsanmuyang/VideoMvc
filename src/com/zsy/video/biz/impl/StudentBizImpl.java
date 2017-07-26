package com.zsy.video.biz.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zsy.video.biz.IStudentBiz;
import com.zsy.video.dao.impl.StudentDaoImpl;
import com.zsy.video.model.Student;

@Service
public class StudentBizImpl implements IStudentBiz {
	@Autowired
	private StudentDaoImpl sDaoImpl;
	
	
	public void setsDaoImpl(StudentDaoImpl sDaoImpl) {
		this.sDaoImpl = sDaoImpl;
	}


	@Override
	public List<Student> getStudents() {
		return sDaoImpl.getStudents();
	}


	@Override
	public boolean login(Map<String, String> map) {
		boolean flag=false;
		List<Student> stuList = new ArrayList<Student>();
		stuList=sDaoImpl.login(map);
		if(!stuList.isEmpty()){
			flag=true;
		}
		return flag;
	}


	@Override
	public int addStudent(Student student) {
		
		return sDaoImpl.addStudent(student);
	}


	@Override
	public boolean findStudent(String snickname) {
		boolean flag=false;
		List<Student> stuList=new ArrayList<Student>();
		stuList=sDaoImpl.findStudent(snickname);
		if(!stuList.isEmpty()){
			flag=true;
		}
		return flag;
	}


	@Override
	public Student getStudentByName(String name) {
		List<Student> stuList=new ArrayList<Student>();
		stuList=sDaoImpl.findStudent(name);
		Student student = new Student();
		if(!stuList.isEmpty()){
			student=stuList.get(0);
		}
		return student;
	}


	@Override
	public int updateStudent(Student student) {
		
		return sDaoImpl.updateStudent(student);
	}

}
