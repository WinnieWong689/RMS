<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%> 
<!DOCTYPE html>
<html>
<head>
<jsp:include page="/WEB-INF/jsp/common/header.jsp"></jsp:include>
<title>风险条目管理</title>
</head>
<body>
	<jsp:include page="/WEB-INF/jsp/common/nav.jsp"></jsp:include>
	<div class="container">
		<div class="page-header">
			<h1 class="pull-left">${projectName} - 风险条目</h1>
			<a class="btn btn-default pull-left" href="<%=request.getContextPath()%>/risk/edit">编辑</a>
			<a class="btn btn-default pull-left" href="<%=request.getContextPath()%>/risk/add">添加风险条目</a>
			<div class="clearfix"></div>
		</div>
		<div class="row show-grid">
			<form class="m-user-search-form form-inline col-md-8" role="form">
				<div class="form-group">
					<label for="input-username">风险内容</label>
	    			<input type="text" class="form-control" id="input-username">
				</div>
				<div class="form-group">
					<label for="select-possibility">可能性</label>
					<select class="form-control" id="select-possibility">
						<option value="-1">全部</option>
						<option value="1">高</option>
						<option value="2">中</option>
						<option value="2">低</option>
					</select>
				</div>
				<div class="form-group">
					<label for="select-influence">影响程度</label>
					<select class="form-control" id="select-influence">
						<option value="-1">全部</option>
						<option value="1">高</option>
						<option value="2">中</option>
						<option value="2">低</option>
					</select>
				</div>
				<div class="form-group">
					<label for="input-submitter">提交者</label>
	    			<input type="text" class="form-control" id="input-submitter">
				</div>
				<div class="form-group">
					<label for="input-follower">跟踪者</label>
	    			<input type="text" class="form-control" id="input-follower">
				</div>
			</form>
			<div class="col-md-1">
				<button class="btn btn-default col-md-12">搜索</button>
			</div>
		</div>
		<div class="row show-grid">
			<div class="col-md-12">
				<div class="pull-left" style="display: inline-block; line-height: 28px; margin-right: 20px">共有 ${total} 个条目</div><button class="btn btn-sm btn-default pull-left">删除选中</button>
				<button class="btn btn-sm btn-default pull-left">修改选中</button>
			</div>
		</div>
		<div>
			<div class="div-table">
				<span class="col-md-5"></span>
				<span class="col-md-1">可能性</span>
				<span class="col-md-1">影响程度</span>
			</div>
		</div>
		<table class="table table-bordered table-hover">
			<thead>
	          <tr>
	            <th><input type="checkbox" value="0" id="checkbox-all"/></th>
	            <th>风险内容</th>
	            <th>可能性</th>
	            <th>影响程度</th>
	            <th>触发器</th>
	            <th>提交者</th>
	            <th>跟踪者</th>
	            <th>条目数</th>
	          </tr>
	        </thead>
	        <tbody>
				<c:forEach items="${risks}" var="risk">
					<tr>
						<td><input type="checkbox" value="${risk.id}" name="user-selector"/></td>
			  			<td onclick="location.href='/rms/risk/risk_track_list/${risk.id}';">${risk.content}</td>
			  			<td onclick="location.href='/rms/risk/risk_track_list/${risk.id}';">
			  				<c:choose>
								<c:when test="${risk.levelChance==1}">高</c:when>
								<c:when test="${risk.levelChance==2}">中</c:when>
								<c:when test="${risk.levelChance==2}">低</c:when>
								<c:otherwise>脏数据</c:otherwise>
							</c:choose>
						</td>
						<td onclick="location.href='/rms/risk/risk_track_list/${risk.id}';">
			  				<c:choose>
								<c:when test="${risk.levelInfluence==1}">高</c:when>
								<c:when test="${risk.levelInfluence==2}">中</c:when>
								<c:when test="${risk.levelInfluence==2}">低</c:when>
								<c:otherwise>脏数据</c:otherwise>
							</c:choose>
						</td>
			  			<td onclick="location.href='/rms/risk/risk_track_list/${risk.id}';">
			  				<c:forEach items="${risk.triggers}" var="trigger">
			  					<p>${trigger.content}</p>
			  				</c:forEach>
			  			</td>
			  			<td onclick="location.href='/rms/risk/risk_track_list/${risk.id}';">${risk.uploader.nickname}</td>
			  			<td onclick="location.href='/rms/risk/risk_track_list/${risk.id}';">${risk.follower.nickname}</td>
			  			<td onclick="location.href='/rms/risk/risk_track_list/${risk.id}';">${fn:length(risk.trackItems)}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<script src="<%=request.getContextPath() %>/js/risk.js"></script>
</body>
</html>