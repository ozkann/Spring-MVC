<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<link href="resources/bootstrap/css/bootstrap.css" rel="stylesheet" media="screen"/>


</head>
<body>


<div style="margin-top:5%;margin-left:15%;margin-right:15%;">

<form method="POST" action="Upload" enctype="multipart/form-data">

	<input type="file" name="file" class="btn btn-default btn-lg btn-block"/>
	<br>
	<input type="text" name="description" class="form-control" placeholder="Image description" required="required">
	<br>
	<input type="submit" class="btn btn-default btn-lg btn-block" value="Upload"/>
	</br><center style="font-size:large; color: green;">${message}</center>
</form>
	
</div>

</body>
</html>
