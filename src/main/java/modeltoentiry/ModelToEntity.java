package modeltoentiry;

import java.util.ArrayList;
import java.util.List;

import Entities.StudentEntities;
import Model.Student;
import controller.GetStudentRollNum;

public class ModelToEntity {
	
	public static StudentEntities convertToEntity(Student model) {
		
		StudentEntities entity = new StudentEntities();
		
		entity.setRollnum(model.getRollnum());
		entity.setName(model.getName());
		entity.setAddress(model.getAddress());
		
		return entity;
		
		
	}
public static Student convertToModel(StudentEntities entity) {
		
	Student model = new Student();
	
	model.setId(entity.getId());
	model.setRollnum(entity.getRollnum());
	model.setName(entity.getName());
	model.setAddress(entity.getAddress());
	
	return model;
	}
public static List<Student> convertToEntitylist(List<StudentEntities> std1) {
	
	List<Student> stdList=new ArrayList();
	
	for(StudentEntities s1 : std1)
	{
		Student std = new Student();
		
		std.setId(s1.getId());
		std.setRollnum(s1.getRollnum());
		std.setName(s1.getName());
		std.setAddress(s1.getAddress());
		
		stdList.add(std);
	}
	return stdList;


}
}