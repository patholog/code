<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<div id="mainbox">
	<div id="box0"><input type="hidden" name="user.belonghospital" value=""></div>
	<div id="box1">
		<img src="${path}/images/icon_select.png" width="20" height="20" />
	</div>
	<div id="items" style="">
		<table border="0" width="100%" cellpadding="0" cellspacing="1">
			<c:forEach var="hospital" items="${hoslist}">
				<tr>
					<td><input name="test"
						value="${hospital.idHospital}" id="test" type=checkbox>
						<input name="${hospital.idHospital}" type="hidden" value="${hospital.name}">
					</td>
					<td>${hospital.name}</td>
				</tr>
			</c:forEach>
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
        
        function getCheckedValues(){
                
                var values = document.getElementsByName("test");
                
                var selectValue="";
                var selectName="";
                
                for(var i=0;i<values.length;i++){
                        if(values[i].checked){ 
                                selectValue += values[i].value +",";
                                var name = document.getElementsByName(values[i].value)[0].value;
                                selectName += name + " | ";
                        }
                }         
                document.getElementById("box0").innerHTML=selectName.substring(0, selectName.length-2);
                document.getElementsByName("user.belonghospital").value=selectValue.substring(0, selectValue.length-2);
        } 
</script>

