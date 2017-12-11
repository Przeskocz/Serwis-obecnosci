package uczelnia.service;

import java.util.*;

import uczelnia.domain.Attendance;

public interface AttendanceService {
	List<Attendance> getAllAttendance();
	Attendance getAttendanceById(String id);
	Boolean createAttendance(Map<String, List<String>> fillParams);
}
