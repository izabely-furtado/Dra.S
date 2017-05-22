$(function(){
    $("#tabela input").keyup(function(){       
        var index = $(this).parent().index();
        var nth = "#tabela td:nth-child("+(index+1).toString()+")";
        var valor = $(this).val().toUpperCase();
        $("#tabela tbody tr").show();
        $(nth).each(function(){
            if($(this).text().toUpperCase().indexOf(valor) < 0){
                $(this).parent().hide();
            }
        });
    });
 
    $("#tabela input").blur(function(){
        $(this).val("");
    });
});

function Pagina(nomeTabela, itensPorPagina) {
    this.nomeTabela = nomeTabela;
    this.itensPorPagina = itensPorPagina;
    this.paginaAtual = 1;
    this.paginas = 0;
    this.inicializado = false;
    
    this.mostrarRegistros = function(from, to) {        
        var linhas = document.getElementById(nomeTabela).rows;
        // i starts from 1 to skip table header row
        for (var i = 1; i < linhas.length; i++) {
            if (i < from || i > to)  
                linhas[i].style.display = 'none';
            else
                linhas[i].style.display = '';
        }
    }
    
    this.mostrarPagina = function(numeroPagina) {
    	if (! this.inicializado) {
    		alert("não inicializado");
    		return;
    	}

        var oldPageAnchor = document.getElementById('pg'+this.paginaAtual);
        oldPageAnchor.className = 'pg-normal';
        
        this.paginaAtual = numeroPagina;
        var newPageAnchor = document.getElementById('pg'+this.paginaAtual);
        newPageAnchor.className = 'pg-selected';
        
        var from = (numeroPagina - 1) * itensPorPagina + 1;
        var to = from + itensPorPagina - 1;
        this.mostrarRegistros(from, to);
    }   
    
    this.prev = function() {
        if (this.paginaAtual > 1)
            this.mostrarPagina(this.paginaAtual - 1);
    }
    
    this.next = function() {
        if (this.paginaAtual < this.paginas) {
            this.mostrarPagina(this.paginaAtual + 1);
        }
    }                        
    
    this.init = function() {
        var linhas = document.getElementById(nomeTabela).rows;
        var registros = (linhas.length - 1); 
        this.paginas = Math.ceil(registros / itensPorPagina);
        this.inicializado = true;
    }

    this.mostrarPaginaNav = function(nomePagina, positionId) {
    	if (! this.inicializado) {
    		alert("não inicializado");
    		return;
    	}
    	var element = document.getElementById(positionId);
    	
    	var paginaHTML = '<span onclick="' + nomePagina + '.prev();" class="pg-ctrl"> &#171 </span>';
        for (var pag = 1; pag <= this.paginas; pag++) 
            paginaHTML += '<span id="pg' + pag + '" class="pg-normal" onclick="' + nomePagina + '.mostrarPagina(' + pag + ');">' + pag + '</span>';
        paginaHTML += '<span onclick="'+nomePagina+'.next();" class="pg-ctrl"> &#187;</span>';            
        
        element.innerHTML = paginaHTML;
    }
}





