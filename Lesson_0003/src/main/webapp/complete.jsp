<%@ page import="edu.tutorial.web.bean.UserData" %>
<%--
  Created by IntelliJ IDEA.
  User: vladimirkr
  Date: 1/15/2015
  Time: 7:02 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Complete</title>
</head>
<body>
  <%
    UserData userData = (UserData) request.getAttribute("userData");
  %>
  <h1>Hello, <% out.println(userData.toString()); %></h1>
  <a href="index.jsp">Back to Main</a>
  <a href="form.jsp">Another one</a>
</body>
</html>
