<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="/Assignment/icon/fontawesome-free-6.2.1-web/fontawesome-free-6.2.1-web/css/all.css" />
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD"
	crossorigin="anonymous">
<link rel="stylesheet" href="/Assignment/css/style.css" />
</head>
<body>
	<c:url var="url" value="/client/detail"></c:url>

	<header class="bg-success-subtle">
		<jsp:include page="/views/layout/header.jsp"></jsp:include>
	</header>

	<div class="main">
		<!-- menu -->
		<jsp:include page="/views/layout/menuClient.jsp"></jsp:include>

		<!-- category -->
		<div class="container">
			<div class="row">

				<div class="col-lg-2 col-md-3 col-sm-4 mt-5">
					<div class="card border border-0 border-end" style="width: 100%">
						<div class="card-body">
							<ul class="list-group list-group-flush">
								<li class="list-group-item"><a class="nav-link"
									href="#sanPham">Tất cả</a></li>
								<li class="list-group-item"><a class="nav-link"
									href="#sanPham/Canon">Canon</a></li>
								<li class="list-group-item"><a class="nav-link"
									href="#sanPham/Nikon">Nikon</a></li>
								<li class="list-group-item"><a class="nav-link"
									href="#sanPham/SamSung">SamSung</a></li>
								<li class="list-group-item"><a class="nav-link"
									href="#sanPham/Sony">Sony</a></li>
							</ul>
						</div>
					</div>
				</div>

				<!-- san pham -->
				<div class="col-lg-10 col-md-9 col-sm-8">
					<div class="row">
						<h2 class="text-center">Featured Product</h2>

                    <form action="${ url }/add-gio-hang" method="post">
						<div class="card mb-3 border border-0" style="max-width: 90%;">
							<div class="row g-0">
								<div class="col-md-4">
									<img src="/Assignment/image/${ productDetail.hinhAnh }" class="img-fluid rounded-start" alt="..." style="width: 100%">
								</div>
								<div class="col-md-8">
									<div class="card-body">
									    <p class="card-text">Loại hàng: ${ productDetail.category.tenLoai }</p>
										<h2 class="card-title">${ productDetail.tenSP }</h2>
										<p class="card-text text-warning">
										<i class="fa-solid fa-star"></i>
										<i class="fa-solid fa-star"></i>
										<i class="fa-solid fa-star"></i>
										<i class="fa-solid fa-star"></i>
										<i class="fa-solid fa-star"></i>
										</p>
										<h3 class="card-text text-danger">đ ${ productDetail.price }</h3>
										<div class="row">
										<div class="col-4">
										  <div class="mb-3 row">
                                            <label class="col-sm-5 col-form-label">Số lượng</label>
                                               <div class="col-sm-7">
                                                 <input type="number" class="form-control" name="soLuong" value="1">
                                               </div>
                                          </div>
                                        </div>
                                        <div class="col-8">
                                        <p class="card-text mt-2 text-secondary-emphasis">${ productDetail.quantity } sản phẩm có sẵn</p>
                                        </div>
										</div>
										
										<div class="position-absolute bottom-0 start-30">
										<button formaction="${ url }/add-gio-hang" class="btn btn-outline-warning">
										<i class="fa-solid fa-cart-shopping"></i></button>
										<button formaction="" class="btn btn-outline-danger"><i class="fa-solid fa-heart"></i></button>
										<button formaction="" class="btn btn-danger fw-bolder">Mua ngay</button>
										</div>
									</div>
								</div>
							</div>
						</div>
</form>

					</div>
				</div>
			</div>
		</div>


		<!-- Banner -->
		<div class="container">
			<div class="row mt-3">

				<div class="col-lg-6">
					<img src="/Assignment/image/banner-1.jpg" alt=""
						style="width: 100%" />
				</div>

				<div class="col-lg-6">
					<img src="/Assignment/image/banner-2.jpg" alt=""
						style="width: 100%" />
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