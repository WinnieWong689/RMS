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
			<a class="btn btn-default pull-left" href="<%=request.getContextPath()%>/risk/new_track_item">添加跟踪条目</a>
			<div class="clearfix">
				<p>${project.description}</p>
			</div>
		</div>
		<div class="row">
			<div class="col-md-1">${riskItem.creater}</div>
			<div class="col-md-11">
				${riskItem.description}
			</div>
			<div class="col-md-12">
				<label>可能性：</label><span>${riskItem.levelChance}</span>
				<label>影响程度:：</label><span>${riskItem.levelInfluence}</span>
			</div>
		</div>
		<div class="row>
			<c:forEach items="${trackItems}" var="trackitem">
				<div class="col-md-12">
					<div class="col-md-3>
						<p>${trackitem.title}</p>
						<p>${trackitem.ctime}</p>
					</div>
					<div class="col-md-9>
						${trackitem.description}
					</div>
				</div>
			</c:forEach>
		</div>
	</div>
</body>

<script>


	
	</script>
</body>
</html>