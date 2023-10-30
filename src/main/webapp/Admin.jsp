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
                    <h2>Catálogo de Brinquedos : : Admininstração</h2>
                </div>

                <table class="table-data">
                    <thead>
                        <tr>
                            <th id="description">Descrição</th>
                            <th>Categoria</th>
                            <th>Valor</th>
                            <th>Controles</th>
                        </tr>
                    </thead>

                    <tbody>
	                    <%
							String user = (String) session.getAttribute("username");
			
							if (user == null) {
								response.sendRedirect("Login.jsp");
							}
							else {
								for (Product product : products) {
								%>
								<tr>
									<td id="description"><%=product.getName()%></td>
									<td><%=product.getCategory().getName()%></td>
									<td><%=product.getPrice()%></td>
									<td>
										<a href="selectProductUpdate?idProduct=<%=product.getId()%>"
											class="btn-edit">Editar</a>
										<a
										href="javascript: deleteProduct(<%=product.getId()%>)"
										class="btn-delete">Excluir</a>
									</td>
								</tr>
								<%
								}
							}
						%>
                    </tbody>
                </table>

                <a href="newProduct" class="new-toy">
                    <span>Novo Brinquedo</span>
                </a>
				<a href="./newCategory.html" class="new-category">
                    <span>Nova Categoria</span>
                </a>
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