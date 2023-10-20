<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>  
<%@ page import="br.com.toyStore.model.Product"%>
<%@ page import="java.util.List"%>
<%
	List<Product> products = (List<Product>) request.getAttribute("products");
%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="utf-8">
<title>.:ToyStore - Catálogo:.</title>
</head>
<body>
	
	<a href="home">Home</a>
	<a href="categories">Categorias</a>
	<a href="./newProduct.html">Novo produto</a>
				
	<table>
		
		<tbody>
			<%
				for (Product product : products) {
				%>
				<tr>
					<td><%=product.getName()%></td>
					<td><%=product.getPrice()%></td>
					<td><%=product.getDescription()%></td>
					<td><a href="selectProduct?idProduct=<%=product.getId()%>"
							class="btn-edit">Selecionar</a> </td>
				</tr>
				<%
				}
			%>
		</tbody>
	</table>
	
	
	
</body>
</html>