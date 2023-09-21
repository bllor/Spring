<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<title>annotation::requestParam</title>
	</head>
	<body>
		<h3>@RequestParam</h3>
		<a href="/Ch04/index">index</a><br><br>
		<form action="/Ch04/annotation/param1" method="post">
			<input type="text" name="uid" /><br>
			<input type="submit" value="전송" />
		</form>
		<form action="/Ch04/annotation/param2" method="post">
			<input type="text" name="uid" /><br>
			<input type="text" name="name" /><br>
			<input type="submit" value="전송" />
		</form>
		<form action="/Ch04/annotation/param3" method="post">
			<input type="text" name="uid" /><br>
			<input type="text" name="name" /><br>
			<input type="text" name="hp" /><br>
			<input type="number" name="age" /><br>
			<input type="submit" value="전송" />
		</form>
	</body>
</html>