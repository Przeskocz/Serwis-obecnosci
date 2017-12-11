package uczelnia.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import uczelnia.domain.Attendance;
import uczelnia.service.AttendanceService;

@Controller
@RequestMapping("/obecnosci")
public class AttendanceController {

	@Autowired
	private AttendanceService attendanceService;

	@RequestMapping
	public ResponseEntity<List<Attendance>> getAllAttendance() {
		return new ResponseEntity<List<Attendance>>(attendanceService.getAllAttendance(), HttpStatus.OK);
	}

	@RequestMapping("/{id}")
	public ResponseEntity<Attendance> getlAttendanceById(@PathVariable("id") String id) {
		return new ResponseEntity<Attendance>(attendanceService.getAttendanceById(id), HttpStatus.OK);
	}

	@RequestMapping("/create/{ByCriteria}")
	public ResponseEntity<Boolean> createAttendance(
			@MatrixVariable(pathVar = "ByCriteria") Map<String, List<String>> fillParams) {
		return new ResponseEntity<Boolean>(attendanceService.createAttendance(fillParams),HttpStatus.OK);
	}
}
