<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h1>상품 목록</h1>

<c:forEach var="ItemDto" items="${list}">
<div>
<img src="${pageContext.request.contextPath}/image/${ItemDto.name}.jpg">
<h3>${ItemDto.name}</h3>
<h3>${ItemDto.price}</h3>
</div>
</c:forEach>

