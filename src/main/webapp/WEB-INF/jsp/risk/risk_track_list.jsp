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
			<div class="clearfix"></div>
		</div>
		
	</div>
</body>

<script>


	
	</script>
</body>
</html>