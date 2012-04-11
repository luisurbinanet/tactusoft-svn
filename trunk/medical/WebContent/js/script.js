/* begin Page */

(function() {
	// fix ie blinking
	var m = document.uniqueID && document.compatMode && !window.XMLHttpRequest
			&& document.execCommand;
	try {
		if (!!m) {
			m('BackgroundImageCache', false, true);
		}
	} catch (oh) {
	}
	;
	// css helper
	var u = navigator.userAgent.toLowerCase();
	var is = function(t) {
		return (u.indexOf(t) != -1)
	};
	jQuery('html')
			.addClass(
					[
							(!(/opera|webtv/i.test(u)) && /msie (\d)/.test(u)) ? ('ie ie' + RegExp.$1)
									: is('firefox/2') ? 'gecko firefox2'
											: is('firefox/3') ? 'gecko firefox3'
													: is('gecko/') ? 'gecko'
															: is('chrome/') ? 'chrome'
																	: is('opera/9') ? 'opera opera9'
																			: /opera (\d)/
																					.test(u) ? 'opera opera'
																					+ RegExp.$1
																					: is('konqueror') ? 'konqueror'
																							: is('applewebkit/') ? 'webkit safari'
																									: is('mozilla/') ? 'gecko'
																											: '',
							(is('x11') || is('linux')) ? ' linux'
									: is('mac') ? ' mac' : is('win') ? ' win'
											: '' ].join(' '));
})();

var _artStyleUrlCached = null;
function artGetStyleUrl() {
	if (null == _artStyleUrlCached) {
		var ns;
		_artStyleUrlCached = '';
		ns = jQuery('link');
		for ( var i = 0; i < ns.length; i++) {
			var l = ns[i].href;
			if (l && /style\.ie6\.css(\?.*)?$/.test(l))
				return _artStyleUrlCached = l.replace(
						/style\.ie6\.css(\?.*)?$/, '');
		}
		ns = jQuery('style');
		for ( var i = 0; i < ns.length; i++) {
			var matches = new RegExp('import\\s+"([^"]+\\/)style\\.ie6\\.css"')
					.exec(ns[i].html());
			if (null != matches && matches.length > 0)
				return _artStyleUrlCached = matches[1];
		}
	}
	return _artStyleUrlCached;
}

function artFixPNG(element) {
	if (jQuery.browser.msie && parseInt(jQuery.browser.version) < 7) {
		var src;
		if (element.tagName == 'IMG') {
			if (/\.png$/.test(element.src)) {
				src = element.src;
				element.src = artGetStyleUrl() + 'images/spacer.gif';
			}
		} else {
			src = element.currentStyle.backgroundImage
					.match(/url\("(.+\.png)"\)/i);
			if (src) {
				src = src[1];
				element.runtimeStyle.backgroundImage = 'none';
			}
		}
		if (src)
			element.runtimeStyle.filter = "progid:DXImageTransform.Microsoft.AlphaImageLoader(src='"
					+ src + "')";
	}
}

jQuery(function() {
	jQuery.each(jQuery('ul.rco-menu>li,ul.rco-vmenu>li'), function(i, val) {
		var l = jQuery(val);
		var s = l.children('span');
		if (s.length == 0)
			return;
		var t = l.find('span.t').last();
		l.children('a').append(t.html(t.text()));
		s.remove();
	});
});/* end Page */

/* begin Menu */
jQuery(function() {
	jQuery
			.each(
					jQuery('ul.rco-menu>li:not(:last-child)'),
					function(i, val) {
						jQuery(
								'<li class="rco-menu-li-separator"><span class="rco-menu-separator"> </span></li>')
								.insertAfter(val);
					});
	if (!jQuery.browser.msie || parseInt(jQuery.browser.version) > 6)
		return;
	jQuery.each(jQuery('ul.rco-menu li'), function(i, val) {
		val.j = jQuery(val);
		val.UL = val.j.children('ul:first');
		if (val.UL.length == 0)
			return;
		val.A = val.j.children('a:first');
		this.onmouseenter = function() {
			this.j.addClass('rco-menuhover');
			this.UL.addClass('rco-menuhoverUL');
			this.A.addClass('rco-menuhoverA');
		};
		this.onmouseleave = function() {
			this.j.removeClass('rco-menuhover');
			this.UL.removeClass('rco-menuhoverUL');
			this.A.removeClass('rco-menuhoverA');
		};

	});
});

/* end Menu */

/* begin Layout */
jQuery(function() {
	if (!jQuery.browser.msie || parseInt(jQuery.browser.version) > 7)
		return;
	var c = jQuery('div.rco-content');
	if (c.length !== 1)
		return;
	var s = c.parent().children('.rco-layout-cell:not(.rco-content)');
	jQuery(window).bind('resize', function() {
		if (c.w == c.parent().width())
			return;
		var w = 0;
		c.css('width', "0");
		s.each(function() {
			w += this.clientWidth;
		});
		c.w = c.parent().width();
		c.css('width', c.w - w);
	}).trigger('resize');
	jQuery('div.rco-content-layout-row').each(function() {
		this.c = jQuery(this).children('.rco-layout-cell');
	}).bind('resize', function() {
		if (this.h == this.clientHeight)
			return;
		this.c.css('height', 'auto');
		this.h = this.clientHeight;
		this.c.css('height', this.h + 'px');
	}).trigger('resize');
});
/* end Layout */

