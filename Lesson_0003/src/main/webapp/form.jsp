<%--
  Created by IntelliJ IDEA.
  User: vladimirkr
  Date: 1/15/2015
  Time: 7:00 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page pageEncoding="UTF-8" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" CONTENT="text/html; charset=UTF-8">
    <title>Fill your data</title>
</head>
<body>
  <form action="UserFormServlet">
    Nick:<input type="text" name="username"/><br/>
    Password:<input type="text" name="password"/><br/>
    First Name:<input type="text" name="firstName"/><br/>
    Second Name:<input type="text" name="secondName"/><br/>
    E-mail:<input type="text" name="email"/><br/>
    Sex:<select name="sexId">
      <option value="1">Man</option>
      <option value="2">Woman</option>
    </select><br/>
    Profession:<select name="professionId">
      <option value="1">Developer</option>
      <option value="2">Manager</option>
      <option value="3">Other...</option>
    </select><br/>
    Language:<select name="languageId">
      <option value="1">Ukrainian</option>
      <option value="2">English</option>
    </select><br/>

    <input type="submit" value="Send Data"/>
  </form>
</body>
</html>
