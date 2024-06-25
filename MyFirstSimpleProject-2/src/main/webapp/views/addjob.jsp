<%@page language = "java" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Add Job</title>
    <link rel="stylesheet" href="css/addjob.css">
</head>
<body>
	<jsp:include page="navbar.jsp"></jsp:include>
    <div class="container">
        <h1>Add Job</h1>
        <form action="handleForm" method="post">
            <div class="form-group">
                <label for="post">Post:</label>
                <input type="text" id="post" name="post" required>
            </div>
            <div class="form-group">
                <label for="job_id">Job ID:</label>
                <input type="text" id="job_id" name="job_id" required>
            </div>
            <div class="form-group">
                <label for="experience">Experience:</label>
                <input type="text" id="experience" name="experience" required>
            </div>
            <div class="form-group">
                <label for="skill">Skill:</label>
                <select id="skillDropdown" name="skill">
			    	<option value="java">Java</option>
				    <option value="python">Python</option>
				    <option value="go">Go</option>
				    <option value="rust">Rust</option>
   				</select> 
            </div>
            <button type="submit">Submit</button>
        </form>
    </div>
</body>
</html>
