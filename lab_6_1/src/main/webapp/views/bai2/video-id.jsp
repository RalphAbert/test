<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 3/31/2023
  Time: 3:11 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-aFq/bzH65dt+w6FI2ooMVUpc+21e0SRygnTpmBvdBgSdnuTN7QbdgL+OapgHtvPp" crossorigin="anonymous">

</head>
<body>

<div class="container">


    <br><br>
    <form class="d-flex" role="search" action="/demo_war_exploded/video/search" method="post">
        <input class="form-control me-2" type="search" name="idVideo" placeholder="Enter your id video..." aria-label="Search">
        <button class="btn btn-outline-success" type="submit">Search</button>
    </form>



<table class="table">
    <thead>
      <th>Username</th>
      <th>FullName</th>
      <th>Email</th>
      <th>Role</th>
    </thead>
    <tbody>
     <c:forEach items="${users}" var="user">
         <td>${user.id}</td>
         <td>${user.fullname}</td>
         <td>${user.email}</td>
         <td>${user.admin == true ?"admin":"user"}</td>
     </c:forEach>
    </tbody>
</table>


</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha2/dist/js/bootstrap.bundle.min.js" integrity="sha384-qKXV1j0HvMUeCBQ+QVp7JcfGl760yU08IQ+GpUo5hlbpg51QRiuqHAJz8+BrxE/N" crossorigin="anonymous"></script>
</body>
</html>
