<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<html>
  <head>
   <title>Login</title>
     <style type="text/css">
     	.login{
     		font-family: Arial;
     		font-size: 14px;
     	}
     </style>
     <link rel="stylesheet" href="CSS/css3.css" style="text/css">
  </head>
  <body topmargin="150px">
  <center>
        <p></p>
    	<form action="UserAction!login" method="post">
    	   <fieldset id="inputs" style="width: 400; height: 150" class="newStyle"><br>
    	      <legend>User Login</legend>
     User Name:<input type="text" class="login" name="user.username" placeholder="Enter User Name" autofocus required><br><br>
      Password:<input type="password" class="login" name="user.password" placeholder="Enter Passward" required><br><br>
      Role:<input type="text"  class="login"  name="user.role" placeholder="Role" list="searchlist" required/><br/><br>
		   	   <datalist id="searchlist">
					<option value="Student" label="Student"/> 
					<option value="Teacher" label="Teacher"/> 
					<option value="Visitor" label="Visitor"/> 
		    	   </datalist>
    	   </fieldset>
              <input type="submit" value="Submit">
              <input type="reset" value="Reset">
    	</form>
   </center>
  </body>
</html>