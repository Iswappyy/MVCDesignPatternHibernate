package Service;

import java.util.List;

import Model.Student;

public interface StudentService {
	
	public boolean createStudent(Student std);
	public Student getStudentRollNum(int rollnum);
	public List<Student> listStudents();
	public boolean updateStudent(int rollnum,Student std);
	public boolean deleteStudent(int rollnum);

}
