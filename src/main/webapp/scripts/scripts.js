/**
 * Validação de formulário
 * @author Davi
 */

function validateUserLogin() {
	
	let username = frmLoginUser.username.value;
	let password = frmLoginUser.password.value;

	if (username === "") {
		window.alert("Preencha o campo Usuário");
		frmLoginUser.name.focus();
		return false;
	}
	else if (password === "") {
		window.alert("Preencha o campo Senha");
		frmLoginUser.password.focus();
		return false;
	}
	else {
		document.forms["frmLoginUser"].submit();
	}
	
}

 function validateNewProduct() {
	let name = frmNewProduct.name.value;
	let price = frmNewProduct.price.value;
	let category = frmNewProduct.category.value;
	let description = frmNewProduct.description.value;

	if (name === "") {
		window.alert("Preencha o campo Nome");
		frmNewProduct.name.focus();
		return false;
	}
	else if (price === "") {
		window.alert("Preencha o campo Valor");
		frmNewProduct.price.focus();
		return false;
	}
	else if (category === "") {
		window.alert("Preencha o campo Categoria");
		frmNewProduct.category.focus();
		return false;
	}
	else if (description === "") {
		window.alert("Preencha o campo Descrição");
		frmNewProduct.description.focus();
		return false;
	}
	
	else {
		document.forms["frmNewProduct"].submit();
	}
 }
 
function deleteProduct(idProduct) {
	 let response = confirm("Confirma a exclusão deste produto ?");
	 
	 if (response === true) {
		window.location.href = "deleteProduct?idProduct=" + idProduct;
	 }
 }