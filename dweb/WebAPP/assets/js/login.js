function login() {
		var nome = document.getElementById("nome").value;
		var senha = document.getElementById("senha").value;
		if (nome == "admin") {
			if (senha == "admin") {
				window.location.href = "./inicio.html"
			} else {
				alert("Senha incorreta para este usuário!");
			}
		} else {
			alert("Senha e usuários incorretos!");
		}
}

function editar() {
    //document.getElementById("nome").innerHTML = document.getElementById("nome").value;

    window.location.href = "./alterarDadosAcesso.html"
    
}

function alterar() {
    var nome = document.getElementById("nome").value;
    var senhaP = document.getElementById("senhaP").value;
    var senha = document.getElementById("senha").value;
    var repita = document.getElementById("repita").value;
    var email = document.getElementById("email").value;
    var lembrar = document.getElementById("lembrar").value;
    var regex = '[^a-zA-Z0-9]+';
    var erro="";
    
    if (senhaP == "") {
        erro += "Informe a senha existente \n";
        document.getElementById("senhaP").style.border = "1px solid red";
    }
    if (senha == "") {
        erro += "Informe a nova senha \n";
        document.getElementById("senha").style.border = "1px solid red";
        if (senha != repita) {
            erro += "SENHAS DIFERENTES!\nFAVOR DIGITAR SENHAS IGUAIS \n";
            document.getElementById("repita").style.border = "1px solid red";
        }
    }
    if (nome == "") {
        erro += "Informe o nome ou login \n";
        document.getElementById("nome").style.border = "1px solid red";
    }
    if (email == "") {
        erro += "Informe o E-mail \n";
        document.getElementById("email").style.border = "1px solid red";
    }
    if (senhaP != "admin") {
        erro += "Senha atual informada incorretamente! \n";
        document.getElementById("senhaP").style.border = "1px solid red";
    }
    if (senha != repita) {
        erro += "SENHAS DIFERENTES!\nFAVOR DIGITAR SENHAS IGUAIS \n";
        document.getElementById("repita").style.border = "1px solid red";
    }
    if (erro != "") {
        alert(erro);
    }
    else {
        window.location.href = "./dadosAcesso.html";
    }
    

}