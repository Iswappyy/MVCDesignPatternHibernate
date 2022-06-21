package dao;

import java.util.List;

import Entities.StudentEntities;


public interface StudentDao {
	public boolean createStudent(StudentEntities std);
	public StudentEntities getStudentRollNum(int rollnum);
	public List<StudentEntities> listStudents();
	public boolean updateStudent(int rollnum,StudentEntities std);
	public boolean deleteStudent(int rollnum);

}
