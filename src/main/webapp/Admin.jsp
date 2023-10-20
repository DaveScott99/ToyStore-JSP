<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="utf-8">
<title>.:ToyStore - Login:.</title>
</head>
<body>

	<%
		String user = (String) session.getAttribute("username");
	
		if (user == null) {
			response.sendRedirect("Login.jsp");
		}
		else {
			out.print("Bem vindo, " + user +" <br/>");
		}
	%>

	<h3>Login Realizado com sucesso</h3>
	<a href="Loggout.jsp">Deslogar</a>

</body>
</html>