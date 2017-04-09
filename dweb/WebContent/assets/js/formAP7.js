
function form7() { 
    //s�o no m�ximo seis anos participando do projeto
    //s�rie no 1� ano no projeto
    var ano1 = document.getElementById("ano1").value;
    var ass1 = document.getElementById("ass1").value;
    var data1 = document.getElementById("data1").value;
    //s�rie no 2� ano no projeto
    var ano2 = document.getElementById("ano2").value;
    var ass2 = document.getElementById("ass2").value;
    var data2 = document.getElementById("data2").value;
    //s�rie no 3� ano no projeto
    var ano3 = document.getElementById("ano3").value;
    var ass3 = document.getElementById("ass3").value;
    var data3 = document.getElementById("data3").value;
    //s�rie no 4� ano no projeto
    var ano4 = document.getElementById("ano4").value;
    var ass4 = document.getElementById("ass4").value;
    var data4 = document.getElementById("data4").value;
    //s�rie no 5� ano no projeto
    var ano5 = document.getElementById("ano5").value;
    var ass5 = document.getElementById("ass5").value;
    var data5 = document.getElementById("data5").value;
    //s�rie no 6� ano no projeto
    var ano6 = document.getElementById("ano6").value;
    var ass6 = document.getElementById("ass6").value;
    var data6 = document.getElementById("data6").value;

    var asstecresp = document.getElementById("asstecresp").value;
    var assrespfam = document.getElementById("assrespfam").value;

    window.location.href = "./visualizaAluno.html"
}

function confirmar(){
	alert("Dados salvos com sucesso!");
}