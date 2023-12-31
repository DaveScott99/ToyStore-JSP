<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="br.com.toyStore.model.Category"%>
<%@ page import="java.util.List"%>
<%
	List<Category> categories = (List<Category>) request.getAttribute("categories");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
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
                    <h2>Nova brinquedo</h2>
                </div>

                
			<form class="form-registry" name="frmNewProduct" action="insertProduct" method="post" enctype="multipart/form-data">

                <div class="form-controls">
                    <div class="labels">
                        <label>Nome:</label>
                        <label>Categoria:</label> 
                        <label>Marca:</label> 
                        <label>Imagem:</label> 
                        <label>Valor:</label> 
                        <label>Detalhes:</label> 
                    </div>
    
                    <div class="inputs">
                        <input type="text" name="name" class="text-field" /> 
                        
                        <select name="category" size="1" class="text-field">
                        	
                        	<option value="">Selecione uma categoria</option>
                       	  <%
							for (Category cat : categories) {
								%>
									<option><%=cat.getName()%></option>
								<%
								}
							%>
                        </select>
                        
                        <input type="text" name="brand" class="text-field" />
                        <input type="file" name="image" class="text-field" />
                        <input type="number" name="price" class="text-field" id="value"/>
                        <textarea name="description" class="text-field" placeholder="Escreva aqui os detalhes do brinquedo..."></textarea>
                    </div>    
                </div>

			</form>
				
			<div class="container-button-new-toy">
				<button class="new-toy" onclick="validateNewProduct()">Salvar dados</button>
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
    
	<script src="scripts/scripts.js" defer></script>

</body>
</html>