<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
	<div id="mainbox">
		<div id="box0"></div><div id="box1">下</div>
		<div id="items" style="">
			<table border="0" width="100%" bgcolor="#000000">
				<table border="0" width="100%" cellpadding="0" cellspacing="1">
				<c:forEach var="hospital" items="${hoslist}">
					<tr bgcolor="#0099CC">
						<td ><input name="hospital.idHospital" value="${hospital.idHospital }" id="test"
							type=checkbox></td>
						<td>${hospital.name}</td>
					</tr>
					</c:forEach>
					</table>

			</table>
		</div>
	</div>

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
         * ä»¥ä¸æ¯ç¨äºå½é¼ æ ç¦»å¼åè¡¨æ¶ï¼åè¡¨æ¶å¤± 
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

