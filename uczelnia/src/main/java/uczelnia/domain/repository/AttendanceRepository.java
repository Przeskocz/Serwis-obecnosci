package uczelnia.domain.repository;

import java.util.*;

import uczelnia.domain.Attendance;

public interface AttendanceRepository {
	List<Attendance> getAllAttendance();
	Attendance getAttendanceById(String id);
	Boolean createAttendance(Map<String, List<String>> fillParams);
}
