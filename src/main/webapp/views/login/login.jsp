<!doctype html>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<html lang="en">
  <head>
  	<title>Login 10</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

	<link href="https://fonts.googleapis.com/css?family=Lato:300,400,700&display=swap" rel="stylesheet">

	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
	
	<link rel="stylesheet" href="<%=request.getContextPath()%>/views/login/css/style.css">
	  <link rel="stylesheet" href="<%=request.getContextPath()%>/views/login/sweetalert%20(1).css">
	  <script src="<%=request.getContextPath()%>/views/login/sweetalert2.all.min.js"></script>

	</head>
	<body class="img js-fullheight" style="background-image: url(images/bg.jpg);">
	<section class="ftco-section">
		<div class="container">
			<div class="row justify-content-center">
				<div class="col-md-6 text-center mb-5">
					<h2 class="heading-section">Login #10</h2>
				</div>
			</div>
			<jsp:include page="aaa.jsp"></jsp:include>
			<div class="row justify-content-center">
				<div class="col-md-6 col-lg-4">
					<div class="login-wrap p-0">
		      	<h3 class="mb-4 text-center">Have an account?</h3>
						<h3 class="mb-4 text-center">${img}</h3>
		      	<form action="login"  method="post" class="signin-form">
		      		<div class="form-group">
		      			<input type="text" class="form-control" placeholder="Username" name="username" value="${username}" required>
		      		</div>
					<span class="text-danger">${errUsername}</span>
	            <div class="form-group">
	              <input id="password-field" type="password" class="form-control" name="pass" value="${pass}" placeholder="Password" required>
	              <span toggle="#password-field" class="fa fa-fw fa-eye field-icon toggle-password"></span>
	            </div>
					<span class="text-danger">${errPass}</span>
	            <div class="form-group">
	            	<button class="form-control btn btn-primary submit px-3" onclick="helo()">Sign In</button>
	            </div>
	            <div class="form-group d-md-flex">
	            	<div class="w-50">
		            	<label class="checkbox-wrap checkbox-primary">Remember Me
									  <input type="checkbox" name="remember" checked>
									  <span class="checkmark"></span>
									</label>
								</div>
								<div class="w-50 text-md-right">
									<a href="#" style="color: #fff">Forgot Password</a>
								</div>
	            </div>
	          </form>
	          <p class="w-100 text-center">&mdash; Or Sign In With &mdash;</p>
	          <div class="social d-flex text-center">
	          	<a href="#" class="px-2 py-2 mr-md-1 rounded"><span class="ion-logo-facebook mr-2"></span> Facebook</a>
	          	<a href="#" class="px-2 py-2 ml-md-1 rounded"><span class="ion-logo-twitter mr-2"></span> Twitter</a>
	          </div>
		      </div>
				</div>
			</div>
		</div>
	</section>

	<script src="<%=request.getContextPath()%>/views/login/js/jquery.min.js"></script>
  <script src="<%=request.getContextPath()%>/views/login/js/popper.js"></script>
  <script src="<%=request.getContextPath()%>/views/login/js/bootstrap.min.js"></script>
  <script src="<%=request.getContextPath()%>/views/login/js/main.js"></script>

	<script>
		 function helo(){
			swal({
						title: "Are you sure?",
						text: "You will not be able to recover this imaginary file!",
						type: "warning",
						showCancelButton: true,
						confirmButtonClass: 'btn-danger',
						confirmButtonText: 'Yes, delete it!',
						closeOnConfirm: false,
						//closeOnCancel: false
					},
					function(){
						swal("Deleted!", "Your imaginary file has been deleted!", "success");
					});
		};
	</script>
	</body>
</html>

