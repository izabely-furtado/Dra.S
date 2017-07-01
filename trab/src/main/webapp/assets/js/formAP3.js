function geraTotal() {
	var aluguel = parseInt(document.getElementById("aluguel").value);
    var agua = parseInt(document.getElementById("agua").value);
    var luz = parseInt(document.getElementById("luz").value);
    var tel = parseInt(document.getElementById("tel").value);
    var gas = parseInt(document.getElementById("gas").value);
    var alimenta = parseInt(document.getElementById("alimenta").value);
    var medica = parseInt(document.getElementById("medica").value);
    var outros = parseInt(document.getElementById("outros").value);
    document.getElementById("totalDESPESA").innerHTML = aluguel + agua + luz + tel + gas + alimenta + medica + outros;
}
function proximo3(){
	window.location.href = "./formularioAcompanhamentoPsico4.html"
}

