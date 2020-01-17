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
<h1>Enter Marks</h1>
<form  action="secondary" method="post" >
<p><label for="studentid">  STUDENT ID</label>: <input type="text" name="studentid" value="${studentid}" readonly="readonly" ></p>
<p><label for="standard">   STANDARD</label> : <input type="text" name="standard" value="${standard}" readonly="readonly"></p>
<p><label for="english">   ENGLISH</label>  : <input type="text" name="english"></p>
<p><label for="hindi">   HINDI</label>      : <input type="text" name="hindi"></p>
<p><label for="science">   SCIENCE</label>  : <input type="text" name="science"></p>
<p><label for="social">   SOCIAL</label>    : <input type="text" name="social"></p>
<p><label for="maths">   MATHS</label>      : <input type="text" name="maths"></p>
<p><input type="reset" value="Reset">   <input type="submit" value="Save"></p>
</form>
</body>
</html>