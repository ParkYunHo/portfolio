<div class="login-box" onkeyup="login.onKeyUpEvt_Login('login')"> 
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
        	<p class="mb-1 col-6"><a href="#" onclick="login.clivkEvt_MoveToPage('forgotPW')">Forgot Password</a></p>
        	<p class="mb-0 col-6" style="text-align: right"><a href="#" class="text-center" onclick="login.clivkEvt_MoveToPage('register')">Register</a></p>
        </div>
    </div>
  </div>
</div>