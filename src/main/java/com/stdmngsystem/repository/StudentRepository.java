package com.stdmngsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stdmngsystem.entity.Student;

public interface StudentRepository  extends JpaRepository<Student, Long>{

}
