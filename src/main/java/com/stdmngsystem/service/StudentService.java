package com.stdmngsystem.service;

import java.util.List;

import com.stdmngsystem.entity.Student;

public interface StudentService {
	List<Student> getAllStudents();
	Student addStudent(Student student);
	Student getStdById(Long id);
	Student editStudent(Student student);
	void deleteStudentById(Long id);

}
