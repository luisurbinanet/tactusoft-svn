var svg;
var svgNS;
var currentTarget;
var previousTarget;
var procedureTooth = {};
var selected = false;

function handleNoteComplete(xhr, status, args) {
	if (args.validationFailed || !args.saved) {
		jQuery('dialogNote').effect("shake", {
			times : 3
		}, 100);
	} else {
		dlgNote.hide();
	}
}

function handleConsentComplete(xhr, status, args) {
	if (args.validationFailed || !args.saved) {
		jQuery('dialogConsent').effect("shake", {
			times : 3
		}, 100);
	} else {
		dlgConsent.hide();
	}
}

function start() {
	statusDialog.show();
}

function stop() {
	statusDialog.hide();
}

function createRectangle(id, x, y, width, height) {
	var rect = document.createElementNS(svgNS, 'rect');
	rect.setAttribute('id', id);
	rect.setAttribute('x', x);
	rect.setAttribute('y', y);
	rect.setAttribute('width', width);
	rect.setAttribute('height', height);
	rect.setAttribute('fill', '#eeeeee');
	rect.setAttribute('stroke', '#000000');
	rect.setAttribute('selected', -1);
	rect.setAttribute('colorApply', "eeeeee");
	rect.addEventListener("click", selectTooth, false);
	rect.addEventListener("mouseover", mouseOver, false);
	rect.addEventListener("mouseout", mouseOut, false);
	var title = document.createElementNS(svgNS, 'title');
	title.textContent = "";
	rect.appendChild(title);
	return rect;
}

function createText(x, y, value) {
	var text = document.createElementNS(svgNS, 'text');
	text.setAttribute('x', x);
	text.setAttribute('y', y);
	text.setAttribute('fill', '#ff0000');
	var data = document.createTextNode(value);
	text.appendChild(data);
	return text;
}

function loadOdontogram() {
	var svgContainer = document.getElementById("form:accordion:svgContainer");
	if (svgContainer) {
		currentTarget = null;
		previousTarget = null;
		procedureTooth = {};

		svg = document.createElementNS("http://www.w3.org/2000/svg", "svg");
		svgNS = svg.namespaceURI;
		svg.setAttribute('width', 850);
		svg.setAttribute('height', 310);

		var x = 15;
		var y = 10;
		var id = 18;
		var cont = -1;
		for ( var i = 0; i < 16; i++) {
			svg.appendChild(createRectangle("v" + id, x, y, 20, 10));
			document.body.appendChild(svg);

			svg.appendChild(createRectangle("m" + id, x - 12, y + 12, 10, 20));
			document.body.appendChild(svg);

			svg.appendChild(createRectangle("t" + id, x, y + 12, 20, 20));
			document.body.appendChild(svg);

			svg.appendChild(createRectangle("d" + id, x + 22, y + 12, 10, 20));
			document.body.appendChild(svg);

			svg.appendChild(createRectangle("p" + id, x, y + 34, 20, 10));
			document.body.appendChild(svg);

			svg.appendChild(createText(x + 3, y + 60, id));
			document.body.appendChild(svg);

			x = x + 50;
			id = id + cont;

			if (id == 10) {
				id = 21;
				cont = 1;
				x = x + 50;
			}
		}

		x = 165;
		y = 80;
		id = 55;
		cont = -1;
		for ( var i = 0; i < 10; i++) {
			svg.appendChild(createRectangle("v" + id, x, y, 20, 10));
			document.body.appendChild(svg);

			svg.appendChild(createRectangle("m" + id, x - 12, y + 12, 10, 20));
			document.body.appendChild(svg);

			svg.appendChild(createRectangle("t" + id, x, y + 12, 20, 20));
			document.body.appendChild(svg);

			svg.appendChild(createRectangle("d" + id, x + 22, y + 12, 10, 20));
			document.body.appendChild(svg);

			svg.appendChild(createRectangle("p" + id, x, y + 34, 20, 10));
			document.body.appendChild(svg);

			svg.appendChild(createText(x + 3, y + 60, id));
			document.body.appendChild(svg);

			x = x + 50;
			id = id + cont;

			if (id == 50) {
				id = 61;
				cont = 1;
				x = x + 50;
			}
		}

		x = 165;
		y = 150;
		id = 85;
		cont = -1;
		for ( var i = 0; i < 10; i++) {
			svg.appendChild(createRectangle("v" + id, x, y, 20, 10));
			document.body.appendChild(svg);

			svg.appendChild(createRectangle("m" + id, x - 12, y + 12, 10, 20));
			document.body.appendChild(svg);

			svg.appendChild(createRectangle("t" + id, x, y + 12, 20, 20));
			document.body.appendChild(svg);

			svg.appendChild(createRectangle("d" + id, x + 22, y + 12, 10, 20));
			document.body.appendChild(svg);

			svg.appendChild(createRectangle("p" + id, x, y + 34, 20, 10));
			document.body.appendChild(svg);

			svg.appendChild(createText(x + 3, y + 60, id));
			document.body.appendChild(svg);

			x = x + 50;
			id = id + cont;

			if (id == 80) {
				id = 71;
				cont = 1;
				x = x + 50;
			}
		}

		x = 15;
		y = 230;
		id = 48;
		cont = -1;
		for ( var i = 0; i < 16; i++) {
			svg.appendChild(createRectangle("v" + id, x, y, 20, 10));
			document.body.appendChild(svg);

			svg.appendChild(createRectangle("m" + id, x - 12, y + 12, 10, 20));
			document.body.appendChild(svg);

			svg.appendChild(createRectangle("t" + id, x, y + 12, 20, 20));
			document.body.appendChild(svg);

			svg.appendChild(createRectangle("d" + id, x + 22, y + 12, 10, 20));
			document.body.appendChild(svg);

			svg.appendChild(createRectangle("p" + id, x, y + 34, 20, 10));
			document.body.appendChild(svg);

			svg.appendChild(createText(x + 3, y + 60, id));
			document.body.appendChild(svg);

			x = x + 50;
			id = id + cont;

			if (id == 40) {
				id = 31;
				cont = 1;
				x = x + 50;
			}
		}

		svgContainer.appendChild(svg);
		loadProcedureTooth();
	}
}

