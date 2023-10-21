<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c1" uri="http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html>
<html lang="en">
<head>
    <title>English Sentence Learning Website</title>
    <jsp:include page="/include" />
	<link href="${pageContext.request.contextPath}/css/subject_sentence_upload.css" rel="stylesheet" type="text/css" media="all" />
    <script src="${pageContext.request.contextPath}/js/app.controllers.ui.subject_sentence_upload.js" language="javascript"></script>
	<script src="${pageContext.request.contextPath}/js/subject_sentence_upload.js" language="javascript"></script>
	<style>
	
	</style>
	<script type="application/x-javascript">
	
	</script>
</head>
<body>
    <div id="header">
        <jsp:include page="/header" />
    </div>
	
    <div id="subject_sentence_upload-content">
    	<script>
		    <c1:if test="${success}">
		        $(document).ready(function() {
		            showDialog();
		        });
		    </c1:if>
		</script>
        <jsp:include page="/subject_sentence_upload-content" />
    </div>

    <div id="footer">
        <jsp:include page="/footer" />
    </div>
</body>
</html>
