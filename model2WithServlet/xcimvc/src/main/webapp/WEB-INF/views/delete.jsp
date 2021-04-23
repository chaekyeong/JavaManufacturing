<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="dto" value="${articleDTO}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
</style>
</head>
<body>
<form action="deleteAction" method="post">
<table>
	<caption>게시물 삭제</caption>
<tr>
	<th>글 번호</th>
	<td>${dto.no}<input type="hidden" name="no" value="${dto.no}" /></td>
</tr>
<tr>
	<th>비밀번호</th>
	<td><input type="password" name="password" 
		required="required" autofocus="autofocus"/><br/>
		<span class="warn">* 처음 글 작성시 비밀번호를 재 입력하세요.</span>	
	</td>
</tr>
<tr>
	<td colspan="2"><button type="submit">확인</button></td>
</tr>
</table>
</form>
</body>
</html>