package com.control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.databaseconnectivity.DataBaseConnectivity;

/**
 * Servlet implementation class TeacherDataInsertion
 */
@WebServlet("/TeacherDataInsertion")
public class TeacherDataInsertion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TeacherDataInsertion() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String name=request.getParameter("name");
		String user=request.getParameter("user");
		String pass=request.getParameter("password");
		
		String address=request.getParameter("city");
		System.out.println(name+" "+ user+" "+ pass+" "+ address);
		int c=DataBaseConnectivity.insertionTeacher(name, user, pass, address);
		if(c>0){
			System.out.println("inserted successful");
			RequestDispatcher rd=request.getRequestDispatcher("TeacherLogin.html");
			rd.forward(request, response);
		}
		
		else{
			System.out.println("insertion failure");
			RequestDispatcher rd=request.getRequestDispatcher("TeacherSignUp.html");
			rd.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
