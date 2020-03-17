<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
 <form action="Controller" method="get">
	 <% 
	 	out.println(session.getAttribute("name"));
	 	out.println(session.getAttribute("count"));
	 %>
	
    </form>

</body>
</html>