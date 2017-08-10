package com.databaseconnectivity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;

import com.mysql.jdbc.PreparedStatement;

public class DataBaseConnectivity {
	static int c=0;
	static int k=0;
	static int l=0;
	public static Connection Database() throws ClassNotFoundException, SQLException{
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/school","root","root");
		return con;
	}
	public static int validation(String user,String passwd,int flags){
		
		String uname=user;
		String pass=passwd;
		int flag=flags;
		int status=0;
		String query1="select * from student";
		String query2="select * from teacher";
		
		try {
			System.out.println("Hiii");
			
			Connection con=Database();
			
			if(flag==1){
				PreparedStatement pst=(PreparedStatement) con.prepareStatement(query1);
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
			}
			if(flag==2){
				PreparedStatement pst=(PreparedStatement) con.prepareStatement(query2);
				ResultSet rs=pst.executeQuery();
				System.out.println("Hiii");
				while(rs.next()){
					System.out.println();
					System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4));
					if(uname.equals(rs.getString(2))&& pass.equals(rs.getString(3))){
						System.out.println("Success coming");
						status=2;
						break;
					}else{
						
						System.out.println("Error coming");
						
						continue;
					}
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return status;
		
	}
	public static int insertion(int id,String name,String user,String pass,String address){
		int uid=id;
		String uname=name;
		String uuser=user;
		String upass=pass;
		String uaddress=address;
		System.out.println(name+" "+ user+" "+ pass+" "+ address);
		try {
			System.out.println("Hiii");
			Connection con=Database();
			PreparedStatement pst= (PreparedStatement) con.prepareStatement("insert into student values(?,?,?,?,?)");
			pst.setInt(1, uid);
			pst.setString(2, uname);
			pst.setString(3, uuser);
			pst.setString(4, upass);
			pst.setString(5, uaddress);
			c=pst.executeUpdate();
			System.out.println(c);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
	
		return c;
		
	}
	public static int insertionTeacher(String name,String user,String pass,String address){
		System.out.println("Enteruing");
		String uname= name;
		String uuser =user;
		String upass =pass;
		
		String uaddress=address;
		System.out.println(name+" "+ user+" "+ pass+" "+ address);
		try {
			System.out.println("Hiii");
			Connection con=Database();
			PreparedStatement pst= (PreparedStatement) con.prepareStatement("insert into teacher values(?,?,?,?)");
			pst.setString(1, uname);
			
			pst.setString(2, uuser);
			pst.setString(3, upass);
			
			pst.setString(4, uaddress);
			c=pst.executeUpdate();
			System.out.println(c);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
	
		return c;
	
	}
	public static int insertionsubject(String sub,String subdesc){
		
		System.out.println("Database coming");
		String subject=sub;
		String subjectdesc=subdesc;
		
		System.out.println(subject+"  "+subjectdesc);
		try {
			System.out.println("try coming");
			System.out.println("Hiii");
			Connection con=Database();
			PreparedStatement pst= (PreparedStatement) con.prepareStatement("insert into subject values(?,?)");
			pst.setString(1, subject);
			
			pst.setString(2, subjectdesc);
			
			c=pst.executeUpdate();
			System.out.println(c);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return c;
		
	}
public static int insertionQuestionAndAnswer(String sub,String que,String ans1,String ans2){
		
		System.out.println("Database coming");
		String subject=sub;
		String question=que;
		String answer1=ans1;
		String answer2=ans2;
		Random rand = new Random();

		int  rn = rand.nextInt(50) + 1;
		int aid=rand.nextInt(50) + 1;
		
		System.out.println(subject+"  "+question+"  "+answer1+"  "+answer2);
		try {
			System.out.println("try coming");
			System.out.println("Hiii");
			Connection con=Database();
			PreparedStatement pst1= (PreparedStatement) con.prepareStatement("insert into question values(?,?,?)");
			pst1.setInt(1,rn);
			pst1.setString(2,question);
			
			pst1.setString(3,subject);
			
			c=pst1.executeUpdate();
			
			System.out.println(c);
			if(c>0){
				PreparedStatement pst2= (PreparedStatement) con.prepareStatement("insert into answer values(?,?,?)");
				pst2.setInt(1,aid);
				pst2.setString(2,answer1);
				
				pst2.setInt(3,rn);
				
				k=pst2.executeUpdate();
				
				PreparedStatement pst3= (PreparedStatement) con.prepareStatement("insert into answer values(?,?,?)");
				pst3.setInt(1,aid);
				pst3.setString(2,answer1);
				
				pst3.setInt(3,rn);
				
				l=pst3.executeUpdate();
				if(k>0&&l>0){
					System.out.println("Answer added");
				}
				
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
		return (k+l);
		
	}
	
}
