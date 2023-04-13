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
<c:url var="url" value="/client/about"></c:url>

<header class="bg-success-subtle">
<jsp:include page="/views/layout/header.jsp"></jsp:include>
</header>

<div class="main">
<!-- menu -->
<jsp:include page="/views/layout/menuClient.jsp"></jsp:include>

<div class="container mt-3">
<h3>Header1</h3>
    <p>
      Lorem ipsum dolor sit amet, consectetur adipisicing elit. Expedita saepe
      veniam quo consequuntur ad totam rem aliquid voluptates hic eos ullam,
      sequi nihil necessitatibus beatae perspiciatis perferendis, eveniet at
      esse vero molestiae debitis distinctio sunt modi. Repellat, eligendi,
      eius! Veritatis in veniam, tempora tempore ratione provident. Sunt nulla
      similique voluptates magni labore maxime tempore error sed necessitatibus
      ab. Quisquam, nisi.
    </p>
    <h3>Header2</h3>
    <p>
      Lorem ipsum dolor sit amet, consectetur adipisicing elit. Expedita saepe
      veniam quo consequuntur ad totam rem aliquid voluptates hic eos ullam,
      sequi nihil necessitatibus beatae perspiciatis perferendis, eveniet at
      esse vero molestiae debitis distinctio sunt modi. Repellat, eligendi,
      eius! Veritatis in veniam, tempora tempore ratione provident. Sunt nulla
      similique voluptates magni labore maxime tempore error sed necessitatibus
      ab. Quisquam, nisi.
    </p>
    <h3>Header3</h3>
    <p>
      Lorem ipsum dolor sit amet, consectetur adipisicing elit. Expedita saepe
      veniam quo consequuntur ad totam rem aliquid voluptates hic eos ullam,
      sequi nihil necessitatibus beatae perspiciatis perferendis, eveniet at
      esse vero molestiae debitis distinctio sunt modi. Repellat, eligendi,
      eius! Veritatis in veniam, tempora tempore ratione provident. Sunt nulla
      similique voluptates magni labore maxime tempore error sed necessitatibus
      ab. Quisquam, nisi.
    </p>
    <h3>Header4</h3>
    <p>
      Lorem ipsum dolor sit amet, consectetur adipisicing elit. Expedita saepe
      veniam quo consequuntur ad totam rem aliquid voluptates hic eos ullam,
      sequi nihil necessitatibus beatae perspiciatis perferendis, eveniet at
      esse vero molestiae debitis distinctio sunt modi. Repellat, eligendi,
      eius! Veritatis in veniam, tempora tempore ratione provident. Sunt nulla
      similique voluptates magni labore maxime tempore error sed necessitatibus
      ab. Quisquam, nisi.
    </p>
    <h3>Header5</h3>
    <p>
      Lorem ipsum dolor sit amet, consectetur adipisicing elit. Expedita saepe
      veniam quo consequuntur ad totam rem aliquid voluptates hic eos ullam,
      sequi nihil necessitatibus beatae perspiciatis perferendis, eveniet at
      esse vero molestiae debitis distinctio sunt modi. Repellat, eligendi,
      eius! Veritatis in veniam, tempora tempore ratione provident. Sunt nulla
      similique voluptates magni labore maxime tempore error sed necessitatibus
      ab. Quisquam, nisi.
    </p>
    <h3>Header6</h3>
    <p>
      Lorem ipsum dolor sit amet, consectetur adipisicing elit. Expedita saepe
      veniam quo consequuntur ad totam rem aliquid voluptates hic eos ullam,
      sequi nihil necessitatibus beatae perspiciatis perferendis, eveniet at
      esse vero molestiae debitis distinctio sunt modi. Repellat, eligendi,
      eius! Veritatis in veniam, tempora tempore ratione provident. Sunt nulla
      similique voluptates magni labore maxime tempore error sed necessitatibus
      ab. Quisquam, nisi.
    </p>
</div>

<!-- Banner -->
<div class="container">
<div class="row mt-5">

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