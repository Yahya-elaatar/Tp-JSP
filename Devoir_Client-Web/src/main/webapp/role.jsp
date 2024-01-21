<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>

<title>Insert title here</title>


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
</head>
<body>


<div class="container">
 <form action="RoleController" method="post" >
  <div class="container">
            <h2 >Role Form</h2>
            <div  class="col-3 mb-3">
                <label for="name" class="form-label">Role Name:</label>
                <input type="text" id="name" name="name" value="${role.name}" class="form-control "  required>
            </div>
			<input type="hidden" name="_method" value="${type}">
			<input type="hidden" name="roleToUpdate" value="${role.id}">
            <button type="submit" class="btn btn-primary">Submit</button>
            </div>
        </form>
        
        
        
        <table class="table">
  <thead>
    <tr>
     <th scope="col">ID</th>
      <th scope="col">NAME</th>
      <th scope="col">Actions</th>
    </tr>
  </thead>
  
  <tbody>
  <c:forEach items="${roles}" var="r">
    <tr>
    
      <td>${r.id}</td>
      <td>${r.name}</td>
      <td>
      
      	<div style="display: flex; gap: 10px;">
						        <form action="RoleController" method="post">
						            <input type="hidden" name="_method" value="delete">
						            <input type="hidden" name="roleToDelete" value="${r.id}">
						            <button type="submit" class="btn btn-danger">Delete</button>
						        </form>
						        <form action="RoleController" method="post">
						            <input type="hidden" name="_method" value="findAll">
						            <input type="hidden" name="roleToGet" value="${r.id}">
						            <button type="submit" class="btn btn-warning">Update</button>
						        </form>
						    </div>
      
      
      </td>
    </tr>
    </c:forEach>
  
  </tbody>
</table>
</div>

</body>
</html>