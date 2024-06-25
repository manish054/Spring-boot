<%@page language="java"%>
<%@page import="com.manish.JobPortal.modal.JobDetails" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
	<head>
		<title>Contact Us</title>
	</head>
	<body>
		<jsp:include page="navbar.jsp"></jsp:include>
		<c:forEach var="job" items="${jobPosts}">
			<%-- <jsp:include page="card.jsp">
				<jsp:param value="${job}" name="jobDetails"/>
			</jsp:include> --%>
			<h3>Post : ${job.getPost()}</h1>
		</c:forEach>
	</body>
</html>
