<%@ page import="java.util.List" %>
<%@ page import="edu.tutorial.web.bean.UserData" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="edu.tutorial.web.db.DBConnector" %>
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
    <title></title>
</head>
<body>
<h1>All users:</h1>
<table border="2">
  <%
  DBConnector dbConnector = new DBConnector();
  List<UserData> usersList = dbConnector.getUsers();
  for(UserData userData:usersList) {%>
  <tr>
    <td>
      <%out.println(userData.getFirstName());%>
    </td>
    <td>
      <%out.println(userData.getSecondName());%>
    </td>
    <td>
      <%out.println(userData.getUsername());%>
    </td>
    <td>
      <%out.println(userData.getEmail());%>
    </td>
  <%}%>
</table>
</body>
</html>
