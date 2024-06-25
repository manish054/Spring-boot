<%@page import="com.manish.JobPortal.modal.JobDetails"%>
<%@page language="java" %>


<html>
	<head>
		<style type="text/css">
		
			.card {
			    width: 300px;
			    border: 1px solid #ccc;
			    border-radius: 5px;
			    box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
			    margin: 20px;
			}
			
			.card-content {
			    padding: 20px;
			}
			
			.title {
			    font-size: 20px;
			    margin-bottom: 10px;
			}
			
			.description {
			    font-size: 16px;
			}
		</style>
	</head>
	<body>
		<%
	JobDetails jobDetails = (JobDetails)request.getAttribute("jobDetails");
%>
		<!-- card.jsp -->
		<div class="card">
		<% if (jobDetails != null) { %>
		    <div class="card-header">
		    	<h3>Post</h3>
		        <h3><%= jobDetails.getPost() %></h3>
		    </div>
		    <div class="card-body">
		    	<p>Job Id</p>
		        <p><%= jobDetails.getjob_id() %></p>
		    </div>
		    <div class="card-body">
		        <p>Experience</p>
		        <p><%= jobDetails.getexperience() %></p>
		    </div>
		    <div class="card-body">
		    	<p>Skills Required</p>
		        <p><%= jobDetails.getSkill() %></p>
		    </div>
		    <%}else{ %>
		    	<p>No Job Deatils Available</p>
		    	<% } %>
		</div>
	</body>
</html>


