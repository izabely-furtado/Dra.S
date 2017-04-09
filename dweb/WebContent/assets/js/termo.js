/**
 * 
 */
function validaCPF(strCPF){
	var Soma;
    var Resto;
    Soma = 0;
	if (strCPF == "00000000000") {
		return false;
	}
    
	for (i=1; i<=9; i++) Soma = Soma + parseInt(strCPF.substring(i-1, i)) * (11 - i);
	Resto = (Soma * 10) % 11;
	
    if ((Resto == 10) || (Resto == 11))  Resto = 0;
    if (Resto != parseInt(strCPF.substring(9, 10)) ) {
    	return false;
    }
	
	Soma = 0;
    for (i = 1; i <= 10; i++) Soma = Soma + parseInt(strCPF.substring(i-1, i)) * (12 - i);
    Resto = (Soma * 10) % 11;
	
    if ((Resto == 10) || (Resto == 11))  Resto = 0;
    if (Resto != parseInt(strCPF.substring(10, 11) ) ) {
    	return false;
    }
    else {
    	return true;
    }
}

function gerar(){
	var nome = document.getElementById("nome").value;
    var cpf = document.getElementById("cpf").value;
    var motivo = document.getElementById("motivo").value;
    var resp = document.getElementById("resp").value;
    var tecresp = document.getElementById("tecresp").value;
    document.getElementById("nome").style.border = "1px solid #ccc";
    document.getElementById("cpf").style.border = "1px solid #ccc";
    document.getElementById("motivo").style.border = "1px solid #ccc";
    document.getElementById("resp").style.border = "1px solid #ccc";
    document.getElementById("tecresp").style.border = "1px solid #ccc";
    
    var erro="";
    
    if (nome == "") {
        erro += "Informe o nome \n";
        document.getElementById("nome").style.border = "1px solid red";
    }
    if (cpf == "" || !validaCPF(cpf.replace(/[^0-9]/g, ""))) {
        erro += "Informe um CPF válido! \n";
        document.getElementById("cpf").style.border = "1px solid red";
    }
    if (motivo == "") {
        erro += "Informe o motivo \n";
        document.getElementById("motivo").style.border = "1px solid red";
    }
    if (resp == "") {
        erro += "Informe o responsável \n";
        document.getElementById("resp").style.border = "1px solid red";
    }
    if (tecresp == "") {
        erro += "Informe o técnico responsável \n";
        document.getElementById("tecresp").style.border = "1px solid red";
    }
    
    if (erro != "") {
        alert(erro);
    }
    else {
        window.location.href = "./termo.html";
    }
    
}