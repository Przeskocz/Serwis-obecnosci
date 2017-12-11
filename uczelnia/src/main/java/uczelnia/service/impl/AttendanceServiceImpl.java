package uczelnia.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uczelnia.domain.Attendance;
import uczelnia.domain.repository.AttendanceRepository;
import uczelnia.service.AttendanceService;

@Service
public class AttendanceServiceImpl implements AttendanceService {
	@Autowired
	AttendanceRepository attendanceRepository;
	
	@Override
	public List<Attendance> getAllAttendance(){
		return attendanceRepository.getAllAttendance();
	}

	@Override
	public Attendance getAttendanceById(String id) {
		return attendanceRepository.getAttendanceById(id);
	}
	
	@Override
	public Boolean createAttendance(Map<String, List<String>> fillParams) {
		return attendanceRepository.createAttendance(fillParams);
	}
}
