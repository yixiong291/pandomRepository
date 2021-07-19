<%--
  Created by IntelliJ IDEA.
  User: 28160
  Date: 2021/6/10
  Time: 22:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/statics/bootstrap-3.4.1-dist/css/bootstrap.min.css">
    <script src="${pageContext.request.contextPath}/statics/js/jquery-3.6.0.js"></script>
    <script src="${pageContext.request.contextPath}/statics/bootstrap-3.4.1-dist/js/bootstrap.min.js"></script>
    <style>
        body{
            background: url("${pageContext.request.contextPath}/statics/img/login.jpg");
            background-size: cover;
        }
        .modal-content{
            color:lightyellow;
            background: rgba(0,0 ,0 , 0.2);
        }
        #warning{
            width: 400px;
            height: 100px;
            position: absolute;
            top: 0;
            left: 0;
            right: 0;
            bottom: 0;
            margin: auto;
            text-align:center;
            font-size: 30px;
            color: white;
        }
    </style>
    <script language="javascript">
        function isValid(form) {
            if (form.name.value === "") {
                alert("用户名不能为空");
                return false;
            }
            if (form.pwd.value != form.pwd2.value) {
                alert("两次输入的密码不同！");
                return false;
            } else if (form.pwd.value === "") {
                alert("用户密码不能为空！");
                return false;
            }

        }
        function isValid2(form)
        {
            if (form.name.value=="")
            {
                alert("用户名不能为空");
                return false;
            }
            if (form.pwd.value!=form.pwd2.value)
            {
                alert("两次输入的密码不同！");
                return false;
            }
            else  if (form.pwd.value=="")
            {
                alert("用户密码不能为空！");
                return false;
            }
            else return true;
        }
    </script>
</head>
<body >

<div id="warning">
    <span>${msg}!</span>
</div>
<!--登录按钮-->
<div class="col-xs-1 col-xs-offset-9 aTopAndBottom">
    <a href="" data-toggle="modal" data-target="#login">
        <span class="glyphicon glyphicon-log-in"></span>
        <span id="loginText">登录</span>
    </a>
</div>
<!--注册按钮-->
<div class="col-xs-1 aTopAndBottom">
    <a href="" data-toggle="modal" data-target="#register">
        <span class="glyphicon glyphicon-user"></span>
        <span id="registText">注册</span>
    </a>
</div>
<!-- 注册 -->
<div id="register" class="modal fade" tabindex="-1">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-body">
                <button class="close" data-dismiss="modal">
                    <span>&times;</span>
                </button>
            </div>
            <div class="modal-title">
                <h1 class="text-center">注册</h1>
            </div>
            <div class="modal-body">
                <form class="form-group" action="${pageContext.request.contextPath}/register/registerUsers" onsubmit="return isValid2(this);">
                    <div class="form-group">
                        <label for="">用户名</label>
                        <input class="form-control" type="text" name="name" placeholder="6-15位字母或数字">
                    </div>
                    <div class="form-group">
                        <label for="">性别</label>
                        <input class="form-control" type="text" name="sex" placeholder="男或女">
                    </div>
                    <div class="form-group">
                        <label for="">密码</label>
                        <input class="form-control" type="password" name="pwd" placeholder="至少6位字母或数字">
                    </div>
                    <div class="form-group">
                        <label for="">再次输入密码</label>
                        <input class="form-control" type="password" placeholder="至少6位字母或数字" name="pwd2"/>
                    </div>
                    <div class="form-group">
                        <label for="">邮箱</label>
                        <input class="form-control" type="email" name="email" placeholder="例如:***@***.com">
                    </div>
                    <div class="text-left">
                        <span class=" glyphicon glyphicon-user"></span>
                        <input type="radio" name="visitor" checked="checked" value="admin">管理员
                        <input type="radio" name="visitor" checked="checked" value="reader">读者
                    </div>
                    <div class="text-right">
                        <button class="btn btn-primary" type="submit" style="background-color: #3a8cd2b3;border: 0px solid transparent;">提交</button>
                        <button class="btn btn-danger" data-dismiss="modal" style="background-color: #fb5e5999;border: 0px solid transparent;">取消</button>
                    </div>
                    <a href="" data-toggle="modal" data-dismiss="modal" data-target="#login">
                        <font style="font-size: 13px;">已有账号？点我登录</font>
                    </a>
                </form>
            </div>
        </div>
    </div>
</div>
<!-- 注册 end-->
<!-- 登录 -->
<div id="login" class="modal fade">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-body">
                <button class="close" data-dismiss="modal">
                    <span>&times;</span>
                </button>
            </div>
            <div class="modal-title">
                <h1 class="text-center">登录</h1>
            </div>
            <div class="modal-body">
                <form class="form-group" action="/library/users/loginUsers" method="post" onsubmit="return isValid(this);">
                    <div class="form-group">
                        <label for="">用户名</label>
                        <input class="form-control" type="text" placeholder="" name="name" id="name">
                    </div>
                    <div class="form-group">
                        <label for="">密码 <span id="info"></span></label>
                        <input class="form-control" type="password" placeholder="" name="pwd" id="pwd">
                    </div>
                    <div class="text-left">
                        <span class=" glyphicon glyphicon-user"></span>
                        <input type="radio" name="visitor" checked="checked" value="admin">管理员
                        <input type="radio" name="visitor" checked="checked" value="reader">读者
                        <div class="text-left">
                            <span  color="red">${msg}</span>
                        </div>
                    </div>
                    <div class="text-right">
                        <button class="btn btn-primary" type="submit" style="background-color: #3a8cd2b3; border: 0px solid transparent;" >登录</button>
                        <button class="btn btn-danger" data-dismiss="modal" style="background-color: #fb5e5999;border: 0px solid transparent;">取消</button>
                    </div>
                    <a href="" data-toggle="modal" data-dismiss="modal" data-target="#register">
                        <font style="font-size: 13px;">还没有账号？点我注册</font>
                    </a>
                </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>
