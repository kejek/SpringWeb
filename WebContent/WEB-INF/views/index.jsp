<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<c:set var="req" value="${pageContext.request}" />
<c:set var="url">${req.requestURL}</c:set>
<c:set var="uri" value="${req.requestURI}" />
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
					<div class="row">
						<div class="col-md-8"></div>
						<div class="col-md-4">
							<c:if test="${answer != null}">
								<div class="alert alert-success" role="alert">${answer}</div>
							</c:if>
							SumIt Up -
							Enter numbers seperated by commas:
							<form:form class="form-signin" method="POST"
								action="${fn:substring(url, 0, fn:length(url) - fn:length(uri))}${req.contextPath}/index"
								modelAttribute="question">
								<div class="input-group">
									<form:input type="text" path="value" class="form-control"
										placeholder="List of Numbers" aria-describedby="list-addon"
										required="true" autofocus="true" />
								</div>
								<br />
								<div class="col-md-12">
									<button class="btn btn-primary btn-block" type="submit">
										<span class="glyphicon glyphicon-log-in"></span> Submit
									</button>
								</div>
							</form:form>
						</div>
					</div>
				</div>

			</div>
		</div>
	</div>
</body>
</html>
