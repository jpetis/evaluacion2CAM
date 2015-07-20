
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="jsp2.Departments"%>
<%@ page import="jsp2.EmployeesDAO"%>
<%@ page import="jsp.listadoDepartamentos"%> 
<%@ page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<% List<Departments> lista = (ArrayList<Departments>)request.getAttribute("departaments_id"); %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Selecciona departamento</title>
</head>
<body>
<%-- Esto es una tabla
<h1>Departamentos</h1>
	<table id="departaments_id">
		<tr>
			<th>Department ID</th>
			<th>Department Name</th>
		</tr>
		<%
			for (Departments dep : lista) {
		%>
		<tr>
		<td><%=dep.getDepartmentId() %></td>
		<td><%=dep.getDepartmentName()%></td>
		</tr>
		<%
			}
		%>
	</table> --%>
	<%--Esto para que salga en un combo --%>
	
	<form method="GET" action="listarEmpleados">
		<select name="departamento">
			<% 
			for (int i = 0; i < lista.size(); i++) 
			{	%>
					
			<option name="<%=lista.get(i).getDepartmentId()%>"><%=lista.get(i).getDepartmentName()%></option>
			<%
				}
			%>
		</select> <input type="submit" value="Obtener Empleados" />
	</form>
</body>
</html>