<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="/WEB-INF/jsp/common/header.jsp"></jsp:include>
<title>登录 - RMS</title>
</head>
<body>
	<jsp:include page="/WEB-INF/jsp/common/nav.jsp"></jsp:include>
	<div class="container">
		<div class="row">
			<h2 class="col-md-offset-2">欢迎使用，请先登录</h2>
		</div>
		<div class="row">
			<div class="alert alert-danger col-md-4 col-md-offset-2" id="js-error-msg" role="alert" style="display:none">${msg}</div>
		</div>
		<div class="row">
			<form class="form-horizontal col-md-4 col-md-offset-2" role="form" action="<c:url value="/auth"/>" method="POST">
		  		<div class="form-group">
		    		<label for="input-email">用户账号</label>
		    		<input type="text" class="form-control" name="username" id="input-name" placeholder="请输入用户名">
		  		</div>
			  	<div class="form-group">
			    	<label for="input-password">密码</label>
			    	<input type="password" class="form-control" name="password" id="input-password" placeholder="请输入密码">
			  	</div>
			  	<div class="form-group">
		  			<button type="submit" class="btn btn-default">登录</button>
		  		</div>
			</form>
			<div class="alert alert-info pull-right">
			<p>新用户请联系管理员申请账号^_^</p>
			<p>检查请使用以下用户：</p>
			<ul>
				<li>管理员:用户名:<label>admin</label> 密码:<label>admin</label></li>
				<li>项目负责人（创建者）:用户名:<label>leader</label> 密码:<label>leader</label></li>
				<li>组员（跟踪者）账户:用户名:<label>jane</label> 密码:<label>jane</label></li>
			</ul>
		</div>
		</div>
	</div>
	<script>
		$(document).ready(function(){
			var msg = $('#js-error-msg').html();
			if(msg.length > 0){
				$('#js-error-msg').show();
			}
		})
	</script>
</body>
</html>