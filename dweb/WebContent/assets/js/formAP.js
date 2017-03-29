
function form1() {
    //dados básicos
    var tipo = document.getElementById("tipo").value;
    var ano = document.getElementById("ano").value;
    var forma = document.getElementById("forma").value;

    //dados pessoais
    var nomeChibi = document.getElementById("nomeCrianca").value;
    var dataNasc = document.getElementById("dataNasc").value;
    var sexo = "F";
    if (document.getElementById("sexoM").ckecked) {
        sexo = "M";
    }
    var responsavel = document.getElementById("responsavel").value;
    var parentesco = document.getElementById("parentesco").value;
    var telefone = document.getElementById("telefone").value;
    var nis = document.getElementById("nis").value;

    //endereço
    var rua = document.getElementById("rua").value;
    var numero = document.getElementById("numero").value;
    var cep = document.getElementById("cep").value;
    var bairro = document.getElementById("bairro").value;
    var cidade = document.getElementById("cidade").value;
    var estado = document.getElementById("estado").value;
    var referencia = document.getElementById("referencia").value;

    //acompanhamento escolar
    var escola = document.getElementById("escola").value;
    //são no máximo seis anos participando do projeto
    //série no 1º ano no projeto
    var ano1 = document.getElementById("ano1").value;
    var serie1 = document.getElementById("serie1").value;
    //série no 2º ano no projeto
    var ano2 = document.getElementById("ano2").value;
    var serie2 = document.getElementById("serie2").value;
    //série no 3º ano no projeto
    var ano3 = document.getElementById("ano3").value;
    var serie3 = document.getElementById("serie3").value;
    //série no 4º ano no projeto
    var ano4 = document.getElementById("ano4").value;
    var serie4 = document.getElementById("serie4").value;
    //série no 5º ano no projeto
    var ano5 = document.getElementById("ano5").value;
    var serie5 = document.getElementById("serie5").value;
    //série no 6º ano no projeto
    var ano6 = document.getElementById("ano6").value;
    var serie6 = document.getElementById("serie6").value;

    //informações médicas - emergenciais
    var medicacao = "N";
    var qmedicacao = "";
    if (document.getElementById("medicacaoS").checked) {
        sexo = "S";
        qmedicacao = document.getElementById("qmedicacao").value;
    }
    var tipoSangue = document.getElementById("tipoSangue").value;
    var alergia = "N";
    var qalergia = "";
    if (document.getElementById("alergiaS").checked) {
        sexo = "S";
        qalergia = document.getElementById("qalergia").value;
    }
    var contatoSOS = document.getElementById("contatoSOS").value;

    //informações de transporte
    var transporte = "N";
    if (document.getElementById("transporteS").checked) {
        sexo = "S";
    }
    var cartao = document.getElementById("cartao").value;

    window.location.href = "./formularioAcompanhamentoPsico2.html"
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
    var sefc = document.getElementById("sefc").value;

    //despesas
    var aluguel = document.getElementById("aluguel").value;
    var agua = document.getElementById("agua").value;
    var luz = document.getElementById("luz").value;
    var tel = document.getElementById("tel").value;
    var gas = document.getElementById("gas").value;
    var alimenta = document.getElementById("alimenta").value;
    var medica = document.getElementById("medica").value;
    var outros = document.getElementById("outros").value;

    //tentar gerar estes dados
    var tudo = document.getElementById("tudo").value;
    var rendafamiliar = document.getElementById("rendafamiliar").value;
    var rendapercapta = document.getElementById("rendapercapta").value;

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

function form3() {

    //condição
    var condicao = document.getElementById("condicao").value;
    var infra = document.getElementById("infra").value;
    var risco = "N";
    var qrisco = "";
    if (document.getElementById("riscoS").checked) {
        sexo = "S";
        qalergia = document.getElementById("qrisco").value;
    }
    window.location.href = "./formularioAcompanhamentoPsico4.html"
}

function form4() {
    //acesso a serviços
    var scras = document.getElementById("scras").value;
    var screas = document.getElementById("screas").value;
    var sus = document.getElementById("sus").value;
    var sesf = document.getElementById("sesf").value;
    var scei = document.getElementById("scei").value;
    var sai = document.getElementById("sai").value;

    //acolhimento
    var anome = document.getElementById("anome").value;
    var ainstituicao = document.getElementById("ainstituicao").value;
    var aresponsavel = document.getElementById("aresponsavel").value;
    var acontato = document.getElementById("acontato").value;
    var amotivo = document.getElementById("amotivo").value;

    //programa/beneficios
    var pdf = document.getElementById("pdf").checked;
    var pi = document.getElementById("pi").checked;
    var pbc = document.getElementById("pbc").checked;
    var bpc = document.getElementById("bpc").checked;
    var bp = document.getElementById("bp").checked;
    var ar = document.getElementById("ar").checked;
    var beneficio = document.getElementById("beneficio").value;
    var outrobeneficio = document.getElementById("outrobeneficio").value;

    window.location.href = "./formularioAcompanhamentoPsico5.html"
}

function form5() {
    //publico
    var isolamento = document.getElementById("isolamento").checked;
    var trabinfantil = document.getElementById("trabinfantil").checked;
    var violencia = document.getElementById("violencia").checked;
    var foraescola = document.getElementById("foraescola").checked;
    var acolhimento = document.getElementById("acolhimento").checked;
    var mse = document.getElementById("mse").checked;
    var egressos = document.getElementById("egressos").checked;
    var abuso = document.getElementById("abuso").checked;
    var eca = document.getElementById("eca").checked;
    var rua = document.getElementById("rua").checked;
    var vulnerabilidade = document.getElementById("vulnerabilidade").checked;

    window.location.href = "./formularioAcompanhamentoPsico6.html"
}

function form6() { 
    //são no máximo seis anos participando do projeto
    //série no 1º ano no projeto
    var ano1 = document.getElementById("ano1").value;
    var ass1 = document.getElementById("ass1").value;
    var data1 = document.getElementById("data1").value;
    //série no 2º ano no projeto
    var ano2 = document.getElementById("ano2").value;
    var ass2 = document.getElementById("ass2").value;
    var data2 = document.getElementById("data2").value;
    //série no 3º ano no projeto
    var ano3 = document.getElementById("ano3").value;
    var ass3 = document.getElementById("ass3").value;
    var data3 = document.getElementById("data3").value;
    //série no 4º ano no projeto
    var ano4 = document.getElementById("ano4").value;
    var ass4 = document.getElementById("ass4").value;
    var data4 = document.getElementById("data4").value;
    //série no 5º ano no projeto
    var ano5 = document.getElementById("ano5").value;
    var ass5 = document.getElementById("ass5").value;
    var data5 = document.getElementById("data5").value;
    //série no 6º ano no projeto
    var ano6 = document.getElementById("ano6").value;
    var ass6 = document.getElementById("ass6").value;
    var data6 = document.getElementById("data6").value;

    var asstecresp = document.getElementById("asstecresp").value;
    var assrespfam = document.getElementById("assrespfam").value;

    window.location.href = "./fimForm.html"
}