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
  <link rel="stylesheet" href="/resources/plugins/fontawesome-free/css/all.min.css">
  <!-- icheck bootstrap -->
  <link rel="stylesheet" href="/resources/plugins/icheck-bootstrap/icheck-bootstrap.min.css">
  <!-- Theme style -->
  <link rel="stylesheet" href="/resources/dist/css/adminlte.min.css">
</head>
<body class="hold-transition login-page">

	<jsp:include page="login.jsp"></jsp:include>

	<script type="text/javascript">
		var login = {
			clivkEvt_MoveToPage: function(page){
				$.ajax({
					url: page,
					type: 'get',
					resultType : 'html',
					success: function(data){
						$('.login-page')[0].innerHTML = data;
					},
					error: function(data){
						console.log(data);
					}
				});
			},
			clickEvt_SignIn: function(){
				var param = {
					'userId': $('#login_inputId')[0].value,
					'userPw': $('#login_inputPw')[0].value
				}
				console.log(param);

				/* $.ajax({
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
				}); */
			},
		};
	</script>

<!-- jQuery -->
<script src="/resources/plugins/jquery/jquery.min.js"></script>
<!-- Bootstrap 4 -->
<script src="/resources/plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
<!-- AdminLTE App -->
<script src="/resources/dist/js/adminlte.min.js"></script>
</body>
</html>