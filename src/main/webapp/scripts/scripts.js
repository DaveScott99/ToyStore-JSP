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
	let category = frmNewProduct.category;
	let price = frmNewProduct.price.value;
	let description = frmNewProduct.description.value;
	let image = frmNewProduct.image.value;

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
	else if (category.options[category.selectedIndex].value === "") {
		window.alert("Selecione uma categoria");
		frmNewProduct.category.focus();
		return false;
	}
	else if (description === "") {
		window.alert("Preencha o campo Descrição");
		frmNewProduct.description.focus();
		return false;
	}
	else if (image === "") {
		window.alert("Selecione uma imagem para o produto");
		frmNewProduct.description.focus();
		return false;
	}
	else {
		document.forms["frmNewProduct"].submit();
	}
 }
 
  function validadeUpdateProduct() {
	let name = frmUpdateProduct.name.value;
	let category = frmUpdateProduct.category;
	let price = frmUpdateProduct.price.value;
	let description = frmUpdateProduct.description.value;

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
	else if (category.options[category.selectedIndex].value === "") {
		window.alert("Selecione uma categoria");
		frmNewProduct.category.focus();
		return false;
	}
	else if (description === "") {
		window.alert("Preencha o campo Descrição");
		frmNewProduct.description.focus();
		return false;
	}
	else {
		document.forms["frmUpdateProduct"].submit();
	}
 }
 
function validateNewCategory() {
	let name = frmNewCategory.name.value;
	let image = frmNewCategory.image.value;
	
	if (name === "") {
		window.alert("Preencha o campo Nome");
		frmNewCategory.name.focus();
		return false;
	}
	else if (image === "") {
		window.alert("Selecione uma imagem para a categoria");
		frmNewCategory.description.focus();
		return false;
	}
	else {
		document.forms["frmNewCategory"].submit();
	}
}
 
function deleteProduct(idProduct) {
	 let response = confirm("Confirma a exclusão deste produto ?");
	 
	 if (response === true) {
		window.location.href = "deleteProduct?idProduct=" + idProduct;
	 }
 }