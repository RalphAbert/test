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
<form class="d-flex" role="search" action="/demo_war_exploded/month3/search" method="post">
    <input  type="checkbox" name="months" value="1"> 1
    <input  type="checkbox" name="months" value="2"> 2
    <input  type="checkbox" name="months" value="3"> 3
    <input  type="checkbox" name="months" value="4"> 4
    <input  type="checkbox" name="months" value="5"> 5
    <input  type="checkbox" name="months" value="6"> 6
    <input  type="checkbox" name="months" value="7"> 7
    <input  type="checkbox" name="months" value="8"> 8
    <input  type="checkbox" name="months" value="9"> 9
    <input  type="checkbox" name="months" value="10"> 10
    <input  type="checkbox" name="months" value="11"> 11
    <input  type="checkbox" name="months" value="12"> 12

    <button class="btn btn-outline-success" type="submit">Search</button>
</form>
<br>



<ul>
    <li>FullName :${user.fullname} </li>
    <li>Email : ${user.email}</li>
</ul>

<table class="table">
    <thead>
      <th>Id</th>
      <th>Title</th>
      <th>Views</th>
      <th>Active</th>
    </thead>
    <tbody>
     <c:forEach items="${videos}" var="video">
         <td>${video.id}</td>
         <td>${video.title}</td>
         <td>${video.views}</td>
         <td>${video.active == true ?"Đang hoạt động":"Không hoạt động"}</td>
     </c:forEach>
    </tbody>
</table>


</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha2/dist/js/bootstrap.bundle.min.js" integrity="sha384-qKXV1j0HvMUeCBQ+QVp7JcfGl760yU08IQ+GpUo5hlbpg51QRiuqHAJz8+BrxE/N" crossorigin="anonymous"></script>
</body>
</html>
