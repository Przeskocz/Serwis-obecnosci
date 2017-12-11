package uczelnia.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import uczelnia.service.*;

@Controller
@RequestMapping("/all")
public class GeneralController {
	@Autowired
	private StudentService studentService;
	@Autowired
	private SubjectService subjectService;

	@RequestMapping
	public ResponseEntity<List<Object>> getAllSubjects() {
		List<Object> lista = new ArrayList<Object>();
		lista.add(subjectService.getAllSubjects());
		lista.add(studentService.getAllStudents());
		return new ResponseEntity<List<Object>>(lista, HttpStatus.OK);
	}
}
