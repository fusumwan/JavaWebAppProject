
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<div class="contrary">
	<div class="container">
		<div class="col col1">

		</div>
		<div class="col col2">
			<h1 class="page-title-header">Subject Sentence Export as PDF</h1>
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
			<form action="${pageContext.request.contextPath}/exportPDF" method="get">
                <input type="submit" id="exportPDF" value="Export PDF" class="btn">
            </form>
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

