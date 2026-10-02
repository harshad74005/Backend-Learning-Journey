package dao;

import java.util.List;

import entith.Student;

public interface StudentDao {

	void addStudent(Student s);
	List<Student> fetchallStudent();
	Student findbyId(int id);
	void updateStudent(Student s);
	void deleteStudent(int id);
}
