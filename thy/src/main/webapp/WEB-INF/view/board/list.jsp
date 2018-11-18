<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../header.jsp" %>

<div class="container">
  <h5>User Info</h5>          
  <table class="table table-hover">
    <thead>
      <tr>
        <th>작성자</th>
        <th>내용</th>
        <th>작성일</th>
        <th>delete</th>
      </tr>
    </thead>
    <tbody>

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