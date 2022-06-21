package modeltoentiry;

import java.util.ArrayList;
import java.util.List;

import Entities.StudentEntities;
import Model.Student;
import controller.GetStudentRollNum;

public class ModelToEntity {
	
	public static StudentEntities convertToEntity(Student model) {
		
		StudentEntities se = new StudentEntities();
		
		se.setRollnum(model.getRollnum());
		se.setName(model.getName());
		se.setAddress(model.getAddress());
		
		return se;
		
		
	}
public static Student convertToModel(StudentEntities std) {
		
	Student model = new Student();
	
	model.setId(std.getId());
	model.setRollnum(std.getRollnum());
	model.setName(std.getName());
	model.setAddress(std.getAddress());
	
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