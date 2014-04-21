$(document).ready(function() {
	var role = getUrlVars()["role"];
	if (role === "undefined") {
		role = "user";
	}
	if (role === "admin") {
		$("#ajax-navbar").load("includes/common/navbar.html", function() {
			markNavbarMenuSection();
			$("li#user-complaints").hide();
			$("li#user-new-complaint").hide();
			appendRoleToLinks(role);
		});
	} else {
		$("#ajax-navbar").load("includes/common/navbar.html", function() {
			markNavbarMenuSection();
			$("li#citizen-registry").hide();
			$("li#all-citizens").hide();
			appendRoleToLinks(role);
		});
	}

});

function markNavbarMenuSection() {
	switch (getCurentFileName()) {
	case "index.html":
		$("li#home").addClass("active");
		break;
	case "myComplaints.html":
		$("li#user-complaints").addClass("active");
		break;
	case "newComplaint.html":
		$("li#user-new-complaint").addClass("active");
		break;
	case "allCitizens.html":
		$("li#all-citizens").addClass("active");
		break;
	default:
		break;
	}
}

function appendRoleToLinks(role) {
	$("a").each(function() {
		var _href = $(this).attr("href");
		if (_href.indexOf("#") === -1) {
			$(this).attr("href", _href + '?role=' + role);
		}
	});
}

function getUrlVars() {
	var vars = [], hash;
	var hashes = window.location.href.slice(
			window.location.href.indexOf('?') + 1).split('&');
	for (var i = 0; i < hashes.length; i++) {
		hash = hashes[i].split('=');
		vars.push(hash[0]);
		vars[hash[0]] = hash[1];
	}
	return vars;
}

function getCurentFileName() {
	var pagePathName = window.location.pathname;
	return pagePathName.substring(pagePathName.lastIndexOf("/") + 1);
}
