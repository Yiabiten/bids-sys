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
			<div class="navbar-header page-scroll">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target="#bs-example-navbar-collapse-1">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand page-scroll" id="brnd" href="#page-top">Bid$</a>
			</div>

			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav navbar-right">
					<li class="hidden"><a href="#page-top"></a></li>
					<li><a class="page-scroll" href="#services">Why us ?</a></li>
					<li><a class="page-scroll" href="#about">How to..</a></li>
					<li><a class="page-scroll" href="#team">Team</a></li>
					<li><a class="page-scroll" href="#contact">Contact</a></li>
				</ul>
			</div>
			<!-- /.navbar-collapse -->
		</div>
		<!-- /.container-fluid -->
	</nav>

	<!-- Header -->
	<header>
		<div class="container">
			<div class="intro-text">
				<div class="intro-lead-in">Hello there !</div>
				<div class="intro-heading">wanna buy or sell something ?</div>
				<a href="#services" class="page-scroll btn btn-xl">Tell Me More</a>
			</div>
		</div>
	</header>

	
		<section id="login">
			<div class="container">
				<div class="row">
					<div class="col-lg-3"></div>
					<div class="col-lg-6">
						<div class="panel panel-default">
							<div class="panel-body">
								<div class="page-header">
									<h3>Login</h3>
								</div>
								<form method="POST" action="j_spring_security_check">

									<label for="inputEmail">Email</label>
									<div class="input-group">
										<span class="input-group-addon"><span
											class="glyphicon glyphicon-envelope"></span></span> <input
											type="email" name="j_username" required="true"
											class="form-control" id="inputEmail"
											placeholder="Enter email" />
									</div>

									<br /> <label for="inputPassword">Password</label>
									<div class="input-group">
										<span class="input-group-addon"><span
											class="glyphicon glyphicon-lock"></span></span> <input
											type="password" name="j_password" required="true"
											class="form-control" id="inputPassword"
											placeholder="Password" />
									</div>
									<hr />
									<button type="submit" value="OK" class="btn btn-primary">
										<span class="glyphicon glyphicon-ok-sign"></span> Log in
									</button>
									<span class="btn">or</span> <a href="register"
										class="btn btn-info">join us</a>
								</form>
								<font color="red"> <span>${ sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message }</span>
								</font>
							</div>
						</div>
					</div>
					<div class="col-lg-3"></div>
				</div>
			</div>
		</section>
	

	<!-- Services Section -->
	<section id="services">
		<div class="container">
			<div class="row">
				<div class="col-lg-12 text-center">
					<h2 class="section-heading">Why us ?</h2>
				</div>
			</div>
			<div class="row text-center">
				<div class="col-md-4">
					<span class="fa-stack fa-4x"> <i
						class="fa fa-circle fa-stack-2x text-primary"></i> <i
						class="fa fa-shopping-cart fa-stack-1x fa-inverse"></i>
					</span>
					<h4 class="service-heading">E-Commerce</h4>
					<p class="text-muted">Buying and selling as simple as it could
						ever be.</p>
				</div>
				<div class="col-md-4">
					<span class="fa-stack fa-4x"> <i
						class="fa fa-circle fa-stack-2x text-primary"></i> <i
						class="fa fa-laptop fa-stack-1x fa-inverse"></i>
					</span>
					<h4 class="service-heading">Responsive Design</h4>
					<p class="text-muted">All you need is a connected device to the
						internet.</p>
				</div>
				<div class="col-md-4">
					<span class="fa-stack fa-4x"> <i
						class="fa fa-circle fa-stack-2x text-primary"></i> <i
						class="fa fa-lock fa-stack-1x fa-inverse"></i>
					</span>
					<h4 class="service-heading">Web Security</h4>
					<p class="text-muted">.. and, it's secure !</p>
				</div>
			</div>
		</div>
	</section>


	<!-- About Section -->
	<section id="about">
		<div class="container">
			<div class="row">
				<div class="col-lg-12 text-center">
					<h2 class="section-heading">How to use ?</h2>
					<h3 class="section-subheading text-muted">It's simple and
						easy, follow these steps:</h3>
				</div>
			</div>
			<div class="row">
				<div class="col-lg-12">
					<ul class="timeline">
						<li>
							<div class="timeline-image">
								<img class="img-circle img-responsive"
									src="<%=request.getContextPath()%>/resources/img/1.jpg" alt="">
							</div>
							<div class="timeline-panel">
								<div class="timeline-heading">
									<h4>#1</h4>
									<h4 class="subheading">Register and login</h4>
								</div>
								<div class="timeline-body">
									<p class="text-muted">
										You cannot use our platform if you're not a registred user. So
										<a href="#register">Register now</a> or <a href="#login">login</a>
									</p>
								</div>
							</div>
						</li>
						<li class="timeline-inverted">
							<div class="timeline-image">
								<img class="img-circle img-responsive"
									src="<%=request.getContextPath()%>/resources/img/2.jpg" alt="">
							</div>
							<div class="timeline-panel">
								<div class="timeline-heading">
									<h4>#2</h4>
									<h4 class="subheading">Choose a product</h4>
								</div>
								<div class="timeline-body">
									<p class="text-muted">We allow our trusted users to post
										their products for the bids. Choose a product from the
										different existing types.</p>
								</div>
							</div>
						</li>
						<li>
							<div class="timeline-image">
								<img class="img-circle img-responsive"
									src="<%=request.getContextPath()%>/resources/img/3.jpg" alt="">
							</div>
							<div class="timeline-panel">
								<div class="timeline-heading">
									<h4>#3</h4>
									<h4 class="subheading">Make a bid</h4>
								</div>
								<div class="timeline-body">
									<p class="text-muted">After choosing the product. Now all
										you have to do is compete other users to gain the product and
										be the buyer. Of course , within the permitted time.</p>
								</div>
							</div>
						</li>
						<li class="timeline-inverted">
							<div class="timeline-image">
								<img class="img-circle img-responsive"
									src="<%=request.getContextPath()%>/resources/img/4.jpg" alt="">
							</div>
							<div class="timeline-panel">
								<div class="timeline-heading">
									<h4>#4</h4>
									<h4 class="subheading">Choose a way to pay</h4>
								</div>
								<div class="timeline-body">
									<p class="text-muted">If you are lucky enough (and rich :D)
										to be the winner of the bid You'll have to choose a payment
										method and proceed to the next step: Livraison.</p>
								</div>
							</div>
						</li>
						<li class="timeline-inverted">
							<div class="timeline-image">
								<h4>
									Now <br>You're <br>the owner
								</h4>
							</div>
						</li>
					</ul>
				</div>
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


	<section id="contact">
		<div class="container">
			<div class="row">
				<div class="col-lg-12 text-center">
					<h2 class="section-heading">Thank you for visiting =)</h2>
					<h5 class="section-heading">You can find us on social media
						below</h5>
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

	<!-- Portfolio Modals -->
	<!-- Use the modals below to showcase details about your portfolio projects! -->



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
