<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>
	
	<p>
	<c:if test="${Auth != null }"><!-- 로그인 상태 -->
		<p>${Auth.name }[${Auth.id }]님, 로그인하였습니다.</p>
		<a href="logout.do">로그아웃</a>
		<a href="list.do">[프로젝트 리스트]</a>
		<a href="">비밀번호 변경</a>
	</c:if>
	</p>
	
	<p>
	<c:if test="${Auth == null }"><!-- 로그아웃 상태 -->
		<a href="login.do">[관리자 로그인]</a><br>
		<a href="join.do">[관리자등록]</a><br>
	</c:if>
	</p>
	<p>
	<a href="list.do">[프로젝트  리스트 보기]</a>
	</p>
	
</body>
</html>