package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.Student;
import Service.StudentImpl;
import Service.StudentService;

public class CreateStudentController extends HttpServlet {
	
	StudentService service = new StudentImpl();
	
	public void doPost(HttpServletRequest rq, HttpServletResponse rp) throws IOException {
		Student model = new Student();
		model.setRollnum(Integer.parseInt(rq.getParameter("rollnum")));
		model.setName(rq.getParameter("name"));
		model.setAddress(rq.getParameter("address"));
		
		PrintWriter out = rp.getWriter();
		
		if(service.createStudent(model)) {
			System.out.println("Student record created succesfully...");
		}
		else {
			System.out.println("Opps..!   Record not created.....");
		}
	}

}


