<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>user4::list</title>
	</head>
	<body>
		<h3>user4 등록</h3>
		
		<a href="/Ch06/index">메인</a>
		<a href="/Ch06/user4/register">등록</a>
		
		<table border="1">
			<tr>
				<th>이름</th>
				<th>성별</th>
				<th>나이</th>
				<th>주소</th>
				<th>관리</th>
			</tr>
			<c:forEach var="user" items="${users}">
			<tr>
				<td>${user.name }</td>
				<c:choose>
					<c:when test="${user.gender eq 1}">
						<td>남자</td>
					</c:when>
					<c:otherwise>
						<td>여자</td>
					</c:otherwise>
				</c:choose>
				<td>${user.age }</td>
				<td>${user.addr }</td>
				<td>
					<a href="/Ch06/user4/modify?seq=${user.seq}">수정</a>
					<a href="/Ch06/user4/delete?seq=${user.seq}">삭제</a>
				</td>
			</tr>
			</c:forEach>
		</table>
	</body>
</html>