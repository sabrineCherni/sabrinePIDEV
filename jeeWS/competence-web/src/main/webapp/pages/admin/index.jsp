<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="email.*"%><html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body style="background-image: url(back11.jpg)">

	<center>
	
		<h2>Send Mail </h2>
	
		<form action="index.jsp">
				Email : <input type="text" name="email"><br>
				<br>
				Message : <textarea name="message" rows="10" cols="15"></textarea><br>
				<br>
				
				<input type="submit" name="Send" value="Send email">
		</form>	


		<%
		String email=(String)request.getParameter("email");
		String message=(String)request.getParameter("message");
		
		if(message!=null){
			send_mail obj_send_mail=new send_mail();
			
			obj_send_mail.send_mail(message,email);
		%>
				<br>Email send to : <%=email %>
		<%	
			
		}
			
		%>



	</center>




</body>
</html>