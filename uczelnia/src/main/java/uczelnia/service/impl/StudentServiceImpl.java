package uczelnia.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uczelnia.domain.Student;
import uczelnia.domain.repository.StudentRepository;
import uczelnia.service.StudentService;

import java.util.*;

@Service
public class StudentServiceImpl implements StudentService{
	
	@Autowired
	private StudentRepository studentRepository;
	
	@Override
	public List<Student> getAllStudents(){
		return studentRepository.getAllStudents();
	}
	
	@Override
	public Student getStudentById(String studentId) {
		return studentRepository.getStudentById(studentId);
	}
	
	@Override
	public Student createStudent(String name, String surname, int age) {
		return studentRepository.createStudent(name, surname, age);
	}
	
	@Override
	public Student updateStudentById(String id, String name, String surname, int age) {
		return studentRepository.updateStudentById(id, name, surname, age);
	}
	
	@Override
	public boolean deleteStudentById(String id) {
		return studentRepository.deleteStudentById(id);
	}
} 
