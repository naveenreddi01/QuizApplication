package com.control;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.databaseconnectivity.DataBaseConnectivity;
import com.mysql.jdbc.PreparedStatement;

/**
 * Servlet implementation class FirstServlet
 */
@WebServlet("/FirstServlet")
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public FirstServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String uname=request.getParameter("user");
		String pass=request.getParameter("password");
		out.println(uname+" "+pass);
		System.out.println("Hiii");
		int status=DataBaseConnectivity.validation(uname,pass,1);
		
		
		/*try {
			System.out.println("Hiii");
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/school","root","root");
			PreparedStatement pst=(PreparedStatement) con.prepareStatement("select * from student");
			ResultSet rs=pst.executeQuery();
			System.out.println("Hiii");
			while(rs.next()){
				System.out.println();
				System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4)+" "+rs.getString(5));
				if(uname.equals(rs.getString(3))&&pass.equals(rs.getString(4))){
					System.out.println("Success coming");
					status=2;
					break;
				}else{
					
					System.out.println("Error coming");
					
					continue;
				}
			}
		*/	if(status==2){
				System.out.println("Success page");
				RequestDispatcher rd=request.getRequestDispatcher("Success.html");
				rd.forward(request, response);
				
			}
			else{
				System.out.println("Error page");
				RequestDispatcher rd=request.getRequestDispatcher("error.html");
				rd.forward(request, response);
			}
			
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
