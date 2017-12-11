package uczelnia.domain.repository.impl;
import java.util.*;

import org.springframework.stereotype.Repository;

import uczelnia.domain.Student;
import uczelnia.domain.repository.StudentRepository;

@Repository
public class InMemoryStudentRepository implements StudentRepository {
	
	private List<Student> listOfStudents = new ArrayList<Student>();
	private int numberOfId;
	
	public InMemoryStudentRepository() {
		listOfStudents.add(new Student("s001","Paweł","Skocz",22));
		listOfStudents.add(new Student("s002","Marcin","Nowak",19));
		listOfStudents.add(new Student("s003","Wioletta","Mormol",25));
		listOfStudents.add(new Student("s004","Joanna","Zubel",22));
		listOfStudents.add(new Student("s005","Mikołaj","Kopernik",24));
		this.setNumberOfId(5);
	}
	
	public int getNumberOfId() {
		return numberOfId;
	}

	public void setNumberOfId(int numberOfId) {
		this.numberOfId = numberOfId;
	}
	
	
	@Override
	public List<Student> getAllStudents(){
		return listOfStudents;
	}
	
	@Override
	public Student getStudentById(String studentId) {
		Student studentById = null;
		for(Student student : listOfStudents) {
			if(student!=null && student.getStudentId()!=null && student.getStudentId().equals(studentId)) {
				studentById = student;
				break;
			}
		}
		
		if(studentById==null) {
			throw new IllegalArgumentException("Brak studenta o wskazanym id: " + studentId);
		}
		return studentById;
	}
	
	@Override
	public Student createStudent(String name, String surname, int age) {
		String id = "s00"+Integer.toString(++this.numberOfId);
		listOfStudents.add(new Student(id,name,surname,age));
		
		return getStudentById(id);
	}
	
	@Override
	public Student updateStudentById(String id, String name, String surname, int age) {
		Student studentById = this.getStudentById(id);
		studentById.setName(name);
		studentById.setSurname(surname);
		studentById.setAge(age);
		
		return studentById;
	}
	
	@Override
	public boolean deleteStudentById(String id) {
		Student studentById = this.getStudentById(id);
		
		return listOfStudents.remove(studentById);	
	}

	
}
