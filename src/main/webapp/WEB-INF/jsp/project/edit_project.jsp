<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<% String path = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="/WEB-INF/jsp/common/header.jsp"></jsp:include>
<title>编辑风险项目</title>
</head>
<body>
	<jsp:include page="/WEB-INF/jsp/common/nav.jsp"></jsp:include>
	<div class="container">
		<div class="page-header">
			<h1>编辑风险项目</h1>
		</div>
		<div class="row">
			<form class="col-md-6" id="add-form" action="<c:url value="/project/edit"/>" method="POST">
				<input type="hidden" name="projectId" value="${project.id}">
				<div class="form-group">
		    		<label for="input-name">项目名</label>
		    		<input type="text" class="form-control" name="name" value="${project.name}" id="input-name" required>
		  		</div>
		  		<div class="form-group">
		    		<label for="input-desc">项目描述</label>
		    		<input class="form-control" name="description"
		    		id="input-desc" required value="${project.description}">
		  		</div>
			  	<div class="form-group">
		  			<a href="<%=path%>/project"><button type="button" class="col-md-5 btn btn-default">返回</button></a>
		  			<button type="submit" class="col-md-5 col-md-offset-1 btn btn-primary">修改</button>
		  		</div>
			</form>
		</div>
	</div>
</body>
</html>