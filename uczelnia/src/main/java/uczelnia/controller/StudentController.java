package uczelnia.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import uczelnia.domain.Student;
import uczelnia.service.StudentService;

@Controller
@RequestMapping("/studenci")
public class StudentController {

	@Autowired
	private StudentService studentService;
	
	@RequestMapping
	public String getAllStudents(Model model) {
		model.addAttribute("students", studentService.getAllStudents());
		return "students";
	}

	@RequestMapping("/{id}")
	public String getStudentById(Model model, @PathVariable("id") String studentId) {
		model.addAttribute("student", studentService.getStudentById(studentId));
		return "student";
	}

	@RequestMapping("/create")
	public ResponseEntity<Student> createStudent(@RequestParam("name") String name,
			@RequestParam("surname") String surname, @RequestParam("age") int age) {
		return new ResponseEntity<Student>(studentService.createStudent(name,surname,age), HttpStatus.OK);
	}
	
	@RequestMapping("/update/{id}")
	public ResponseEntity<Student> updateStudent(@PathVariable("id") String id, @RequestParam("name") String name,
			@RequestParam("surname") String surname, @RequestParam("age") int age) {
		return new ResponseEntity<Student>(studentService.updateStudentById(id,name,surname,age), HttpStatus.OK);
	}
	
	@RequestMapping("/delete/{id}")
	public ResponseEntity<Boolean> deleteStudent(@PathVariable("id") String id) {
		return new ResponseEntity<Boolean>(studentService.deleteStudentById(id), HttpStatus.OK);
	}
}
