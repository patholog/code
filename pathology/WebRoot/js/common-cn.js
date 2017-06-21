// JavaScript Document
// js对文字进行编码涉及3个函数：escape,encodeURI,encodeURIComponent，相应3个解码函数：unescape,decodeURI,decodeURIComponent

// Trim() , LTrim() , RTrim() 
// to trim text 
// usage text.Trim();
String.prototype.Trim = function() 
{ 
	return this.replace(/(^\s*)|(\s*$)/g, ""); 
}
String.prototype.trim = String.prototype.Trim;
String.prototype.LTrim = function() 
{
	return this.replace(/(^\s*)/g, ""); 
}
String.prototype.ltrim = String.prototype.LTrim;
String.prototype.lTrim = String.prototype.LTrim;
String.prototype.RTrim = function() 
{
	return this.replace(/(\s*$)/g, "");
}
String.prototype.rtrim = String.prototype.RTrim;
String.prototype.rTrim = String.prototype.RTrim;

// check a value is in the array or not
// Returns true if the passed value is found in the array. Returns false if it is not.
// usage string.inArray(array)
String.prototype.inArray = function(arr)
{
	for(var i in arr )
	{
		if ( arr[i] === this.toString() )
			return true;
	}
	return false;
}

// get AJax XmlHttp request object 
function getXmlHttp()
{
	var xmlHttp = null;
	//开始取值过程
	try { 
		xmlHttp = new ActiveXObject("MSXML2.XMLHTTP"); 
	} 
	catch(e) 
	{ 
		try { 
			xmlHttp = new ActiveXObject("Microsoft.XMLHTTP"); 
		} 
		catch(e2){
			xmlHttp = false;
		} 
	}
	if (!xmlHttp && typeof XMLHttpRequest != 'undefined') 
	{
		try {
			xmlHttp = new XMLHttpRequest();
		} catch (e3) {
			xmlHttp = false;
		}
	}
	return xmlHttp;
}

// mergeSpace :: Trim text then merge object's space values into one space
// parameter obj : object as TextBox, TextArea, etc;
// return String replaced
function mergeSpace(obj)  // method set obj.value
{
	var str = obj.value; 
	str = str.trim();   // use Trim method ************** 
	var regExp = /\s+/g;
	str = str.replace(regExp," ");
	obj.value = str;
}

// trimValue :: Trim text value of the object
// parameter obj : object as TextBox, TextArea, etc;
// return String replaced
function trimValue(obj)  // method set obj.value
{
	obj.value = obj.value.trim(); // use Trim method ************** 
}

// maxLenCheck :: Check obj's maxlen 
// obj object(TextBox, TextArea); maxlen numeric; strObjName string
// return Boolean
function maxLenCheck(obj,maxlen,strObjName) // True or False
{
	var str = obj.value.toString();
	var len = str.length;
	if( len > maxlen )
	{
		alert(strObjName+"长度不能大于"+ceil(maxlen/2)+"个字.");
		// obj.focus();
		return false;
	}
	return true;
}

// isEmpty :: Check obj is empty or not
// obj object(TextBox, TextArea, Selection); strObjName string
// return Boolean
function isEmpty(obj,strObjName)  // True or False
{
	var str = obj.value;
	var regExp = /\s+/g;
	str = str.replace(regExp,"");
	var len = str.length;
	if(len==0) {
		alert(strObjName+"不能为空!");
		// obj.focus();
		return true;
	}
	return false;
}

// isAlphaNumeric :: Check obj is alphanumeric formated or not
// obj object(TextBox); strObjName string
// return Boolean
function isAlphaNumeric(obj,strObjName)  // True or False
{
	// empty is not the test aim
	if(obj.value.Trim()=='')
		return true;

	var str = obj.value;
	var regExp = /^[a-zA-Z0-9]+$/g;
	if(obj.value.match(regExp)) {
		return true;
	}else{
		alert(strObjName+"不是字母数字类型!只允许a-zA-Z0-9.");
		// obj.value = '';
		// obj.focus();
		return false;
	}
}

// isNumeric :: Check obj is numeric formated or not
// obj object(TextBox); strObjName string
// return Boolean
function isNumeric(obj,strObjName)  // True or False
{
	// empty is not the test aim
	if(obj.value.Trim()=='')
		return true;
	
	var str = obj.value;
	var regExp = /^[0-9]+$/g;
	if(obj.value.match(regExp)) {
		return true;
	}else{
		alert(strObjName+"只允许数字0-9.");
		// obj.value = '';
		// obj.focus();
		return false;
	}
}

