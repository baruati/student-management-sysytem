package com.stdmngsystem.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stdmngsystem.entity.Student;
import com.stdmngsystem.repository.StudentRepository;
import com.stdmngsystem.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	StudentRepository repository;
	

//	public StudentServiceImpl(StudentRepository repository) {
//		super();
//		this.repository = repository;
//	}


	@Override
	public List<Student> getAllStudents() {
		return this.repository.findAll();
	}


	@Override
	public Student addStudent(Student student) {
		return this.repository.save(student);
	}


	@Override
	public Student getStdById(Long id) {
		// TODO Auto-generated method stub
		return this.repository.findById(id).get();
	}


	@Override
	public Student editStudent(Student student) {
		// TODO Auto-generated method stub
		return this.repository.save(student);
	}


	@Override
	public void deleteStudentById(Long id) {
		this.repository.deleteById(id);
		
	}

}
