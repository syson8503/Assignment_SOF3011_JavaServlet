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
	<c:url var="url" value="/client/gio-hang"></c:url>

	<header class="bg-success-subtle">
		<jsp:include page="/views/layout/header.jsp"></jsp:include>
	</header>

	<div class="main">
		<!-- menu -->
		<jsp:include page="/views/layout/menuClient.jsp"></jsp:include>

		<div class="container">
		
		<form action="${ url }/tao-hoa-don" method="post">
		<p class="text-center" style="color: red;">${ error }</p>
		<p class="text-center" style="color: green;">${ errorTT }</p>
		<table class="table">
              <thead>
                <tr>
                  <th class="text-end"><input class="form-check-input mt-5" type="checkbox" value="${ i }" name="chkChonAll"/></th>
                  <th></th>
                  <th></th>
                  <th>Đơn giá</th>
                  <th>Số lượng</th>
                  <th>Số tiền</th>
                  <th>Thao tác</th>
                </tr>
              </thead>
              <tbody>
              <c:forEach items="${ listGioHang }" var="i">
                <tr>
                  <td class="text-end"><input class="form-check-input mt-5" type="checkbox" value="${ i.id }" name="chkChon"/></td>
                  <td class="text-end"><img src="/Assignment/image/${ i.productId.hinhAnh }" class="img-fluid rounded mx-auto d-block" style="width: 100px" /></td>
                  <td >
                     <h5 class="mt-4">${i.productId.tenSP}</h5>
                     <p>${i.productId.gioiThieu}</p>
                  </td>
                  <td><p class="mt-5 text-danger mb-2 fw-bold">$${i.donGia}</p></td>
                  <td><p class="mt-5">${i.soLuong}</p>
                  </td>
                  <td><p class="mt-5 text-danger mb-2 fw-bold">$${i.tong}</p></td>
                  <td>
                    <a href="${ url }/delete?id=${i.id}" class="btn btn-danger mt-5" >
                       <i class="fa-solid fa-delete-left"></i>
                    </a>
                  </td>
                </tr>
                </c:forEach>
              </tbody>
            </table>
            
            <div class="row border-bottom border-danger border-3">
            <div class="col-10"></div>
            <div class="col-2">
               <button formaction="${ url }/tao-hoa-don" class="btn btn-outline-danger fw-bold mt-5 mb-3" >
                       Tạo hoá đơn
               </button>
               </div>
            </div>
		</form>
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