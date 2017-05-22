/**
 * 
 */
function encontraPorLetraI() {
	nome = "Izabely Almeida Furtado Corrêa";
	responsavel = "Sérgio Furtado Corrêa";
	contato = "(27) 99708-8212";
	nasc = "29/03/1995";
	turma = "Sonserina"
    document.getElementById("encontra").innerHTML = "<tr><td>" + nome + "</td><td>" + responsavel + "</td><td>" + contato + "</td><td>" + nasc + "</td><td>" + turma +"</td></tr>";   
    document.getElementById("encontra").innerHTML += "<tr><td>" + nome + "</td><td>" + responsavel + "</td><td>" + contato + "</td><td>" + nasc + "</td><td>" + turma +"</td></tr>";   
    document.getElementById("encontra").innerHTML += "<tr><td>" + nome + "</td><td>" + responsavel + "</td><td>" + contato + "</td><td>" + nasc + "</td><td>" + turma +"</td></tr>";   
}

function encontraPorLetraS() {
	nome = "<a href='./visualizaAluno.html' >Suzana Priscila Soares Leal</a>";
	responsavel = "Jurema Conceição da Costa";
	contato = "(27) 99999-9999";
	nasc = "11/11/1991";
	turma = "Lufa Lufa"
    document.getElementById("encontra").innerHTML = "<tr><td>" + nome + "</td><td>" + responsavel + "</td><td>" + contato + "</td><td>" + nasc + "</td><td>" + turma +"</td></tr>";   
    document.getElementById("encontra").innerHTML += "<tr><td>" + nome + "</td><td>" + responsavel + "</td><td>" + contato + "</td><td>" + nasc + "</td><td>" + turma +"</td></tr>";   
    document.getElementById("encontra").innerHTML += "<tr><td>" + nome + "</td><td>" + responsavel + "</td><td>" + contato + "</td><td>" + nasc + "</td><td>" + turma +"</td></tr>";   
}
function encontraPorLetra() {
	nome = " - ";
	responsavel = " - ";
	contato = " - ";
	nasc = " - ";
	turma = " - ";
    document.getElementById("encontra").innerHTML = "<tr><td>" + nome + "</td><td>" + responsavel + "</td><td>" + contato + "</td><td>" + nasc + "</td><td>" + turma +"</td></tr>";   
    document.getElementById("encontra").innerHTML += "<tr><td>" + nome + "</td><td>" + responsavel + "</td><td>" + contato + "</td><td>" + nasc + "</td><td>" + turma +"</td></tr>";   
    document.getElementById("encontra").innerHTML += "<tr><td>" + nome + "</td><td>" + responsavel + "</td><td>" + contato + "</td><td>" + nasc + "</td><td>" + turma +"</td></tr>";   
}

function encontra() {
	alert("Nenhum Registro Encontrado")
}

function pesquisaTurmas() {
    
    window.location.href = "./visualizaTurma.html";
    
}
