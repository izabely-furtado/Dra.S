function possuiRisco(){
	if (document.getElementById("riscoN").checked){
		document.getElementById("qrisco").disabled = true;
	}
	else {
		document.getElementById("qrisco").disabled = false;
	}
}

function form4() {
    //condi��o
    var condicao = document.getElementById("condicao").value;
    if (condicao == ""){
    	document.getElementById("condicao").style.border = "1px solid red";
    	alert("Informe a condição de sua moradia");
    }
    else {
	    //var infra = document.getElementsByName("infra").value;
	    var pagua = document.getElementById("pagua").checked;
	    var pesgoto = document.getElementById("pesgoto").checked;
	    var penergia = document.getElementById("penergia").checked;
	    var plixo = document.getElementById("plixo").checked;
	
	    var risco = "N";
	    var qrisco = "";
	    if (document.getElementById("riscoS").checked) {
	        sexo = "S";
	        qalergia = document.getElementById("qrisco").value;
	    }
	    
    	window.location.href = "./formularioAcompanhamentoPsico5.html"
    }
}