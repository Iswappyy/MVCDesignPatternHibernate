package Service;

import java.util.List;

import Model.Student;
import dao.StudentDao;
import dao.StudentDaoImpl;
import modeltoentiry.ModelToEntity;

public class StudentImpl implements StudentService {
    
	StudentDao stdao = new StudentDaoImpl();
	@Override
	public boolean createStudent(Student std) {
		
		return stdao.createStudent(ModelToEntity.convertToEntity(std));
	}

	@Override
	public Student getStudentRollNum(int rollnum) {
		return ModelToEntity.convertToModel(stdao.getStudentRollNum(rollnum));
	}

	@Override
	public List<Student> listStudents() {
      List<Student> list = ModelToEntity.convertToEntitylist(stdao.listStudents());
		
		return list;
	}

	@Override
	public boolean updateStudent(int rollnum, Student std) {
		return stdao.updateStudent(std.getRollnum(), ModelToEntity.convertToEntity(std));
	}

	@Override
	public boolean deleteStudent(int rollnum) {
		return stdao.deleteStudent(rollnum);
		
	}

}
