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
                    <h2>Categorias</h2>
                </div>

                <div class="l-cards-category">
                
                <%
				for (Category cat : categories) {
					%>
                    
					<article class="card-category">
                       	<a href="selectCategory?idCategory=<%=cat.getId()%>">
                            <img src="assets/<%=cat.getImageName()%>" alt="" class="product-image-category"/>
                            <h2 class="name"><%=cat.getName()%></h2>
                        </a>
					</article>  
            
					<%
					}
				%>

                </div>
                
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