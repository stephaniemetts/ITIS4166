<%-- 
    Document   : ClogView
    Created on : Mar 9, 2016, 11:48:31 PM
    Author     : tyler
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html>
<head>

<title>Different View</title>

</head>

<body style="margin: 0px; padding: 0px; font-family: 'Trebuchet MS',verdana;">

<table width="100%" style="height: 100%;" cellpadding="10" cellspacing="0" border="0">
<tr>

<!-- ============ HEADER SECTION ============== -->
<td colspan="2" style="height: 100px;" bgcolor="#777d6a"><h1>Other View</h1></td></tr>

<tr>
<!-- ============ LEFT COLUMN (MENU) ============== -->
<td width="20%" valign="top" bgcolor="#999f8e">
</td>

<!-- ============ RIGHT COLUMN (CONTENT) ============== -->
<td width="80%" valign="top" bgcolor="#d2d8c7">

<h2>Alternate View for User Information</h2>

You have just been given a gift by a coworker. He is a lowly web developer. He makes half your salary and has half your training. After acknowledging how 
awesome you are, He gives this crappy page to you and asked you to make it show the logged in user's information that they provided at signup.

<br>
<br>

Please create a bean containing the logged in user's information after they login and place it in the session. Then, convert this page to a jsp file 
and display the data in the bean. I do not care where on the page it is displayed or how it looks. You do not have to alter the style of this page to 
match the rest of your application. It does not need links. Please use the same filename with a jsp extension.
<br>
<br>


        <h3>User Information:</h3>
        
        <jsp:useBean id="beanSession" class="login.UserBean" scope="request" /><br>
        First Name: <jsp:getProperty name="beanSession" property="firstName"/><br>
        Last Name: <jsp:getProperty name="beanSession" property="lastName"/><br>
        Email: <jsp:getProperty name="beanSession" property="email"/><br>
        Username: <jsp:getProperty name="beanSession" property="username"/><br>
        Balance: <jsp:getProperty name="beanSession" property="balance"/><br>
        Gender: <jsp:getProperty name="beanSession" property="gender"/><br>

</td></tr></table>
</body>

</html>