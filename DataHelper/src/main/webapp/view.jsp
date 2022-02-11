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
<table border="1">
<tr>
<th>studentid</th><th>studentmarks</th><th>studentname</th>
</tr>
<% 
Datahelper.connection();
ResultSet res=Datahelper.dqlOpe("select * from student");
while(res.next())
{%>
<tr>
<td><%=res.getString(1) %></td>
<td><%=res.getString(2) %></td>
<td><%=res.getString(3) %></td>
<td><a href="edit.jsp?q=<%=res.getString(1)%>">EDIT</a></td>
<td><a href="delete.jsp?q=<%=res.getString(1)%>">DELETE</a></td>
</tr>
<%} %>
<%
if(request.getParameter("q")!=null)
{
out.print(request.getParameter("q"));	
}
%>
<form action="insertSer" method="post">
<tr>
<td><input type="number" name="txtid" placeholder="enter id" /></td>
<td><input type="number" name="txtmarks" placeholder="enter marks" /></td>
<td><input type="text" name="txtname" placeholder="enter name" /></td>
<td colspan="2"><input type="submit" name="btn" value="INSERT"></td>
</tr>
</form>
</table>
</body>
</html>