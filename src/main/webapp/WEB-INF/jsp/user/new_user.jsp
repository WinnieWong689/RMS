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
		    		<p class="text-danger pull-right" id="alert-username" hidden>该用户账号已存在！</p>
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
						<input type="radio" name="role" value="1" checked> 负责人
					</label>
					<label class="radio-inline">
						<input type="radio" name="role" value="2"> 组员
					</label>
			  	</div>
			  	<div class="form-group">
		  			<a href="<%=path%>/user"><button type="button" class="col-md-5 btn btn-default">返回</button></a>
		  			<button type="button" id="js-add-user" class="col-md-5 col-md-offset-1 btn btn-primary" disabled>添加</button>
		  		</div>
			</form>
		</div>
	</div>
	<script>
		var exist = 0;
		$(document).ready(function() {
			$('#input-username').bind('input propertychange', function() {  
			    $.ajax({
			    	type: "post",
			    	url: "/rms/user/check",
			    	data: {
			    		username: $(this).val()
			    	},
			    	success: function(data) {
			    		exist = data.result;	
			    		if (!exist) {
			    			$('#alert-username').hide()
			    			$('#js-add-user').prop("disabled", false);
			    		} else {
			    			$('#alert-username').show();
			    			$('#js-add-user').prop("disabled", true);
			    		}
			    	}
			    });
			}); 
			
			$('#js-add-user').click(function() {
				if (!exist) {
					$('#add-form').submit();
				}
			});
		});
	
	</script>
</body>
</html>