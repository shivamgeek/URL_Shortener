package com.shivam.testDB;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class TestDbServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String user = "root", pass = "rootroot";
		String jdbcUrl = "jdbc:mysql://localhost:3306/web_customer_tracker";
		String driver = "com.mysql.jdbc.Driver";
		
		try {
			
			PrintWriter out = response.getWriter();
			out.println("Checking DB connectivity to "+jdbcUrl);
			
			Class.forName(driver);
			
			Connection con = DriverManager.getConnection(jdbcUrl, user, pass);
			
			out.println("Connectivity to DB Succesful");
			
			con.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