/* begin Button */
function artButtonSetup(className) {
	jQuery
			.each(
					jQuery("a." + className + ", button." + className
							+ ", input." + className),
					function(i, val) {
						var b = jQuery(val);
						if (!b.parent().hasClass('rco-button-wrapper')) {
							if (!b.hasClass('rco-button'))
								b.addClass('rco-button');
							jQuery(
									"<span class='rco-button-wrapper'><span class='rco-button-l'> </span><span class='rco-button-r'> </span></span>")
									.insertBefore(b).append(b);
							if (b.hasClass('active'))
								b.parent().addClass('active');
						}
						b.mouseover(function() {
							jQuery(this).parent().addClass("hover");
						});
						b.mouseout(function() {
							var b = jQuery(this);
							b.parent().removeClass("hover");
							if (!b.hasClass('active'))
								b.parent().removeClass('active');
						});
						b.mousedown(function() {
							var b = jQuery(this);
							b.parent().removeClass("hover");
							if (!b.hasClass('active'))
								b.parent().addClass('active');
						});
						b.mouseup(function() {
							var b = jQuery(this);
							if (!b.hasClass('active'))
								b.parent().removeClass('active');
						});
					});
}
jQuery(function() {
	artButtonSetup("rco-button");
});

/* end Button */

/* begin VMenu */
jQuery(function() {
	jQuery('ul.rco-vmenu li')
			.not(':first')
			.before(
					'<li class="rco-vsubmenu-separator"><span class="rco-vsubmenu-separator-span"> </span></li>');
	jQuery('ul.rco-vmenu > li.rco-vsubmenu-separator').removeClass(
			'rco-vsubmenu-separator').addClass('rco-vmenu-separator').children(
			'span').removeClass('rco-vsubmenu-separator-span').addClass(
			'rco-vmenu-separator-span');
	jQuery('ul.rco-vmenu > li > ul > li.rco-vsubmenu-separator:first-child')
			.removeClass('rco-vsubmenu-separator').addClass(
					'rco-vmenu-separator')
			.addClass('rco-vmenu-separator-first').children('span')
			.removeClass('rco-vsubmenu-separator-span').addClass(
					'rco-vmenu-separator-span');
}); /* end VMenu */

/* begin VMenuItem */
jQuery(function() {
	jQuery.each(jQuery('ul.rco-vmenu'), function(i, val) {
		var m = jQuery(val);
		m.find("ul, a").removeClass('active');
		var links = m.find('a');
		for ( var i = 0; i < links.length; i++) {
			if (links[i].href == window.location.href) {
				var a = jQuery(links[i]);
				a.parent().children('ul').addClass('active');
				a.parents('ul.rco-vmenu ul').addClass('active');
				a.parents('ul.rco-vmenu li').children('a').addClass('active');
				break;
			}
		}
	});
});
/* end VMenuItem */

function FP_swapImgRestore() {// v1.0
	var doc = document, i;
	if (doc.$imgSwaps) {
		for (i = 0; i < doc.$imgSwaps.length; i++) {
			var elm = doc.$imgSwaps[i];
			if (elm) {
				elm.src = elm.$src;
				elm.$src = null;
			}
		}
		doc.$imgSwaps = null;
	}
}

function FP_swapImg() {// v1.0
	var doc = document, args = arguments, elm, n;
	doc.$imgSwaps = new Array();
	for (n = 2; n < args.length; n += 2) {
		elm = FP_getObjectByID(args[n]);
		if (elm) {
			doc.$imgSwaps[doc.$imgSwaps.length] = elm;
			elm.$src = elm.src;
			elm.src = args[n + 1];
		}
	}
}

function FP_preloadImgs() {// v1.0
	var d = document, a = arguments;
	if (!d.FP_imgs)
		d.FP_imgs = new Array();
	for ( var i = 0; i < a.length; i++) {
		d.FP_imgs[i] = new Image;
		d.FP_imgs[i].src = a[i];
	}
}

function FP_getObjectByID(id, o) {// v1.0
	var c, el, els, f, m, n;
	if (!o)
		o = document;
	if (o.getElementById)
		el = o.getElementById(id);
	else if (o.layers)
		c = o.layers;
	else if (o.all)
		el = o.all[id];
	if (el)
		return el;
	if (o.id == id || o.name == id)
		return o;
	if (o.childNodes)
		c = o.childNodes;
	if (c)
		for (n = 0; n < c.length; n++) {
			el = FP_getObjectByID(id, c[n]);
			if (el)
				return el;
		}
	f = o.forms;
	if (f)
		for (n = 0; n < f.length; n++) {
			els = f[n].elements;
			for (m = 0; m < els.length; m++) {
				el = FP_getObjectByID(id, els[n]);
				if (el)
					return el;
			}
		}
	return null;
}
