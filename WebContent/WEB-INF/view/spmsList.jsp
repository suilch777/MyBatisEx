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
		width:800px;
		border-collapse: collapse;
	}
	tr:first-child td{
		text-align: right;
		color:blue;
	}
	td:FIRST-CHILD{
		width:20px;
	}
	td:last-child{
		text-align: center;
	}	
	.title a{
		width:100px;
		display:block;
		text-overflow:ellipsis;
		white-space:nowrap; 
		overflow: hidden;
	}
	.page_wrap a{
		text-decoration: none;
		color:black;	
		width:30px;
		display:inline-block;
	}	
	.page_wrap a:hover{
		text-decoration: underline;
	}
	a.page2{
		width:50px;
	}
	.active{
		background: pink;
		border-radius: 10px;     
	}
</style> 
</head>
<body>
	<table border="1">		
		<tr>
			<td colspan="6">
				<a href="${pageContext.request.contextPath }/spms/write.do">[게시글 쓰기]</a>
			</td>
		</tr>
		<tr>
			<th>번호</th>
			<th>프로젝트 이름</th>
			<th>프로젝트 내용</th>
			<th>시작날자</th>  
			<th>종료날자</th>
			<th>진행상태</th>
		</tr>
		<c:forEach var="spms" items="${spmsPage.content }">
		<tr>
			<td>${spms.sp_no}</td>
			<td class="title">
				<a href="read.do?no=${spms.sp_name}">${spms.sp_name}</a>
			</td>
			<td>${spms.content}</td>
			<td>${spms.startdate}</td>
			<td>${spms.enddate}</td>
			<td>${spms.status}</td>
		</tr>
		</c:forEach>
		<tr>
			<td colspan="6" >
				<div class="page_wrap">
				<c:if test="${smpsPage.startPage > 10 }">
					<a href="list.do?page=${smpsPage.startPage - 1}" class="page2">[이전]</a>
				</c:if>
				<c:forEach var="pNo" begin="${smpsPage.startPage }" end="${articlePage.endPage }">
					<c:if test="${pNo == smpsPage.currentPage }">
						<a href="list.do?page=${pNo }" class="active">${pNo }</a>
					</c:if>					 
					<c:if test="${pNo != smpsPage.currentPage }">
						<a href="list.do?page=${pNo }" >${pNo }</a>
					</c:if>		
				</c:forEach>
				<c:if test="${smpsPage.endPage < smpsPage.totalPages }">
					<a href="list.do?page=${smpsPage.endPage + 1 }" class="page2">[다음]</a>
				</c:if>
				</div>
			</td>
		</tr>
	</table>	
</body>
</html>




