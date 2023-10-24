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
					<h2>Catálogo de Brinqudos : : Nome da categoria</h2>
                </div>

                <div class="l-cards">
                
                <%
					for (Product product : products) {
					%>
						
						<a href="selectProduct?idProduct=<%=product.getId()%>">
	                        <article class="card">
	                            <img src="https://m.media-amazon.com/images/I/81zdQczhOCL.jpg" alt="" class="product-image"/>
	                            <p><%=product.getName()%></p>
	                            <p>R$ <%=product.getPrice()%></p>
	                        </article>    
                   	 	</a>
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