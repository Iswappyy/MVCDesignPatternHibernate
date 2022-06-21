package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.Student;
import Service.StudentImpl;
import Service.StudentService;

public class DeleteStudent extends HttpServlet {

	StudentService service = new StudentImpl();

	public void doPost(HttpServletRequest rq, HttpServletResponse rp) throws IOException {
		Student model = new Student();
	
		PrintWriter out = rp.getWriter();

		if (service.deleteStudent(Integer.parseInt(rq.getParameter("rollnum")))) {
			System.out.println("Student record deleted succesfully...");
		} else {
			System.out.println("Opps..!   Record not deleted.....");
		}
	}
}