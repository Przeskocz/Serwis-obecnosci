package uczelnia.service.impl;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uczelnia.domain.Subject;
import uczelnia.domain.repository.SubjectRepository;
import uczelnia.service.SubjectService;

@Service
public class SubjectServiceImpl implements SubjectService {

	@Autowired
	private SubjectRepository subjectRepository;

	@Override
	public List<Subject> getAllSubjects() {
		return subjectRepository.getAllSubjects();
	}

	@Override
	public Subject getSubjectById(String id) {
		return subjectRepository.getSubjectById(id);
	}

	@Override
	public boolean createSubject(String name, int length) {
		return subjectRepository.createSubject(name, length);
	}

	@Override
	public boolean deleteSubjectById(String id) {
		return subjectRepository.deleteSubjectById(id);
	}

	@Override
	public Subject updateSubjectById(String id, String name, int length) {
		return subjectRepository.updateSubjectById(id, name, length);
	}
}
