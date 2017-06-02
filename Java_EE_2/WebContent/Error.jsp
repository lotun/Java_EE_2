<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
a data-entry error, ostalos <%=5-Integer.parseInt((String)getServletContext().getAttribute("trying"))%> attempts
<%
request.getRequestDispatcher("/user.jsp").include(request, response);
%>
</body>
</html>