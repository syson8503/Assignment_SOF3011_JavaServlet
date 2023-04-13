<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link
      rel="stylesheet"
      href="/Assignment/icon/fontawesome-free-6.2.1-web/fontawesome-free-6.2.1-web/css/all.css"
    />
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD"
	crossorigin="anonymous">
<link rel="stylesheet" href="/Assignment/css/style.css" />
</head>
<body>
<c:url var="url" value="/admin/category"></c:url>

<header class="bg-success-subtle">
<jsp:include page="/views/layout/header.jsp"></jsp:include>
</header>

<div class="main">

<div class="container">
<div class="row">

<div class="col-2 mt-4">
<!-- menu -->
<jsp:include page="/views/layout/menuManager.jsp"></jsp:include>
</div>

<div class="col-10">
<h4 class="text-center mt-4 mb-5">Category Manager</h4>

        <form class="row g-3" action="/category/hien-thi" method="post">
          <div class="col-md-3"></div>
          
          <!-- name -->
          <div class="col-md-6">
            <label class="form-label">Name</label>
            <input type="text" class="form-control" name="nameCategory" value="${ categoryForm.tenLoai }"/>
            <p style="color: red;">${ errorName }</p>
          </div>
          
          <div class="col-md-3"></div>
          
          <div class="col-3"></div>
          <!-- add -->
          <div class="col-3 text-center mt-5">
            <button
              type="submit"
              class="btn btn-warning"
              style="min-width: 100px"
              formaction="${ url }/add" >
              Add
            </button>
          </div>
          
          <!-- update -->
          <div class="col-3 text-center mt-5">
            <button
              type="submit"
              class="btn btn-success"
              style="min-width: 100px"
              formaction="${ url }/update"
            >
              Update
            </button>
          </div>
          <div class="col-3"></div>
</form>

          <!-- table -->
          <div class="row mt-5">
            <table class="table table-bordered">
              <thead>
                <tr>
                  <th>Id</th>
                  <th>Name</th>
                </tr>
              </thead>
              <tbody>
              <c:forEach items="${ listCategory }" var="i">
                <tr>
                  <td>${ i.id }</td>
                  <td>${ i.tenLoai }</td>
                  <td>
                    <a href="${ url }/delete?idLoai=${ i.id }" ><i class="fa-solid fa-trash"></i></a>
                    <a href="${ url }/detail?idLoai=${ i.id }"><i class="fa-solid fa-pen"></i></a>
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

<footer class="bg-danger-subtle">
<jsp:include page="/views/layout/footer.jsp"></jsp:include>
</footer>

<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"
		integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.min.js"
		integrity="sha384-mQ93GR66B00ZXjt0YO5KlohRA5SY2XofN4zfuZxLkoj1gXtW8ANNCe9d5Y3eG5eD"
		crossorigin="anonymous"></script>
</body>
</html>