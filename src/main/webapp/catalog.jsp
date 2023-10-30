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
<title>.:ToyStore:.</title>
<link rel="stylesheet" type="text/css" href="css/styles.css"
	media="screen" />
</head>
<body>
	
	<div class="container">
		
        <div class="content">
            <header class="header">

                <div class="brand">
                    <h1>ToyStore</h1>
                </div>
    
            </header>
    
            <main class="main">
                
                <div class="navigation">
					<h2>Catálogo de Brinquedos : : <%out.print(request.getAttribute("name_category"));%></h2>
                </div>

                <div class="l-cards">
                
                <%
					for (Product product : products) {
					%>	
						<article class="card">
	                       	<a href="selectProduct?idProduct=<%=product.getId()%>">
	                            <img src="assets/<%=product.getImageName()%>" alt="Imagem do produto" class="product-image"/>
	                            <h2 class="name"><%=product.getName()%></h2>
	                            <span class="price">R$ <%=product.getPrice()%></span>
	                        </a>
                       </article>    
					<%
					}
				%>
                
                </div>
                
            </main>
    
        </div>
		
        <aside class="aside">
            <div class="logo">
                logo
            </div>

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