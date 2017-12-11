package uczelnia.domain.repository.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import uczelnia.domain.repository.*;
import uczelnia.domain.*;

import java.text.SimpleDateFormat;
import java.util.*;

@Repository
public class InMemotyAttendanceRepository implements AttendanceRepository {

	private List<Attendance> listOfAttendance = new ArrayList<Attendance>();
	private int numberOfAttendances = 2;

	private List<Student> listStudents = new ArrayList<Student>();

	@Autowired
	private InMemorySubjectRepository subjectRepository = new InMemorySubjectRepository();

	@Autowired
	private InMemoryStudentRepository studentRepository = new InMemoryStudentRepository();


	public int getNumberOfAttendances() {
		return numberOfAttendances;
	}

	public void setNumberOfAttendances(int numberOfAttendances) {
		this.numberOfAttendances = numberOfAttendances;
	}

	public InMemotyAttendanceRepository() {
		Date data = new Date();
		SimpleDateFormat ft = new SimpleDateFormat("yyyy.MM.dd  HH:mm");
		String dzis = ft.format(data).toString();

		Calendar calendar = Calendar.getInstance();
		calendar.set(2017, 9, 29, 15, 30);

		// Attendance 1
		Subject subjectById = subjectRepository.getSubjectById("sub002");

		Student studentById = null;
		String[] id = { "s001", "s002", "s004" };
		for (String studentId : id) {
			studentById = studentRepository.getStudentById(studentId);
			this.listStudents.add(studentById);
		}

		Attendance attendance1 = new Attendance("at001", dzis, subjectById, this.listStudents);
		listOfAttendance.add(attendance1);

		// Attendance 2
		subjectById = subjectRepository.getSubjectById("sub001");

		this.listStudents = new ArrayList<Student>();
		String[] id2 = { "s002", "s003", "s005" };

		for (String studentId : id2) {
			studentById = studentRepository.getStudentById(studentId);
			this.listStudents.add(studentById);
		}

		Attendance attendance2 = new Attendance("at002", ft.format(calendar.getTime()), subjectById, this.listStudents);
		listOfAttendance.add(attendance2);

	}

	@Override
	public List<Attendance> getAllAttendance() {
		return listOfAttendance;
	}

	@Override
	public Attendance getAttendanceById(String id) {
		Attendance attendanceById = null;
		for (Attendance attendance : listOfAttendance) {
			if (attendance != null && attendance.getIdOfAttendance() != null
					&& attendance.getIdOfAttendance().equalsIgnoreCase(id)) {
				attendanceById = attendance;
				break;
			}
		}

		if (attendanceById == null) {
			throw new IllegalArgumentException("Brak obecności o wskazanym id: " + id);
		}

		return attendanceById;
	}

	@Override
	public Boolean createAttendance(Map<String, List<String>> fillParams) {
				
		Set<Subject> subjectById = new HashSet<Subject>();
		Set<Student> studentById = new HashSet<Student>();
		Set<String> date = new HashSet<String>();
		
		
		Set<String> criterias = fillParams.keySet();
		
		if (criterias.contains("przedmiot")) {
			for(String subjectId : fillParams.get("przedmiot")) {
				for(Subject subject :  subjectRepository.getAllSubjects()) {
					if(subject.getSubjectId().equalsIgnoreCase(subjectId)) {
						subjectById.add(subjectRepository.getSubjectById(subjectId));
					}
				}
				
			}
		}
		
		if(criterias.contains("studenci")) {
			for(String studentId : fillParams.get("studenci")) {
				for(Student student : studentRepository.getAllStudents()){
					if(student.getStudentId().equalsIgnoreCase(studentId)) {
						studentById.add(studentRepository.getStudentById(studentId));
					}
				}
			}

		}
		
		if(criterias.contains("data")) {
			for(String gDate : fillParams.get("data")) {
				date.add(gDate);
			}
		}
		
		String gData="";
		Subject subject=null;
		List<Student> studentsList = new ArrayList<Student>();
		
		if(subjectById.isEmpty() || studentById.isEmpty() || date.isEmpty()) {
			for(Student x : studentById) studentsList.add(x);
			for(Subject x : subjectById) subject=x;
			for(String x : date) gData+=x;
		}

		
		Attendance newAttendance = new Attendance("at00"+Integer.toString(++numberOfAttendances), gData, subject, studentsList);
		
		listOfAttendance.add(newAttendance);
				
		return true;
	}

}
