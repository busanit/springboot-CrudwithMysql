<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../header.jsp" %>

<div class="container">
  <form action="/board/update" method="POST" name="w_form">
    <div class="form-group">
      <input type="text" class="form-control" name="title" value="${title}">
    </div>
    <div class="form-group">
      <input type="text" class="form-control" name="content" value="${content}">
    </div>
    <button class="form-control foode-btn" type="submit">수정완료</button>
  </form>
</div>
<br>



<%@ include file="../footer.jsp" %>