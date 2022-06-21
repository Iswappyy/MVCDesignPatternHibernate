package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.ListIterator;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.Student;
import Service.StudentImpl;
import Service.StudentService;

public class ListStudent extends HttpServlet {

	StudentService service = new StudentImpl();

	public void doGet(HttpServletRequest rq, HttpServletResponse rp) throws IOException {
				List<Student> list = service.listStudents();
	PrintWriter out = rp.getWriter();
	if(list!=null)
	{
		ListIterator itr = list.listIterator();
		while(itr.hasNext())
		{
			out.println(itr.next());
		}
	}else {
		out.println("No Student record found");
	}
}
}