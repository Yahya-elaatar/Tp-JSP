<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
<title>Students</title>
</head>
<body class="bg-light">


<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <div class="container-fluid">
    <a class="navbar-brand" href="#">Navbar</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="StudentController">Students</a>
        </li>
       
         <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="FiliereController">Filiere</a>
        </li>
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="RoleController">Role</a>
        </li>
 
 
     
      </ul>
     
    </div>
  </div>
</nav>
<div class="container">
        <form action="StudentController" method="post">
        <div class="container">
            <h2>Student Form</h2>
            <div class="col-3">
                <label for="firstName" class="form-label">First Name:</label>
                <input type="text" id="firstName" name="firstName" value="${student.firstName}" class="form-control" required>
            </div>
            <div class="col-3"> 
                <label for="lastName" class="form-label">Last Name:</label>
                <input type="text" id="lastName" name="lastName" value="${student.lastName }" class="form-control" required>
            </div>
            <div class="col-3">
                <label for="telephone" class="form-label">Telephone:</label>
                <input type="tel" id="telephone" name="telephone" value="${student.telephone }"  class="form-control" required>
            </div>
			<div class="col-3">
                <label for="email" class="form-label">Email:</label>
                <input type="email" id="email" name="email" value="${student.login }" class="form-control" required>
            </div>
            <div class="col-3">
                <label for="password" class="form-label">Password:</label>
                <input type="password" id="password" name="password" value="${student.password }" class="form-control" required>
            </div>
            <div class="col-3 mb-3" >
		        <label for="filiere" class="form-label">Filiere:</label>
		        <select id="filiereId" name="filiereId" class="form-control" required>
		            <c:forEach items="${filieres}" var="f" >
		                <option value="${f.id}">${f.name}</option>
		            </c:forEach>
		        </select>
		    </div>
			<input type="hidden" name="_method" value="${type}">
			<input type="hidden" name="studentToUpdate" value="${student.id}">
            <button type="submit" class="btn btn-primary">Submit</button>
            </div>
        </form>

        <div class="table-responsive mt-3">
            <table class="table table-striped table-bordered">
                <thead class="table">
                    <tr>
                        <th>ID</th>
                        <th>Email</th>
                        <th>First Name</th>
                        <th>Last Name</th>
                        <th>Telephone</th>
                        <th>Filiere</th>
                        <th>Action</th>
                    </tr>
                </thead>
                <tbody>
                   <c:forEach items="${students}" var="s">
                    <tr>
                        <td>${s.id}</td>
                        <td>${s.login}</td>
                        <td>${s.firstName}</td>
                        <td>${s.lastName}</td>
                        <td>${s.telephone}</td>
                        <td>${s.filiere != null ? s.filiere.name : ''}</td>
                        <td>
						    <div style="display: flex; gap: 10px;">
						        <form action="StudentController" method="post">
						            <input type="hidden" name="_method" value="delete">
						            <input type="hidden" name="studentToDelete" value="${s.id}">
						            <button type="submit" class="btn btn-danger">Delete</button>
						        </form>
						        <form action="StudentController" method="post">
						            <input type="hidden" name="_method" value="findAll">
						            <input type="hidden" name="studentToGet" value="${s.id}">
						            <button type="submit" class="btn btn-success">Update</button>
						        </form>
						    </div>
						</td>

                    </tr>
                   </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
<ul>
</ul>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.min.js" integrity="sha384-BBtl+eGJRgqQAUMxJ7pMwbEyER4l1g+O15P+16Ep7Q9Q+zqX6gSbd85u4mG4QzX+" crossorigin="anonymous"></script>
</body>
</html>