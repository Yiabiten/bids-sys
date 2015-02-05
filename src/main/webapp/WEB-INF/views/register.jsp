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

<title>Bids System - Welcome !</title>

<!-- Bootstrap Core CSS -->
<link
	href="<%=request.getContextPath()%>/resources/css/bootstrap.min.css"
	rel="stylesheet">

<!-- Custom CSS -->

<link href="<%=request.getContextPath()%>/resources/css/agency.css"
	rel="stylesheet">

<!-- Custom Fonts -->
<link
	href="<%=request.getContextPath()%>/resources/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">
<link href="http://fonts.googleapis.com/css?family=Montserrat:400,700"
	rel="stylesheet" type="text/css">
<!--link href='http://fonts.googleapis.com/css?family=Kaushan+Script' rel='stylesheet' type='text/css'-->

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

#brnd {
	font-family: "Kaushan";
}
</style>

<link
	href='http://fonts.googleapis.com/css?family=Droid+Serif:400,700,400italic,700italic'
	rel='stylesheet' type='text/css'>
<link
	href='http://fonts.googleapis.com/css?family=Roboto+Slab:400,100,300,700'
	rel='stylesheet' type='text/css'>

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body id="page-top" class="index">

	<!-- Navigation -->
	<nav class="navbar navbar-default navbar-fixed-top">
		<div class="container">
			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header nav ">
				<a class="navbar-brand page-scroll" id="brnd"  href="index#page-top">Bid$</a>
			</div>


		</div>
		<!-- /.container-fluid -->
	</nav>


	<section id="contact">
		<div class="container">
			<div class="row">
				<div class="col-lg-12 text-center">
					<h2 class="section-heading">Join the plateform now !</h2>
					<h3 class="section-heading">and the market is yours</h3>
				</div>
			</div>

		</div>
	</section>
	<section id="register">
		<div class="container">
			<div class="row">
				<div class="col-lg-3"></div>
				<div class="col-lg-6">
					<div class="page-header">
						<h3>Register</h3>
						<span>* All fields are required</span>
					</div>
					<f:form modelAttribute="loginForm" action="register" method="POST">
						<div class="row">

							<div class="col-md-6">
								<label for="inputEmail">Email</label>
								<div class="input-group">
									<span class="input-group-addon"><span
										class="glyphicon glyphicon-envelope"></span></span>
									<f:input path="mail" type="email" name="mail" required="true"
										class="form-control" id="inputEmail" placeholder="Enter email" />
								</div>
							</div>
							<div class="col-md-6">
								<label for="inputProf">Profession</label>
								<div class="input-group">
									<span class="input-group-addon"><span
										class="glyphicon glyphicon-earphone"></span></span>
									<f:input path="prof" type="text" name="prof" required="true"
										class="form-control" id="inputProf"
										placeholder="Enter profession" />
								</div>
							</div>
						</div>
						<br />
						<div class="row">
							<div class="col-md-6">
								<label for="inputPassword">Password</label>
								<div class="input-group">
									<span class="input-group-addon"><span
										class="glyphicon glyphicon-lock"></span></span>
									<f:input path="password" type="password" name="pwd"
										required="true" class="form-control" id="inputPassword"
										placeholder="Password" />
								</div>
							</div>
							<div class="col-md-6">
								<label for="inputPasswordAgain">Confirm password</label>
								<div class="input-group">
									<span class="input-group-addon"><span
										class="glyphicon glyphicon-lock"></span></span>
									<f:input path="pwdAgain" type="password" name="pwdAgain"
										required="true" class="form-control" id="inputPasswordAgain"
										placeholder="Password again.." />
								</div>
							</div>
						</div>
						<br />

						<div class="row">
							<div class="col-md-6">
								<label for="inputFirst">first name</label>
								<div class="input-group">
									<span class="input-group-addon"><span
										class="glyphicon glyphicon-flash"></span></span>
									<f:input path="first" type="text" name="first" required="true"
										class="form-control" id="inputFirst"
										placeholder="Hey, [insert first name here] !" />
								</div>
							</div>
							<div class="col-md-6">
								<label for="inputLast">last name</label>
								<div class="input-group">
									<span class="input-group-addon"><span
										class="glyphicon glyphicon-flash"></span></span>
									<f:input path="last" type="text" name="last" required="true"
										class="form-control" id="inputLast"
										placeholder="Hey,[insert last name here] !" />
								</div>
							</div>
						</div>

						<hr />
						<button type="submit" class="btn btn-info">
							<span class="glyphicon glyphicon-ok-sign"></span> Register
						</button>
						<div class="col-md-5 btn">

							<c:if test="${not loginForm.error}">
								<div class="col-md-2 btn" style="color: green">
									<span class="glyphicon glyphicon-ok"></span> Done ! Now <a
										href="index">Log in</a>.
								</div>
							</c:if>
							<c:if test="${loginForm.error and not empty loginForm.prof}">
								<div class="col-md-2 btn" style="color: #e13">
									<span class="glyphicon glyphicon-remove"></span> Error occured
								</div>
							</c:if>
						</div>

					</f:form>
				</div>
				<div class="col-lg-3"></div>
			</div>
		</div>
	</section>


	<!-- Team Section -->
	<section id="team" class="bg-light-gray">
		<div class="container">
			<div class="row">
				<div class="col-lg-12 text-center">
					<h2 class="section-heading">Our Amazing Team</h2>

				</div>
			</div>
			<div class="row">
				<div class="col-sm-4">
					<div class="team-member">
						<img src="<%=request.getContextPath()%>/resources/img/team1.jpg"
							class="img-responsive img-circle" alt="">
						<h4>El Mehdi KZADRI</h4>
						<br />
						<ul class="list-inline social-buttons">
							<li><a href="#"><i class="fa fa-twitter"></i></a></li>
							<li><a href="#"><i class="fa fa-facebook"></i></a></li>
						</ul>
					</div>
				</div>
				<div class="col-sm-4">
					<div class="team-member">
						<img src="<%=request.getContextPath()%>/resources/img/team2.jpg"
							class="img-responsive img-circle" alt="">
						<h4>Youness IABITEN</h4>
						<br />
						<ul class="list-inline social-buttons">
							<li><a href="//twitter.com/yiabiten"><i
									class="fa fa-twitter"></i></a></li>
							<li><a href="//fb.com/yiabiten"><i
									class="fa fa-facebook"></i></a></li>

						</ul>
					</div>
				</div>
				<div class="col-sm-4">
					<div class="team-member">
						<img src="<%=request.getContextPath()%>/resources/img/team3.jpg"
							class="img-responsive img-circle" alt="">
						<h4>Amine RHANEMI</h4>
						<br />
						<ul class="list-inline social-buttons">
							<li><a href="#"><i class="fa fa-twitter"></i></a></li>
							<li><a href="#"><i class="fa fa-facebook"></i></a></li>
						</ul>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-lg-8 col-lg-offset-2 text-center">
					<p class="large text-muted">Projet : Création d'un système des
						enchères.</p>
					<p class="large text-muted">Design Patterns - M. Abdeslam
						En-nouaary</p>
				</div>
			</div>
		</div>
	</section>



	<footer>
		<div class="container">
			<div class="row">
				<div class="col-md-4">
					<span class="copyright">Copyright &copy; Bid$.com (GLMSI
						2014/15)</span>
				</div>
				<div class="col-md-4">
					<ul class="list-inline social-buttons">
						<li><a href="#"><i class="fa fa-twitter"></i></a></li>
						<li><a href="#"><i class="fa fa-facebook"></i></a></li>
						<li><a href="#"><i class="fa fa-linkedin"></i></a></li>
					</ul>
				</div>
				<div class="col-md-4">
					<ul class="list-inline quicklinks">
						<li><a href="#">Privacy Policy</a></li>
						<li><a href="#">Terms of Use</a></li>
					</ul>
				</div>
			</div>
		</div>
	</footer>



	<!-- jQuery -->
	<script src="<%=request.getContextPath()%>/resources/js/jquery.js"></script>

	<!-- Bootstrap Core JavaScript -->
	<script
		src="<%=request.getContextPath()%>/resources/js/bootstrap.min.js"></script>

	<!-- Plugin JavaScript -->
	<script
		src="http://cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.3/jquery.easing.min.js"></script>
	<script src="<%=request.getContextPath()%>/resources/js/classie.js"></script>
	<script
		src="<%=request.getContextPath()%>/resources/js/cbpAnimatedHeader.js"></script>

	<!-- Custom Theme JavaScript -->
	<script src="<%=request.getContextPath()%>/resources/js/agency.js"></script>

</body>

</html>
