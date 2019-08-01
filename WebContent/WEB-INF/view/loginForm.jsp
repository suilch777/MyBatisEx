<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/common.css">
<style>
* {
	margin: 0 auto;
}

form {
	margin-top: 100px;
	padding: 50px;
	border: 1px solid blue;
	border-radius: 10px;
	width: 460px;
}

input {
	text-align: center;
}

p {
	margin: 20px;
}
</style>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="js/common.js"></script>
<script>
	$(function() {
		$("#f1").submit(function() {
			$(".error, .error2").css("display", "none");

			//빈 input태그가 존재하면 submit을 막도록 한다.
			if (checkInputEmpty($("input[name]")) == false) {
				return false;
			}

		})
	})
</script>
</head>
<body>
	<form action="login.do" method="post" id="f1">
		<p>
			<label>아이디</label>&nbsp;&nbsp;&nbsp; <input type="text" name="id">
			<span class="error">ID를 입력하세요</span>
			<c:if test="${notJoin ==true }">
				<span class="error2">회원이 아닙니다. 회원가입을 해주세요</span>
			</c:if>
		</p>
		<p>
			<label>비밀번호</label> <input type="password" name="password"> <span
				class="error">비밀번호를 입력하세요</span>
			<c:if test="${notMatchPassword ==true }">
				<span class="error2">아이디와 비밀번호가 일치하지 않습니다.</span>
			</c:if>
		</p>
		<p>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<input type="submit" value="로그인">
		</p>
	</form>

</body>
</html>




