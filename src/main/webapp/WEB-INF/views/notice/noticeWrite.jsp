<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../template/boot.jsp" />
<c:import url="../template/summernote.jsp" />
</head>
<body>
<c:import url="../template/nav.jsp" />

<div class="container">
		  <h1> Notice Write</h1>
		  <form action="./noticeWrite" method="post" id="frm" onsubmit=true enctype="multipart/form-data">
		 
		  
		    <div class="form-group">
		      <label for="name">TITLE</label>
		      <input type="text" class="form-control" id="title" placeholder="Enter TITLE" name="title" value="${dto.title}">
		    </div>
		    
		    <div class="form-group">
		      <label for="writer">WRITER</label>
		      <input type="text" class="form-control" id="writer"  name="writer" value="${member.name}" readonly="readonly">
		    </div>
		    
		    <div class="form-group">
	      		<label for="comment">Contents:</label>
	      		<textarea class="form-control" rows="5" id="contents" placeholder="Enter contents" name="contents" >${dto.contents}</textarea>
	   		</div>
			
			
			
			<div id="files">	   		
		    	<div class="form-group" title="parent" >
	      			<label class="control-label col-sm-2" for="file">Files:</label>
	      			<div class="col-sm-9">
	      				<input type="file" class="form-control " id="file" name="files">
	      			</div>
		    	<div class="col-sm-1">
	      			<input type="button"  name="files"  class= "btn btn-danger del" value="delete">
	   			</div>
				</div>
			</div>	   		
	   		
	   		
	   		<input type="button" value="add file" class="btn btn-default" id="btn">
		    
		    
		    <button class="btn btn-default" id="submit">SUBMIT</button>
		    <!-- <input type="button" id="btn2" value="test">  -->
			<a href="./noticeList.jsp" class="btn btn-default">LIST</a>
		  </form>
		  
		
		</div>
		
		<script type="text/javascript">
				var files = $('#files').html();
				$('#files').empty();

				var count =0;
				var index= 0;

				//섬머노트(에디터)
				$("#contents").summernote({
			        height: 400
				});
					
				//파일 폼 5개까지만 추가
				$('#btn').click(function() {
				if(count<5){
					$('#files').append(files);
					count++;
				}else {
					alert("5개 이상 금지");
					}
				});

				//파일 삭제
				$("#files").on("click",".del",function() {
				
				$(this).parent().parent().remove();
				count--;
				
				});
				

				
		</script>
		

</body>
</html>