// isLetter :: Check obj is letters or not
// obj object(TextBox); strObjName string
// return Boolean
function isLetter(obj,strObjName)  // True or False
{
	// empty is not the test aim
	if(obj.value.Trim()=='')
		return true;
		
	var str = obj.value;
	var regExp = /^[a-zA-Z]+$/g;
	if(obj.value.match(regExp)) {
		return true;
	}else{
		alert(strObjName+"只允许使用字母a-z.");
		// obj.value = '';
		// obj.focus();
		return false;
	}
}

/*
** @ Name: checkEmail()
** @ Parameter: obj -> an input object; strObjName -> string
** @ Function: validating the input object's value is email or not
*/
function checkEmail(obj,strObjName)  // True or False
{
	// empty is not the test aim
	if(obj.value.Trim()=='')
		return true;
		
	var emailExp = /^[a-zA-Z0-9_\-\.]*@([a-zA-Z0-9][a-zA-Z0-9\-]+\.)+[a-zA-Z]{2,4}$/; 
	if( obj.value.match(emailExp)) {
		return true;
	}else{
		alert(strObjName+"不合法!");
		// obj.focus();
		return false;
	}
}

/*
** @ Name: checkDate()
** @ Parameter: obj -> an input object; strObjName -> string
** @ Function: validating the input object's value is valid Date or not
*/
function checkDate(obj,strObjName)
{
	// empty is not the test aim
	if(obj.value.Trim()=='')
		return true;

	var dateExp = /^[1-2][0-9]{3}\-(0[1-9]|1[1-2])\-(0[1-9]|[1-2][0-9]|3[0-1])$/;   // e.g. 2009-05-14 
	if(obj.value.match(dateExp)) {
		return true;
	}else{
		alert(strObjName+"不合法!");
		// obj.focus();
		return false;
	}
}

/*
** @ Name: isFloat()
** @ Parameter: obj -> an input object; strObjName -> string
** @ Function: validating the input object's value is float or not
*/
function isFloat(obj,strObjName)
{
	// empty is not the test aim
	if(obj.value.Trim()=='')
		return true;

	if(obj.value.length==1)
		var floatExp = /^[0-9]$/;
	else
		var floatExp = /^[0-9]\d*\.?\d*$/; 
	
	if(obj.value.match(floatExp)) {
		return true;
	} else {
		alert(strObjName+"只允许浮点数.");
		// obj.focus();
		return false;
	}
}

/*
** @ Name: isInt()
** @ Parameter: obj -> an input object; strObjName -> string
** @ Function: validating the input object's value is signed Integer or not
*/
function isInt(obj,strObjName)
{
	// empty is not the test aim
	if(obj.value.Trim()=='')
		return true;
		
	var regExp = /^(0|[1-9][0-9]*)$/;
	if(obj.value.match(regExp)) {
		return true;
	}else{
		alert(strObjName+"只允许整数.");
		// obj.focus();
		return false;
	}
}

/*
** @ Name: doSearch()
// parameter objID : the text box html object id, where we enter search term 
** usage: doSearch('term')
*/
function doSearch(objID)
{
	var term = document.getElementById(objID).value;
	var url = window.location.href;
	var arr = url.split("?");
	// reset url if no query
	if( arr.length==1 || arr[1].Trim()=='' )
	{	// no query in url, get the old query
		var prequery = document.getElementById('prequery').value.Trim();
		if( prequery.match(/^\?catid=[^&]{1,}$/g) )
			prequery = '';
		url = url + prequery;
		var regExpTmp = /\?+/g; // replace ?? to ? 
		url = url.replace(regExpTmp,'?');
	}
	var queryString = setNewQueryString(url,'term',term,1);	
	// check if pager in use
	if( queryString.indexOf('page=') >=0 )
	{
		var newURL = arr[0]+"?"+queryString;
		queryString = setNewQueryString(newURL,'page','1',1);	
	}
	window.location.href = queryString=="" ? arr[0] : (arr[0]+"?"+queryString) ;
}

