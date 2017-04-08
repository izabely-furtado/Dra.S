

var testeform2 = null;
///var conteudoform2 = new Object();
function conteudoform2(familia, despesas, tudo, rendafamiliar, rendapercapta) {
    this.familia = new conteudofamilia();
    this.despesas = new conteudodespesas();
    this.tudo = tudo;
    this.rendafamiliar = rendafamiliar;
    this.rendapercapta = rendapercapta;
}

//var conteudofamilia = new Object();
function conteudofamilia(nome, parentesco, idade, dn, situacao, escolaridade, renda, scfv) {
    this.nome = nome;
    this.parentesco = parentesco;
    this.idade = idade;
    this.dn = dn;
    this.situacao = situacao;
    this.escolaridade = escolaridade;
    this.renda = renda;
    this.scfv = scfv;
}

//var conteudodespesas = new Object();
function conteudodespesas(aluguel, agua, luz, tel, gas, alimenta, medica, outros) {
    this.aluguel = aluguel;
    this.agua = agua;
    this.luz = luz;
    this.tel = tel;
    this.gas = gas;
    this.alimenta = alimenta;
    this.medica = medica;
    this.outros = outros;
}
function form2() {
    //composi��o familiar
    var nome = document.getElementById("nome").value;
    var parentesco = document.getElementById("parentesco").value;
    var idade = document.getElementById("idade").value;
    var dn = document.getElementById("dn").value;
    var situacao = document.getElementById("situacao").value;
    var escolaridade = document.getElementById("escolaridade").value;
    var renda = document.getElementById("renda").value;
    var scfv = document.getElementById("scfv").value;

    var familia = new conteudofamilia(nome, parentesco, idade, dn, situacao, escolaridade, renda, scfv);
    
    //despesas
    var aluguel = document.getElementById("aluguel").value;
    var agua = document.getElementById("agua").value;
    var luz = document.getElementById("luz").value;
    var tel = document.getElementById("tel").value;
    var gas = document.getElementById("gas").value;
    var alimenta = document.getElementById("alimenta").value;
    var medica = document.getElementById("medica").value;
    var outros = document.getElementById("outros").value;

    var despesas = new conteudodespesas(aluguel, agua, luz, tel, gas, alimenta, medica, outros);

    //tentar gerar estes dados
    var tudo = document.getElementById("tudo").value;
    var rendafamiliar = document.getElementById("rendafamiliar").value;
    var rendapercapta = document.getElementById("rendapercapta").value;

    testeform2 = new conteudoform2(familia, despesas, tudo, rendafamiliar, rendapercapta);
    //var url = "./formularioAcompanhamentoPsico3.html";
    //var elementos = "nome=" + nome + ",parentesco=" + parentesco + ",idade=" + idade + ",dn=" + dn + ",situacao=" + situacao + ",escolaridade=" + escolaridade + ",renda=" + renda + ",scfv=" + scfv + ",aluguel=" + aluguel;
    //passando elementos para p�xima p�gina
    //window.open(url, "teste", elementos);
    window.location.href = "./formularioAcompanhamentoPsico3.html"

}

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

function calcRendaTotal() {
    var renda = document.getElementById("renda").value;
    var rendax = document.getElementById("rendaX").value;

    return renda + rendax;
}

function calcDespesas() {
    //despesas
    var aluguel = document.getElementById("aluguel").value;
    var agua = document.getElementById("agua").value;
    var luz = document.getElementById("luz").value;
    var tel = document.getElementById("tel").value;
    var gas = document.getElementById("gas").value;
    var alimenta = document.getElementById("alimenta").value;
    var medica = document.getElementById("medica").value;
    var outros = document.getElementById("outros").value;

    return aluguel + agua + luz + tel + gas + alimenta + medica + outros;
}


