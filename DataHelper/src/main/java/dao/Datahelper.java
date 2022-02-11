package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Datahelper {
	static  Connection conn;
	static Statement st;
	public static void connection() throws Exception
	{
		 Class.forName("com.mysql.jdbc.Driver");
		 conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/markstest","root","");
		 st = conn.createStatement();
	}

	public static int dmlOpe(String query) throws Exception
	{
		return st.executeUpdate(query);
	}

	public static ResultSet dqlOpe(String query) throws Exception
	{
		return st.executeQuery(query);
	}

	public static void closeConn() throws Exception
	{
		conn.close();
	}

	}


