<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/common.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="js/common.js"></script>
<script>
	$(function(){
		$("#f1").submit(function(){
			$(".error").css("display","none");	
			$(".error2").css("display","none");
			
			//빈 input태그가 존재하면 submit을 막도록 한다.
			if(checkInputEmpty( $("input[name]") ) == false){
				return false;
			}
			
			//id 입력 확인
			var idReg = /^[a-z0-9]{6,15}$/i;
			var id = $("input[name='id']").val();
			if(idReg.test(id) ==false){
				$("input[name='id']").next().css("display","inline");
				return false;
			}
			
			//name 확인
			var nameReg = /^[가-힣]{2,5}$/;
			var name = $("input[name='name']").val();
			if( nameReg.test(name)== false){
				$("input[name='name']").next().css("display","inline");
				return false;
			}
			
			//password 확인
			var passReg = /^[a-z0-9!@#$%^&]{8,20}$/;
			var pass = $("input[name='password']").val();
			if( passReg.test(pass) == false){
				$("input[name='password']").next().css("display","inline");
				return false;
			}
			
					
			//password일치하지 않을때
			if($("input[name='password']").val() != $("input[name='confirmPassword']").val()){
				$("input[name='confirmPassword']").next().next().css("display","inline");				
				return false;
			}
			
		});
	})
</script>
</head>
<body>
	<form action="join.do" method="post" id="f1">
		<p>
			<label>아이디</label>
			<input type="text" name="id" value="${param.id }">
			<button id="btn1">중복확인</button>
			<span class="error">ID(영어,숫자 6~15)를 입력하세요</span>
			<c:if test="${duplicatedId == true }">
				<span class="error2">이미 사용중인 ID입니다</span>
			</c:if>
		</p>
		<p>
			<label>이름</label> 
			<input type="text" name="name" value="${param.name }">
			<span class="error">이름(한글 2~5)을 입력하세요</span>
		</p>
		<p>
			<label>비밀번호</label>
			<input type="password" name="password" >
			<span class="error">암호(영어,숫자,특수문자 8~20)를 입력하세요</span>
		</p>
		<p>
			<label>비밀번호 확인</label>
			<input type="password" name="confirmPassword">
			<span class="error">암호 확인란을 입력하세요</span>
			<span class="error">암호가 일치하지 않습니다</span>
		</p>
		<p>			
			<input type="submit" value="가입">
		</p>
	</form>

</body>
</html>