<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<% int path = request.getContextPath(); %>
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
			<form class="col-md-6" action="<c:url value="/user/create"/>" method="POST">
				<div class="form-group">
		    		<label for="input-title">标题</label>
		    		<input type="text" class="form-control" name="title" id="input-title" required>
		  		</div>
		  		<div class="form-group">
		    		<label for="input-description">姓名</label>
		    		<input type="text" class="form-control" name="discription" id="input-discription" required>
		  		</div>
		  		<a href="/risk"><button type="button" class="btn btn-default">返回</button></a>
		  		<button type="submit" class="btn btn-primary">添加</button>
			</form>
		</div>
	</div>
</body>
</html>