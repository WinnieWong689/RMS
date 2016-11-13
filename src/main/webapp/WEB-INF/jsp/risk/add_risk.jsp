<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<% String path = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="/WEB-INF/jsp/common/header.jsp"></jsp:include>
<title>添加风险条目</title>
</head>
<body>
	<jsp:include page="/WEB-INF/jsp/common/nav.jsp"></jsp:include>
	<div class="container">
		<div class="page-header">
			<h1>${projectName} - 添加风险条目</h1>
		</div>
		<div class="row">
			<form class="col-md-4" id="add-form" action="<c:url value="/risk/add"/>" method="POST">
				<div class="form-group">
		    		<label for="input-username">风险内容</label>
		    		<input type="text" class="form-control" name="username" id="input-username" required>
		  		</div>
		  		<div class="form-group">
		    		<label for="input-nickname">可能性</label>
		    		<label class="radio-inline">
						<input type="radio" name="possibility" value="high" checked> 高
					</label>
					<label class="radio-inline">
						<input type="radio" name="possibility" value="med"> 中
					</label>
					<label class="radio-inline">
						<input type="radio" name="possibility" value="low"> 低
					</label>
		  		</div>
			  	<div class="form-group">
			    	<label for="input-password">影响程度</label>
			    	<label class="radio-inline">
						<input type="radio" name="infulence" value="high" checked> 高
					</label>
					<label class="radio-inline">
						<input type="radio" name="infulence" value="med"> 中
					</label>
					<label class="radio-inline">
						<input type="radio" name="infulence" value="low"> 低
					</label>
			  	</div>
			  	<div class="form-group">
			  		<label style="display: block">触发器</label>
			  		<input type="text" class="form-control" name="trigger" id="input-trigger-1" required>
			  		<span>+</span>
			  	</div>
			  	<div class="form-group">
		  			<a href="<%=path%>/risk_list"><button type="button" class="col-md-5 btn btn-default">返回</button></a>
		  			<button type="submit" class="col-md-5 col-md-offset-1 btn btn-primary">添加</button>
		  		</div>
			</form>
		</div>
	</div>
	<script src="<%=request.getContextPath() %>/js/risk.js"></script>
</body>
</html>