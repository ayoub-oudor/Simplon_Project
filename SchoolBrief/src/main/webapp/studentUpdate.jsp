<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>update Student</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css" integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn" crossorigin="anonymous">
</head>
<body>

<form action="StudentServlet"  method="post">
<div class="container">
    <div class="row my-4">
        <div class="col-md-8 mx-auto"> 
            <div class="card">
                <div class="card-header">update student</div>
                <div class="card-body bg-light">
                    
                        <div class="form-group">
                            <label for="nom">nom*</label>
                            <input type="text" name="nom" class="form-control" placeholder="nom">
                        </div>
                        <div class="form-group">
                            <label for="prenom">prenom*</label>
                            <input type="text" name="prenom" class="form-control" placeholder="prenom">
                        </div>
                        <div class="form-group">
                            <button class="btn btn-primary" type="submit" name="submit">Update</button>
                        </div>
                    
                </div>
            </div>
        </div>
    </div>
</div>
</form>
</body>
</html>