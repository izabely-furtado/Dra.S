$(function(){
  $('.menu-sidebar > li > a').find($('.badge.badge-plus')).html('<i class="material-icons">add</i>');
	//Destaque
  $("#destaque").owlCarousel({
      navigation : false,
      slideSpeed : 300,
      paginationSpeed : 400,
      singleItem:true,    
      autoPlay: true,
      stopOnHover: true,
      transitionStyle: 'fade'
  });

  /*Menu Mobile*/
  $("#menu").hide();
 	$('.navbar-toggle').click(function(){
 		if($("#menu").hide()){
 			$("#menu").show();
      $(".bg-content").css('z-index','-1');
      $("body").css('overflow','hidden');
 		}else{
 			$("#menu").hide();
      $(".bg-content").css('z-index','999');
      $("body").css('overflow','auto');
 		}
 	});
 	$('.btn-close').click(function(){
 		$("#menu").hide();
    $(".bg-content").css('z-index','999');
    $("body").css('overflow','auto');
 	});

  /*Menu e Submenu Sidebar*/

  $('.menu-sidebar > li.sub > a').click(function(){
    if($(this).parent().hasClass('open')){
      $(this).parent().removeClass('open');
      $(this).find($('.badge.badge-plus')).html('<i class="material-icons">add</i>');  
      $(this).parent().find('.dropdown-submenu').hide();
    }else {
      $(this).parent().addClass('open')
      $(this).find($('.badge.badge-plus')).html('<i class="material-icons">remove</i>');
      $(this).parent().find('.dropdown-submenu').show();
    }
  });

  /* Light Gallery */
  $('.zoom').lightGallery({
    thumbnail:false,
    controls: false,
    selector: '.item',
    autoplayControls: false,
    enableDrag: false
    /*counter: false*/
  }); 


  
  $('.popup-title a').click(function(){
    if($(this).parent().parent().parent().hasClass('open')){
      $(this).parent().parent().parent().removeClass('open');
      $(this).find('.material-icons').text('add');
    }else{
      $(this).parent().parent().parent().addClass('open');
      $(this).find('.material-icons').text('remove');
    }
  });

  $('.link-open-list').click(function(){
    if($(this).parent().find('.list-theme').hasClass('open')){
      $(this).parent().find('.list-theme').removeClass('open');
    }else{
      $(this).parent().find('.list-theme').addClass('open');
    }
  });

  $('.menu-sidebar-group .btn-sidebar-menu').click(function(){
    if($(this).parent().hasClass('active')){
      $(this).parent().removeClass('active');
      $(this).find('.material-icons').html('menu');
    }else{
      $(this).parent().addClass('active');
      $(this).find('.material-icons').html('clear');
    }
  });

  $( window ).resize(function() {
    if($(this).width()>768){
      if($("#menu").show()){
        $("#menu").hide();
        $(".bg-content").css('z-index','999');
        $("body").css('overflow','auto');
      }
    }
  });
  /*EMISSÃO DE BOLETO*/
$('.group-choose-people').show();
  $('.group-choose-people .group-cpf').show();
  $('.group-choose-people .group-cnpj').hide();
  $('#DocumentoCPF').attr("required", true);
  $('#DocumentoCNPJ').attr("required", false);
  $('.form-people').change(function(){
    if($(this).val()=="1"){
      $('.group-choose-people').show();
      $('.group-choose-people .group-cpf').show();
      $('.group-choose-people .group-cnpj').hide();
      $('#DocumentoCPF').attr("required", true);
      $('#DocumentoCNPJ').attr("required", false);
    }else if($(this).val()=="2"){
      $('.group-choose-people').show();
      $('.group-choose-people .group-cpf').hide();
      $('.group-choose-people .group-cnpj').show();
      $('#DocumentoCPF').attr("required", false);
      $('#DocumentoCNPJ').attr("required", true);
  } else {
      $('.group-choose-people').hide();
    }
  });
  $('[data-toggle="popover"]').popover();


  /*UPLOAD CUSTOMIZADO*/
  $('.file-field').change(function(){
    $('.file-field-text').val($(this).val());
  });

  /*OUVIDORIA*/
  $('.btn-ouvidoria').click(function(){
      $(this).hide();
      $('.form-ouvidoria').addClass('active');
  });

  $('.galerias.fotos').lightGallery({
    thumbnail:true,
    selector: '.item',
    controls: false,
    autoplayControls: false,
    enableDrag: true
    /*counter: false*/
  }); 

  /*SIMULADOR*/
   $(".linhas-de-creditos > .list-group > .list-group-item > .radio").on('click',function() { 
     $(".linhas-de-creditos > .list-group > .list-group-item > .radio").parent().removeClass('open');
      $(this).parent().addClass('open');
    });

  $('.btn-send-mail').on('click', function () {
    swal({
      title: 'Enviar por e-mail',
      input: 'email',
      confirmButtonColor: '#165f90',
      cancelButtonColor: '#ccc',
      confirmButtonClass: 'btn-radius',
      cancelButtonClass: 'btn-radius',
      inputPlaceholder: 'Digite seu e-mail',
      showCancelButton: true,
      confirmButtonText: 'Enviar',
      cancelButtonText: 'Cancelar',
      showLoaderOnConfirm: true,
      showCloseButton: true,
      allowOutsideClick: true,
      allowEscapeKey: true,
	  inputValidator: function ( email ) {
       return new Promise( function ( resolve, reject ) {
         var regex = /^([a-zA-Z0-9_.+-])+\@(([a-zA-Z0-9-])+\.)+([a-zA-Z0-9]{2,4})+$/;
         if( regex.test( email ) ) {
           resolve()
         } else {
           reject( 'Endereço de e-mail inválido!' )
         }
       })
     }
    }).then(function (email) {
      swal({
          type: 'success',
          html: 'E-mail enviado para: ' + email
      })
       
    });
  });

  /* Login Cliente e Consultor */ 
  $('.btn-forgot-pass').on('click', function () {
    swal({
      title: 'Informe seu e-mail de login',
      input: 'email',
      confirmButtonColor: '#165f90',
      cancelButtonColor: '#ccc',
      confirmButtonClass: 'btn-radius',
      cancelButtonClass: 'btn-radius',
      inputPlaceholder: 'Digite seu e-mail',
      showCancelButton: true,
      confirmButtonText: 'Enviar',
      cancelButtonText: 'Cancelar',
      showLoaderOnConfirm: true,
      showCloseButton: true,
      allowOutsideClick: true,
      allowEscapeKey: true,
	  inputValidator: function ( email ) {
       return new Promise( function ( resolve, reject ) {
         var regex = /^([a-zA-Z0-9_.+-])+\@(([a-zA-Z0-9-])+\.)+([a-zA-Z0-9]{2,4})+$/;
         if( regex.test( email ) ) {
           resolve()
         } else {
           reject( 'Endereço de e-mail inválido!' )
         }
       })
     }
    }).then(function (email) {
      swal({
          type: 'success',
          html: 'Senha enviada via SMS para o nº (27) XXXXX-1234.'
      })
       
    });
  });

  //BTN MORE
  $('.btn-more').mouseenter(function(){
    $(this).addClass('active');
  });
  $('.btn-more').mouseleave(function(){
    $(this).removeClass('active');
  });

});
