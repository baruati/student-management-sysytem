package com.stdmngsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.web.JsonPath;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.service.annotation.DeleteExchange;

import com.stdmngsystem.entity.Student;
import com.stdmngsystem.service.StudentService;

@Controller
public class StudentController {
	@Autowired
	private StudentService studentService;

	@GetMapping("/students")
	public String showStudents(Model model) {
		model.addAttribute("students", studentService.getAllStudents());
		return "students";
	}

	@GetMapping("/students/new")
	public String createStudentForm(Model model) {
		Student student = new Student();
		model.addAttribute("student", student);
		return "create_student";
	}

	@PostMapping("/students")
	public String addStudent(@ModelAttribute("student") Student student) {
		studentService.addStudent(student);
		return "redirect:/students";

	}

	@GetMapping("/students/edit/{id}")
	public String editStdForm(@PathVariable Long id, Model model) {
		model.addAttribute("student", studentService.getStdById(id));
		return "edit_student";

	}

	@PostMapping("/students/{id}")
	public String UpdateStudent(@PathVariable Long id, @ModelAttribute("student") Student student, Model model) {
		Student existingStd = studentService.getStdById(id);
		existingStd.setId(id);
		existingStd.setFirstName(student.getFirstName());
		existingStd.setLastName(student.getLastName());
		existingStd.setEmail(student.getEmail());
		studentService.editStudent(existingStd);
		return "redirect:/students";

	}
	@GetMapping("/students/delete/{id}")
	public String deleteStudent(@PathVariable Long id) {
		studentService.deleteStudentById(id);

		return "redirect:/students";
	}

}
