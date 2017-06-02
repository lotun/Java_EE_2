<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="css.css" rel="stylesheet" type="text/css" />
<script src="js.js"></script>
<title>Insert title here</title>
</head>
<body>
<form action="http://localhost:8080/Java_EE_2/Stat" method="post" onsubmit="return validate_form ( );" name="contact_form">
    <label><b>Login</b></label>
    <input type="text" required=""  placeholder="Enter login" name="login" >

    <label><b>Password</b></label>
    <input type="password" placeholder="Enter password" name="password" required="">
	<button type="submit">Set Up</button>

</form>

</body>
</html>