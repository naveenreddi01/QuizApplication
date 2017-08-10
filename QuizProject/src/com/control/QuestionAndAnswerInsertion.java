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
 * Servlet implementation class QuestionAndAnswerInsertion
 */
@WebServlet("/QuestionAndAnswerInsertion")
public class QuestionAndAnswerInsertion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QuestionAndAnswerInsertion() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		System.out.println("hII");
		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String sub=request.getParameter("subject");
		String que=request.getParameter("question");
		String ans1=request.getParameter("answer1");
		String ans2=request.getParameter("answer2");
		System.out.println("3rd line");
		System.out.println(sub +" "+que+" "+ans1 +" "+ans2);
		int c=DataBaseConnectivity.insertionQuestionAndAnswer(sub,que,ans1,ans2);
		System.out.println(c);
			if(c>0){
				System.out.println("inserted successful");
				out.println("inserted successful");
			}
			
			else{
				System.out.println("insertion failure");
				out.println("inserted not successful");
				
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
