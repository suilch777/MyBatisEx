<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
*{
margin: 0 auto;
}

div{
	margin-top: 100px;
	padding: 50px;
	border: 1px solid blue;
	border-radius: 10px;
	width: 460px;
	
}
p{
	
	margin: 20px;
	text-align: center;
	
}
</style>


</head>
<body>
	<div>
	
	
	<p>
	<c:if test="${Auth == null }"><!-- 로그아웃 상태 -->
	<P>	<a href="login.do">[관리자 로그인]</a></P>
	<P>	<a href="join.do">[관리자등록]</a></P>
	</c:if>
	</p>
	
	
	<c:if test="${Auth != null }"><!-- 로그인 상태 -->
		<p>${Auth.name }[${Auth.id }]님, 로그인하였습니다.</p>
		<p><a href="logout.do">로그아웃</a></p>
		<p><a href="list.do">[프로젝트 리스트]</a></p>
		<p><a href="">비밀번호 변경</a></p>
	</c:if>
	
	</div>
</body>
</html>