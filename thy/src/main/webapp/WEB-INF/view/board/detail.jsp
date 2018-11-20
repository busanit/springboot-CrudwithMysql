<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../header.jsp" %>

<section id="about">
    <div class="container">
    <a href="/board/updateForm?boardid=${boardVO.boardid}" class="btn btn-primary">수정</a>
    <a href="/board/delete?boardid=${boardVO.boardid}" class="btn btn-danger">삭제</a><br><br>
    <div class="row">
        <div class="col-lg-8 mx-auto">
        <h2 class="text-center"><b>${boardVO.title}</b></h2>
        <hr>
        <p class="lead">${boardVO.content}</p>
        <hr>
        </div>
    </div>
    </div>
</section>


<%@ include file="../footer.jsp" %>