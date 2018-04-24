<%@page import= "java.util.Date" %>
<%@page import= "domain.LoanApplication"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import= "java.util.Random" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Pozyczki u Zuka</title>
</head>
<body>
<%!
	private Random generator= new Random();
%>

<%
	String number = ""+generator.nextInt();
%>
	<jsp:useBean id="loan" class="domain.LoanApplication" scope="session"/>
	<jsp:setProperty property="number" name="loan" value="<%=number %>"/>
	<jsp:setProperty property="date" name="loan" value="<%=new Date() %>"/>
	Wygenerowany numer wniosku: <%=loan.getNumber() %>
		<br/>
	Date wygenerowania: <%=loan.getDate() %>
	
	<form action="person.jsp">
		<label>Wnioskowana kwota: <input type="number" id="amount" name="amount"/></label></br>
		<label>Ilosc rat: <input type= "number" id="instellmentCount" name= "installmentCount"/></label></br>
		<input type="submit" value="nstepny krok"/>
	</form>
</body>
</html>