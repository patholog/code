// JavaScript Document

//树形菜单
function leftMenuTreeView() {
	// get the tree menu
	var leftmenu = document.getElementById('leftmenu');
	// set menu title
	var list = leftmenu.getElementsByTagName('div');
	for ( i=0; i<list.length; i++ ) {
		list[i].getElementsByTagName('h3')[0].onclick = function() {
			if (this.parentNode.getElementsByTagName('ul')[0].style.display == 'block') 
			{
				this.parentNode.getElementsByTagName('ul')[0].style.display = 'none';
				setCookie('list_display_'+this.parentNode.id,'none');
				this.className = 'iconopen';
				setCookie('display_icon_'+this.parentNode.id,'iconopen');
			} else {
				// close all firstly 
				var leftmenu_n = document.getElementById('leftmenu');
				var list_n = leftmenu.getElementsByTagName('div');
				for ( m=0; m<list.length; m++ ) 
				{
					list_n[m].getElementsByTagName('ul')[0].style.display = 'none';
					setCookie('list_display_'+list_n[m].id,'none');
					list_n[m].getElementsByTagName('h3')[0].className = 'iconopen';
					setCookie('display_icon_'+list_n[m].id,'iconopen');
				}
				// open this 
				this.parentNode.getElementsByTagName('ul')[0].style.display = 'block';
				setCookie('list_display_'+this.parentNode.id,'block');
				this.className = 'iconclose';
				setCookie('display_icon_'+this.parentNode.id,'iconclose');
			}
		}
		cookieClassName = getCookie('display_icon_'+list[i].getElementsByTagName('h3')[0].parentNode.id)?getCookie('display_icon_'+list[i].getElementsByTagName('h3')[0].parentNode.id):'iconopen';
		list[i].getElementsByTagName('h3')[0].className = cookieClassName;
		cookieStyle = getCookie('list_display_'+list[i].getElementsByTagName('h3')[0].parentNode.id)?getCookie('list_display_'+list[i].getElementsByTagName('h3')[0].parentNode.id):'none';
		list[i].getElementsByTagName('h3')[0].parentNode.getElementsByTagName('ul')[0].style.display = cookieStyle;
	}
	// set menu links display style
	var linkitem = leftmenu.getElementsByTagName('a');
	for ( j=0; j<linkitem.length; j++ ) {
		linkitem[j].onclick = function() {
			for ( k=0; k<linkitem.length; k++ ) {
				linkitem[k].className = '';
			}
			this.className = 'current';
			setCookie('link_current',this.innerHTML);
			this.blur();
		}
		if( getCookie('link_current')==linkitem[j].innerHTML )
			linkitem[j].className = 'current';
	}
	// alert(document.cookie);
}

// This functions reads & returns the cookie value of the specified cookie (by cookie name) 
function getCookie(CookieName)
{
	var CookieVal = '';
	if(document.cookie)	   //only if exists
	{
		var arr = document.cookie.split((escape(CookieName) + '=')); 
		if(arr.length >= 2)
		{
			var arr2 = arr[1].split(';');
			CookieVal  = unescape(arr2[0]); //unescape() : Decodes the String
		}
	}
	return CookieVal;
}

// set a cookie
function setCookie(cookie_name,cookie_value)
{    
	if(!navigator.cookieEnabled)
		alert('浏览器必须启用Cookie，否则无法正常工作！');   
	else 
	{
		var date=new Date();   
		date.setTime(date.getTime()+1000*60*60*24);
		document.cookie=cookie_name+"="+escape(cookie_value)+';expires='+date.toGMTString(); 
		// alert( date.toGMTString() );
	}    
}
