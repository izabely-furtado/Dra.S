$(document).ready(function() {
    //Inicio Mascara Telefone
    function setMaskPhone( input ) {
        var phone, element;
        element = $( input );
        phone = element.val().replace(/\D/g, '');
        if(phone.length > 10) {
            element.mask("(00) 00000-0009");
        } else {
            element.mask("(00) 0000-00009");  
        }
    }

    $(".telefone").focusin(function(){ 
        setMaskPhone( $(this) );
    });

    $(".telefone").focusout(function(){
        setMaskPhone( $(this) );
    });

    $(".telefone").keyup(function(){ 
        var phone, element;
        element = $(this);
        phone = element.val().replace(/\D/g, '');
        if(phone.length == 11) {
            element.mask("(00) 00000-0009");
        } else if(phone.length == 10) {
            element.mask("(00) 0000-00009");  
        }
    });
    //Fim Mascara Telefone
    
    jQuery(".cpf").mask("000.000.000-00");

    jQuery(".cnpj").mask("00.000.000/0000-00");
    
    jQuery(".data").mask("00/00/0000");
    
    jQuery(".cep").mask("00000-000");
    
    jQuery(".hora").mask("00:00");

    jQuery(".dinheiro").mask('000.000.000.000.000,00', {reverse: true});
});
(jQuery);
