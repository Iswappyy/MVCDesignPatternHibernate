package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.Student;
import Service.StudentImpl;
import Service.StudentService;

public class GetStudentRollNum extends HttpServlet {
	
	StudentService service = new StudentImpl();
	
	public void doGet(HttpServletRequest rq, HttpServletResponse rp) throws IOException {
		
		
		int rollnum = Integer.parseInt(rq.getParameter("rollnum"));
		
		
		PrintWriter out = rp.getWriter();
		Student std = service.getStudentRollNum(rollnum);
		
		System.out.println("we got data through roll number..");
		
		if( std!= null)
		{
			out.println("Student fetch details: " + "Id: "+ std.getId() +" Roll Number: "+ std.getRollnum() +" Name: "+ std.getName()+" Address : "+ std.getAddress());
		}else {
			out.println("oops student record not found...");
		}
}
}