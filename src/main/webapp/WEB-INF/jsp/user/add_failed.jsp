<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
		<p>系统将在<span id="js-count-down">3</span>秒后跳转</p>
	</div>
	
	<script>
		$(document).ready(function(){
			intervalid = setInterval("count()", 1000); 
		});

		var intervalid;
		var i = 2;
		
		function count() { 
			if (i == 0) { 
				clearInterval(intervalid); 
				var url = "/rms/user";
				window.location.href = url;
			}
			$('#js-count-down').html(i); 
			i--; 
		}
	</script>
</body>
</html>