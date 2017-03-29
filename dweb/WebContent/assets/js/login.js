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