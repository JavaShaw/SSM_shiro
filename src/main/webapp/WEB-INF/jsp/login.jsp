<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/10/11
  Time: 14:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
    <script src="../../js/jquery-3.1.1.min.js"></script>
    <script src="../../js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="../../css/bootstrap.min.css" >
    <link rel="stylesheet" href="../../css/login.css" >
    <link rel="stylesheet" href="../../css/font-awesome.min.css"/>
</head>
<body>
    <div class="container">
        <div class="row">
            <div class="col-md-offset-3 col-md-6">
                <form class="form-horizontal" action="/user/login" method="post">
                    <span class="heading">用户登录</span>
                    <div class="form-group">
                        <input type="text" class="form-control" id="input_username"  name="username" placeholder="用户名">
                        <i class="fa fa-user"></i>
                    </div>
                    <div class="form-group help">
                        <input type="password" class="form-control" id="input_psw" name="password" placeholder="密　码">
                        <i class="fa fa-lock"></i>
                    </div>
                    <div class="form-group ">
                        <input type="text" class="form-control" name="code" placeholder="验证码">
                        <i class="fa fa-image"></i>
                    </div>
                    <div class="form-group ">
                        <img id="img" src="/validatecode.jsp" onclick="refresh()">
                    </div>
                    <div class="form-group">
                        <div class="main-checkbox">
                            <input type="checkbox" value="None" id="checkbox1" name="check"/>
                            <label for="checkbox1"></label>
                        </div>
                        <span class="text">记住我</span>
                        <button type="submit"  id="btn_login" class="btn btn-default">登录</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</form>
</body>
</html>
<%--点击改变验证码--%>
<script>
    function refresh(){
        var url="/validatecode.jsp?rand="+Math.random(); //加入随机数防止缓存不进方法
        $("#img").attr("src",url);
    }
</script>

