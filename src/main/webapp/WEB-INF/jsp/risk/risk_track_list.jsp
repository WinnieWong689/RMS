<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<% String path = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="/WEB-INF/jsp/common/header.jsp"></jsp:include>
<title>项目风险追踪页</title>
</head> 
<body>
	<jsp:include page="/WEB-INF/jsp/common/nav.jsp"></jsp:include>
	<div class="container">
		<div class="page-header">
			<h1 class="pull-left">跟踪条目列表</h1>
			<c:if test="${follower}">
				<a class="btn btn-default pull-left" href="<%=request.getContextPath()%>/risk/add_track_item/${riskItem.id}">添加跟踪条目</a>
			</c:if>
			<a class="btn btn-default pull-left" href="<%=request.getContextPath()%>/risk/risk_list/${riskItem.id}">返回</a>
			<div class="clearfix"></div>
			<div>
				<p>${project.description}</p>
			</div>
		</div>
		<div class="row">
			<div class="col-md-12">
				<div class="item-bordered">
					<div class="col-md-1">${riskItem.uploader.nickname}</div>
					<div class="col-md-11">
						${riskItem.content}
					</div>
					<div class="clearfix"></div>
				</div>
			</div>
			<div class="col-md-12">
					<span style="margin-left: 15px">可能性：
						<c:choose>
							<c:when test="${riskItem.levelChance==1}">
								<label class="level-label text-danger">高</c:when>
							<c:when test="${riskItem.levelChance==2}">
								<label class="level-label text-warning">中</c:when>
							<c:when test="${riskItem.levelChance==2}">
								<label class="level-label text-success">低</c:when>
							<c:otherwise>脏数据</c:otherwise>
						</c:choose></label>
					</span>
					<span>影响程度:：
						<c:choose>
							<c:when test="${riskItem.levelInfluence==1}">
								<label class="level-label text-danger">高</c:when>
							<c:when test="${riskItem.levelInfluence==2}">
								<label class="level-label text-warning">中</c:when>
							<c:when test="${riskItem.levelInfluence==2}">
								<label class="level-label text-success">低</c:when>
							<c:otherwise>脏数据</c:otherwise>
						</c:choose></label>
					<span style="display:inline-block;" class="pull-right">由<label>${riskItem.follower.nickname}</label>跟踪</span>
				
			</div>
			<div class="col-md-12">
				<div class="col-md-1">触发器 </div>
				<ul class="col-md-11">
					<c:forEach items="${riskItem.triggers}" var="trigger">
						<li>${trigger.content}</li>
					</c:forEach> 
				</ul>
			</div>
		</div>
		
		<table class="table table-bordered">
			<thead>
	          <tr>
	            <th colspan="2">共有${trackCount}个条目</th>
	          </tr>
	        </thead>
	        <tbody>
				<c:forEach items="${trackItems}" var="trackitem">
					<tr>
			  			<td width="30%">
							<p>${trackitem.title}</p>
							<p>${trackitem.ctime}</p>
			  			</td>
			  			<td width="70%">${trackitem.description}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>