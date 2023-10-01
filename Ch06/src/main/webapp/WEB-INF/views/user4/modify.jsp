<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>user4::Modify</title>
	</head>
	<body>
		<h3>user4 수정</h3>
		<a href="/Ch06/index">메인</a>
		<a href="/Ch06/user4/list">user4 목록</a>
		
		<form action="/Ch06/user4/modify" method="post">
			<table border="1">
			<input type="hidden" name="seq" value="${user4DTO.seq} " />
				<tr>
					<td>이름</td>
					<td><input type="text" value="${user4DTO.name }"  name="name" /></td>
				</tr>
				<tr>
					<td>성별</td>
					<td>
						<select name="gender" >
							<option ${user4DTO.gender eq 1?'selected':''} value="1">남자</option>
							<option ${user4DTO.gender eq 2?'selected':''} value="2">여자</option>
						</select>
					</td>
				</tr>
				<tr>
					<td>나이</td>
					<td><input type="text" name="age" value="${user4DTO.age }" /></td>
				</tr>
				<tr>
					<td>주소</td>
					<td><input type="text" name="addr" value="${user4DTO.addr }" /></td>
				</tr>
				<tr>
					<td colspan="2" align ="right"><input type="submit" value ="등록하기"/></td>
				</tr>
			</table>
		</form>
	</body>
</html>