function createAnimation(id) {
	var animate = document.createElementNS(svgNS, 'animate');
	animate.setAttribute('id', "a" + id);
	animate.setAttribute('attributeName', "stroke-width");
	animate.setAttribute('from', 0);
	animate.setAttribute('to', 6);
	animate.setAttribute('dur', "1s");
	animate.setAttribute('repeatCount', "indefinite");
	return animate;
}

function mouseOver(evt) {
	var target = evt.target;
	target.setAttributeNS(null, "stroke", "#000000");
	target.setAttributeNS(null, "stroke-width", "4");
}

function mouseOut(evt) {
	var target = evt.target;
	target.setAttributeNS(null, "stroke", "#000000");
	target.setAttributeNS(null, "stroke-width", "1");
}

function selectTooth(evt) {
	currentTarget = evt.target;
	if (previousTarget) {
		/*
		 * if (previousTarget.getAttribute("selected") == -1) {
		 * previousTarget.setAttributeNS(null, "fill", "#eeeeee"); } else { var
		 * color = "#" + previousTarget.getAttribute("colorApply");
		 * previousTarget.setAttributeNS(null, "fill", color); }
		 */
		var animate = document.getElementById("a" + previousTarget.id);
		previousTarget.removeChild(animate);
	}

	currentTarget.appendChild(createAnimation(currentTarget.id));

	previousTarget = currentTarget;
	getCurrentTooth(currentTarget.id);
	selected = true;
}

function applyProcedure(xhr, status, args) {
	if (currentTarget) {
		if (args.apply) {
			currentTarget.setAttribute("selected", args.descProcedure);
			currentTarget.setAttribute("fill", "#" + args.color);
		} else {
			currentTarget.setAttribute("fill", "#eeeeee");
			currentTarget.setAttribute("selected", -1);
		}
		currentTarget.children[0].innerHTML = args.descProcedure;
	}
}

function showProcedureTooth(xhr, status, args) {
	var procedures = JSON.parse(args.procedureTooth);
	jQuery.each(procedures, function(i, val) {
		var rect = document.getElementById(val.tooth);
		rect.setAttribute("selected", 1);
		rect.setAttribute("fill", "#" + val.color);
		rect.children[0].innerHTML = val.descProcedure;
	});
}

loadOdontogram();