<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.util.*" %>
    <%@ page import="java.text.DateFormat" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%

DateFormat myf = DateFormat.getDateInstance(DateFormat.LONG) ; 
String mys = myf.format(new Date()) ; 
String myLS = (String) request.getSession().getAttribute("LoginStatus") ; 
out.print("the genratetd date is : " + mys + "  and login stats is :" + myLS ) ; 


%>

</body>
</html>