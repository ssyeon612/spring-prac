<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="updateres.do" method="post">
		<input type="hidden" name="myno" value=${dto.myno } />
		<table border="1">
			<tr>
				<th>WRITER</th>
				<td><input type="text" name="myname" value="${dto.myname }"/></td>
			</tr>
			<tr>
				<th>TITLE</th>
				<td><input type="text" name="mytitle" value="${dto.mytitle }"/></td>
			</tr>
			<tr>
				<th>CONTENT</th>
				<td><textarea rows="10" col="50" name="mycontent">${dto.mycontent }</textarea></td>
			</tr>
			<tr>
				<td colspan="2" align="right">
					<input type="submit" value="done" />
					<input type="button" value="cancel" onclick="location.href='detail.do?myno=${dto.myno }'" />
				</td>
			</tr>
		</table>	
	</form>
</body>
</html>