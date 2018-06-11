<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta charset="UTF-8">

  <title>Login </title>


    <link rel="stylesheet" href="style.css" type="text/css" />
    
</head>
<body>
<div class="wrapper fadeInDown">
  <div id="formContent">
    <!-- Tabs Titles -->
    <h2 class="active"> Sign In </h2>
   <%!String acc_no=null; %>
<%acc_no=(String)request.getParameter("acc_no"); %>
<%! HttpSession session;%>
<% session= request.getSession(true); %>
	      <%  String acc_no=(String)session.getAttribute("acc_no"); %>
        <%System.out.println("U ENTERED"+acc_no); %>
    
<form method="post" action="passAuth">
<div class="avatar">
      <img src="retrieveServlet?acc_no=<%=acc_no %>" style="border-radius: 50%;" width="100" height="160" onError="loadImage()" onAbort="loadImage()">
		</div>
   
            <input type="text" id="password" class="fadeIn third" name="password" placeholder="Password">
               
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