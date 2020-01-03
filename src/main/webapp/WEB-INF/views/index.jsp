<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- Latest compiled and minified CSS -->
<c:import url="./template/boot.jsp" />
</head>
<body>
	<c:import url="./template/nav.jsp" />

	<div class="container">
		<form action="./">
				<select name="lang">
						<option >ko</option>
						<option>en</option>
				</select>
				
				<button>Change</button>
		</form>


		<h1>
			<spring:message code="hello"></spring:message>
		
			<spring:message code="hello2" text="No messssage!!" var="t"></spring:message>
			
			
			<div>
			<c:if test="${ not empty member}">
				<spring:message code="loginMessage" arguments="${member.id},${member.email}" argumentSeparator=","></spring:message>
			</c:if>
			</div>
		</h1>

		<img alt="iu.jpg입니다" src="./images/iu.jpg">

		<h1>${t}</h1>
	</div>

</body>
</html>