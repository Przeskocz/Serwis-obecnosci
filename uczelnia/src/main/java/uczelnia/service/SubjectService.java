package uczelnia.service;

import java.util.*;

import uczelnia.domain.Subject;

public interface SubjectService {

	List<Subject> getAllSubjects();

	Subject getSubjectById(String id);

	boolean createSubject(String name, int length);

	boolean deleteSubjectById(String id);
	
	Subject updateSubjectById(String id, String name, int length);
}
