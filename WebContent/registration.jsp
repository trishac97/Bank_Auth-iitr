<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta charset="UTF-8">

  <title>CodePen - Login </title>


    <link rel="stylesheet" href="style.css" type="text/css" />
</head>
<body>
<div class="wrapper fadeInDown">
  <div id="formContent">
    <!-- Tabs Titles -->
    <h2 class="active"> Sign In </h2>
<form method="post" action="uploadServlet" enctype="multipart/form-data">
<div style="color: blue;padding-left: 500px;background-color: rgba(0,0,255,0.1);margin-bottom: 20px"><b>
                                
    				<%
    			
        if(request.getAttribute("servermsg")!=null)
        	out.print(request.getAttribute("servermsg"));%>
        	</div>				
<div><br>
   
      <input type="text" id="acc_no" class="fadeIn third" name="acc_no" placeholder="10-Digit Account Number">
            <input type="text" id="password" class="fadeIn third" name="password" placeholder="Password">
                  <input type="text" id="first_name" class="fadeIn third" name="first_name" placeholder="First Name"><br>
                      <input type="text" id="last_name" class="fadeIn third" name="last_name" placeholder="Last Name"><br>
    <input type="file" name="photo" class="fadeIn third" size="50"/>
      <input type="submit" class="fadeIn fourth" value="Log In">
    </form>

    <!-- Remind Passowrd -->
    <div id="formFooter">
      <a class="underlineHover" href="#">Forgot Password?</a>
    </div>

  </div>
</div>

</body>
</html>