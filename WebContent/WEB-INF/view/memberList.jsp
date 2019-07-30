<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	table{
		width:600px;
		border-collapse: collapse;
	}
	th, td{
		padding:5px 10px;
		border:1px solid gray;
	}
</style>
</head>
<body>
	<table>
		<tr>
			<th>아이디</th>
			<th>비번</th>
			<th>이름</th>
			<th>날짜</th>
		</tr>
	
	<c:forEach var="member" items="${list }">
		<tr>
			<td>${member.memberid }</td>
			<td>${member.password }</td>
			<td>${member.name }</td>
			<td>${member.regdate }</td>
		</tr>
	</c:forEach>
	</table>
	<br>
	<a href="index.jsp">홈 화면</a>
</body>
</html>