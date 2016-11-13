<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<% String path = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="/WEB-INF/jsp/common/header.jsp"></jsp:include>
<title>新建项目</title>
</head>
<body>
	<jsp:include page="/WEB-INF/jsp/common/nav.jsp"></jsp:include>
	<div class="container">
		<div class="page-header">
			<h1>新建项目</h1>
		</div>
		<div class="row">
			<div class="alert alert-danger col-md-6" id="js-error-msg" role="alert" hidden>
				新建项目失败！
			</div>
		</div>
		<div class="row">
			<form class="col-md-6" id="add-form" action="<c:url value="/project/add"/>" method="POST">
				<div class="form-group">
		    		<label for="input-name">项目名</label>
		    		<input type="text" class="form-control" name="name" id="input-name" required>
		  		</div>
		  		<div class="form-group">
		    		<label for="input-desc">项目描述</label>
		    		<textarea rows="8" class="form-control" name="description" id="input-desc" required></textarea>
		  		</div>
			  	<div class="form-group">
		  			<a href="<%=path%>/project"><button type="button" class="col-md-5 btn btn-default">返回</button></a>
		  			<button type="button" id="js-add-project" class="col-md-5 col-md-offset-1 btn btn-primary">添加</button>
		  		</div>
			</form>
		</div>
	</div>
	<script>
		$(document).ready(function() {
			
			$('#js-add-project').click(function() {
				var name = $('#input-name').val();
				var desc = $('#input-desc').val();
				if (!(name && desc)) {
					$('#js-error-msg').html('项目名和项目描述不可为空！').show();
					return;
				} else {

					$.ajax({
						type: "post",
						url: "/rms/project/add",
						data: {
							name: name,
							description: desc
						},
						success: function(data){
							if(data['result']==1){
								window.location.href = "/rms/project";
							} else {
								$('#js-error-msg').html('新建项目失败!').show();
							}
						},
						error: function() {
							alert("Oh no！出错了！");
						}
					});
				}
			});
			
		});
	</script>
</body>
</html>