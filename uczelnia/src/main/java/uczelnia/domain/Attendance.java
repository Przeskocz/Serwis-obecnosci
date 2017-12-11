package uczelnia.domain;

import java.util.*;

public class Attendance {
	private String idOfAttendance;
	private String date;
	private Subject subject;
	private List<Student> students;

	
	
	public String getIdOfAttendance() {
		return idOfAttendance;
	}

	public void setIdOfAttendance(String idOfAttendance) {
		this.idOfAttendance = idOfAttendance;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	public Attendance(String idOfAttendance, String date, Subject subject, List<Student> students) {
		this.idOfAttendance=idOfAttendance;
		this.date = date;
		this.subject = subject;
		this.students = students;
	}

	public Attendance() {
		super();

	}

}
