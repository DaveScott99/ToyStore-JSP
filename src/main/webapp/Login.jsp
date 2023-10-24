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
            <header class="header">

                <div class="brand">
                    <h1>ToyStore</h1>
                </div>
    
            </header>
    
            <main class="main">
                
               <form class="form-login" action="login" method="post" name="frmLoginUser">
                    <div class="field">
                        <label>Usuário</label>
                        <input type="text" name="username" />
                    </div>
                    <div class="field">
                        <label>Senha</label>
                        <input type="password" name="password" />
                    </div>

                    <div class="field">
                        <button class="btn-login" onclick="validateUserLogin()">Logar</button>
                    </div>
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