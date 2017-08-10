package com.control;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.databaseconnectivity.DataBaseConnectivity;
import com.mysql.jdbc.PreparedStatement;

/**
 * Servlet implementation class InsertionServlet
 */
@WebServlet("/InsertionServlet")
public class InsertionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertionServlet() {
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
		int id=Integer.parseInt(request.getParameter("id"));
		String name=request.getParameter("name");
		String user=request.getParameter("user");
		String pass=request.getParameter("password");
		String address=request.getParameter("city");
		System.out.println(name+" "+ user+" "+ pass+" "+ address);
		int c=DataBaseConnectivity.insertion(id, name, user, pass, address);
		System.out.println(c);
			if(c>0){
				System.out.println("inserted successful");
				RequestDispatcher rd=request.getRequestDispatcher("Login.html");
				rd.forward(request, response);
			}
			
			else{
				System.out.println("insertion failure");
				RequestDispatcher rd=request.getRequestDispatcher("SignUp.html");
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
