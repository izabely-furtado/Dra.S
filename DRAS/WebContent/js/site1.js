// elements
var $page = document.getElementById('.page');

document.getElementById('.menu_toggle').on('click', function(){
  $page.toggleClass('shazam');
});
document.getElementById('.content').on('click', function(){
  $page.removeClass('shazam');
});

