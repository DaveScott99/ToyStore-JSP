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
                    <h2>Editar brinquedo</h2>
                </div>

                
			<form class="form-registry" name="frmUpdateProduct" method="post" action="updateProduct" enctype="multipart/form-data">

                <div class="form-controls">
                    <div class="labels">
                        <label>Código:</label>
                        <label>Nome:</label>
                        <label>Categoria:</label> 
                        <label>Marca:</label> 
                        <label>Imagem:</label> 
                        <label>Valor:</label> 
                        <label>Detalhes:</label> 
                    </div>
    
                    <div class="inputs">
                        <input type="number" name="code" class="text-field" id="code-field" min="1" readonly="readonly"
                        value="<%out.print(request.getAttribute("id_product"));%>"/>
                        
                        <input type="text" name="name" class="text-field" 
                        value="<%out.print(request.getAttribute("name_product"));%>"/> 
                        
                         <select name="category" size="1" class="text-field">
                        	
                        	<option value="<%out.print(request.getAttribute("name_category"));%>" selected="selected"><%out.print(request.getAttribute("name_category"));%></option>
                       	  <%
							for (Category cat : categories) {
								%>
									<option><%=cat.getName()%></option>
								<%
								}
							%>
                        </select>
                        
                        <input type="text" name="brand" value="<%out.print(request.getAttribute("brand_product"));%>" class="text-field" />
                        
                        <input type="text" name="image-name" value="<%out.print(request.getAttribute("image_product"));%>" style="display: none">
                        
                        <input type="file" value="" name="image" class="text-field" />
                        
                        <input type="number" name="price" class="text-field" id="value" 
                        value="<%out.print(request.getAttribute("price_product"));%>"/>
                        
                        <textarea name="description" class="text-field" placeholder="Escreva aqui os detalhes do brinquedo..." 
                        ><%out.print(request.getAttribute("description_product"));%></textarea>
                    </div>    
                </div>

			</form>
				
			<div class="container-button-new-toy">
				<button class="new-toy" onclick="validadeUpdateProduct()">Salvar edição</button>
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