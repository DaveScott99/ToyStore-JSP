<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>  
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="utf-8">
<title>.:ToyStore:.</title>
<link rel="stylesheet" type="text/css" href="css/styles.css"
	media="screen" />
</head>
<body>
	
	<div class="container">
		
        <div class="content">
    
            <main class="main">

                <div class="navigation">
                	<h2>Catálogo de Brinquedos</h2>
                    <span>></span>
                    <h2><%out.print(request.getAttribute("name_category"));%></h2>
                    <span>></span>
                    <h2><%out.print(request.getAttribute("name_product"));%></h2>
                </div>
               
                <article class="container-product">

                    <div class="product">
                        <div class="product-cover">
                            <img src="assets/<%out.print(request.getAttribute("image_name"));%>" alt="Imagem do produto">
                        </div>
    
                        <div class="product-info">
                            <div class="product-code">
                                <span>Código: <%out.print(request.getAttribute("id_product"));%></span>
                            </div>
                            <div class="product-name">
                                <h2><%out.print(request.getAttribute("name_product"));%></h2>
                            </div>
                            <div class="product-price">
                                <span>R$ <%out.print(request.getAttribute("price_product"));%></span>
                            </div>
                        </div>
                    </div>

                    <div class="product-description">
                        <p><%out.print(request.getAttribute("description_product"));%></p>
                    </div>

                </article>               
                
            </main>
    
        </div>
		
        <aside class="aside">
        	<a href="home">
	        	<div class="logo">
	                <img alt="logo" src="imgs/ToyStore-logo.png">
	            </div>
        	</a>

           <nav class="menu">
                <ul>
                    <a href="home"><li class="menu-item">Home</li></a>
                    <a href="categories"><li class="menu-item">Catálogo de Brinquedos</li></a>
                    <a href="admin"><li class="menu-item">Administração</li></a>
                    <a href="#"><li class="menu-item">Sobre a equipe</li></a>
                </ul>
            </nav>
        </aside>
		
	</div>
	
</body>
</html>