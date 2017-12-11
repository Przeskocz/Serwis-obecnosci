package uczelnia.domain.repository.impl;

import uczelnia.domain.repository.*;
import uczelnia.domain.Subject;
import java.util.*;

import org.springframework.stereotype.Repository;

@Repository
public class InMemorySubjectRepository implements SubjectRepository {
	private List<Subject> listOfSubject = new ArrayList<Subject>();
	private int numberOfSubject;

	public InMemorySubjectRepository() {
		listOfSubject.add(new Subject("sub001", "Programowanie obiektowe", 675));
		listOfSubject.add(new Subject("sub002", "Matematyka dyskretna", 700));
		listOfSubject.add(new Subject("sub003", "Aplikacje internetowe I", 360));
		this.numberOfSubject = 3;
	}

	public int getNumberOfSubject() {
		return numberOfSubject;
	}

	public void setNumberOfSubject(int numberOfSubject) {
		this.numberOfSubject = numberOfSubject;
	}

	@Override
	public List<Subject> getAllSubjects() {
		return listOfSubject;
	}

	@Override
	public Subject getSubjectById(String id) {
		Subject subjectById = null;
		for (Subject subject : listOfSubject) {
			if (subject != null && subject.getSubjectId() != null && subject.getSubjectId().equalsIgnoreCase(id)) {
				subjectById = subject;
				break;
			}
		}
		if (subjectById == null) {
			throw new IllegalArgumentException("Brak przedmiotu o wskazanym id: " + id);
		}
		return subjectById;
	}

	@Override
	public boolean createSubject(String name, int length) {
		String subjectId = "sub00" + Integer.toString(++this.numberOfSubject);
		listOfSubject.add(new Subject(subjectId, name, length));
		return true;
	}

	@Override
	public boolean deleteSubjectById(String id) {
		Subject subjectById = this.getSubjectById(id);
		return listOfSubject.remove(subjectById);
	}
	
	@Override
	public Subject updateSubjectById(String id, String name, int length) {
		Subject subjectById = this.getSubjectById(id);
		subjectById.setNazwa(name);
		subjectById.setLength(length);
		return subjectById;
	}
}
