function ChkAllClick(sonName, cbAllId) {
	var arrSon = document.getElementsByName(sonName);
	var cbAll = document.getElementById(cbAllId);
	var tempState = cbAll.checked;
	for (i = 0; i < arrSon.length; i++) {
		if (arrSon[i].checked != tempState)
			arrSon[i].click();
	}
}
function ChkSonClick(sonName, cbAllId) {
	var arrSon = document.getElementsByName(sonName);
	var cbAll = document.getElementById(cbAllId);
	for ( var i = 0; i < arrSon.length; i++) {
		if (!arrSon[i].checked) {
			cbAll.checked = false;
			return;
		}
	}
	cbAll.checked = true;
}
function ChkOppClick(sonName) {
	var arrSon = document.getElementsByName(sonName);
	for (i = 0; i < arrSon.length; i++) {
		arrSon[i].click();
	}
}
function changeBgColor(btn) {
	var btn = document.getElementById(btn);
	btn.style.backgroundColor = "#90BFFF";
}
function recoverBgColor(btn) {
	var btn = document.getElementById(btn);
	btn.style.backgroundColor = "#448EF3";
} // JavaScript Document

function play() {
	document.getElementById("menu_item").style.display = "";
}
function noplay() {
	document.getElementById("menu_item").style.display = "none";
}
function passwd() {
	var pass = document.getElementById("password").value;
	var tip = document.getElementById("pwsdtip");
	if (pass.length < 4) {
		//document.getElementById("meter").value = pass.length;
		tip.innerHTML = "差";
	} else if (pass.length <= 8) {
		//document.getElementById("meter").value = pass.length;
		tip.innerHTML = "中";
	} else {
		//document.getElementById("meter").value = pass.length;
		tip.innerHTML = "高";
	}
}

function show() {
	var file = document.getElementById("f").files[0];
	var fileReader = new FileReader();
	fileReader.readAsDataURL(file);
	fileReader.onload = function() {
		document.getElementById("img").src = fileReader.result;
	};
}

