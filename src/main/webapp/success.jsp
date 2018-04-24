<%@page import= "domain.LoanApplication"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<jsp:useBean id="loanService" class="service.LoanService" scope="application"/>
	<jsp:useBean id="loan" class="domain.LoanApplication" scope="session"/>
	<jsp:useBean id="parameters" class="domain.LoanParameters" scope="session"/>
	<jsp:useBean id="person" class="domain.Person" scope="session"/>
	<jsp:useBean id="adress" class="domain.Adress" scope="session"/>
	
	<jsp:setProperty property="*" name="person"/>
	<jsp:setProperty property="*" name="adress"/>

	
	
	<%
		loan.setParameters(parameters);
		loan.setPerson(person);
		loan.setAdress(adress);
		loanService.add(loan);
	%>
	<u1>
	<%
		for(LoanApplication loanApplication: loanService.getAll()){
	%>
	<li>Wniosek:<%=loanApplication.getNumber()
					+" Osoba: "+loanApplication.getPerson().getSurname()
					+", Kwota: "+loanApplication.getParameters().getAmount()
					+", miasto: "+loanApplication.getAdress().getCity()
					+", kod pocztowy: "+loanApplication.getAdress().getZipCode()
					+", ulica: "+loanApplication.getAdress().getStreet()
					+", nr domu: "+loanApplication.getAdress().getHouseNumber()
					+", nr lokalu: "+loanApplication.getAdress().getLocalNumber()
					+", nr telefonu: "+loanApplication.getAdress().getPhoneNumber()%></li>
	<%
		}
	%>
</body>
</html>