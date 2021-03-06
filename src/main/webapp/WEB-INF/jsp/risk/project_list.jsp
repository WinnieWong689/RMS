<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<% String path = request.getContextPath();%>
<% int num = 0; %>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="/WEB-INF/jsp/common/header.jsp"></jsp:include>
<title>RMS - 风险项目列表</title>
</head>
<body>
	<jsp:include page="/WEB-INF/jsp/common/nav.jsp"></jsp:include>
	<div class="container">
		<c:if test="${role}">
			<button href="<%=path%>/project/get" class="btn btn-sm btn-primary pull-left">添加风险项目</button>
		</c:if>

		<table class="table table-striped">
			<thead>
	          <tr>
	            <th>#</th>
	            <th>项目名</th>
	            <th>创建者</th>
	            <th>创建时间</th>
	            <th>操作</th>
	          </tr>
	        </thead>
	        <tbody>
				<c:forEach items="${projects}" var="project">
					<a href="#"><tr>
			  			<td>${project.id}</td>
			  			<td>${project.name}</td>
			  			<td>${project.creater}</td>
			  			<td>${project.ctime}</td>
			  			<td><button href="<%=path%>/risk/risk_track_list" class="btn btn-sm btn-default pull-left">查看风险条目</button></td>
					</tr>
					</a>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>