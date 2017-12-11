package uczelnia.domain;

public class Student {
	private String studentId;
	private String name;
	private String surname;
	private int age;
		
	public String getStudentId() {
		return studentId;
	}
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	public Student(){
		super();
	}
	
	public Student(String studentId, String name, String surname, int age) {
		this.studentId=studentId;
		this.name=name;
		this.surname=surname;
		this.age=age;
	}
}
