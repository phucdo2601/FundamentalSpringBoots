package com.phucdn.hello.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.phucdn.hello.model.Student;

@Controller
@RequestMapping("students")
public class StudentController {
	
	@GetMapping("new")
	public String newForm() {
		return "students/new";
	}
	
	@PostMapping("saveOrUpdate")
	public String saveOrUpdate(@RequestParam("studentID") String studentID, 
			@RequestParam("name") String name, 
			Model model) {
		System.out.println("Edit Student ID: "+studentID);
		System.out.println("Edit Name: "+name);
		model.addAttribute("studentID", studentID);
		model.addAttribute("name", name);
		return "students/viewDetail";
	}
	
	@PostMapping("update")
	public String update(Student st, Model model) {
		System.out.println("Update Method: ");
		model.addAttribute("studentID", st.getStudentID());
		model.addAttribute("name", st.getName());
		return "students/viewDetail";
	}
	
	//tra ve danh sach cac sinh vien
	@ModelAttribute("students")
	public List<Student> getStudents() {
		List<Student> list = new ArrayList<>();
		list.add(new Student("S02", "Minh"));
		list.add(new Student("S03", "Phat"));
		
		return list;
	}
	
	@GetMapping("edit/{studentID}")
	public String edit(@PathVariable("studentID") String studentID,
			Model model) {
		System.out.println("Student ID: "+studentID);
		
		Student st = new Student();
		st.setStudentID(studentID);
		st.setName("Minh");
		model.addAttribute("student", st);
		return "students/edit";
	}
	
	@GetMapping("viewDetail/{studentID}")
	public String viewDetail(@PathVariable("studentID") String studentID,
			Model model) {
		System.out.println("Student ID: "+studentID);
		Student st = new Student();
		st.setStudentID(studentID);
		st.setName("Minh");
		model.addAttribute("studentID", st.getStudentID());
		model.addAttribute("name", st.getName());
		return "students/viewDetail";
	}
	
	@RequestMapping("list")
	public String list() {
		return "students/list";
	}
	
	@RequestMapping("search")
	public String search() {
		return "students/search";
	}
}
