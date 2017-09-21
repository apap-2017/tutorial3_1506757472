package com.example.tutorial3.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

import com.example.tutorial3.model.StudentModel;

public class InMemoryStudentService implements StudentService {
	private static List<StudentModel> studentList = new ArrayList<StudentModel>();
	
	@Override
	public StudentModel selectStudent(String npm) {
		for (StudentModel currentStudent : studentList) {
			if (currentStudent.getNpm() != null && currentStudent.getNpm().equals(npm)) {
				return currentStudent;
			}
		}
		
		return null;
	}

	@Override
	public List<StudentModel> selectAllStudents() {
		return studentList;
	}

	@Override
	public void addStudent(StudentModel student) {
		studentList.add(student);
	}

	@Override
	public void deleteStudent(String npm) {
		Iterator<StudentModel> studentListIterator = studentList.iterator();
		
		while (studentListIterator.hasNext()) {
			StudentModel currentStudent = studentListIterator.next();
			
			if (currentStudent.getNpm().equals(npm)) {
				studentListIterator.remove();
			}
		}
	}
}
