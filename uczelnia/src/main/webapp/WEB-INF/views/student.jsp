<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<title>Student</title>
</head>
<body>
	<section>
		<div class="jumbotron">
			<div class="container">
				<h1>Student</h1>
			</div>
		</div>
	</section>
	<section class="container">
		<div class="row">
			<div class="col-md-5">
				<h3>${student.surname}</h3>
				<h4>${student.name}</h4>
				<p>
					Wiek: <span class="label label-warning">${student.age}</span>
				</p>
				

				<p>
					<a href="<spring:url value="/studenci" />" class="btn btndefault">
						<span class="glyphicon-hand-left glyphicon"></span> Wstecz
					</a>
				</p>
			</div>
		</div>
	</section>
</body>
</html>