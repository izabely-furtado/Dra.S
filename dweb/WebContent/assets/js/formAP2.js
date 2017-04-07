

var testeform2 = null;
///var conteudoform2 = new Object();
function conteudoform2(familia, despesas, tudo, rendafamiliar, rendapercapta) {
    this.familia = familia;
    this.despesas = despesas;
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
    //composição familiar
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
    //passando elementos para póxima página
    //window.open(url, "teste", elementos);
    window.location.href = "./formularioAcompanhamentoPsico3.html"

}

function addParente() {
    //composição familiar
    var nome = document.getElementById("nome").value;
    var parentesco = document.getElementById("parentesco").value;
    var idade = document.getElementById("idade").value;
    var dn = document.getElementById("dn").value;
    var situacao = document.getElementById("situacao").value;
    var escolaridade = document.getElementById("escolaridade").value;
    var renda = document.getElementById("renda").value;
    var sefc = document.getElementById("sefc").value;

    //tentar gerar numa tabela
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
