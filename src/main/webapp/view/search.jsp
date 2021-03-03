<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="DAO.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html lang="en">

<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>Shop Homepage - Start Bootstrap Template</title>
<%@include file="../reuse.component/view/jsLib.jsp"%>
</head>

<body>
	<%@include file="../reuse.component/view/header.jsp"%>
	<!-- Page Content -->
	<div class="container">

		<div class="row">

			<div class="col-lg-3">

				<h1 class="my-4">Shop Name</h1>
				<div class="list-group">
					<a href="#" class="list-group-item">Category 1</a> <a href="#"
						class="list-group-item">Category 2</a> <a href="#"
						class="list-group-item">Category 3</a>
				</div>

			</div>
			<!-- /.col-lg-3 -->

			<div class="col-lg-9">

				<div id="carouselExampleIndicators" class="carousel slide my-4"
					data-ride="carousel">
					<ol class="carousel-indicators">
						<li data-target="#carouselExampleIndicators" data-slide-to="0"
							class="active"></li>
						<li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
						<li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
					</ol>
					<div class="carousel-inner" role="listbox">
						<div class="carousel-item active">
							<img class="d-block img-fluid" src="http://placehold.it/900x350"
								alt="First slide">
						</div>
						<div class="carousel-item">
							<img class="d-block img-fluid" src="http://placehold.it/900x350"
								alt="Second slide">
						</div>
						<div class="carousel-item">
							<img class="d-block img-fluid" src="http://placehold.it/900x350"
								alt="Third slide">
						</div>
					</div>
					<a class="carousel-control-prev" href="#carouselExampleIndicators"
						role="button" data-slide="prev"> <span
						class="carousel-control-prev-icon" aria-hidden="true"></span> <span
						class="sr-only">Previous</span>
					</a> <a class="carousel-control-next" href="#carouselExampleIndicators"
						role="button" data-slide="next"> <span
						class="carousel-control-next-icon" aria-hidden="true"></span> <span
						class="sr-only">Next</span>
					</a>
				</div>

				<div class="row">
					<%
						Object objProd = request.getAttribute("prods");
						boolean isAddAble = String.valueOf(request.getAttribute("isAddAble")).equals("1");
						
						ArrayList<ProductModel> productDaos = (ArrayList<ProductModel>) (objProd != null ? objProd
								: new ArrayList<ProductModel>());
						
						for (int i = 0; i < productDaos.size(); i++) {
					%>
					<div class="col-lg-4 col-md-6 mb-4">
						<div class="card h-100">
							<a href="./detail?idprod=<%=productDaos.get(i).getId()%>"><img
								class="card-img-top"
								src="https://cdnb.artstation.com/p/assets/images/images/030/035/871/large/sophie-williams-antiquephoneside.jpg"
								alt=""></a>
							<div class="card-body">
								<h4 class="card-title">
									<a href="./detail?idprod=<%=productDaos.get(i).getId()%>"><%=productDaos.get(i).getNameItems()%></a>
								</h4>
								<h5>
									<fmt:setLocale value="vi_VN" />
									<fmt:formatNumber value="<%=productDaos.get(i).getPrice()%>"
										type="currency" />
								</h5>
								<p class="card-text"><%=productDaos.get(i).getDescription()%></p>
							</div>
							<div class="card-footer">
								<small class="text-muted">&#9733; &#9733; &#9733;
									&#9733; &#9734;</small>
								<%
									if (isAddAble) {
								%>
								<form style="display: inline;" action="/MobileShop/home"
									method="POST">
									<input type="hidden" id="custId" name="action" value="addProd">
									<input type="hidden" id="custId" name="idProd"
										value="<%=productDaos.get(i).getId()%>">
									<button style="float: right;" type="submit"
										class="btn btn-outline-primary">
										<i class="fas fa-cart-plus"></i>
									</button>
								</form>
								<%
									}
								%>
							</div>

						</div>
					</div>
					<%
						}
					%>
					<%=productDaos.size() == 0 ? "</h4>Not found anything like what are you looking for!</h4>" : ""%>

				</div>
				<!-- /.row -->

			</div>
			<!-- /.col-lg-9 -->

		</div>
		<!-- /.row -->

	</div>
	<!-- /.container -->

	<%@include file="../reuse.component/view/footer.jsp"%>

</body>

</html>