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
<c:url var="url" value="/admin/product"></c:url>

<header class="bg-success-subtle">
<jsp:include page="/views/layout/header.jsp"></jsp:include>
</header>

<div class="main">
<div class="container">
    <div class="row text-center mt-5">
      <div class="col-lg-4 col-md-2"></div>
      <div class="col-lg-4 col-md-8">
        <h3 class="mb-3">Đổi mật khẩu</h3>
        <form class="mt-4" action="/Assignment/forgot-password/quen-mat-khau" method="post">
        <p style="color: green;">${ error }</p>
          <!-- account -->
          <div class="row mb-3">
            <label class="col-sm-4 col-form-label">Username</label>
            <div class="col-sm-8">
              <input type="text" class="form-control" name="username" value="${ account.username }"/>
              <p style="color: red;">${ errorUName }</p>
            </div>
          </div>
          <!-- password -->
          <div class="row mb-3">
            <label class="col-sm-4 col-form-label"
              >Password</label
            >
            <div class="col-sm-8">
              <input
                type="password"
                class="form-control"
                name="password"
              />
              <p style="color: red;">${ errorPW }</p>
            </div>
          </div>
          <div class="row mb-3">
            <label class="col-sm-4 col-form-label"
              >New password</label
            >
            <div class="col-sm-8">
              <input
                type="password"
                class="form-control"
                name="newPW"
              />
              <p style="color: red;">${ errorNewPW }</p>
            </div>
          </div>
          <div class="row mb-3">
            <label class="col-sm-4 col-form-label"
              >Confirm</label
            >
            <div class="col-sm-8">
              <input
                type="password"
                class="form-control"
                name="confirm"
              />
              <p style="color: red;">${ errorConfirm }</p>
            </div>
          </div>

          <button
            type="submit"
            class="btn btn-danger mt-4 mb-4"
            formaction="/Assignment/forgot-password/quen-mat-khau"
          >
            Lưu thay đổi
          </button>
        </form>
      </div>

      <div class="col-lg-4 col-md-2"></div>
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