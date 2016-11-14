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
	<c:choose>
	<c:when test="${error}">
		添加出错啦！
		<a href="<%=path%>/risk/risk_list/${project.id}"><button type="button" class="col-md-5 btn btn-default">返回</button></a>
	</c:when>
	<c:otherwise>
	<div class="container">
		<div class="page-header">
			<h1>${project.name} - 添加风险条目</h1>
		</div>
		<div class="row">
			<form class="col-md-4" id="add-form" action="<c:url value="/risk/add"/>" method="POST">
				<input type="hidden" name="projectId" value="${project.id}" >
				<div class="form-group">
		    		<label for="input-content">风险标题</label>
		    		<input type="text" class="form-control" name="title" id="input-content" required>
		  		</div>
				<div class="form-group">
		    		<label for="input-content">风险内容</label>
		    		<input type="text" class="form-control" name="content" id="input-content" required>
		  		</div>
		  		<div class="form-group">
		    		<label for="input-chance">可能性</label>
		    		<label class="radio-inline" id="input-chance">
						<input type="radio" name="chance" value="1" checked> 高
					</label>
					<label class="radio-inline">
						<input type="radio" name="chance" value="2"> 中
					</label>
					<label class="radio-inline">
						<input type="radio" name="chance" value="3"> 低
					</label>
		  		</div>
			  	<div class="form-group">
			    	<label for="input-influence">影响程度</label>
			    	<label class="radio-inline">
						<input type="radio" name="influence" value="1" checked> 高
					</label>
					<label class="radio-inline">
						<input type="radio" name="influence" value="2"> 中
					</label>
					<label class="radio-inline">
						<input type="radio" name="influence" value="3"> 低
					</label>
			  	</div>
			  	<div class="form-group">
			  		<label style="display: block">触发器</label>
			  		<input type="text" class="form-control" name="trigger" id="input-trigger-1" required>
			  	</div>
			  	<div class="form-group">
			  		<label style="display: block">跟踪者</label>
			  		<select class="form-control" id="select-role" name="follwer">
			  			<c:forEach items="${users}" var="user">
							<option value="${user.id}">${user.nickname}</option>
						</c:forEach>
					</select>
			  	</div>
			  	<div class="form-group">
		  			<a href="<%=path%>/risk/risk_list/${project.id}"><button type="button" class="col-md-5 btn btn-default">返回</button></a>
		  			<button type="submit" class="col-md-5 col-md-offset-1 btn btn-primary">添加</button>
		  		</div>
			</form>
		</div>
	</div>
	</c:otherwise>
	</c:choose>
</body>
</html>