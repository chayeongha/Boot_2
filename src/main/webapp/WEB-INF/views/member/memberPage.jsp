<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../template/boot.jsp" />
</head>
<body>
<c:import url="../template/nav.jsp" />

	<div class="container">
  <h2>member Page</h2>
  
  <form action="./memberLogin">
    
    <div class="form-group">
      <label for="id">id:</label>
      <input type="text" class="form-control" id="id" name="id" value="${member.id}" readonly="readonly">
    </div>
    
    <div class="form-group">
      <label for="name">name</label>
      <input type="text" class="form-control" id="name" name="name" value="${member.name}" readonly="readonly">
    </div>
    
     <div class="form-group">
      <label for="name">email</label>
      <input type="text" class="form-control" id="email" name="email" value="${member.email}" readonly="readonly">
    </div>
    
    	<div class="form-group">
		 <img alt="이미지" src="../upload/${member.memberFilesVO.fname}">
		</div>
		
		<div class="form-group">
   			<a class="btn btn-primary" href="./memberFileDown?fnum=${member.memberFilesVO.fnum}">fileDown</a>
  		</div>
  
    <div>
    <button type="submit" class="btn btn-default">수정</button>
 	</div>
  
  </form>
</div>



</body>
</html>