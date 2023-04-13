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
	<c:url var="url" value="/admin/account"></c:url>

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
					<h4 class="text-center mt-4 mb-5">Account Manager</h4>

					<form class="row g-3" action="${ url }/hien-thi" method="post">

						<!-- Username -->
						<div class="col-md-6">
							<label class="form-label">Username</label> <input type="text"
								class="form-control" name="username" value="${ accountForm.username }" />
								<p style="color: red;">${ errorUname }</p>
						</div>
						<!-- matkhau -->
						<div class="col-md-6">
							<label class="form-label">Password</label> <input type="password"
								class="form-control" name="password" value="${ accountForm.matKhau }" />
								<p style="color: red;">${ errorPW }</p>
						</div>

						<!-- name -->
						<div class="col-md-6">
							<label class="form-label">Name</label> <input type="text"
								class="form-control" name="nameAcc" value="${ accountForm.ten }" />
								<p style="color: red;">${ errorName }</p>
						</div>
						<!-- ngay sinh -->
						<div class="col-md-6">
							<label class="form-label">Ngày sinh</label> <input type="text"
								class="form-control" name="birthday" value="${ accountForm.ngaySinh }" />
								<p style="color: red;">${ errorNgaySinh }</p>
						</div>

						<!-- SDT -->
						<div class="col-md-6">
							<label class="form-label">SĐT</label> <input type="text"
								class="form-control" name="sdt" value="${ accountForm.sdt }" />
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
												value="true" ${accountForm.gioiTinh == true ? "checked" : ""}>
											<label class="form-check-label"> Nam </label>
										</div>

										<div class="col-3 mt-2">
											<input class="form-check-input" type="radio" name="gioiTinh"
												value="false" ${accountForm.gioiTinh == false ? "checked" : ""}>
											<label class="form-check-label"> Nữ </label>
										</div>
									</div>
								</div>

							</div>
						</div>

						<!-- email -->
						<div class="col-md-6">
							<label class="form-label">Email</label> <input type="text"
								class="form-control" name="email" value="${ accountForm.email }" />
								<p style="color: red;">${ errorEmail }</p>
						</div>

						<!-- trang thai -->
						<div class="col-md-6">
							<legend class="col-form-label col-sm-2 pt-0">Trạng thái</legend>
							<div class="col-sm-10 mt-4">
								<div class="form-check">
									<div class="row">
										<div class="col-5 mt-2">
											<input class="form-check-input" type="radio" name="trangThai"
											value="true" ${accountForm.trangThai == true ? "checked" : ""}>
										<label class="form-check-label"> Đang hoạt động </label>
										</div>

										<div class="col-5 mt-2">
											<input class="form-check-input" type="radio" name="trangThai"
											value="false" ${accountForm.trangThai == false ? "checked" : ""}>
										<label class="form-check-label"> Ngừng hoạt động </label>
										</div>
									</div>
								</div>

							</div>
						</div>
						
						<!-- diaChi -->
						<div class="col-md-6">
							<label class="form-label">Địa chỉ</label> <input type="text"
								class="form-control" name="address" value="${ accountForm.diaChi }"/>
								<p style="color: red;">${ errorDiaChi }</p>
						</div>

						<!-- chuc vu -->
						<div class="col-md-6">
							<legend class="col-form-label col-sm-2 pt-0">Chức vụ</legend>
							<div class="col-sm-10 mt-4">
								<div class="form-check">
									<div class="row">
										<div class="col-3 mt-2">
											<input class="form-check-input" type="radio" name="chucVu"
											value="true" ${accountForm.chucVu == true ? "checked" : ""}>
										<label class="form-check-label"> Admin </label>
										</div>

										<div class="col-3 mt-2">
											<input class="form-check-input" type="radio" name="chucVu"
											value="false" ${accountForm.chucVu == false ? "checked" : ""}>
										<label class="form-check-label"> Khách hàng </label>
										</div>
									</div>
								</div>

							</div>
						</div>

						<!-- add -->
						<div class="col-6 text-center mt-5">
							<button type="submit" class="btn btn-warning"
								style="min-width: 100px" formaction="${ url }/add">Add</button>
						</div>
						<!-- update -->
						<div class="col-6 text-center mt-5">
							<button type="submit" class="btn btn-success"
								style="min-width: 100px" formaction="${ url }/update">Update</button>
						</div>
					</form>

					<!-- table -->
					<div class="row mt-5">
						<table class="table table-bordered">
							<thead>
								<tr>
									<th>Username</th>
									<th>Name</th>
									<th>Ngày sinh</th>
									<th>Giới tính</th>
									<th>Trạng thái</th>
									<th>Chức vụ</th>
									<th>Edit</th>
								</tr>
							</thead>
							<tbody>
							<c:forEach items="${ listAccount }" var="i">
								<tr> 
								  <td>${ i.username }</td>
								  <td>${ i.ten }</td>
								  <td>${ i.ngaySinh }</td>
								  <td>
								    <c:if test="${ i.gioiTinh == 'true' }">Nam</c:if>
							        <c:if test="${ i.gioiTinh == 'false' }">Nữ</c:if>
							      </td>
								  <td>
								    <c:if test="${ i.trangThai == 'true' }">Đang Hoạt động</c:if>
							        <c:if test="${ i.trangThai == 'false' }">Ngừng hoạt động</c:if>
								  </td>
								  <td>
								    <c:if test="${ i.chucVu == 'true' }">Admin</c:if>
							        <c:if test="${ i.chucVu == 'false' }">Khách hàng</c:if>
								  </td>
								  <td>
									<a href="${ url }/delete?uname=${i.username}"><i class="fa-solid fa-trash"></i></a> 
									<a href="${ url }/detail?uname=${i.username}"><i class="fa-solid fa-pen"></i></a>
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