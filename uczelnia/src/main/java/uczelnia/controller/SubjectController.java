package uczelnia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import uczelnia.service.SubjectService;
import uczelnia.domain.Subject;

import java.util.*;


@Controller
@RequestMapping("/przedmioty")
public class SubjectController {
	@Autowired
	private SubjectService subjectService;

	@RequestMapping
	public ResponseEntity<List<Subject>> getAllSubjects() {
		return new ResponseEntity<List<Subject>>(subjectService.getAllSubjects(), HttpStatus.OK);
	}

	@RequestMapping("/{id}")
	public ResponseEntity<Subject> getSubjectById(@PathVariable("id") String id) {
		return new ResponseEntity<Subject>(subjectService.getSubjectById(id), HttpStatus.OK);
	}

	@RequestMapping("/create")
	public ResponseEntity<Boolean> createSubject(@RequestParam("name") String name,
			@RequestParam("length") int length) {
		return new ResponseEntity<Boolean>(subjectService.createSubject(name, length), HttpStatus.OK);
	}

	@RequestMapping("/delete/{id}")
	public ResponseEntity<Boolean> deleteSubjectById(@PathVariable("id") String id) {
		return new ResponseEntity<Boolean>(subjectService.deleteSubjectById(id), HttpStatus.OK);
	}
	
	@RequestMapping("/update/{id}")
	public ResponseEntity<Subject> updateSubjectById(@PathVariable("id") String id, 
			@RequestParam("name") String name, @RequestParam("length") int length) {
		return new ResponseEntity<Subject>(subjectService.updateSubjectById(id, name, length), HttpStatus.OK);
	}
}
