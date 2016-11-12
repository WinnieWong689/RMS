<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="/WEB-INF/jsp/common/header.jsp"></jsp:include>
<title>用户管理</title>
</head>
<body>
	<jsp:include page="/WEB-INF/jsp/common/nav.jsp"></jsp:include>
	<div class="container">
		<div class="page-header">
			<h1 class="pull-left">用户管理</h1>
			<a class="btn btn-default pull-left" href="<%=request.getContextPath()%>/user/add">添加用户</a>
			<div class="clearfix"></div>
		</div>
		<div class="row show-grid">
			<form class="m-user-search-form form-inline col-md-8" role="form">
				<div class="form-group">
					<label for="input-username">账号</label>
	    			<input type="text" class="form-control" id="input-username">
				</div>
				<div class="form-group">
					<label for="input-nickname">姓名</label>
	    			<input type="text" class="form-control" id="input-nickname">
				</div>
				<div class="form-group">
					<label for="select-role">角色</label>
					<select class="form-control" id="select-role">
						<option value="-1">全部</option>
						<option value="1">普通用户</option>
						<option value="2">其他</option>
					</select>
				</div>
			</form>
			<div class="col-md-1">
				<button class="btn btn-default col-md-12">搜索</button>
			</div>
		</div>
		<div class="row show-grid">
			<div class="col-md-12">
				<div class="pull-left" style="display: inline-block; line-height: 28px; margin-right: 20px">共有${total}位用户</div><button class="btn btn-sm btn-default pull-left">删除选中</button>
			</div>
		</div>
		<table class="table table-bordered">
			<thead>
	          <tr>
	            <th><input type="checkbox" value="0" id="checkbox-all"/></th>
	            <th>账号</th>
	            <th>密码</th>
	            <th>姓名</th>
	            <th>角色</th>
	          </tr>
	        </thead>
	        <tbody>
				<c:forEach items="${users}" var="user">
					<tr>
						<td><input type="checkbox" value="${user.id}" name="user-selector"/></td>
			  			<td>${user.username}</td>
			  			<td>******</td>
			  			<td>${user.nickname}</td>
			  			<td>
			  				<c:choose>
								<c:when test="${user.role==1}">普通用户</c:when>
								<c:when test="${user.role==2}">角色2</c:when>
								<c:when test="${user.role==2}">角色3</c:when>
								<c:otherwise>脏数据</c:otherwise>
							</c:choose>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<script src="<%=request.getContextPath() %>/js/user.js"></script>
</body>
</html>