<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>user5::Register</title>
	</head>
	<body>
		<h3>user5 등록</h3>
		<a href="/Ch06/index">메인</a>
		<a href="/Ch06/user5/list">user5 목록</a>
		<form action="/Ch06/user5/register" method="post">
			<table border="1">
				<tr>
					<td>아이디</td>
					<td><input type="text" name="uid" /></td>
				</tr>
				<tr>
					<td>이름</td>
					<td><input type="text" name="name" /></td>
				</tr>
				<tr>
					<td>생일</td>
					<td><input type="date" name="birth" /></td>
				</tr>
				<tr>
					<td>성별</td>
					<td>
						<select name ="gender">
							<option value="1">남자</option>
							<option value="2">여자</option>
						</select>
					</td>
				</tr>
				<tr>
					<td>나이</td>
					<td><input type="text" name="age" /></td>
				</tr>
				<tr>
					<td>주소</td>
					<td><input type="text" name="addr" /></td>
				</tr>
				<tr>
					<td colspan="2" align ="right"><input type="submit" value ="등록하기"/></td>
				</tr>
			</table>
		</form>
	</body>
</html>