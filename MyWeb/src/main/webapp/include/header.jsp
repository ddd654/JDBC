<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-idth, initial-scale=1">


<title>Welcome to MyWorld</title>

<!-- Bootstrap Core CSS -->
<%-- <%=request.getContextPath() %> --%>
<link
	href="${pageContext.request.contextPath }/resources/css/bootstrap.css"
	rel="stylesheet">
<!-- Custom CSS -->
<link
	href="${pageContext.request.contextPath }/resources/css/business-casual.css"
	rel="stylesheet">

<!-- Fonts -->
<link
	href="https://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800"
	rel="stylesheet" type="text/css">
<link
	href="https://fonts.googleapis.com/css?family=Josefin+Slab:100,300,400,600,700,100italic,300italic,.400italic,600italic,700italic"
	rel="stylesheet" type="text/css">

<!-- jQuery -->
<script src="${pageContext.request.contextPath }/resources/js/jquery.js"></script>

<!-- Bootstrap Core JavaScript -->
<script
	src="${pageContext.request.contextPath }/resources/js/bootstrap.min.js"></script>

<style>
.abc {
	position: sticky;
	top: 0px;
	width: 100%;
	z-index: 10;
}
</style>


</head>

<body>
	<!-- header -->
	<div class="brand">My Web</div>
	<div class="address-bar">Welcome to MyWorld</div>

	<nav class="navbar navbar-default abc" role="navigation">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target="#bs-example-navbar-collapse-1">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>

				<a class="navbar-brand" href="/hong">My First Web</a>
			</div>


			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav">

					<li><a href="${pageContext.request.contextPath }/index.jsp">HOME</a>
					</li>
					<li><a
						href="${pageContext.request.contextPath }/member/member.jsp">Member</a>
					</li>
					<li><a href="">BOARD</a></li>

					<!-- 마이페이지로 가면 로그인 메뉴대신에 다른게 보여야한다 -->
					<!-- 여기로 들어가면 컨트롤러로 간다 --> 
					<c:choose>

						<c:when test="${sessionScope.user_id == null}">

							<li>
								
								<a href="${pageContext.request.contextPath }/user/login.user">LOGIN</a>
							</li>
							<li>
								<a href="${pageContext.request.contextPath }/user/join.user" style="color: red">JOIN</a>
							</li>
						</c:when>

						
						<%-- 이주석 --%>
						<c:otherwise>

							<li>
								<a href="${pageContext.request.contextPath }/user/Logout.user">LOGOUT</a>
							</li>
							<li>
								<a href="${pageContext.request.contextPath }/user/mypage.user" style="color: red">mypage1</a>
							</li>

						</c:otherwise>


					</c:choose>

				</ul>
			</div>


			<!-- /.navbar-collapse -->
		</div>
		<!-- /.container -->
	</nav>
	<!-- end header -->