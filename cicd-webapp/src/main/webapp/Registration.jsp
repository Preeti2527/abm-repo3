<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Registration</title>
</head>
<body>
<form action="">  
Title: <input type="text" name="title" placeholder="Title"/> 
First Name: <input type="text" name="fname" placeholder="First Name" /><br/> 
Last Name: <input type="text" name="lname" placeholder="Last Name" /> 
Email: <input type="email" name="email" placeholder="Email Address"/><br/> 
Password: <input type="password" name="password" />
Confirm Password: <input type="password" name="password" /><br/> 
Date of Birth: <input type="date" name="dateofbirth" placeholder="Date Of Birth" />
Phone Number: <input type="number" name="PhoneNumber"  placeholder="Number" /></br>
<input type="submit" value="register"/>
<input type="cancel" value="cancel"/>
</form>
</body>
</html>