function possuiCRAS(){
	if (document.getElementById("crasN").checked){
		document.getElementById("qcras").disabled = true;
	}
	else {
		document.getElementById("qcras").disabled = false;
	}
}
function possuiCREAS(){
	if (document.getElementById("creasN").checked){
		document.getElementById("qcreas").disabled = true;
	}
	else {
		document.getElementById("qcreas").disabled = false;
	}
}
function possuiSUS(){
	if (document.getElementById("susN").checked){
		document.getElementById("qsus").disabled = true;
	}
	else {
		document.getElementById("qsus").disabled = false;
	}
}
function possuiESF(){
	if (document.getElementById("esfN").checked){
		document.getElementById("qesf").disabled = true;
	}
	else {
		document.getElementById("qesf").disabled = false;
	}
}
function possuiCEI(){
	if (document.getElementById("ceiN").checked){
		document.getElementById("qcei").disabled = true;
	}
	else {
		document.getElementById("qcei").disabled = false;
	}
}

function possuiescola(){
	if (document.getElementById("escolaN").checked){
		document.getElementById("qescola").disabled = true;
	}
	else {
		document.getElementById("qescola").disabled = false;
	}
}

function possuiSAI(){
	if (document.getElementById("saiN").checked){
		document.getElementById("qsai").disabled = true;
	}
	else {
		document.getElementById("qsai").disabled = false;
	}
}

function form5() {
	var erro = "";
    //acesso a servi�os
	var cras = "N";
    var qcras = "";
    if (document.getElementById("crasS").checked) {
        cras = "S";
        qcras = document.getElementById("qcras").value;
        if (qcras == ""){
        	erro += "Informe o CRAS \n";
        	document.getElementById("qcras").style.border = "1px solid red";
        }
    }
    var creas = "N";
    var qcreas = "";
    if (document.getElementById("creasS").checked) {
        cras = "S";
        qcreas = document.getElementById("qcreas").value;
        if (qcreas == ""){
        	erro += "Informe o CREAS \n";
        	document.getElementById("qcreas").style.border = "1px solid red";
        }
    }
    var sus = "N";
    var qsus = "";
    if (document.getElementById("susS").checked) {
        sus = "S";
        qsus = document.getElementById("qsus").value;
        if (qsus == ""){
        	erro += "Informe o SUS \n";
        	document.getElementById("qsus").style.border = "1px solid red";
        }
    }
    var esf = "N";
    var qesf = "";
    if (document.getElementById("esfS").checked) {
    	esf = "S";
        qesf = document.getElementById("qesf").value;
        if (qesf == ""){
        	erro += "Informe o ESF \n";
        	document.getElementById("qesf").style.border = "1px solid red";
        }
    }
    var cei = "N";
    var qcei = "";
    if (document.getElementById("ceiS").checked) {
        cei = "S";
        qcei = document.getElementById("qcei").value;
        if (qcei == ""){
        	erro += "Informe o CEI \n";
        	document.getElementById("qcei").style.border = "1px solid red";
        }
    }
    var sai = "N";
    var qsai = "";
    if (document.getElementById("saiS").checked) {
        sai = "S";
        qsai = document.getElementById("qsai").value;
        if (qsai == ""){
        	erro += "Informe o Acolhimento Institucional \n";
        	document.getElementById("qsai").style.border = "1px solid red";
        }
    }
    var escola = "N";
    var qescola = "";
    if (document.getElementById("escolaS").checked) {
        escola = "S";
        qescola = document.getElementById("qescola").value;
        if (qescola == ""){
        	erro += "Informe a Escola \n";
        	document.getElementById("qescola").style.border = "1px solid red";
        }
    }

    if (erro == ""){
	    //acolhimento
	    var anome = document.getElementById("anome").value;
	    var ainstituicao = document.getElementById("ainstituicao").value;
	    var aresponsavel = document.getElementById("aresponsavel").value;
	    var acontato = document.getElementById("acontato").value;
	    var amotivo = document.getElementById("amotivo").value;
	
	    //programa/beneficios
	    var pbf = document.getElementById("pbf").checked;
	    var pi = document.getElementById("pi").checked;
	    var pbc = document.getElementById("pbc").checked;
	    var bpc = document.getElementById("bpc").checked;
	    var bp = document.getElementById("bp").checked;
	    var ar = document.getElementById("ar").checked;
	    var beneficio = document.getElementById("beneficio").value;
	    var outrobeneficio = document.getElementById("outrobeneficio").value;
	    
	    window.location.href = "./formularioAcompanhamentoPsico6.html"
    }
    else {
    	alert(erro);
    }
    
}
