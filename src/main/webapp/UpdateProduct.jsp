<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>.:ToyStore:.</title>
<link rel="stylesheet" type="text/css" href="./styles.css"
	media="screen" />
</head>
<body>

	<a href="home">Home</a>
	<a href="categories">Categorias</a>
	<a href="admin">Administração</a>
	
	<br />

		<main>
		
			<form name="frmNewProduct" action="updateProduct">

				<div class="field">
					<label>Código: </label> 
					<input type="number" name="id_product"
						min="1" readonly="readonly"
						value="<%out.print(request.getAttribute("id_product"));%>" /> 
				</div>
				
				<div class="field">
					<label>Nome: </label> 
					<input type="text" name="name" 
						value="<%out.print(request.getAttribute("name_product"));%>" />
				</div>
				
				<div class="field">
					<label>Categoria: </label> 
					<input type="text" name="category" 
						value="<%out.print(request.getAttribute("name_category"));%>" />
				</div>
				<div class="field">
					<label>Marca: </label> 
					<input type="text" name="name_brand" />
				</div>
				<div class="field">
					<label>Imagem: </label> 
					<input type="text" name="image" />
				</div>
				<div class="field">
					<label>Valor: </label> 
					<input type="number" name="price" 
						value="<%out.print(request.getAttribute("price_product"));%>" />
				</div>
				<div class="field">
					<label>Detalhes: </label> 
					<input type="text" name="description" 
						value="<%out.print(request.getAttribute("description_product"));%>" />
				</div>

			</form>
			
			<br />

			<div>
				<button onclick="validateNewProduct()">Salvar edição</button>
			</div>
		</main>

	<script src="scripts/scripts.js" defer></script>
</body>
</html>