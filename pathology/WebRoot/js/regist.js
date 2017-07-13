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
	var tip = document.getElementById("tip");
	if (pass.length < 4) {
		document.getElementById("meter").value = pass.length;
		tip.innerHTML = "差";
	} else if (pass.length <= 8) {
		document.getElementById("meter").value = pass.length;
		tip.innerHTML = "中";
	} else {
		document.getElementById("meter").value = pass.length;
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

// demo
function isString(str) {
	return (typeof str == 'string') && str.constructor == String;
}
String.prototype.startWith = function(s) {
	if (!isString(s))
		return false;
	if (s == null || s == "" || this.length == 0 || s.length > this.length)
		return false;
	if (this.substr(0, s.length) == s)
		return true;
	else
		return false;
	return true;
}

String.prototype.endWith = function(str) {
	var reg = new RegExp(str + "$");
	return reg.test(this);
}

$(document).ready(function() {
	$('#x_btn_demo').click(function() {
		var p = {
			param : getParamObj()
		}
		var param = JSON.stringify(p);
		$.ajax({
			type : "post",
			url : 'demo.action?demo',
			contentType : "application/json; charset=utf-8",
			data : param,
			dataType : "json",// 设置需要返回的数据类型
			success : function(d) {
				if (d.success == 1) {
					validate(d.rt);
					alert('通过！写跳转');
				} else {
					validate(d.rt);
				}
				// alert(JSON.stringify(d));
			},
			error : function(d) {
				alert(d.responseText);
			}
		});

	});
});
function validate(o) {
	var pre = "x_tip_";
	for ( var i in o) {
		if (i.endWith("_tip")) {
			$("#" + pre + i).html(o[i]);
		}
	}
}
function getParamObj() {
	var mark = "x_txt_";
	var param = {};
	$(':input').each(function() {
		var id = $(this).attr("id");
		if (isString(id)) {
			if (id.startWith(mark)) {
				var fieldName = id.substr(mark.length, id.length);
				param[fieldName] = $(this).val();
			}
		}
	});
	return param;
}