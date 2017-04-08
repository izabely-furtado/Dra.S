
var testform1 = null;
var erro = "";
function conteudoform1() {
    this.basico = new conteudoBasico();
    this.pessoal = new conteudoPessoal();
    this.endereco = new conteudoEndereco();
    this.escola = new conteudoEscola();
    this.medico = new conteudoMedico();
    this.transporte = new conteudoTransporte();
}

function conteudoBasico() {
    this.tipo = document.getElementById("tipo").value;
    this.ano = document.getElementById("ano").value;
    this.forma = document.getElementById("forma").value;
    if (this.tipo == "") {
        erro += "Informe o tipo \n";
        document.getElementById("tipo").style.border = "1px solid red";
    }
    if (this.ano == "") {
        erro += "Informe o ano \n";
        document.getElementById("ano").style.border = "1px solid red";
    }
    if (this.forma == "") {
        erro += "Informe a forma \n";
        document.getElementById("forma").style.border = "1px solid red";
    }
    if (this.ano < 1900) {
        erro += "Informe um ano válido \n";
        document.getElementById("ano").style.border = "1px solid red";
    }
}

function validaTelefone(telefone) {
    //se n�o desejar n�meros � s� remover da regex abaixo
    var regex = '[^a-zA-Z]+';
    var testandosamerda = telefone.match(regex);
    if (telefone.match(regex)) {
        //encontrou ent�o n�o passa na valida��o
        return false;
    }
    else {
        //n�o encontrou caracteres especiais
        return true;
    }
}

function conteudoPessoal() {
    this.nomeCrianca = document.getElementById("nomeCrianca").value; ;
    this.dataNasc = document.getElementById("dataNasc").value; ;
    this.sexo = "F";
    if (document.getElementById("sexoM").ckecked) {
        sexo = "M";
    }
    this.responsavel = document.getElementById("responsavel").value;
    this.parentesco = document.getElementById("parentesco").value;
    this.telefone = document.getElementById("telefone").value;
    this.nis = document.getElementById("nis").value;
    document.getElementById("nomeCrianca").style.border = "1px solid #ccc";
    document.getElementById("dataNasc").style.border = "1px solid #ccc";
    document.getElementById("responsavel").style.border = "1px solid #ccc";
    document.getElementById("telefone").style.border = "1px solid #ccc";
    document.getElementById("nis").style.border = "1px solid #ccc";
    
    if (this.nomeCrianca == "") {
        erro += "Informe o nome da criança \n";
        document.getElementById("nomeCrianca").style.border = "1px solid red";
    }
    if (this.responsavel == "") {
        erro += "Informe o responsavel pela criança \n";
        document.getElementById("responsavel").style.border = "1px solid red";
    }
    if (this.parentesco == "") {
        erro += "Informe o parentesco \n";
        document.getElementById("parentesco").style.border = "1px solid red";
    }
    if (this.telefone == "") {
        erro += "Informe um telefone válido \n";
        document.getElementById("telefone").style.border = "1px solid red";
    }
}

function conteudoEndereco() {
    this.rua = document.getElementById("rua").value;
    this.numero = document.getElementById("numero").value;
    this.cep = document.getElementById("cep").value;
    this.bairro = document.getElementById("bairro").value;
    this.cidade = document.getElementById("cidade").value;
    this.estado = document.getElementById("estado").value;
    this.referencia = document.getElementById("referencia").value;
    document.getElementById("rua").style.border = "1px solid #ccc";
    document.getElementById("numero").style.border = "1px solid #ccc";
    document.getElementById("cep").style.border = "1px solid #ccc";
    document.getElementById("bairro").style.border = "1px solid #ccc";
    document.getElementById("cidade").style.border = "1px solid #ccc";
    document.getElementById("estado").style.border = "1px solid #ccc";
    document.getElementById("referencia").style.border = "1px solid #ccc";
    
    if (this.rua == "") {
        erro += "Informe a rua \n";
        document.getElementById("rua").style.border = "1px solid red";
    }
    if (this.numero == "") {
        erro += "Informe o numero \n";
        document.getElementById("numero").style.border = "1px solid red";
    }
    if (this.cep == "") {
        erro += "Informe o cep \n";
        document.getElementById("cep").style.border = "1px solid red";
    }
    if (this.bairro == "") {
        erro += "Informe o bairro \n";
        document.getElementById("bairro").style.border = "1px solid red";
    }
    if (this.cidade == "") {
        erro += "Informe a cidade \n";
        document.getElementById("cidade").style.border = "1px solid red";
    }
    if (this.estado == "") {
        erro += "Informe o estado \n";
        document.getElementById("estado").style.border = "1px solid red";
    }
    
}

function conteudoEscola() {
    this.escola = document.getElementById("escola").value;
    //s�o no m�ximo seis anos participando do projeto
    //s�rie no 1� ano no projeto
    this.ano1 = document.getElementById("ano1").value;
    this.serie1 = document.getElementById("serie1").value;
    //s�rie no 2� ano no projeto
    this.ano2 = document.getElementById("ano2").value;
    this.serie2 = document.getElementById("serie2").value;
    //s�rie no 3� ano no projeto
    this.ano3 = document.getElementById("ano3").value;
    this.serie3 = document.getElementById("serie3").value;
    //s�rie no 4� ano no projeto
    this.ano4 = document.getElementById("ano4").value;
    this.serie4 = document.getElementById("serie4").value;
    //s�rie no 5� ano no projeto
    this.ano5 = document.getElementById("ano5").value;
    this.serie5 = document.getElementById("serie5").value;
    //s�rie no 6� ano no projeto
    this.ano6 = document.getElementById("ano6").value;
    this.serie6 = document.getElementById("serie6").value;
    document.getElementById("escola").style.border = "1px solid #ccc";
    
    if (this.escola == "") {
        erro += "Informe a escola \n";
        document.getElementById("escola").style.border = "1px solid red";
    }
}

function conteudoMedico() {
    this.medicacao = "N";
    this.qmedicacao = "";
    document.getElementById("qmedicacao").style.border = "1px solid red";
    document.getElementById("qalergia").style.border = "1px solid red";
    document.getElementById("contatoSOS").style.border = "1px solid red";
    
    if (document.getElementById("medicacaoS").checked) {
        sexo = "S";
        qmedicacao = document.getElementById("qmedicacao").value;
    }
    this.tipoSangue = document.getElementById("tipoSangue").value;
    this.alergia = "N";
    this.qalergia = "";
    if (document.getElementById("alergiaS").checked) {
        sexo = "S";
        qalergia = document.getElementById("qalergia").value;
    }
    this.contatoSOS = document.getElementById("contatoSOS").value;
    if (this.contatoSOS == "") {
        erro += "Informe um contato de emergência \n";
        document.getElementById("contatoSOS").style.border = "1px solid red";
    }
    
}

function conteudoTransporte() {
    this.transporte = "N";
    if (document.getElementById("transporteS").checked) {
        sexo = "S";
    }
    this.cartao = document.getElementById("cartao").value;

}

function form1() {
    testform1 = new conteudoform1();
    if (erro != "") {
        alert(erro);
        erro = "";
        window.location.href = "#";
    }
    else {
        window.location.href = "./formularioAcompanhamentoPsico2.html";
    }
}
