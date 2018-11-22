<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../header.jsp" %>

<div class="container"> 
  <a href="/board/writeForm" class="btn btn-success">글쓰기</a>      
  <table class="table table-hover">
    <thead>
      <tr>
        <th>번호</th>
        <th>제목</th>
        <th>조회수</th>
        <th>작성자</th>
        <th>delete</th>
      </tr>
    </thead>
    <tbody>
      <c:forEach var="data" items="${list.content}">
        <tr>
          <td>${data.boardid }</td>
          <td><a href="/board/detail?boardid=${data.boardid}">${data.title}</a></td>
          <td>${data.readcount }</td>
          <td>${data.user.name }</td>
          <td><a href="/board/delete/${data.boardid}"><i class="material-icons">delete</i></a></td>
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