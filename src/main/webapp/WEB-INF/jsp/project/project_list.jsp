<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<% String path = request.getContextPath();%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="/WEB-INF/jsp/common/header.jsp"></jsp:include>
<title>RMS - 风险项目列表</title>
</head>
<body>
	<jsp:include page="/WEB-INF/jsp/common/nav.jsp"></jsp:include>
	<div class="container">
		<div class="page-header">
			<h1 class="pull-left">项目管理</h1>
			<c:if test="${role != 2}">
				<a href="<%=path%>/project/add" class="btn btn-sm btn-primary pull-left">添加风险项目</a>
			</c:if>
			<div class="clearfix"></div>
		</div>
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
					<tr>
			  			<td>${project.id}</td>
			  			<td>${project.name}</td>
			  			<td>${project.creater}</td>
			  			<td>${project.ctime}</td>
			  			<td><a href="<%=path%>/risk/risk_list/${project.id}" class="btn btn-sm btn-default pull-left">查看风险条目</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>