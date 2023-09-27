<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Ordertable Website</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta name="apple-mobile-web-app-capable" content="yes">
	<meta name="format-detection" content="telephone=no"/>
	<meta name="viewport" content="user-scalable=no, initial-scale=1, maximum-scale=1, minimum-scale=1, width=device-width, height=device-height"/>
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/index.css">
	<link href="http://fonts.googleapis.com/css?family=Open+Sans:400,300,600" rel="stylesheet" type="text/css" />
	<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
	<link href="${pageContext.request.contextPath}/css/app.css" rel="stylesheet" type="text/css" media="all" />
	<script src="${pageContext.request.contextPath}/js/bcrypt.min.js" language="javascript"></script>
	<script src="${pageContext.request.contextPath}/js/error.protection.js" language="javascript"></script>
	<script src="${pageContext.request.contextPath}/js/app.controllers.js" language="javascript"></script>
	<script src="${pageContext.request.contextPath}/js/app.controllers.ui.js" language="javascript"></script>
	<script src="${pageContext.request.contextPath}/js/app.domain.models.repositories.js" language="javascript"></script>
	<script src="${pageContext.request.contextPath}/js/app.domain.models.js" language="javascript"></script>
	<script src="${pageContext.request.contextPath}/js/app.domain.repositories.js" language="javascript"></script>
	<script src="${pageContext.request.contextPath}/js/app.domain.services.js" language="javascript"></script>
	<script src="${pageContext.request.contextPath}/js/app.domain.utils.js" language="javascript"></script>
	<script src="${pageContext.request.contextPath}/js/app.domain.js" language="javascript"></script>
	<script src="${pageContext.request.contextPath}/js/app.js" language="javascript"></script>
	<script src="${pageContext.request.contextPath}/js/main.js"></script>
	<link href="${pageContext.request.contextPath}/css/login.css" rel="stylesheet" type="text/css" media="all" />
	<script src="${pageContext.request.contextPath}/js/accountinfo.js" language="javascript"></script>
	
	<script type="application/x-javascript"> 


	</script>
</head>
<body>
    <div id="header">
        <jsp:include page="/header" />
    </div>

    <div id="accountinfo-content">
        <jsp:include page="/accountinfo-content" />
    </div>

    <div id="footer">
        <jsp:include page="/footer" />
    </div>
</body>
</html>