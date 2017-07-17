<!DOCTYPE html>
<html>

<head>
	<title>Library System</title>
	<link rel="stylesheet" 
	      type="text/css" 
	      href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
</head>

<body>
<div class="container">
	<div class="row">
		<div class="col-lg-12">
			<div id="content">
			<div id="text">
				<h1>Error Page</h1>
				<ul>
				<li>You may have already checked out 3 books</li>
				<li>The book you want to borrow is already checked out</li>
				</ul>
			</div>
			<hr>
    	    <form class="form-inline">
	        <button type="button" onclick="window.location.href='${pageContext.request.contextPath}/book/show'; return false" class="btn btn-primary">Go Back</button>
            </form>
		    </div>
		</div>
	</div>
</div>

</body>

</html>