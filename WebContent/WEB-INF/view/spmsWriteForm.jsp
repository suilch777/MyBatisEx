<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
* {
	margin: 0 auto;
}

div {
	margin-top: 100px;
	padding: 50px;
	border: 1px solid blue;
	border-radius: 10px;
	width: 460px;
}
p{
	
	margin: 20px;
	text-align: left;
	
}
</style>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>

<script>
	$(function() {
		$("#f1").submit(function() {
			$(".error").css("display", "none");

			//빈 input태그가 존재하면 submit을 막도록 한다.
			if (checkInputEmpty($("input[name]")) == false) {
				return false;
			}
		})
	})
</script>
</head>
<body>
<div>
	<form action="${pageContext.request.contextPath}/spms/write.do"
		method="post" id="f1">
		
				
		<p>
			<label>프로젝트 이름</label> <input type="text" name="sp_name" size="50">
			<!--  <span class="error">프로젝트 이름을 입력하세요.</span>  -->
		</p>
		<p>
			<label>프로젝트 내용</label>
			<textarea name="content" rows="10" cols="60"></textarea>
		</p>

		<p>
			<label>시작날자</label> <input type="date" name="startdate">
		</p>

		<p>
			<label>종료날자</label> <input type="date" name="enddate">
		</p>

		<p>
			<label>진행상태</label> <input type="text" name="status">
		</p>
		<p>
			<input type="submit" value="새 글 등록">
		</p>
	</form>

</div>

</body>
</html>