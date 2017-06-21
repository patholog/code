// JavaScript Document
/// forbid refresh
//屏蔽鼠标右键、Ctrl+N、Shift+F10、F11、F5刷新、退格键
var evt;
var ie=false;
var ff=false;
var key;

document.onkeydown = forbidRefresh;    //屏蔽刷新

document.oncontextmenu = noRightClick; //屏蔽鼠标右键

function noRightClick(e)
{
	if(e) {
		evt = e;
		ff = true;
		key = evt.which;
	} 
	else if(window.event) 
	{
		evt = window.event;
		ie = true;
		key = evt.keyCode;
	} else
		return false;
	//////////////////////////
	if(ie) {
		evt.returnValue=false;
	}
	if(ff) {
		return false;
	}
}

function forbidRefresh(e)
{
	//////////////////////////
	if(e) {
		evt = e;
		ff = true;
		key = evt.which;
	} 
	else if(window.event) 
	{
		evt = window.event;
		ie = true;
		key = evt.keyCode;
	} else
		return false;
	/////////////////////////
	if
	(  (evt.altKey) &&      // ALT 按键
		 (
		  	(key==37) ||   //屏蔽 Alt+ 方向键 ←
			(key==39)      //屏蔽 Alt+ 方向键 →
		 )      
	)
	{
		if(ie) {
			evt.keyCode = 0;
			evt.returnValue=false;
		}
		if(ff) {
			return false;
		}
	}
	/////////////////////////
	if (
		(key==116) ||               //屏蔽 F5 刷新键
		(evt.ctrlKey && key==82)    //Ctrl + R
	)
	{
		if(ie) {
			evt.keyCode = 0;
			evt.returnValue=false;
		}
		if(ff) {
			return false;
		}
	}
	if (key==122)     //屏蔽F11
	{
		if(ie) {
			evt.keyCode = 0;
			evt.returnValue=false;
		}
		if(ff) {
			return false;
		}
	} 
	if (evt.ctrlKey && key==78) //屏蔽 Ctrl+n
	{
		if(ie) {
			evt.keyCode = 0;
			evt.returnValue=false;
		}
		if(ff) {
			return false;
		}
	} 
	if (evt.shiftKey && key==121)  //屏蔽 shift+F10
	{
		if(ie) {
			evt.keyCode = 0;
			evt.returnValue=false;
		}
		if(ff) {
			return false;
		}
	} 
	//////////////////////////////////////////
}
