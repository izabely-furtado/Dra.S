function validaDadosTurma() {
		var codigo = document.getElementById("codigo").value;
		var numAlunos = document.getElementById("maxiAlunos").value;
		var turno = document.getElementById("turno").value;
		var nivel = document.getElementById("nivel").value;

		
		if (codigo == "") {
			
			alert("Preencha o campo nome!");
			
			document.getElementById("codigo").focus();
			
			return false;
		}
		
		if(numAlunos == "")
		{
			alert("Preencha o campo número máximo de alunos!");
			document.getElementById("maxiAlunos").focus();
			return false;
		}
		
		if(turno == "")
		{
			alert("Preencha o campo turno!");
			document.getElementById("turno").focus();
			return false;
		}
		
		if(nivel == "")
		{
			alert("Preencha o campo nivel!");
			document.getElementById("nivel").focus();
			return false;
		}
		
	
}

function alerta()
{
	var nome;
    do {
     nome = prompt ("nome do aluno:");
    } while (nome == null || nome == "");
 
    alert ("Inserir o aluno "+nome);
	return nome;
}



 
 
function apagaLinha(i){
	
	var resposta = confirm("Deseja excluir o aluno?");
 
     if (resposta == true) {
          document.getElementById('tabela').deleteRow(i);
     }	
    
}

function adicionaLinha(nome){
                
                var parte1 = "<tr><td>Teste " + nome + "</td>";
                var parte2 = "<td  id='tabela" + nome + "'><input type='button' ";
               
                 document.getElementById("tabela").innerHTML += parte1 + parte2 + parte3;
                 document.getElementById("tabela").innerHTML += "</td></tr>";
}
		   
		 

function adicionaAluno()/*não está inserindo de acordo com a formatação da tabela*/
{
	var nome;
    do {
     nome = prompt ("nome do aluno:");
    } while (nome == null || nome == "");
 
    alert ("Inserir o aluno "+nome);
	
                var parte1 = "<tr><td>" + nome + "</td>";
                var parte2 = "<td  id='tabela" + nome + "'><input type='button' ";
				
				
				
                 document.getElementById("tabela").innerHTML += parte1 + parte2;
                 document.getElementById("tabela").innerHTML += "</td></tr>";

	
}
