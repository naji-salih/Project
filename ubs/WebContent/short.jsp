<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>${ 1+ 1}</h1>
<%= request.getParameter("name") %>
<h1>${ param["name"] }</h1>
	${ EineZahl }<br/>
	${ EinString }<br/>
	${ Counter }<br/>
	${ DataShort.getName }<br/>
	${ DataShort.getAdresse.strasse }<br/>
	${ person}<br/>
	<%
		for(int i = 0; i < 2; i++){
			request.setAttribute("i", i);
			out.print(i);
		}
	
	%>
	
	${sessionScope["EineZahl"]}
</body>
</html>