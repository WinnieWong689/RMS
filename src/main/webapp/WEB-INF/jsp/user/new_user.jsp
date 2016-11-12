<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<% String path = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="/WEB-INF/jsp/common/header.jsp"></jsp:include>
<title>新建用户</title>
</head>
<body>
	<jsp:include page="/WEB-INF/jsp/common/nav.jsp"></jsp:include>
	<div class="container">
		<div class="page-header">
			<h1>添加用户</h1>
		</div>
		<div class="row">
			<form class="col-md-4" id="add-form" action="<c:url value="/user/add"/>" method="POST">
				<div class="form-group">
		    		<label for="input-username">用户账号</label>
		    		<input type="text" class="form-control" name="username" id="input-username" required>
		  		</div>
		  		<div class="form-group">
		    		<label for="input-nickname">姓名</label>
		    		<input type="text" class="form-control" name="nickname" id="input-nickname" required>
		  		</div>
			  	<div class="form-group">
			    	<label for="input-password">密码</label>
			    	<input type="password" class="form-control" name="password" id="input-password" required>
			  	</div>
			  	<div class="form-group">
			  		<label style="display: block">用户角色</label>
			  		<label class="radio-inline">
						<input type="radio" name="role" value="1" checked> 普通用户
					</label>
					<label class="radio-inline">
						<input type="radio" name="role" value="2"> 角色2
					</label>
					<label class="radio-inline">
						<input type="radio" name="role" value="3"> 角色3
					</label>
			  	</div>
			  	<div class="form-group">
		  			<a href="<%=path%>/user"><button type="button" class="col-md-5 btn btn-default">返回</button></a>
		  			<button type="submit" class="col-md-5 col-md-offset-1 btn btn-primary">添加</button>
		  		</div>
			</form>
		</div>
	</div>
	<script src="<%=request.getContextPath() %>/js/user.js"></script>
</body>
</html>