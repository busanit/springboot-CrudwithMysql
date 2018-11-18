<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:choose>
    <c:when test="${empty sessionScope.login}">
        <c:redirect url = "/loginForm"/>
    </c:when>
    <c:otherwise>
        <c:redirect url = "/"/>
    </c:otherwise>
</c:choose>