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
					<div class="row">
						<div class="col-md-9">
							<h3>Spring Web</h3>
						</div>
						<div class="col-md-3">
							<c:if test="${loginError != null}">
								<div class="alert alert-danger" role="alert">${loginError}</div>
							</c:if>
							<form:form class="form-signin" method="POST"
								action="${fn:substring(url, 0, fn:length(url) - fn:length(uri))}${req.contextPath}/login"
								modelAttribute="user">
								<div class="input-group">
									<span class="input-group-addon" id="user-addon"><i
										class="glyphicon glyphicon-user"></i></span>
									<form:input type="text" path="userName" class="form-control"
										placeholder="Username" aria-describedby="user-addon"
										required="true" autofocus="true" />
								</div>
								<div class="col-md-12" style="height: 10px;"></div>
								<div class="input-group">
									<span class="input-group-addon" id="password-addon"><i
										class="glyphicon glyphicon-asterisk"></i></span>
									<form:input type="password" path="password"
										class="form-control" placeholder="Password"
										aria-describedby="password-addon" required="true"
										autofocus="true" />
								</div>
								<div class="col-md-12" style="height: 10px;"></div>
								<div class="col-md-12">
									<button class="btn btn-primary btn-block" type="submit">
										<span class="glyphicon glyphicon-log-in"></span> Login in
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
