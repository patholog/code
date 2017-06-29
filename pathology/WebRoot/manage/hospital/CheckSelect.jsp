<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Untitled Document</title>

<style type="text/css">
div {
	padding: 0px;
	font-size: 12px;
}

#mainbox {
	width: 234px;
}

#box0 {
	width: 200px;
	height: 20px;
	border: 1px solid green;
	float: left;
	padding-top: 2px;
	padding-left: 2px;
	overflow-y: scroll;
}

#box1 {
	width: 20px;
	height: 20px;
	cursor: pointer;
	border: 1px solid green;
	float: left;
	text-align: center;
	padding-top: 2px;
}

#items {
	border: 1px solid black;
	width: 208px;
	display: none;
	height: 100px;
	overflow-y: scroll;
}

#box3 {
	width: 218px;
	/*border-bottom:1px solid green;
                                border-left:1px solid green;
                                border-right:1px solid green;        
                        */
	padding-left: 4px;
}

.over {
	background-color: #11586E;
	font-weight: bold;
	color: #FFF;
	/*border-top:1px dotted black;
                                border-bottom:1px dotted black;*/
	cursor: pointer;
}

p {
	font-size: 12px;
	color: activeCaption;
	font-weight: bold;
}
</style>

</head>
<body>

	<div id="mainbox">
		<div id="box0"></div>
		<div id="box1">↓</div>
		<div id="items" style="">
			<table border="0" width="100%" bgcolor="#000000">
				<table border="0" width="100%" cellpadding="0" cellspacing="1">
					<tr bgcolor="#0099CC">
						<td width="10%"><input value="200012020202" id="test"
							type=checkbox></td>
						<td>200012020202</td>
						<td>张 三</td>
					</tr>
					<tr bgcolor="#0099CC">
						<td><input value="200012020202" id="test" type=checkbox>
						</td>
						<td>200012020202</td>
						<td>张 三</td>
					</tr>
					<tr bgcolor="#0099CC">
						<td><input value="200012020202" id="test" type=checkbox>
						</td>
						<td>200012020202</td>
						<td>张 三</td>
					</tr>
					<tr bgcolor="#0099CC">
						<td><input value="200012020202" id="test" type=checkbox>
						</td>
						<td>200012020202</td>
						<td>张 三</td>
					</tr>
					<tr bgcolor="#0099CC">
						<td><input value="200012020202" id="test" type=checkbox>
						</td>
						<td>200012020202</td>
						<td>张 三</td>
					</tr>
					<tr bgcolor="#0099CC">
						<td><input value="200012020202" id="test" type=checkbox>
						</td>
						<td>200012020202</td>
						<td>张 三</td>
					</tr>
				</table>

			</table>
		</div>
	</div>



</body>
<script type="text/javascript">
        var flag=0;
        var oDiv0=document.getElementById("box0");
        var oDiv1=document.getElementById("box1");
        var oDiv=document.getElementById("items");
        oDiv1.onclick=function(){
              if(flag==0){
                       oDiv.style.display="block"; 
                                   flag = 1;
               }
               else{
                                   flag=0; 
                                oDiv.style.display="none"; 
                                getCheckedValues();
                         }

        } 
        
        oDiv0.onclick=function(){
            if(flag!=0){
                                   flag=0; 
                                oDiv.style.display="none"; 
                                getCheckedValues();
                         }

        } 
        /*
         * 以下是用于当鼠标离开列表时，列表消失 
          oDiv.onmouseleave = function(){
                flag=0; this.style.display="none"; getCheckedValues();        
        } */
        function getCheckedValues(){
                
                var values = document.getElementsByName("test");
                
                var selectValue="";
                
                for(var i=0;i<values.length;i++){
                        if(values[i].checked){ 
                                selectValue += values[i].value +" | ";
                        }
                }         
                document.getElementById("box0").innerText=selectValue;
        } 
</script>
</html>
