package uczelnia.service;

import java.util.*;
import uczelnia.domain.Student;

public interface StudentService {
	List<Student> getAllStudents();
	Student getStudentById(String studentId);
	Student createStudent(String name, String surname, int age);
	Student updateStudentById(String id, String name, String surname, int age);
	boolean deleteStudentById(String id);
}
