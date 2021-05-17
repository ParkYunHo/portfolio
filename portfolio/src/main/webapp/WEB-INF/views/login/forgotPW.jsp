<div class="login-box" onkeyup="login.onKeyUpEvt_Login('forgot')">
  <div class="card card-outline card-primary">
    <div class="card-header text-center">
      <a href="#" class="h3"><b>Yoonho Park</b> Portfolio</a>
    </div>
    <div class="card-body">
      <p class="login-box-msg">You forgot your password? Here you can easily retrieve a new password.</p>
      <!--  
      <form action="recover-password.html" method="post">
        <div class="input-group mb-3">
          <input type="email" class="form-control" placeholder="Email" id="forgot_inputEmail">
          <div class="input-group-append">
            <div class="input-group-text">
              <span class="fas fa-envelope"></span>
            </div>
          </div>
        </div>
        <div class="row">
          <div class="col-12">
            <button type="submit" class="btn btn-primary btn-block" onclick="login.clickEvt_Forgot()">Request new password</button>
          </div>
        </div>
      </form>
       -->
      <div class="input-group mb-3">
        <input type="email" class="form-control" placeholder="Email" id="forgot_inputEmail">
        <div class="input-group-append">
          <div class="input-group-text">
            <span class="fas fa-envelope"></span>
          </div>
        </div>
      </div>
      <div class="row">
        <div class="col-12">
          <button type="submit" class="btn btn-primary btn-block" onclick="login.clickEvt_Forgot()">Request new password</button>
        </div>
        <!-- /.col -->
      </div>
      <p class="mt-3 mb-1">
        <a href="#" onclick="login.clivkEvt_MoveToPage('loginPage')">Login</a>
      </p>
    </div>
    <!-- /.login-card-body -->
  </div>
</div>
<!-- /.login-box -->