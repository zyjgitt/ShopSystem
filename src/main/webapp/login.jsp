<%--
  Created by IntelliJ IDEA.
  User: lenvovo
  Date: 2017/12/26
  Time: 10:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录页面</title>
    <link href="/bootstrap/css/bootstrap.css" rel="stylesheet">
    <script src="/js/jquery-3.2.1.min.js" type="text/javascript"></script>
    <script src="/bootstrap/js/bootstrap.js" type="text/javascript"></script>
    <style type="text/css">
        #main{
            margin-top: 20%;
            margin-left: 35%;
        }
        #but{
            margin-left: 200px;
        }
    </style>
</head>
<body>
  <div id="main">
   <form action="/login" method="post" class="form-horizontal" role="form">
       <div class="form-group">
         <label  for="name" class="col-sm-2 control-label">账号名：</label>
         <input type="text" name="username" id="name" class="col-sm-2" placeholder="请输入您的账户名"/>
       </div>
       <div class="form-group">
       <label  for="pass" class="col-sm-2 control-label">密码：</label>
       <input type="password" name="password" class="col-sm-2" id="pass" placeholder="请输入您的密码"/>
       </div>
       <div class="form-group" id="but">
       <input type="submit"  class="btn btn-primary col-sm-2"  value="登录">
       </div>
   </form>
  </div>
</body>
</html>
<%--
form class="form-horizontal" role="form">
 <div class="form-group">
 <label for="inputEmail3" class="col-sm-2 control-label">邮箱:</label>
 <div class="col-sm-4">
 <input type="email" class="form-control" id="inputEmail3" placeholder="请输入您的邮箱地址">
 </div>
 </div>
 <div class="form-group">
 <label for="inputPassword3" class="col-sm-2 control-label">密码:</label>
 <div class="col-sm-4">
 <input type="password" class="form-control" id="inputPassword3" placeholder="请输入您的邮箱密码">
 </div>
 </div>
 </form>
--%>