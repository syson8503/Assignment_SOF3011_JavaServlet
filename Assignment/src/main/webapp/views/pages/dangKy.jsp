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
	<c:url var="url" value="/admin/product"></c:url>

	<header class="bg-success-subtle">
		<jsp:include page="/views/layout/header.jsp"></jsp:include>
	</header>

	<div class="main">
		<div class="container">
			<h3 class="mb-3 text-center">Đăng ký</h3>

			<div class="row">
				<div class="col-2"></div>
				<div class="col-8">
					<form class="row mt-4" action="/Assignment/Register/dang-ky" method="post">
                      <p style="color: green;">${ error }</p>
						<!-- Username -->
						<div class="col-md-6">
							<label class="form-label">Username</label> <input type="text"
								class="form-control" name="username" />
							<p style="color: red;">${ errorUname }</p>
						</div>
						<!-- matkhau -->
						<div class="col-md-6">
							<label class="form-label">Password</label> <input type="password"
								class="form-control" name="password" />
							<p style="color: red;">${ errorPW }</p>
						</div>

						<!-- name -->
						<div class="col-md-6">
							<label class="form-label">Name</label> <input type="text"
								class="form-control" name="nameAcc" />
							<p style="color: red;">${ errorName }</p>
						</div>
						<!-- ngay sinh -->
						<div class="col-md-6">
							<label class="form-label">Ngày sinh</label> <input type="text"
								class="form-control" name="birthday" />
							<p style="color: red;">${ errorNgaySinh }</p>
						</div>

						<!-- SDT -->
						<div class="col-md-6">
							<label class="form-label">SĐT</label> <input type="text"
								class="form-control" name="sdt" />
							<p style="color: red;">${ errorSDT }</p>
						</div>

						<!-- gioiTinh -->
						<div class="col-md-6">
							<legend class="col-form-label col-sm-2 pt-0">Giới tính</legend>
							<div class="col-sm-10 mt-4">
								<div class="form-check">
									<div class="row">
										<div class="col-3 mt-2">
											<input class="form-check-input" type="radio" name="gioiTinh"
												value="true"
												${accountForm.gioiTinh == true ? "checked" : ""}> <label
												class="form-check-label"> Nam </label>
										</div>

										<div class="col-3 mt-2">
											<input class="form-check-input" type="radio" name="gioiTinh"
												value="false"
												${accountForm.gioiTinh == false ? "checked" : ""}> <label
												class="form-check-label"> Nữ </label>
										</div>
									</div>
								</div>

							</div>
						</div>

						<!-- email -->
						<div class="col-md-6">
							<label class="form-label">Email</label> <input type="text"
								class="form-control" name="email" />
							<p style="color: red;">${ errorEmail }</p>
						</div>

						<!-- diaChi -->
						<div class="col-md-6">
							<label class="form-label">Địa chỉ</label> <input type="text"
								class="form-control" name="address" />
							<p style="color: red;">${ errorDiaChi }</p>
						</div>
						
						<div class="col-12 text-center">
							<button type="submit" class="btn btn-warning mt-4 mb-4"
								formaction="/Assignment/Register/dang-ky">Register</button>
						</div>
					</form>
				</div>
				<div class="col-2"></div>
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