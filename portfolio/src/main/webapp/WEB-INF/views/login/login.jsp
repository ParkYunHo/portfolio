<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<html lang="en">
<head>
  <meta charset="EUC-KR">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>Portfolio Sign in</title>

  <!-- Google Font: Source Sans Pro -->
  <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700&display=fallback">
  <!-- Font Awesome -->
  <link rel="stylesheet" href="../../resources/plugins/fontawesome-free/css/all.min.css">
  <!-- icheck bootstrap -->
  <link rel="stylesheet" href="../../resources/plugins/icheck-bootstrap/icheck-bootstrap.min.css">
  <!-- Theme style -->
  <link rel="stylesheet" href="../../resources/dist/css/adminlte.min.css">
</head>
<body class="hold-transition login-page">

	<div class="login-box"> 
	  <div class="card card-outline card-primary">
	  	<!-- Header -->
	    <div class="card-header text-center">
	      <a href="#" class="h3"><b>Yoonho Park</b> Portfolio</a>
	    </div>
	    	    
	    <div class="card-body">
	      <p class="login-box-msg">Sign in to start your session</p>
	
	      <div class="input-group mb-3">
	          <input type="email" class="form-control" placeholder="Email" id="login_inputId">
	          <div class="input-group-append">
	            <div class="input-group-text">
	              <span class="fas fa-envelope"></span>
	            </div>
	          </div>
	        </div>
	        <div class="input-group mb-3">
	          <input type="password" class="form-control" placeholder="Password" id="login_inputPw">
	          <div class="input-group-append">
	            <div class="input-group-text">
	              <span class="fas fa-lock"></span>
	            </div>
	          </div>
	        </div>
	        <div class="row mb-4">
	          <div class="col-12">
	            <button type="submit" class="btn btn-primary btn-block" onclick="login.clickEvt_SignIn()">Sign In</button>
	          </div>
	        </div>
	        
	        <div class="row">
	        	<p class="mb-1 col-6"><a href="#">Forgot Password</a></p>
	        	<p class="mb-0 col-6" style="text-align: right"><a href="#" class="text-center">Register</a></p>
	        </div>
	    </div>
	  </div>
	</div>
	
	
	<script type="text/javascript">
		var login = {
			clickEvt_SignIn: function(){
				var param = {
					'userId': $('#login_inputId')[0].value,
					'userPw': $('#login_inputPw')[0].value
				}
				console.log(param);

				$.ajax({
					url: 'login/check',
					type: 'post',
					data: param,
					success: function(data){
						console.log(data);
						location.href='/';
					},
					error: function(data){
						console.log(data);
					}
				});
			}
		}
	</script>


<!-- jQuery -->
<script src="../../resources/plugins/jquery/jquery.min.js"></script>
<!-- Bootstrap 4 -->
<script src="../../resources/plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
<!-- AdminLTE App -->
<script src="../../resources/dist/js/adminlte.min.js"></script>
</body>
</html>