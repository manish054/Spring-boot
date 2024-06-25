<%@page language="java" %>
<%@page import="com.manish.JobPortal.modal.JobDetails" %>
<% JobDetails jobDetails = (JobDetails)request.getAttribute("jobDeatils"); %>


<html>
	<head>
		<title>Success</title>
	</head>
	<body>
		<jsp:include page="navbar.jsp"></jsp:include>
		<h1>Job Post Details</h1>
		 <%-- <jsp:include page="card.jsp">
    		<jsp:param name="jobDetails" value="<%= jobDetails %>" />
    	</jsp:include> --%>
	</body>
</html>