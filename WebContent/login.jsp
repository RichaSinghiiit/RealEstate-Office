<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<!-- Redirects to LoginServlet which checks whether password is correct-->
<title>Insert title here</title>
</head>
<body>
	<form action="login" method="post">
		
		Enter password:<br><br>
		<input type="password" name="password"><br><br>
		<input type="submit" value="login">
		
	</form>
	<%
   		if(null!=request.getAttribute("errorMessage"))
    	{
        	out.println(request.getAttribute("errorMessage"));
    	}
	%>

</body>
</html>