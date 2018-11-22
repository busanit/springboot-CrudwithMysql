<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../header.jsp" %>

<div class="container">
    <div class="posts">
        <div class="post">
            <h1 class="post-title">
                ${boardVO.title}
            </h1>
            ${boardVO.content}
        </div>
    </div>
<a href="/board/updateForm" class="btn btn-success">수정</a>
</div>


<%@ include file="../footer.jsp" %>