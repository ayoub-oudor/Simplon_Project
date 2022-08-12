<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Delete Cousre</title> 
<link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
<form action="CourseServlet"  method="post">
  <div class="container">
    <h1>Delete Course</h1>
    
    <label for="name"><b>Delete Course</b></label>
    <input type="text" placeholder="delete" name="delete" required minlength="3">

    <div class="clearfix">
      <button type="button" class="cancelbtn"><a href="login.jsp">Log out</button>
      <button type="submit" class="delete">Delete</button>
      <button type="button" class="courbtn"><a href="courseList.jsp">List des cours</button>
    </div>
  </div>
</form>
</body>
</html>