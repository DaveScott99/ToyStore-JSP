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
<title>.:ToyStore - Administração:.</title>
</head>
<body>
	<h2>Administração</h2>
				
	<a href="home">Home</a>
	<a href="categories">Categorias</a>
	<a href="admin">Administração</a>
	
	<br/>
	<br/>
	
	<table>
		
		<thead>
			<tr>
				<th>Descrição</th>
				<th>Categoria</th>
				<th>Valor</th>
				<th>Controles</th>
			</tr>
		</thead>
		
		<tbody>
			<%
				String user = (String) session.getAttribute("username");

				if (user == null) {
					response.sendRedirect("Login.jsp");
				}
				else {
					for (Product product : products) {
					%>
					<tr>
						<td><%=product.getName()%></td>
						<td><%=product.getCategory().getName()%></td>
						<td><%=product.getPrice()%></td>
						<td>
							<a href="selectProductUpdate?idProduct=<%=product.getId()%>"
								class="btn-edit">Editar</a>
							<a
							href="javascript: deleteProduct(<%=product.getId()%>)"
							class="btn-delete">Excluir</a>
						</td>
					</tr>
					<%
					}
				}
			%>
		</tbody>
	</table>

	<br/>
	
	<a href="./newProduct.html">Novo produto</a>
	
	<br/>
	<br/>
	
	<a href="Loggout.jsp">Deslogar</a>
	
	<script src="scripts/scripts.js" defer></script>

</body>
</html>