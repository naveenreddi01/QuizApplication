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
 * Servlet implementation class SubjectInsertion
 */
@WebServlet("/SubjectInsertion")
public class SubjectInsertion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SubjectInsertion() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("hII");
		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		System.out.println("1st line");
		String sub=request.getParameter("subject");
		String subdesc=request.getParameter("subjectdesc");
		System.out.println("3rd line");
		System.out.println(sub +" "+subdesc);
		int c=DataBaseConnectivity.insertionsubject(sub,subdesc);
		System.out.println(c);
			if(c>0){
				System.out.println("inserted successful");
				RequestDispatcher rd=request.getRequestDispatcher("AddQuestion.html");
				rd.forward(request, response);
			}
			
			else{
				System.out.println("insertion failure");
				RequestDispatcher rd=request.getRequestDispatcher("Addsubject1.html");
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
