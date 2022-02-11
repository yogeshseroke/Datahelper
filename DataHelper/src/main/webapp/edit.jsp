<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ page import="java.sql.*" %>
    <%@ page import="dao.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="editSer" method="post">
<table>
<tr>
<%
if(request.getParameter("q")!=null)
{
  Datahelper.connection();
  ResultSet res=Datahelper.dqlOpe("select * from student where studentid='"+request.getParameter("q")+"'");
  while(res.next())
  {
  %>
  <td><input type="number" name="txtid" value="<%= res.getString(1) %>" /></td>
  <td><input type="number" name="txtmarks" value="<%= res.getString(2) %>" /></td>
  <td><input type="text" name="txtname" value="<%= res.getString(3) %>" /></td>
  <td colspan="2"><input type="submit" name="btn" value="EDIT"></td>
</tr>
</table>
</form>
	  <%
  }
}
%>

</body>
</html>