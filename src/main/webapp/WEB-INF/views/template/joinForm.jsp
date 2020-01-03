<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<form action="./memberJoin" method="post" enctype="multipart/form-data">
		
			<div class="form-group">
				<label for="id">id:</label> 
				<input type="text"
					class="form-control" id="id" placeholder="Enter id"
					name="id">
			</div>
			
			<div class="form-group">
				<label for="pw">Password:</label> 
				<input type="password"
					class="form-control" id="pw" placeholder="Enter password"
					name="pw">
			</div>
			
			<div class="form-group">
				<label for="pw2">Password:</label> 
				<input type="password"
					class="form-control" id="pw2" placeholder="Enter password"
					name="pw2">
			</div>
			
			<div class="form-group">
				<label for="name">name:</label> 
				<input type="text"
					class="form-control" id="name" placeholder="Enter name"
					name="name">
			</div>
			
			<div class="form-group">
				<label for="email">email:</label> 
				<input type="email"
					class="form-control" id="email" placeholder="Enter eamil"
					name="email">
			</div>
			
			<div class="form-group">
				<label for="files">files:</label> 
				<input type="file"
					class="form-control" id="files" name="files">
			</div>
			
		
			<button type="submit" class="btn btn-default">Submit</button>
		</form>