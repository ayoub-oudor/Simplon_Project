<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Course</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css" integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn" crossorigin="anonymous">
</head>
<body>

<form action="CourseServlet"  method="post">
<div class="container">
    <div class="row my-4">
        <div class="col-md-8 mx-auto"> 
            <div class="card">
                <div class="card-header">Add Course</div>
                <div class="card-body bg-light">
                    
                        <div class="form-group">
                            <label for="nom">name*</label>
                            <input type="text" name="nom" class="form-control" placeholder="name">
                        </div>
                        <div class="form-group">
                            <label for="date">date*</label>
                            <input type="date" name="date" class="form-control" placeholder="date">
                        </div>
                        <div class="form-group">
                            <button class="btn btn-primary" type="submit" name="submit">Add</button>
                        </div>
                    
                </div>
            </div>
        </div>
    </div>
</div>
</form>
</body>
</html>