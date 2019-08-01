<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
*{
	margin: 0 auto;
}
	table{
		margin-top: 50px;
		width:600px;
		
		border-collapse: collapse;
	}
		tr:last-child{
		text-align: center;
		
	}	
	
	td{
		border:1px solid blue;
	}
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script> 
<script>
	$(function(){
		$("#del").click(function() {
			var res = confirm("정말 삭제하시겠습니까?");
			if(res == true){
				location.href="delete.do?no=${spms.sp_no }";
			}else{
				return false;
			}
		})
	})
</script>
</head>
<body>
	<table>
		<tr>
			<td>번호</td>
			<td>${spms.sp_no }</td>
		</tr>
		<tr>
			<td>프로젝트 이름</td>
			<td>${spms.sp_name }</td>
		</tr>
		<tr>
			<td>프로젝트 내용</td>
			<td>${spms.content }</td>
		</tr>
		<tr>
			<td>시작날자</td>
			<td><fmt:formatDate pattern="yyyy-MM-dd" value="${spms.startdate}"/> </td>
			</tr>
			
			<tr>
			<td>종료날자</td>
			<td><fmt:formatDate pattern="yyyy-MM-dd" value="${spms.enddate}"/></td>
		</tr>
		<tr>
		<td>진행상태</td>
		<td>${spms.status}</td>
		</tr>
		<tr>
			<td colspan="2">
				<a href="list.do">[목록]</a>
				
					<a href="">[수정]</a>
					<a href="delete.do?no=${spms.sp_no }" id="del">[삭제]</a>
				
			</td>
		</tr>
	</table>

</body>
</html>