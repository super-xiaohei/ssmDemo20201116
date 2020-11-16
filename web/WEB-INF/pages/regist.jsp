<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/11/13
  Time: 10:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title> Registration Page</title>

    <!-- Google Font: Source Sans Pro -->
    <!-- Font Awesome -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/plugins/fontawesome-free/css/all.min.css">
    <!-- icheck bootstrap -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/plugins/icheck-bootstrap/icheck-bootstrap.min.css">
    <!-- Theme style -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/dist/css/adminlte.min.css">
</head>
<body class="hold-transition register-page">
<div class="register-box">
    <div class="card card-outline card-primary">
        <div class="card-header text-center">
            <a href="${pageContext.request.contextPath}/static/index2.html" class="h1"><b>用户</b>注册</a>
        </div>
        <div class="card-body">
            <p class="login-box-msg">注册一个新用户哦</p>

            <form>
                <p style="color: red;font-size: 12px" id="msg">${registErrorMsg}</p>
                <div class="input-group mb-3">
                    <input type="text" class="form-control" name="username" id="username" placeholder="电话或者邮箱">
                    <div class="input-group-append">
                        <div class="input-group-text">
                            <span class="fas fa-envelope"></span>
                        </div>
                    </div>
                </div>
                <div class="input-group mb-3">
                    <input type="password" class="form-control" name="password" id="password" placeholder="密码">
                    <div class="input-group-append">
                        <div class="input-group-text">
                            <span class="fas fa-lock"></span>
                        </div>
                    </div>
                </div>
                <div class="input-group mb-3">
                    <input type="password" class="form-control" name="repassword" id="repassword" placeholder="确认密码" >
                    <div class="input-group-append">
                        <div class="input-group-text">
                            <span class="fas fa-lock"></span>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-8">
                        <div class="icheck-primary">
                            <input type="checkbox" id="agreeTerms" name="terms" value="agree">
                            <label for="agreeTerms">
                                我同意此<a href="#">协议</a>
                            </label>
                        </div>
                    </div>
                    <!-- /.col -->
                    <div class="col-4">
                        <button type="button" class="btn btn-primary btn-block" id="regist">注册</button>
                    </div>
                    <!-- /.col -->
                </div>
            </form>

            <div class="social-auth-links text-center">
                <a href="#" class="btn btn-block btn-primary">
                    <i class="fab fa-facebook mr-2"></i>
                    快点注册！！！
                </a>
                <a href="#" class="btn btn-block btn-danger">
                    <i class="fab fa-google-plus mr-2"></i>
                    不然滚蛋！！！
                </a>
            </div>

            <a href="${pageContext.request.contextPath}/login.jsp" class="text-center">我已有账号</a>
        </div>
        <!-- /.form-box -->
    </div><!-- /.card -->
</div>
<!-- /.register-box -->

<!-- jQuery -->
<script src="${pageContext.request.contextPath}/static/plugins/jquery/jquery.min.js"></script>
<!-- Bootstrap 4 -->
<script src="${pageContext.request.contextPath}/static/plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
<!-- AdminLTE App -->
<script src="${pageContext.request.contextPath}/static/dist/js/adminlte.min.js"></script>
<script src="${pageContext.request.contextPath}/static/layer/layer.js"></script>
<script src="${pageContext.request.contextPath}/static/layer/theme/default/layer.css"></script>
</body>
</html>

<script>
    $(function () {
        $("#regist").click(function () {
            var password = $("#password").val();
            var repassword = $("#repassword").val();
            if(password != repassword){
                layer.msg("两次密码不一致",{icon:4,time:3000});
                return false;
            }else {
                $("#msg").text("");
            }

            $.ajax({
                type:'get',
                url:'${pageContext.request.contextPath}/insert',
                data:{"username":$("#username").val(),"password":$("#password").val()},
                success:function (flag) {
                    console.info(flag)//true
                    if(flag === "true"){
                        layer.msg("注册成功，即将跳转到登录界面",{icon:1,time:2000},function () {
                            window.location = "${pageContext.request.contextPath}";
                        })
                    }else {
                        layer.msg("注册失败，请使用电话号码和邮箱注册",{icon:5,time:1500},function () {
                            return false;
                        })
                    }
                }
            })
        })
    })
</script>


