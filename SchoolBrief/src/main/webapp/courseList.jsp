<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>list des cours </title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css" integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn" crossorigin="anonymous">

</head>
<body>
<div class="container">
    <div class="row my-4">
        <div class="col-md-10 mx-auto">
            <div class="card">
                <div class="card-body bg-light">

				    <div class="clearfix">
				      <button type="button" class="insertbtn"><a href="studentAdd.jsp">Add Course</a></button>
				      <button type="button" class="updatebtn"><a href="listentUpdate.jsp">Update Course</a></button>
				      <button type="button" class="updatebtn"><a href="profList.jsp">Prof Managment</a></button>
				      <button type="button" class="updatebtn"><a href="studentList.jsp">Student Managment</a></button>
				      <button type="button" class="cancelbtn"><a href="login.jsp">Log out</a></button>
				    </div>

                    <table class="table table-hover">
                        <thead>
                            <tr>
                                <th scope="col">date</th>
                                <th scope="col">name</th>
                                <th scope="col">Professeur Id</th>
                                <th scope="col">Student Id</th>
                                <th scope="col">Action</th>
                            </tr>
                        </thead>
                        <tbody>
                        	  <c:forEach  items="${listCourse}" var="cour">
							  <tr>
							  	<td><c:out value="${cour.date}" /></td>
							  	<td><c:out value="${cour.name}" /></td>
							  	<td><c:out value="${cour.professeur_id}" /></td>
							  	<td><c:out value="${cour.student_id}" /></td>
							  	<td>
							  	        <form method="post" class="mr-1" action="update">
                                            <input type="hidden" name="id" value="  <c:out value="${cour.cour_id}"/>">
                                            <button class="btn bnt-sm btn-warning"><i class="fa fa-edit"></i></button>
                                        </form>
                                        <form method="post" class="mr-1" action="delete">
                                            <input type="hidden" name="id" value="<c:out value="${cour.cour_id}" />" >
                                            <button class="btn bnt-sm btn-danger"><i class="fa fa-trash"></i></button>
                                        </form>
							  	</td>
							  </tr>
							  </c:forEach>
	  
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>