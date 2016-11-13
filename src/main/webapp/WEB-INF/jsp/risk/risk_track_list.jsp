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
			<a class="btn btn-default pull-left" href="<%=request.getContextPath()%>/risk/add_track_item/${riskItem.id}">添加跟踪条目</a>
			<div class="clearfix"></div>
			<div>
				<p>${project.description}</p>
			</div>
		</div>
		<div class="row">
			<div class="col-md-1">${riskItem.uploader.nickname}</div>
			<div class="col-md-11">
				${riskItem.content}
			</div>
			<div class="col-md-12">
				<span><label>可能性：</label>${riskItem.levelChance}</span>
				<span><label>影响程度:：</label>${riskItem.levelInfluence}</span>
				<span>由<label>${riskItem.follower.nickname}</label>跟踪</span>
			</div>
			<div class="col-md-12">
				<c:forEach items="${riskItem.triggers}" var="trigger">
					<p>${trigger.content}</p>
				</c:forEach>
			</div>
		</div>
		
		<table class="table table-bordered">
			<thead>
	          <tr>
	            <th colspan="2">共2个追踪项</th>
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