<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>System</title>


<!-- Bootstrap Core CSS -->
<link
	href="<%=request.getContextPath()%>/resources/css/bootstrap.min.css"
	rel="stylesheet">

<!-- Custom CSS -->
<link href="<%=request.getContextPath()%>/resources/css/sb-admin-2.css"
	rel="stylesheet">

<!-- Custom Fonts -->
<link
	href="<%=request.getContextPath()%>/resources/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
<style type="text/css">
@font-face {
	font-family: 'Kaushan';
	font-style: normal;
	font-weight: 400;
	src: url('<%=request.getContextPath()%>/resources/fonts/kaushan1.woff2')
		format('woff2');
	unicode-range: U+0100-024F, U+1E00-1EFF, U+20A0-20AB, U+20AD-20CF,
		U+2C60-2C7F, U+A720-A7FF;
}

@font-face {
	font-family: 'Kaushan';
	font-style: normal;
	font-weight: 400;
	src: url('<%=request.getContextPath()%>/resources/fonts/kaushan2.woff2')
		format('woff2');
	unicode-range: U+0000-00FF, U+0131, U+0152-0153, U+02C6, U+02DA, U+02DC,
		U+2000-206F, U+2074, U+20AC, U+2212, U+2215, U+E0FF, U+EFFD, U+F000;
}

a.navbar-brand {
	font-family: 'Kaushan';
}

.prodlist {
	margin-bottom: 50px;
}
</style>

</head>

<body>

	<div id="wrapper">

		<!-- Navigation -->
		<nav class="navbar navbar-default navbar-static-top" role="navigation"
			style="margin-bottom: 0">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target=".navbar-collapse">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>

				<a class="navbar-brand" href="index.html">Bid$</a>
			</div>
			<!-- /.navbar-header -->

			<ul class="nav navbar-top-links navbar-right">
				<li><a href="/profile">Hey, ${loginForm.user.firstName}
						${loginForm.user.lastName} ! </a></li>
				<!-- /.dropdown -->
				<li class="dropdown"><a class="dropdown-toggle"
					data-toggle="dropdown" href="#"> <i class="fa fa-user fa-fw"></i>
						<i class="fa fa-caret-down"></i>
				</a>
					<ul class="dropdown-menu dropdown-user">
						<li><a href="profile"><i class="fa fa-user fa-fw"></i>
								User Profile</a></li>
						<li><a href="#"><i class="fa fa-gear fa-fw"></i> Settings</a>
						</li>
						<li class="divider"></li>
						<li><a href="logout"><i class="fa fa-sign-out fa-fw"></i>
								Logout</a></li>
					</ul> <!-- /.dropdown-user --></li>
				<!-- /.dropdown -->
			</ul>
			<!-- /.navbar-top-links -->

			<div class="navbar-default sidebar" role="navigation">
				<div class="sidebar-nav navbar-collapse">
					<ul class="nav" id="side-menu">
						<li class="sidebar-search">
							<div class="input-group custom-search-form">
								<input type="text" class="form-control" placeholder="Search...">
								<span class="input-group-btn">
									<button class="btn btn-default" type="button">
										<i class="fa fa-search"></i>
									</button>
								</span>
							</div> <!-- /input-group -->
						</li>
						<li><a class="active" href="feed"><i
								class="fa fa-dashboard fa-fw"></i> Latest Products</a></li>

						<li><a href="my_products"><i class="fa fa-table fa-fw"></i>
								My Products</a></li>
						<li><a href="#"><i class="fa fa-table fa-fw"></i> Won
								Products</a></li>
						<li><a href="BidsHistory"><i class="fa fa-edit fa-fw"></i>
								My Bids</a></li>

						<li><a href="#"><i class="fa fa-sitemap fa-fw"></i>
								Utilites<span class="fa arrow"></span></a>
							<ul class="nav nav-second-level">
								<li><a href="addProduct">Add Product</a></li>
								<li><a href="#">Add Card</a></li>
								<sec:authorize access="hasRole('Admin')">
									<li><a href="limit">Add Limit</a></li>
									<li><a href="block">Block user</a></li>
								</sec:authorize>

							</ul> <!-- /.nav-second-level --></li>
					</ul>
				</div>
				<!-- /.sidebar-collapse -->
			</div>
			<!-- /.navbar-static-side -->
		</nav>

		<!-- Page Content -->
		<div id="page-wrapper" style="background: #eee">
			<div class="container-fluid">
				<div class="row">
					<div class="col-lg-12">

						<div class="container prodlist">
							<div class="row" style="margin-top: 20px; margin-left: 150px;">
								<c:if test="${ empty loginForm.lp }">
									<br />
									<br />
									<br />
									<br />
									<div class="col-md-1"></div>
									<div class="col-md-6" style="border: 1px solid #a1a1a1;">
										<h2 style="color: #aaa; text-align: center;">
											No products available. <br />Get back soon, we'll still be
											here =)
										</h2>
									</div>
								</c:if>
								<c:if test="${not empty loginForm.lp }">
									<ul>
										<c:forEach items="${loginForm.lp}" var="prod">
											<br />
											<li
												style="list-style: none; background-image: none; background-repeat: none; background-position: 0;">
												<table>
													<tr>
														<td><img
															src="<%=request.getContextPath()%>/resources/img/3.jpg"
															height=150 width=150 alt=""></td>
														<td>
															<div class="panel"
																style="padding-right: 5px; margin: 0px; height: 150px; width: 550px;">
																<div class="row">
																	<div class="col-md-1"></div>
																	<div class="col-md-8">
																		<h3>${ prod.name }</h3>
																	</div>
																	<div class="col-md-3">
																		<br />
																		<form action="addBid">
																			<button type="submit" name="id_prod"
																				value="${ prod.idProduit }" class="btn btn-default ">Enter
																				Bid</button>
																		</form>
																	</div>
																</div>
																<div class="row">
																	<div class="col-md-1"></div>
																	<div class="col-md-5">

																		Min Price: <span style="color: blue">${ prod.prixMin }
																			<span class="glyphicon glyphicon-euro"></span>
																		</span>
																	</div>
																	<div class="col-md-6">
																		<span class="glyphicon glyphicon-user"></span> ${ prod.user.firstName }
																		${ prod.user.lastName }
																	</div>
																</div>
																<div class="row">
																	<div class="col-md-1"></div>
																	<div class="col-md-11">
																		<span class="glyphicon glyphicon-calendar"></span>
																		Expires on: ${ prod.dateExp }
																	</div>
																</div>
																<div class="row">
																	<div class="col-md-1"></div>
																	<div class="col-md-11">
																		<span style="color:#aaa">Description: ${prod.etat}</span>
																	</div>
																</div>
															</div>
														</td>
													</tr>
												</table>
											</li>
										</c:forEach>
									</ul>
								</c:if>
							</div>




						</div>
					</div>
					<!-- /.col-lg-12 -->
				</div>
				<!-- /.row -->
			</div>
			<!-- /.container-fluid -->
		</div>
		<!-- /#page-wrapper -->

	</div>
	<!-- /#wrapper -->

	<!-- jQuery -->
	<script src="<%=request.getContextPath()%>/resources/js/jquery.js"></script>

	<!-- Bootstrap Core JavaScript -->
	<script
		src="<%=request.getContextPath()%>/resources/js/bootstrap.min.js"></script>


</body>

</html>
