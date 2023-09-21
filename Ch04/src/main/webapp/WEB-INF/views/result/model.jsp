<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<title>result::ModelAttribute</title>
	</head>
	<body>
		<h3>@ModelAttribute 어노테이션실습</h3>
		<a href="/Ch04/index">index</a><br><br>
		
		<h4>model1 결과</h4>
		<p>
			uid : ${modelDTO.uid }
		<!-- modelDTO에서 이름을 지정을 해주지 않았기 때문에 첫글자가 소문자로 변경되어서 나온다. -->
		</p>
		<h4>model2 결과</h4>
		<p>
			uid: ${user.uid }
			name: ${user.name }
		</p>
		
		<h4>model3 결과</h4>
		<p>
			uid:${modelDTO.uid }
			name:${modelDTO.name}
			hp:${modelDTO.hp }
			age:${modelDTO.age }
		</p>
	</body>
</html>