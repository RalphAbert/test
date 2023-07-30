<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 3/31/2023
  Time: 4:40 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%
    // New location to be redirected
    String site = new String("http://localhost:8080/demo_war_exploded/user/index");
    response.setStatus(response.SC_MOVED_TEMPORARILY);
    response.setHeader("Location", site);
%>



</body>
</html>
