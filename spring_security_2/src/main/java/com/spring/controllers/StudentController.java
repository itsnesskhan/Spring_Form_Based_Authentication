package com.spring.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.models.Student;

@RestController
@RequestMapping(path = "api/students")
public class StudentController {

	public static final List<Student> STUDENTS = Arrays.asList(new Student(1, "Nasser Khan"),
			new Student(2, "Hamda Khan"), new Student(3, "Zoya Sheikh"));

	
	@GetMapping("{id}")
	public Student getStudent(@PathVariable("id") Integer studentId) {
		return STUDENTS.stream().filter(student -> studentId.equals(student.getId())).findFirst()
				.orElseThrow(() -> new IllegalStateException("Student with id " + studentId + " doesn't exist"));
	}

	@GetMapping
	public List<Student> getallStudent() {
		return STUDENTS;
	}
//	@PreAuthorize("hasAuthority('student:write')")
	@PostMapping
	public void registerStudent(@RequestBody Student student) {
		System.out.println(student);
	}

	@PutMapping("{id}")
	public void updateStudent(@PathVariable("id") Integer studentID, @RequestBody Student student) {
		System.out.println(studentID+" "+student);
	}

	@DeleteMapping("{id}")
	public void deleteStudent(@PathVariable("id") Integer studentID) {
		System.out.println("Student with id " + studentID + " is deleted");
	}

}
