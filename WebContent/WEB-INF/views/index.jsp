<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">


<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">

</head>

<body>
	<div class="contents">
		<div class="panel panel-default">
			<div class="panel-heading">
				<h3 class="panel-title">Spring Web</h3>
			</div>
			<div class="panel-body">
				<div class="col-md-12">
					<h3>Spring Web</h3>
					<br /> This is the landing page.

				</div>

			</div>
		</div>
	</div>
</body>
</html>
