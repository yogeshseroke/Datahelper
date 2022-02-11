

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
 * Servlet implementation class editSer
 */
@WebServlet("/editSer")
public class editSer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public editSer() {
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
			int x=Datahelper.dmlOpe("update student set studentid='"+request.getParameter("txtid")+"',studentmarks='"+request.getParameter("txtmarks")+"',studentname='"+request.getParameter("txtname")+"'");
           Datahelper.closeConn();
           if(x!=0)
           {
        	   response.sendRedirect("view.jsp?q=data update");
           }
           else
           {
        	   response.sendRedirect("view.jsp?q=data not update");
           }
		}
		catch(Exception ex)
		{
			out.print(ex.getMessage().toString());
		}
	}

}
