<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table border="1">
	<caption>게시물 리스트</caption>
<tr>
	<th>번호</th>
	<th>제목</th>
	<th>이름</th>
	<th>날씨</th>
	<th>조회수</th>
</tr>
<c:forEach var="dto" items="${list}">
<tr>
	<td>${dto.no}</td>
	<td><a href="detail?no=${dto.no}">${dto.title}</a></td>
	<td>${dto.name}</td>
	<td>${dto.regdate}</td>
	<td>${dto.readcount}</td>
</tr>
</c:forEach>
<tr>
	<td colspan="5">
	<c:choose>
		<c:when test="${startPage != 1}">
			<a href="list?pg=${startPage - 1}">[이전]</a>
		</c:when>
		<c:otherwise>
			<a href="list?pg=${startPage - 1}" style="visibility:hidden;">[이전]</a>
		</c:otherwise>
	</c:choose>
	<c:forEach var="i" begin="${startPage}" end="${endPage}" step="1">
		<c:choose>
			<c:when test="${startPage} == ${i}">
				${i}
			</c:when>
			<c:otherwise>
				<a href="list?pg=${i}">${i}</a>	
			</c:otherwise>
		</c:choose>
	</c:forEach>
	<c:choose>
		<c:when test="${endPage != totalPage}">
			<a href="list?pg=${endPage + 1}">[다음]</a>
		</c:when>
		<c:otherwise>
			<a href="list?pg=${endPage + 1}" style="visibility:hidden;">[다음]</a>
		</c:otherwise>
	</c:choose>
	</td>
</tr>
</table>
<a href="insert">글쓰기</a>
</body>
</html>