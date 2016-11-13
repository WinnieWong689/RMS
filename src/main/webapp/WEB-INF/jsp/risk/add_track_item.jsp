<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<% String path = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="/WEB-INF/jsp/common/header.jsp"></jsp:include>
<title>添加跟踪条目</title>
</head> 
<body>
	<jsp:include page="/WEB-INF/jsp/common/nav.jsp"></jsp:include>
	<div class="container">
		<h1>添加跟踪条目</h1>
		<div class="row">
			<form class="col-md-6" id="add-form" action="<c:url value="/risk/add_track_item"/>" method="POST">
				<div class="form-group">
		    		<input type="hidden" class="form-control" name="itemId" value="${itemId}">
		  		</div>
				<div class="form-group">
		    		<label for="input-title">标题</label>
		    		<input type="text" class="form-control" name="title" id="input-title" required>
		  		</div>
		  		<div class="form-group">
		    		<label for="input-description">内容</label>
		    		<input type="text" class="form-control" name="description" id="input-description" required>
		  		</div>
		  		<a href="<%=path %>/risk/risk_track_list/${itemId}"><button type="button" class="btn btn-default">返回</button></a>
		  		<button type="submit" class="btn btn-primary" id="js-add-risk-item">添加</button>
			</form>
		</div>
	</div>
</body>

<script>

$(document).ready(function() {
	$('#js-add-risk-item').click(function() {
		var title = $("#input-title").val().trim();
		var dscrpt = $("#input-description").val().trim();
		if (title == '' || title == null) {
			alert("请输入标题");
		}
		if (title == '' || title == null) {
			alert("请输入描述");
		}
		$("#add-form").submit();
	});
});
	
	</script>
</body>
</html>