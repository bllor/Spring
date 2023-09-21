<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>user3::Modify</title>
	</head>
	<body>
		<h3>user3 수정</h3>
		<a href="/Ch05/index">메인</a>
		<a href="/Ch05/user3/list">user3 목록</a>
		
		<form action="/Ch05/user3/modify" method="post">
			<table border="1">
				<tr>
					<td>아이디</td>
					<td><input type="text" name="uid" value="${user3DTO.uid }" readonly="readonly"/></td>
				</tr>
				<tr>
					<td>이름</td>
					<td><input type="text" value="${user3DTO.name }"  name="name" /></td>
				</tr>
				<tr>
					<td>휴대폰</td>
					<td><input type="text" value="${user3DTO.hp }"  name="hp" /></td>
				</tr>
				<tr>
					<td>나이</td>
					<td><input type="text" name="age" value="${user3DTO.age }" /></td>
				</tr>
				<tr>
					<td colspan="2" align ="right"><input type="submit" value ="등록하기"/></td>
				</tr>
			</table>
		</form>
	</body>
</html>