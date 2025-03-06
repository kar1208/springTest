<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="ctp" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <jsp:include page="/WEB-INF/views/include/bs5.jsp" />
  <title>test10.jsp</title>
</head>
<body>
<p><br/></p>
<div class="container">
  <h2>이곳은 test10.jsp입니다.</h2>
  <hr/>
  <div><a href="${ctp}/0306/test10/i1234" class="btn btn-success-sm">홍길동(인사과)</a></div>
  <div><a href="${ctp}/0306/test10/c2345" class="btn btn-success-sm">김말숙(총무과)</a></div>
  <div><a href="${ctp}/0306/test10/s3456" class="btn btn-success-sm">이기자(생산과)</a></div>
</div>
<p><br/></p>
</body>
</html>