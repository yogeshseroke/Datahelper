

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Datahelper;
import java.sql.*;

/**
 * Servlet implementation class insertSer
 */
@WebServlet("/insertSer")
public class insertSer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public insertSer() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		PrintWriter out=response.getWriter();
		try
		{
			Datahelper.connection();
			ResultSet res=Datahelper.dqlOpe("select * from student where studentid='"+request.getParameter("txtid")+"'");
		    if(res.next())
		    {
		    	response.sendRedirect("view.jsp?q=This is already exists");
		    }
		    else
		    {
		    	response.sendRedirect("view.jsp");
		    }
		    int x=Datahelper.dmlOpe("insert into student(studentid,studentmarks,studentname) value('"+request.getParameter("txtid")+"','"+request.getParameter("txtmarks")+"','"+request.getParameter("txtname")+"')");
	      Datahelper.closeConn();
	      if(x!=0)
	      {
	    	  response.sendRedirect("view.jsp");
	      }
	      else
	      {
	    	  response.sendRedirect("view.jsp?q=insert data first");
	      }
		}
		catch(Exception ex)
		{
			out.print(ex.getMessage().toString());
		}
	}

}
