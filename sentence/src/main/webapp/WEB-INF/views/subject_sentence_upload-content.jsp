<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c2" uri="http://java.sun.com/jsp/jstl/core" %>  
<div class="contrary">
	<div class="container">
		<div class="col col1">

		</div>
		<div class="col col2">
			<h1 class="page-title-header">Subject sentence upload page</h1>
		</div>
		<div class="col col3">

		</div>
	</div>
</div>

<div class="contrary">
	<div class="container">
		<div class="col col1">
		</div>
		<div class="col col2">

			<form:form modelAttribute="fileUploadForm" action="${pageContext.request.contextPath}/uploadCSV" method="post" enctype="multipart/form-data" id="csvUploadForm">
			    <!-- Custom Bootstrap file input style -->
			    <div class="custom-file mb-3">
			        <input type="file" class="custom-file-input" id="subject_sentence_upload_file" name="csvFile">
			        <label class="custom-file-label" for="subject_sentence_upload_file">Choose file</label>
			    </div>
			    <p><label class="form-label" ><b>Max upload size is 5 MB.</b></label><p>
			    <!-- Bootstrap button style -->
			    <input type="submit" value="Upload CSV" class="btn btn-primary"/>
			</form:form>
			

		</div>
		<div class="col col3">

		</div>
	</div>
</div>

<div class="contrary">
	<div class="container">
		<div class="col col1">
		</div>
		<div class="col col2">
            
			<hr>
            
<p class="normal-font">Didn't register an account with this website?</p>
<p class="normal-font"><a href="${pageContext.request.contextPath}/signup">Sign up</a></p>
			
		</div>
		<div class="col col3">

		</div>
	</div>
</div>

