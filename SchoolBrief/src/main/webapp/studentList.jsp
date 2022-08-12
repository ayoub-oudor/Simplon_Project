<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>list des etudiants </title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css" integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn" crossorigin="anonymous">

</head>
<body>
<div class="container">
    <div class="row my-4">
        <div class="col-md-10 mx-auto">
            <div class="card">
                <div class="card-body bg-light">

				    <div class="clearfix">
				      <button type="button" class="insertbtn"><a href="studentAdd.jsp">Add student</a></button>
				      <button type="button" class="insertbtn"><a href="studentUpdate.jsp">Update student</a></button>
				      <button type="button" class="insertbtn"><a href="courseList.jsp">Course</a></button>
				      <button type="button" class="cancelbtn"><a href="login.jsp">Log out</a></button>
				    </div>

                    <table class="table table-hover">
                        <thead>
                            <tr>
                                <th scope="col">student id</th>
                                <th scope="col">nom</th>
                                <th scope="col">prenom</th>
                                <th scope="col">Action</th>
                            </tr>
                        </thead>
                        <tbody>
                        	  <c:forEach  items="${listStudent}" var="professeur">
							  <tr>
							  	<td><c:out value="${student.id}" /></td>
							  	<td><c:out value="${student.nom}" /></td>
							  	<td><c:out value="${student.prenom}" /></td>
							  	<td>
							  	        <form method="post" class="mr-1" action="update">
                                            <input type="hidden" name="id" value="  <c:out value="${student.student_id}"/>">
                                            <button class="btn bnt-sm btn-warning"><i class="fa fa-edit"></i></button>
                                        </form>
                                        <form method="post" class="mr-1" action="delete">
                                            <input type="hidden" name="id" value="<c:out value="${professeur.student_id}" />" >
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