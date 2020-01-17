<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<style>
p {
  font-size: 20px;
}
form { width: 400px; }
label { float: left; width: 220px; }
input[type=number] { float: left; width: 250px; }
.clear { clear: both; height: 3; line-height: 2; }
.floatright { float: right; }
</style>
<h1>Enter Student Details</h1>
<form action="admin" method="post">
<p><label for="studentid">  STUDENT ID</label>   : <input type="text" name="studentid" required></p>
<p><label for="studentname">STUDENT NAME</label> : <input type="text" name="studentname" required></p>
<p><label for="category">   STUDENT CATEGORY</label> : <input type="text" name="category" required></p>
<p><label for="standard">   STANDARD</label> : <input type="text" name="standard" required></p>
<p><input type="submit" value="ADD"></p>     
</form>
</body>
</html>





