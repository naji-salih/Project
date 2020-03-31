<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
<%
	out.print("<h1>" + request.getParameter("name").toUpperCase() + "</h1>");
%>