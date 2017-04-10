function validaAula() {
		var tipoAula = document.getElementById("tipoAula").value;
		var horarios = document.getElementById("horarios").value;
		var dataAula = document.getElementById("dataAula").value;
		var nivel = document.getElementById("nivel").value;
		var conteudoAula = document.getElementById("conteudoAula").value;

		
		if(horarios == "")
		{
			alert("Preencha o campo número horário");
			document.getElementById("horarios").focus();
			return false;
			
		}
		
		if(dataAula == "")
		{
			alert("Preencha o campo data!");
			document.getElementById("dataAula").focus();
			return false;
		}
		
		if(conteudoAula == "")
		{
			alert("Preencha o conteúdo da aula!");
			document.getElementById("horarios").focus();
			return false;
		}
		
		if(conteudoAula.checked)
		{
			document.getElementById("conteudoAula").focus();
			
			return false;
		}
		

}


function limpaTextArea(){
	document.getElementById('conteudoAula').value=''; // Limpa o campo

}