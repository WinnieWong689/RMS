<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<% int num = 0; %>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="/WEB-INF/jsp/common/header.jsp"></jsp:include>
<title>用户管理</title>
</head>
<body>
	<jsp:include page="/WEB-INF/jsp/common/nav.jsp"></jsp:include>
	<div class="container">
		<table class="table table-striped">
			<thead>
	          <tr>
	            <th></th>
	            <th>用户账号</th>
	            <th>密码</th>
	            <th>姓名</th>
	            <th>职位</th>
	          </tr>
	        </thead>
	        <tbody>
				<c:forEach items="${users}" var="user">
					<a href="#"><tr>
						<td><input type="checkbox"/></td>
			  			<td>${user.username}</td>
			  			<td>******</td>
			  			<td>${user.nickname}</td>
			  			<td>${user.role}</td>
					</tr>
					</a>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>