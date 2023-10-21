<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  

<!--
/**************************************************
 // Author: Sum Wan,FU
 // Date: 27-5-2019
 // Description: header include (banner, nav, search box). This page is for partially loading
 **************************************************/
-->
<script>
	//JavaScript cannot directly parse JSP expressions. Therefore, we need to pass the value of JSP to JavaScript.
    var contextPath = "<%= request.getContextPath() %>";
</script>
<div id="banner" class="banner banner_large">
	<div class="header">
		<!-- container-for-Head-Nav -->
		<div class="container">
			<div class="logo">
				<a href="${pageContext.request.contextPath}/"><img src="${pageContext.request.contextPath}/images/logo.png" class="img-responsive" alt=""  /></a>
			</div>
			<!-- script-for-nav -->
			<div class="head-nav">
					<span class="menu"> </span>
					<ul>
						<li id="home_li" ><a href="${pageContext.request.contextPath}/">Home</a></li>
						<li id="login_li" ><a href="${pageContext.request.contextPath}/login">Login</a></li>
						<li id="logout_li" style="display:none" ><a href="#">Logout</a></li>
						<li id="sign_up_li" ><a href="${pageContext.request.contextPath}/signup">Sign Up</a></li>
						<security:authorize access="hasAuthority('USER') or hasAuthority('MANAGER') or hasAuthority('ADMIN')">
						<li id="account_info_li" ><a href="${pageContext.request.contextPath}/accountinfo">Account Info</a></li>
						</security:authorize>
						<security:authorize access="hasAuthority('MANAGER') or hasAuthority('ADMIN')">  
						<li id="management_li" ><a href="${pageContext.request.contextPath}/management">Management</a></li>
						</security:authorize>
					</ul>
					<div class="clearfix"></div>
			</div>
			<div class="clearfix"> </div>
		</div> 
	</div>
	<!-- end of container-for-Head-Nav -->
	<!-- container-search -->
	<div id="search-container"  class="container">
		<div class="search-container" >
			<article> 
			<form>
				<div class="banner-info">
				<div class="col info">
					<h1 id="search-title" class="search-title">Find your English sentence example for learning</h1>
					
					<select id="search_criteria_1_drp" name="search_criteria_1_drp" class="form-select search-container-select" aria-label="party size">
						<option value="IT INTERVIEW">IT INTERVIEW</option>
					</select>
					<select id="search_criteria_2_drp" name="search_criteria_2_drp" class="form-select search-container-select" aria-label="party size">
						<option value="NORMAL QUESTION">NORMAL QUESTION</option>
						<option value="DEBUGGING SKILLS">DEBUGGING SKILLS</option>
						<option value="VPN SETUP">VPN SETUP</option>
						<option value="DATA PASSION">DATA PASSION</option>
						<option value="PANDEMIC CHALLENGES">PANDEMIC CHALLENGES</option>
						<option value="DATA STRUCTURE KNOWLEDGE">DATA STRUCTURE KNOWLEDGE</option>
						<option value="PORTFOLIO">PORTFOLIO</option>
						<option value="CLOUD KNOWLEDGE">CLOUD KNOWLEDGE</option>
						<option value="WEB DEVELOPMENT">WEB DEVELOPMENT</option>
						<option value="INVESTMENT IN LEARNING">INVESTMENT IN LEARNING</option>
						<option value="WEBSITE OPTIMIZATION">WEBSITE OPTIMIZATION</option>
						<option value="METHODOLOGY USE">METHODOLOGY USE</option>
						<option value="LEARNING IMPORTANCE">LEARNING IMPORTANCE</option>
						<option value="DB ROLE HIGHLIGHT">DB ROLE HIGHLIGHT</option>
						<option value="CYBERSECURITY SKILL">CYBERSECURITY SKILL</option>
						<option value="WEB FRAMEWORK SKILLS">WEB FRAMEWORK SKILLS</option>
						<option value="DEVELOPER INSIGHTS">DEVELOPER INSIGHTS</option>
						<option value="CODE QUALITY">CODE QUALITY</option>
						<option value="CODING FEEDBACK">CODING FEEDBACK</option>
						<option value="FEELING">FEELING</option>
						<option value="INSIGHT SHARING">INSIGHT SHARING</option>
						<option value="FEEDBACK APPRECIATION">FEEDBACK APPRECIATION</option>
						<option value="CONTINUOUS INTEGRATION">CONTINUOUS INTEGRATION</option>
						<option value="INTERVIEWEE QUERY">INTERVIEWEE QUERY</option>
						<option value="RESPONSIVE DESIGN">RESPONSIVE DESIGN</option>
						<option value="PLATFORM EXPERTISE">PLATFORM EXPERTISE</option>
						<option value="SEO PRACTICES">SEO PRACTICES</option>
						<option value="APP DEVELOPMENT">APP DEVELOPMENT</option>
						<option value="ANALYTICS EXPERTISE">ANALYTICS EXPERTISE</option>
						<option value="API KNOWLEDGE">API KNOWLEDGE</option>
						<option value="QUESTION">QUESTION</option>
						<option value="PROVIDING REFERENCES">PROVIDING REFERENCES</option>
						<option value="USER INTERFACE CREATION">USER INTERFACE CREATION</option>
						<option value="DEVELOPER CHALLENGE">DEVELOPER CHALLENGE</option>
						<option value="SECURITY UPDATES">SECURITY UPDATES</option>
						<option value="LEARNING EMPHASIS">LEARNING EMPHASIS</option>
						<option value="HACKATHON ORGANIZATION">HACKATHON ORGANIZATION</option>
						<option value="PROJECT SHOWCASE">PROJECT SHOWCASE</option>
						<option value="VALUE">VALUE</option>
						<option value="CYBERSECURITY MONITORING">CYBERSECURITY MONITORING</option>
						<option value="DISCUSSION ON VISUALIZATION">DISCUSSION ON VISUALIZATION</option>
						<option value="PROJECT PRESENTATION">PROJECT PRESENTATION</option>
						<option value="DAILY MEETINGS">DAILY MEETINGS</option>
						<option value="SOLUTION">SOLUTION</option>
						<option value="TECH CERTIFICATIONS">TECH CERTIFICATIONS</option>
						<option value="TECHNICAL PROFICIENCY">TECHNICAL PROFICIENCY</option>
						<option value="BACKEND SKILLS">BACKEND SKILLS</option>
						<option value="OPINION">OPINION</option>
						<option value="ROADMAP PRESENTATION">ROADMAP PRESENTATION</option>
						<option value="POSITIVE IMPRESSION">POSITIVE IMPRESSION</option>
						<option value="TECH SUPPORT">TECH SUPPORT</option>
						<option value="TECH VALUES">TECH VALUES</option>
						<option value="CYBERSECURITY FOCUS">CYBERSECURITY FOCUS</option>
						<option value="NETWORK MONITORING">NETWORK MONITORING</option>
						<option value="TECHNOLOGY OPPORTUNITIES">TECHNOLOGY OPPORTUNITIES</option>
						<option value="INNOVATION PRIDE">INNOVATION PRIDE</option>
						<option value="AUTOMATION ACHIEVEMENT">AUTOMATION ACHIEVEMENT</option>
						<option value="AUTOMATED TESTING">AUTOMATED TESTING</option>
						<option value="ML EXPERIENCE">ML EXPERIENCE</option>
						<option value="PROJECT MANAGEMENT">PROJECT MANAGEMENT</option>
						<option value="EXPECTATION">EXPECTATION</option>
						<option value="DIGITAL THOUGHTS">DIGITAL THOUGHTS</option>
						<option value="RESOURCE MANAGEMENT">RESOURCE MANAGEMENT</option>
						<option value="DEVELOPMENT METHODOLOGY">DEVELOPMENT METHODOLOGY</option>
						<option value="OPEN-SOURCE CONTRIBUTION">OPEN-SOURCE CONTRIBUTION</option>
						<option value="ML EXPLANATION">ML EXPLANATION</option>
						<option value="EXPERIENCE NEEDED">EXPERIENCE NEEDED</option>
						<option value="DBM SKILL">DBM SKILL</option>
						<option value="NETWORK OVERSIGHT">NETWORK OVERSIGHT</option>
						<option value="TEST DESIGN">TEST DESIGN</option>
						<option value="LANGUAGE PROFICIENCY">LANGUAGE PROFICIENCY</option>
						<option value="TECHNICAL DEPTH">TECHNICAL DEPTH</option>
						<option value="SOFTWARE DESIGN">SOFTWARE DESIGN</option>
						<option value="GLOBAL COLLABORATION">GLOBAL COLLABORATION</option>
						<option value="PLATFORM LAUNCH">PLATFORM LAUNCH</option>
						<option value="CLOUD EXPERIENCE">CLOUD EXPERIENCE</option>
						<option value="AGILE USE">AGILE USE</option>
						<option value="WORKSHOP ATTENDANCE">WORKSHOP ATTENDANCE</option>
						<option value="TEAM COLLABORATION">TEAM COLLABORATION</option>
						<option value="FULL-STACK SKILLS">FULL-STACK SKILLS</option>
						<option value="AUTOMATED REPORTING">AUTOMATED REPORTING</option>
						<option value="FEEDBACK SHARING">FEEDBACK SHARING</option>
						<option value="TEAMWORK EMPHASIS">TEAMWORK EMPHASIS</option>
						<option value="CODE MANAGEMENT">CODE MANAGEMENT</option>
						<option value="DAILY STAND-UPS">DAILY STAND-UPS</option>
						<option value="INDUSTRY KNOWLEDGE">INDUSTRY KNOWLEDGE</option>
						<option value="REPUTATION ACKNOWLEDGMENT">REPUTATION ACKNOWLEDGMENT</option>
						<option value="RECRUITMENT CRITERIA">RECRUITMENT CRITERIA</option>
						<option value="VALUE ATTRACTION">VALUE ATTRACTION</option>
						<option value="EXPERIENCE INQUIRY">EXPERIENCE INQUIRY</option>
						<option value="NETWORK SECURITY">NETWORK SECURITY</option>
						<option value="SKILL DEMONSTRATION">SKILL DEMONSTRATION</option>
						<option value="PENETRATION TESTING">PENETRATION TESTING</option>
						<option value="AI INSIGHTS">AI INSIGHTS</option>
						<option value="CLOUD OPPORTUNITIES">CLOUD OPPORTUNITIES</option>
						<option value="CANDIDATE VALUATION">CANDIDATE VALUATION</option>
						<option value="EMAIL RECEIVED">EMAIL RECEIVED</option>
						<option value="REFERENCE REQUEST">REFERENCE REQUEST</option>
						<option value="ARCHITECTURE UTILIZATION">ARCHITECTURE UTILIZATION</option>
						<option value="REQUIREMENT">REQUIREMENT</option>
						<option value="INFRASTRUCTURE DESIGN">INFRASTRUCTURE DESIGN</option>
						<option value="DEVELOPMENT EXPERIENCE">DEVELOPMENT EXPERIENCE</option>
						<option value="PORTFOLIO SUBMISSION">PORTFOLIO SUBMISSION</option>
						<option value="TRAINING PROVIDED">TRAINING PROVIDED</option>
						<option value="OFFER">OFFER</option>
						<option value="ALGORITHM TEST">ALGORITHM TEST</option>
						<option value="DATA ANALYSIS BACKGROUND">DATA ANALYSIS BACKGROUND</option>
						<option value="DOCUMENTATION">DOCUMENTATION</option>
						<option value="DIVERSITY EMPHASIS">DIVERSITY EMPHASIS</option>
						<option value="FEEDBACK">FEEDBACK</option>
						<option value="MARKET EXPANSION">MARKET EXPANSION</option>
						<option value="CODING EXPLANATION">CODING EXPLANATION</option>
						<option value="COMMUNICATION ENCOURAGEMENT">COMMUNICATION ENCOURAGEMENT</option>
						<option value="REMOTE WORK BENEFITS">REMOTE WORK BENEFITS</option>
						<option value="TECHNICAL QUERY">TECHNICAL QUERY</option>
						<option value="FEATURE PRIORITIZATION">FEATURE PRIORITIZATION</option>
						<option value="SYSTEM TESTING">SYSTEM TESTING</option>
						<option value="QA TESTING">QA TESTING</option>
						<option value="INTERVIEW SKILLS">INTERVIEW SKILLS</option>
						<option value="TRAINING OFFER">TRAINING OFFER</option>
						<option value="EMPLOYEE COLLABORATION">EMPLOYEE COLLABORATION</option>
						<option value="PRODUCT INNOVATION">PRODUCT INNOVATION</option>
						<option value="DOCUMENT LIST">DOCUMENT LIST</option>
						<option value="OPEN-SOURCE QUERY">OPEN-SOURCE QUERY</option>
						<option value="INTERFACE IMPROVEMENT">INTERFACE IMPROVEMENT</option>
						<option value="FOCUS">FOCUS</option>
						<option value="CODE REVIEW">CODE REVIEW</option>
						<option value="SYSTEM DESIGN EXPERTISE">SYSTEM DESIGN EXPERTISE</option>
						<option value="UI DEVELOPMENT">UI DEVELOPMENT</option>
						<option value="DEBUGGING RESPONSIBILITY">DEBUGGING RESPONSIBILITY</option>
						<option value="TECH UTILIZATION">TECH UTILIZATION</option>
						<option value="HARDWARE ADVICE">HARDWARE ADVICE</option>
						<option value="INFORMATION">INFORMATION</option>
						<option value="HARDWARE EVALUATION">HARDWARE EVALUATION</option>
						<option value="SOFTWARE UNDERSTANDING">SOFTWARE UNDERSTANDING</option>
						<option value="PLATFORM INTEGRATION">PLATFORM INTEGRATION</option>
						<option value="CONFIDENT RESPONSE">CONFIDENT RESPONSE</option>
						<option value="CYBERSECURITY MEASURES">CYBERSECURITY MEASURES</option>
						<option value="MENTORSHIP OFFER">MENTORSHIP OFFER</option>
						<option value="SCALING EXPERTISE">SCALING EXPERTISE</option>
						<option value="DATA MANAGEMENT">DATA MANAGEMENT</option>
					</select>
					<select id="search_criteria_3_drp" name="search_criteria_3_drp" class="form-select search-container-select" aria-label="party size">
						<option value="article_01+subject_01+verb_01+noun_01+preposition_02+clause_01">Article+Subject+Verb+Noun+Preposition+Clause</option>
						<option value="article_01+subject_01+verb_01+preposition_01+noun_01+clause_01">Article+Subject+Verb+Preposition+Noun+Clause</option>
						
						
						
						
					</select>
					<a id="search_btn" class="normal_button" href="#">Search</a>
				</div>
				<div class="clearfix"></div>
			</div>
		</form>
		</article>
		</div>
	</div>
	<!-- end of container-search -->
</div>
