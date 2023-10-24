<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
            <header class="header">

                <div class="brand">
                    <h1>ToyStore</h1>
                </div>
    
            </header>
    
            <main class="main">
                
                <div class="navigation">
                    <h2>Catálogo de Brinqudos : : Editar brinquedo</h2>
                </div>

                
			<form class="form-registry" name="frmProduct" method="post">

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
                        
                        <input type="text" name="category" class="text-field" 
                        value="<%out.print(request.getAttribute("name_category"));%>"/>
                        
                        <input type="text" name="brand" class="text-field" />
                        <input type="file" name="image" class="text-field" />
                        
                        <input type="number" name="value" class="text-field" id="value" 
                        value="<%out.print(request.getAttribute("price_product"));%>"/>
                        
                        <textarea type="text" name="descritpion" class="text-field" placeholder="Escreva aqui os detalhes do brinquedo..." 
                        ><%out.print(request.getAttribute("description_product"));%></textarea>
                    </div>    
                </div>

                <button class="new-toy" onclick="validateNewProduct()">Salvar edição</button>

			</form>

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

	<script src="scripts/scripts.js" defer></script>
</body>
</html>