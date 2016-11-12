<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<% int path = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="/WEB-INF/jsp/common/header.jsp"></jsp:include>
<title>新建用户</title>
</head>
<body>
	<jsp:include page="/WEB-INF/jsp/common/nav.jsp"></jsp:include>
	<div class="container">
		<h1>添加用户失败！</h1>
		<p>系统将在<span id="js-count-down"></span>秒后跳转</p>
	</div>
	
	<script>
		$(document).ready(function(){
			var i = 3;
			var intervalid;
			intervalid = setInterval("count()", 1000); 
			
			var count = function countDown() { 
				if (i == 0) { 
					clearInterval(intervalid); 
					var url = urlPrefix + "/";
					window.location.href = url;
				}
				$('#js-count-down').html(i); 
				i--; 
			}
		})
	</script>
</body>
</html>