/**
 * Validação de formulário
 * @author Davi
 */

 function validateNewProduct() {
	let name = frmNewProduct.name.value;
	let price = frmNewProduct.price.value;
	let category = frmNewProduct.category.value;
	let description = frmNewProduct.description.value;

	if (name === "") {
		window.alert("Preencha o campo Nome");
		frmAluno.name.focus();
		return false;
	}
	else if (price === "") {
		window.alert("Preencha o campo Valor");
		frmAluno.email.focus();
		return false;
	}
	else if (category === "") {
		window.alert("Preencha o campo Categoria");
		frmAluno.address.focus();
		return false;
	}
	else if (description === "") {
		window.alert("Preencha o campo Descrição");
		frmAluno.address.focus();
		return false;
	}
	
	else {
		document.forms["frmNewProduct"].submit();
	}
 }
 
function confirmation(raAluno) {
	 let response = confirm("Confirma a exclusão deste produto ?");
	 
	 if (response === true) {
		window.location.href = "delete?raAluno=" + raAluno;
	 }
 }