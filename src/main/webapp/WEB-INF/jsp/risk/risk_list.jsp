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
			<h1 class="pull-left">${project.name} - 风险条目</h1>
			<input type="hidden" value="${project.id}" id="project-id">
			<c:if test="${uploader}">
				<a class="btn btn-default pull-left" href="<%=request.getContextPath()%>/project/edit/${project.id}">编辑</a>
				<a class="btn btn-default pull-left" href="<%=request.getContextPath()%>/risk/add/${project.id}">添加风险条目</a>
			</c:if>
			<div class="clearfix"></div>
			<div>${project.description}</div>
		</div>
		<!-- 
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
		-->
		<div class="row show-grid">
			<div class="col-md-12">
				<div class="pull-left" style="display: inline-block; line-height: 28px; margin-right: 20px">共有 ${total}个条目</div>
				<c:if test="${uploader}">
					<button class="btn btn-sm btn-default pull-left" id="js-delete-btn" disabled data-toggle="modal" data-target="#del-confirm-modal">删除选中</button>
				</c:if>
			</div>
		</div>
		<table class="table table-bordered table-hover">
			<thead>
	          <tr>
	            <th><input type="checkbox" value="0" id="checkbox-all"/></th>
	            <th>风险标题</th>
	            <th>内容</th>
	            <th>可能性</th>
	            <th>影响程度</th>
	            <th>触发器</th>
	            <th>提交者</th>
	            <th>跟踪者</th>
	            <th>条目数</th>
	            <c:if test="${uploader}">
	            <th>操作</th>
	            </c:if>
	          </tr>
	        </thead>
	        <tbody>
				<c:forEach items="${risks}" var="risk">
					<tr>
						<td><input type="checkbox" value="${risk.id}" name="selector"/></td>
						<td onclick="location.href='/rms/risk/risk_track_list/${risk.id}';">${risk.title }</td>
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
			  			<c:if test="${uploader}">
			  			<td>
			  				<a href="<%=request.getContextPath()%>/risk/edit/${risk.id}" class="btn btn-default btn-sm">修改</a>
			  			</td></c:if>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	
	<div class="modal fade" id="del-confirm-modal">
		<div class="modal-dialog">
			<div class="modal-content">
		      	<div class="modal-header">
		        	<button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">关闭</span></button>
		        	<h4 class="modal-title">删除风险条目</h4>
		      	</div>
		      	<div class="modal-body">
		      		<p>确认删除所选风险条目吗？</p>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
					<button type="button" class="btn btn-primary" id="js-delete-confirm">确认</button>
				</div>
			</div><!-- /.modal-content -->
		</div><!-- /.modal-dialog -->
	</div><!-- /.modal -->
	<script src="<%=request.getContextPath() %>/js/risk.js"></script>
</body>
</html>