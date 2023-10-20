<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="utf-8">
<title>.:ToyStore - Login:.</title>
</head>
<body>

	<form action="login" name="frmLoginUser">
		Usuário: <br/><input type="text" name="username"/><br/>
		Senha: <br/><input type="password" name="password"/><br/>
		<button onclick="validateUserLogin()">Logar</button>
	</form>
	
	<script src="scripts/scripts.js" defer></script>

</body>
</html>