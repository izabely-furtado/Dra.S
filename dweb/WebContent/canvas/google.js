(function(i, s, o, g, r, a, m) {
	i['GoogleAnalyticsObject'] = r;
	i[r] = i[r] || function() {
		(i[r].q = i[r].q || []).push(arguments)
	}, i[r].l = 1 * new Date();
	a = s.createElement(o), m = s.getElementsByTagName(o)[0];
	a.async = 1;
	a.src = g;
	m.parentNode.insertBefore(a, m)
})(window, document, 'script', '//www.google-analytics.com/analytics.js', 'ga');

(function() {

	ga('create', 'UA-37190734-7', 'auto', {
		'allowLinker' : true
	});
	ga('require', 'linker');
	ga('linker:autoLink', [ 'designschool.canva.com', 'about.canva.com',
			'support.canva.com' ]);
	ga('require', 'displayfeatures');
	var user = window['analyticsConfig'] && window['analyticsConfig']['user'];
	if (user && user != 'UAAAAAAAAAA') {
		ga('set', '&uid', user);
	}
	ga('send', 'pageview');
})();
