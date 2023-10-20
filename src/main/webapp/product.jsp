<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>  

<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="utf-8">
<title>.:ToyStore - Produto:.</title>
</head>
<body>
	
	<a href="home">Home</a>
	<a href="categories">Categorias</a>
	
	<%out.print(request.getAttribute("name_product"));%>
	<%out.print(request.getAttribute("price_product"));%>
	<%out.print(request.getAttribute("description_product"));%>
	
</body>
</html>