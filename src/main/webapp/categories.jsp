<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>  
<%@page import="br.com.toyStore.model.Category"%>
<%@ page import="java.util.List"%>
<%
	List<Category> categories = (List<Category>) request.getAttribute("categories");
%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="utf-8">
<title>.:ToyStore - Categorias:.</title>
</head>
<body>
	
	<a href="home">Home</a>
	<a href="categories">Categorias</a>
	<a href="Login.jsp">Administração</a>

	<table>
		<tbody>
			<%
				for (Category cat : categories) {
				%>
					<tr>
						<td><%=cat.getName()%></td>
							
						<td><a href="selectCategory?idCategory=<%=cat.getId()%>"
								class="btn-edit">Selecionar</a> </td>
					</tr>
				<%
				}
			%>
		</tbody>
	</table>
	
	
</body>
</html>