/*
** @ Name: MM_jumpMenu()
// parameter 1 variable : the query variable name
// parameter 2 value : the query variable value
** usage: MM_jumpMenu('id','21') 
*/
function MM_jumpMenu(variable,value)
{	
	var url = window.location.href;
	var arr = url.split("?");
	// reset url if no query
	if( arr.length==1 || arr[1].Trim()=='' )
	{	// no query in url, get the old query
		var prequery = document.getElementById('prequery').value.Trim();
		if( prequery.match(/^\?term=[^&]{1,}$/g) )
			prequery = '';
		url = url + prequery; 
		var regExpTmp = /\?+/g; // replace ?? to ? 
		url = url.replace(regExpTmp,'?');
	}
	// blank checker 
	var regExp = /\s+/g;
	// if varialbe == '' then return false
	if( variable.replace(regExp,'')=='' )	
		return false;
		// =========================
	var queryString = setNewQueryString(url,variable.trim(),value,1);		
	// check if pager in use
	if( variable!='page' && queryString.indexOf('page=') >=0 )
	{
		var newURL = arr[0]+"?"+queryString;
		queryString = setNewQueryString(newURL,'page','1',1);	
	}
	// check if catid in use for category 
	if( variable!='catid' && queryString.indexOf('catid=') >=0 )
	{
		var newURL = arr[0]+"?"+queryString;
		queryString = setNewQueryString(newURL,'catid','',1);	
	}
	window.location.href = queryString=="" ? arr[0] : (arr[0]+"?"+queryString) ;
}

// set the new query string
// parameter 1 url : the url adress text
// parameter 2 variable : the query variable name
// parameter 3 value : the query variable value
// parameter 4 cache : to determine to save original query string text or not (1 or 0)
// usage setNewQueryString('http://localhost/pma/index.php?id=20&db=devweb&p=2','id','21',1) 
function setNewQueryString(url,variable,value,cache) 
{
	// define the variable to save query string text
	var queryString = '';
	var oldQueryString = '';
	// blank checker 
	var regExp = /\s+/g;
	// check and fill the url address
	if( url.replace(regExp,'')=='' )
		url = window.location.href;
	// set default value for variable's value	
	value = typeof value!="undefined"?value:'';
	value = value.trim(); // use Trim method ************** 
	// set default value for cache	
	cache = typeof cache!="undefined"?cache:1;
	if( cache!=0 && cache!=1 )
		cache = 1;
	// parse the url into array
	var urlArr = url.split("?");
	var counter = urlArr.length;

	// if there are old query strings, save them
	if( counter >1 )
		oldQueryString = urlArr[1];
	// set old query string blank value
	if( oldQueryString.replace(regExp,'')=='' )
		oldQueryString = '';
	
	// if varialbe == '' 
	// then return old query string text
	if( variable.replace(regExp,'')=='' )	
		return oldQueryString;
		// =========================
	// if don't have old query strings, 
	// just return a new query string text
	if( oldQueryString=='' )  {
		if( value!='' )
			queryString = variable+"="+value;
		return queryString;
		// =========================
	} 		
	// if don't cache original qurey string, 
	// just return a new query string text
	if(!cache)  {
		if( value!='' )
			queryString = variable+"="+value;
		return queryString;
		// =========================
	}
	// parse the old query string text
	// and resolove into new query string text
	var queryStrArr = urlArr[1].split("&");
	counter = queryStrArr.length;
	// used for test repeat query variables
	var testArr = new Array();
	// test if the variable exist
	var flag = false;
	// set value for query variables seperately
	for (var i in queryStrArr) 
	{   // check if the single old query value does exist 
		var oldQueryValue = queryStrArr[i].replace(regExp,'');
		if( oldQueryValue!='' )
		{
			var newArr = queryStrArr[i].split('=');
			// set value for the old query variable seperately
			var newVal = '';
			if(newArr[0]==variable)
			{
				newVal = value;  // new value
				flag = true;
			} else
				newVal = typeof newArr[1]!="undefined"?newArr[1]:''; // old value
			// test repeat query variables
			if( !newArr[0].inArray(testArr) && newVal.trim()!='' )  // use inArray method ************** 
			{
				// organize the new query stings 
				queryString += (queryString!=''?"&":'')+newArr[0]+'='+newVal;
				// push value into array
				testArr.push(newArr[0]);
			}
		} // end of if( oldQueryValue!='' )
	} // end for 
	
	if( ( queryString=='' || !flag ) && value!='' ) // blank query string  or  variable does not exists
		queryString += (queryString!=''?"&":'') + variable+"="+value;
	
	return queryString;
}

