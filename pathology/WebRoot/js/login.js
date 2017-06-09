function deleteLogin(){
	var del=document.getElementById("login_box");
	var bg_filter=document.getElementById("bg_filter");
	bg_filter.style.display="none";
	del.style.display="none";
}
function showBox(){
	var show=document.getElementById("login_box");
	var bg_filter=document.getElementById("bg_filter");
	show.style.display="block";
	bg_filter.style.display="block";
	
}
/*var tmpHtml="";//创建全局变量用于存贮登录页面
var game={
	login:$(".login"),
	
	init:function(){
		$(".wapper").click(function(){
			game.sweep();
		});
	},
	//生成二维码界面
	sweep:function(){
		tmpHtml=game.login.html();//将登录页面的赋值给tmpHtml
		game.login.empty();
		game.barcode();
	},
	barcode:function(){
		var text=$("<div>");
		text.addClass("text");		
		text.html("扫描二维码登录");
		game.login.append(text);
		//二维码图片
		var images=$("<images src='images/sweep01.jpg' />");
		images.addClass("images");
		game.login.append(images);
		//返回登录界面
		var back=$('<div onclick="game.reback()">');
		back.addClass("back");
		back.html("返回登录页面");
		game.login.append(back);
		
	},
	reback:function(){
			game.login.html(tmpHtml);//重新给登录页面赋值
		}
	
}
$(function(){
	game.init();
});
*/
/*javascript面向对象编程*/
//声明全局变量用于存储login界面
var tmpHtml="";
//创建对象
var obj={
	//获取login
	login:$(".login"),
	//创建二维码点击事件
	init:function(){
		$(".wapper").click(function(){
			obj.sweep();
		});
	},
	//生成二维码界面
	sweep:function(){
		tmpHtml=obj.login.html();
		obj.login.empty();//将login页面制空
		obj.barcode();
	},
	//生成二维码
	barcode:function(){
		var text=$("<div>");
		text.addClass("text");
		text.html("扫码登录");
		obj.login.append(text);
		var images=$("<images src='images/sweep01.jpg' />");
		images.addClass("images");
		obj.login.append(images);
		var back=$("<div onclick='obj.reback()'>");
		back.addClass("back");
		back.html("返回登录页");
		obj.login.append(back);
		
	},
	reback:function(){
		obj.login.html(tmpHtml);
	}
}
obj.init();
