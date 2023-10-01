<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>user4::Register</title>
	</head>
	<body>
		<h3>user4 등록</h3>
		<a href="/Ch06/index">메인</a>
		<a href="/Ch06/user4/list">user4 목록</a>
		<form action="/Ch06/user4/register" method="post">
			<table border="1">
				<tr>
					<td>이름</td>
					<td><input type="text" name="name" /></td>
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