// auto set the link_slug by title
// filter brand name
function filterBrand(str,brand)
{
	if(brand.Trim()!='')
	{
		var reg = new  RegExp(brand+'\\s+','i');
		str = str.replace(reg,'');
		reg = new  RegExp('\\s+'+brand,'i');
		str = str.replace(reg,'');
		reg = new  RegExp(brand,'i');
		str = str.replace(reg,'');
	}
	return str;
}
// 3 functions below
function setLinkSlug(str,slugObjId)
{
	var slugObj = document.getElementById(slugObjId);
	slugObj.value = getLinkSlug(str);
	// alert(str);
}
// same to php function getLinkSlug($str) 
function getLinkSlug(str)
{
	var newStr = str.Trim().toLowerCase();
	if( str!='' )
	{	// work
		var regExpCh =  /[\u4e00-\u9fcf]/;
		if( newStr.search(regExpCh)>=0 )
			str = encodeSpecial(encodeURIComponent(newStr));
			// js对文字进行编码涉及3个函数：escape,encodeURI,encodeURIComponent，相应3个解码函数：unescape,decodeURI,decodeURIComponent
		else
		{
			var regExp = /[^a-zA-Z0-9]/g;
			str = newStr.replace(regExp,' ');
			regExp = /\s+/g;
			str = str.replace(regExp,' ').Trim();
			if(str=='')
				str = encodeSpecial(encodeURIComponent(newStr));
				// js对文字进行编码涉及3个函数：escape,encodeURI,encodeURIComponent，相应3个解码函数：unescape,decodeURI,decodeURIComponent
			else
				str = str.replace(regExp,'-');
		}
		return str;
	} else
		return '';
	// the value return 
}
// ! ' ( ) * ~  -> 6 个 js encodeURIComponent 不编码 而 php rawurlencode 编码 的特殊字符
function encodeSpecial(str,encodeSpace)
{
	if( typeof encodeSpace!="undefined" && encodeSpace )
	{	// only for urlencode use for <space encode>
		regExp = /\%20/g;
		str = str.replace(regExp,'+');
	}
	// ! 
	regExp = /\!/g;
	str = str.replace(regExp,'%21');
	// ' 
	regExp = /\'/g;
	str = str.replace(regExp,'%27');
	// (
	regExp = /\(/g;
	str = str.replace(regExp,'%28');
	// )
	regExp = /\)/g;
	str = str.replace(regExp,'%29');
	// * 
	regExp = /\*/g;
	str = str.replace(regExp,'%2A');
	// ~ 
	regExp = /\~/g;
	str = str.replace(regExp,'%7E');
	return str;
}

// set timer for pages
function Time()
{
	var Timer = new Date();	
	var myclock = Timer.toLocaleString();
	document.getElementById('mytimer').innerHTML = myclock;
	setTimeout("Time()",1000)//每1000毫秒，调用一次Time函数,即一秒动一次。
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
	{
		alert('We need cookie enabled!');   
		return false;
	}
	else 
	{
		var date=new Date();   
		date.setTime(date.getTime()+1000*60*60*24); // one day 
		document.cookie=cookie_name+"="+escape(cookie_value)+';expires='+date.toGMTString(); 
		// alert( date.toGMTString() );
		return true;
	} 
}
// js get query string value
// use regular expression way get string directly
function getQueryString(name)
{   
 var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");
 var r = window.location.search.substr(1).match(reg);
 if (r!=null) 
 	return decodeURIComponent(r[2]); //  use this to avoid utf-8 decode error
 return '';
} 
// js get all query strings in array 
// use substring way capture all query in to an array 
function getQuery(url)
{
	if( url.trim()=='')
		url = location.search.replace(/\&amp;/g,'&');
	else
		url = url.replace(/\&amp;/g,'&');
	var theRequest = new Array();
	//alert(url);
	if(url.indexOf("?") != -1)
	{ 
	  var urlArr = url.split('?');
	  url = '?'+urlArr[urlArr.length-1];
	  var str = url.substr(1);
	  strsArr = str.split("&");
	  for(var i = 0; i < strsArr.length; i++ )
	  { 
		 theRequest[strsArr[i].split("=")[0]] = decodeURIComponent(strsArr[i].split("=")[1]);//  use this to avoid utf-8 decode error
	  }
	}
	// return an array[]
	return theRequest;
}
