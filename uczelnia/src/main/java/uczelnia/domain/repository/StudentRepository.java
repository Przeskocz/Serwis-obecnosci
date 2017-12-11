package uczelnia.domain.repository;

import uczelnia.domain.Student;

import java.util.List;

public interface StudentRepository {
	List<Student> getAllStudents();

	Student getStudentById(String studentId);

	Student createStudent(String name, String surname, int age);

	Student updateStudentById(String id, String name, String surname, int age);

	boolean deleteStudentById(String id);
}
