<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<c:redirect url="/login" />
<html>
<head>
<!-- This page should never be displayed. It's here as it is default generated. Our dispatcher
     servlet should redirect all root URL access to the /index and use the template.jsp -->

</head>

<body>You should not be here. This should redirect you to /home
</body>

</html>
