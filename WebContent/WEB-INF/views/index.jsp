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
						<div class="col-md-6">
							Lorem ipsum dolor sit amet, consectetur adipiscing elit. Quisque
							facilisis pellentesque dapibus. Vestibulum ultrices nisl in
							scelerisque dictum. In dapibus turpis non rutrum dignissim. Nulla
							nisi felis, commodo non tempor sed, accumsan a erat. Nunc
							elementum nulla odio, at feugiat enim elementum et. Nunc at est
							diam. Vestibulum ex purus, ornare vitae ipsum sed, varius
							interdum elit. Praesent tristique dui ipsum, sed hendrerit ex
							finibus non. Ut viverra velit nibh. Maecenas mattis augue eget
							laoreet sagittis. Proin et risus commodo, venenatis leo et,
							vestibulum nulla. Donec condimentum, diam condimentum finibus
							commodo, ligula ante blandit libero, at sollicitudin urna tortor
							in sem. Donec in ornare mi. <br /> Donec malesuada mollis
							eleifend. Fusce eget tristique risus, eget sollicitudin leo.
							Donec cursus sodales massa, a luctus lacus. Ut vestibulum non
							quam quis molestie. Curabitur purus tortor, bibendum et aliquet
							vel, sagittis a quam. Ut nisl libero, pharetra nec interdum
							pretium, pharetra ut odio. Integer vulputate lobortis dui, a
							placerat lorem lacinia ac. Proin enim dolor, eleifend quis ante
							eget, molestie porta arcu. Nullam fermentum venenatis erat in
							bibendum. Pellentesque eget fermentum arcu. Ut maximus eros
							malesuada commodo mattis.
						</div>
						<div class="col-md-6">
							Lorem ipsum dolor sit amet, consectetur adipiscing elit. Quisque
							facilisis pellentesque dapibus. Vestibulum ultrices nisl in
							scelerisque dictum. In dapibus turpis non rutrum dignissim. Nulla
							nisi felis, commodo non tempor sed, accumsan a erat. Nunc
							elementum nulla odio, at feugiat enim elementum et. Nunc at est
							diam. Vestibulum ex purus, ornare vitae ipsum sed, varius
							interdum elit. Praesent tristique dui ipsum, sed hendrerit ex
							finibus non. Ut viverra velit nibh. Maecenas mattis augue eget
							laoreet sagittis. Proin et risus commodo, venenatis leo et,
							vestibulum nulla. Donec condimentum, diam condimentum finibus
							commodo, ligula ante blandit libero, at sollicitudin urna tortor
							in sem. Donec in ornare mi. <br /> Donec malesuada mollis
							eleifend. Fusce eget tristique risus, eget sollicitudin leo.
							Donec cursus sodales massa, a luctus lacus. Ut vestibulum non
							quam quis molestie. Curabitur purus tortor, bibendum et aliquet
							vel, sagittis a quam. Ut nisl libero, pharetra nec interdum
							pretium, pharetra ut odio. Integer vulputate lobortis dui, a
							placerat lorem lacinia ac. Proin enim dolor, eleifend quis ante
							eget, molestie porta arcu. Nullam fermentum venenatis erat in
							bibendum. Pellentesque eget fermentum arcu. Ut maximus eros
							malesuada commodo mattis.
						</div>
					</div>

				</div>

			</div>
		</div>
	</div>
</body>
</html>
