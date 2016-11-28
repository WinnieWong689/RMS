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
			<div class="alert alert-info col-md-5" style="margin-top: 30px">
				<p>新用户请联系管理员申请账号^_^</p>
				<p>检查请使用以下用户：</p>
				<ul>
					<li>管理员:用户名:<label>admin</label> 密码:<label>admin</label></li>
					<li>项目负责人（创建者）:用户名:<label>leader</label> 密码:<label>leader</label></li>
					<li>组员（跟踪者）账户:用户名:<label>jane</label> 密码:<label>jane</label></li>
				</ul>
				<p>用户权限设置如下：</p>
				<ul>
					<li>管理员只负责用户管理</li>
					<li>项目负责人拥有创建风险项目并为项目添加风险条目的权限</li>
					<li>组员即项目跟踪者拥有添加风险条目跟踪的权限</li>
					<li>负责人和组员可以查看所有项目，但只能对各自创建（负责人）/跟踪（组员）的项目/风险条目进行操作</li>
				</ul>
				<p class="text-danger" style="margin-top: 15px">如果出现服务器500错误请刷新页面，我们还在积极排查错误原因，非常抱歉对您的使用造成不便。</p>
			</div>
			<div class="col-md-6 col-md-offset-1">
				<h2>欢迎使用，请先登录</h2>
				<div class="alert alert-danger col-md-8" id="js-error-msg" role="alert" style="display:none">${msg}</div>
				<form class="form-horizontal col-md-8" role="form" action="<c:url value="/auth"/>" method="POST">
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