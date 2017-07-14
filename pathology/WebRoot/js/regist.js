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

//判断输入密码的类型    
function CharMode(iN){    
	if (iN>=48 && iN <=57) //数字    
		return 1;    
	if (iN>=65 && iN <=90) //大写    
		return 2;    
	if (iN>=97 && iN <=122) //小写    
		return 4;    
	else    
		return 8;     
}  
//bitTotal函数    
//计算密码模式    
function bitTotal(num){    
	modes=0;    
	for (i=0;i<4;i++){    
		if (num & 1) modes++;    
		num>>>=1;    
	}  
	return modes;    
}  
//返回强度级别    
function checkStrong(sPW){    
	if (sPW.length<6)    
		return 0; //密码太短，不检测级别  
	Modes=0;    
	for (i=0;i<sPW.length;i++){    
		//密码模式    
		Modes|=CharMode(sPW.charCodeAt(i));    
	}  
	return bitTotal(Modes);    
}  

//显示颜色    
function pwStrength(pwd){    
	Dfault_color="#eeeeee";     //默认颜色  
	L_color="#FF0000";      //低强度的颜色，且只显示在最左边的单元格中  
	M_color="#FF9900";      //中等强度的颜色，且只显示在左边两个单元格中  
	H_color="#33CC00";      //高强度的颜色，三个单元格都显示  
	if (pwd==null||pwd==''){    
		Lcolor=Mcolor=Hcolor=Dfault_color;  
	}    
	else{    
		S_level=checkStrong(pwd);    
		switch(S_level) {    
		case 0:    
			Lcolor=Mcolor=Hcolor=Dfault_color;  
			break;  
		case 1:    
			Lcolor=L_color;  
			Mcolor=Hcolor=Dfault_color;  
			break;    
		case 2:    
			Lcolor=Mcolor=M_color;    
			Hcolor=Dfault_color;    
			break;    
		default:    
			Lcolor=Mcolor=Hcolor=H_color;    
		}    
	}    
	document.getElementById("strength_L").style.background=Lcolor;    
	document.getElementById("strength_M").style.background=Mcolor;    
	document.getElementById("strength_H").style.background=Hcolor;    
	return;  
}  



