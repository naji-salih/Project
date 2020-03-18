<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

 <form action="BookController" method="get">
	
	 <fieldset>		
      <input type="text" id="name" class="name" name="name" placeholder="name">
      <input type="text" id="genre" class="genre" name="genre" placeholder="genre">
      <input type="text" id="seiten" class="seiten" name="seiten" placeholder="seiten">
      </fieldset>
      	
      <fieldset>	
      <input type="text" id="vname" class="vname" name="vname" placeholder="vname">
      <input type="text" id="nname" class="nname" name="nname" placeholder="nname">
	<input type="date" id="datum" class="datum" name="datum" placeholder="datum">
      </fieldset>
      
      <input type="submit" class="antwort" value="send" name="send">
   
    </form>

</body>
</html>