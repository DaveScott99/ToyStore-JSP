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
	
	<%
		for (Product product : products) {
		%>
			<%=product.getName()%>
			<%=product.getPrice()%>
			<%=product.getDescription()%>
		<%
		}
	%>
	
</body>
</html>