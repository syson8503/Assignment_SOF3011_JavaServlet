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
<c:url var="url" value="/client/home"></c:url>

<header class="bg-success-subtle">
<jsp:include page="/views/layout/header.jsp"></jsp:include>
</header>

<div class="main">
<!-- menu -->
<jsp:include page="/views/layout/menuClient.jsp"></jsp:include>

<!-- banner -->
<div class="container">
<div class="row">
<div class="card border border-0">
  <img src="/Assignment/image/banner.jpg" class="card-img" alt="..." width="100%">
  <div class="card-img-overlay" style="margin-left: 100px; margin-top: 50px">
    
    <h3 class="card-title text-success-emphasis fw-bold mt-5">FRUIT FRESH</h3>
    <h1 class="card-title text-dark fw-bold mt-3">Vegetable</h1>
    <h1 class="card-title text-dark fw-bold">100% Organic</h1>
    <p class="card-text text-dark mt-5"><small>Free Pickup and Delivery Available</small></p>
  </div>
</div>
</div>
</div>

<!-- san pham -->
<div class="container">
<div class="row">
<h2 class="text-center mt-3">Featured Product</h2>

<c:forEach items="${ listProducts }" var="i">
<div class="col-lg-3 col-md-4 col-sm-6">
<div class="card border border-0" style="width: 100%;">
<a href="${ url }/detail?idDetail=${i.id}" class="nav-link link-dark">
  <img src="/Assignment/image/${ i.hinhAnh }" class="card-img-top" alt="..." style="width: 100%"></a>
  <div class="card-body mx-auto">
  <a href="${ url }/detail?idDetail=${i.id}" class="nav-link link-dark">
    <h5 class="card-title text-center">${ i.tenSP }</h5></a>
    <p class="card-text  fw-medium text-center">$<span class="text-danger">${ i.price }</span></p>
    <a href="#" class="btn btn-outline-danger rounded-circle" >
    <i class="fa-solid fa-heart"></i></a>
    <a href="${ url }/detail?idDetail=${i.id}" class="btn btn-outline-warning rounded-circle" ><i class="fa-solid fa-cart-shopping"></i></a>
  </div>
</div>
</div>
</c:forEach>

</div>

<div class="row text-center mt-5">
<nav aria-label="Page navigation example">
  <ul class="pagination justify-content-center">
    <li class="page-item">
      <a class="page-link link-dark " href="#" aria-label="Previous">
        <span aria-hidden="true">&laquo;</span>
      </a>
    </li>
    <li class="page-item"><a class="page-link link-dark" href="#">1</a></li>
    <li class="page-item"><a class="page-link link-dark" href="#">2</a></li>
    <li class="page-item"><a class="page-link link-dark" href="#">3</a></li>
    <li class="page-item">
      <a class="page-link link-dark" href="#" aria-label="Next">
        <span aria-hidden="true">&raquo;</span>
      </a>
    </li>
  </ul>
</nav>
</div>
</div>

<!-- Banner -->
<div class="container">
<div class="row mt-3">

<div class="col-lg-6">
<img src="/Assignment/image/banner-1.jpg" alt="" style="width: 100%" />
</div>

<div class="col-lg-6">
<img src="/Assignment/image/banner-2.jpg" alt="" style="width: 100%" />
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