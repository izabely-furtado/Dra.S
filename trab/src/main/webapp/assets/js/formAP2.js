function proximo2(){
	window.location.href = "./formularioAcompanhamentoPsico3.html"
}

function addParente() {
    //composi��o familiar
	var erro = "";
	var add = "";
	document.getElementById("nome").style.border = "1px solid #ccc";
	document.getElementById("parentesco").style.border = "1px solid #ccc";
	document.getElementById("idade").style.border = "1px solid #ccc";
	document.getElementById("dn").style.border = "1px solid #ccc";
	document.getElementById("situacao").style.border = "1px solid #ccc";
	document.getElementById("renda").style.border = "1px solid #ccc";
	document.getElementById("scfv").style.border = "1px solid #ccc";
	document.getElementById("escolaridade").style.border = "1px solid #ccc";
    var nome = document.getElementById("nome").value;
    if (nome == "") {
        erro += "Informe o nome \n";
        document.getElementById("nome").style.border = "1px solid red";
    }
    var parentesco = document.getElementById("parentesco").value;
    if (parentesco == "") {
        erro += "Informe o parentesco \n";
        document.getElementById("parentesco").style.border = "1px solid red";
    }
    var idade = document.getElementById("idade").value;
    if (idade == "") {
        erro += "Informe a idade \n";
        document.getElementById("idade").style.border = "1px solid red";
    }
    var dn = document.getElementById("dn").value;
    if (dn == "") {
        erro += "Informe a data de nascimento \n";
        document.getElementById("dn").style.border = "1px solid red";
    }
    var situacao = document.getElementById("situacao").value;
    if (situacao == "") {
        erro += "Informe a situacao \n";
        document.getElementById("situacao").style.border = "1px solid red";
    }
    var escolaridade = document.getElementById("escolaridade").value;
    if (escolaridade == "") {
        erro += "Informe a escolaridade \n";
        document.getElementById("escolaridade").style.border = "1px solid red";
    }
    var renda = document.getElementById("renda").value;
    if (renda == "") {
        erro += "Informe a renda \n";
        document.getElementById("renda").style.border = "1px solid red";
    }
    var scfv = document.getElementById("scfv").value;
    if (scfv == "") {
        erro += "Informe o scfv \n";
        document.getElementById("scfv").style.border = "1px solid red";
    }
    if (erro != ""){
    	alert(erro);
    //	add = "";
    }
    
    document.getElementById("parente").innerHTML += "<tr><td>" + nome + "</td><td>" + parentesco + "</td><td>" + idade + "</td><td>" + dn + "</td><td>" + situacao + "</td><td>" + escolaridade + "</td><td>" + renda + "</td><td>" + scfv + "</td></tr>";
    
}

