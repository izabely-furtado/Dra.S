function validaDadosAula() {
		var tipoaula = document.getElementById("tipoAula").value;
		var horario = document.getElementById("horarios").value;
		var data= document.getElementById("dataAula").value;
		var conteudo = document.getElementById("conteudoAula").value;

		
		if (tipoaula == "") {
			
			alert("Preencha o campo tipo de aula!");
			
			document.getElementById("tipoAula").focus();
			
			return false;
		}
		
		if(horario == "")
		{
			alert("Preencha o campo horario!");
			document.getElementById("horarios").focus();
			return false;
		}
		
		if(data == "")
		{
			alert("Preencha o campo data!");
			document.getElementById("dataAula").focus();
			return false;
		}
		
		if(conteudo == "")
		{
			alert("Informe o conteudo da aula");
			document.getElementById("conteudoAula").focus();
			return false;
		}
		
	
}


