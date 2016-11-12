<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<% int path = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="/WEB-INF/jsp/common/header.jsp"></jsp:include>
<title>新建用户</title>
</head>
<body>
	<jsp:include page="/WEB-INF/jsp/common/nav.jsp"></jsp:include>
	<div class="container">
		<h1>添加用户</h1>
		<div class="row">
			<form class="col-md-6" action="<c:url value="/user/create"/>" method="POST">
				<div class="form-group">
		    		<label for="input-email">用户名</label>
		    		<input type="text" class="form-control" name="username" id="input-username" required>
		  		</div>
		  		<div class="form-group">
		    		<label for="input-email">姓名</label>
		    		<input type="text" class="form-control" name="nickname" id="input-nickname" required>
		  		</div>
			  	<div class="form-group">
			    	<label for="input-password">密码</label>
			    	<input type="password" class="form-control" name="password" id="input-password" required>
			  	</div>
			  	<div class="form-group">
			  		<label class="radio-inline">
						<input type="radio" name="role" value="1" selected> 普通用户
					</label>
					<label class="radio-inline">
						<input type="radio" name="role" value="2"> 角色2
					</label>
					<label class="radio-inline">
						<input type="radio" name="role" value="3"> 角色3
					</label>
			  	</div>
		  		<a href="/user"><button type="button" class="btn btn-default">返回</button></a>
		  		<button type="submit" class="btn btn-primary">添加</button>
			</form>
		</div>
	</div>
</body>
</html>