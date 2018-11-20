<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../header.jsp" %>

<div class="container">
  <h5>User Info</h5>          
  <table class="table table-hover">
    <thead>
      <tr>
        <th>id</th>
        <th>name</th>
        <th>email</th>
        <th>delete</th>
      </tr>
    </thead>
    <tbody>
    <c:forEach var="data" items="${list.content}">
      <tr>
        <td>${data.userid }</td>
        <td>${data.name }</td>
        <td>${data.email }</td>
        <td><a href="/admin/user/delete?userid=${data.userid}"><i class="material-icons">delete</i></a></td>
      </tr>
    </c:forEach>
    </tbody>
  </table>
</div>

<div class="container"> <!--하단고정 class="footer" -->
  <ul class="pagination"> <!-- justify-content-center, justify-content-end -->
    <c:if test="${!list.first}">
      <li class="page-item"><a class="page-link" href="?page=${list.number-1}">Previous</a></li>
    </c:if>
    <c:if test="${!list.last}">
      <li class="page-item"><a class="page-link" href="?page=${list.number+1}">Next</a></li>
    </c:if>
  </ul>
</div>

<%@ include file="../footer.jsp" %>