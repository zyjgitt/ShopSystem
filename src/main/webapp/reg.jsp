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
    <title>会员注册页面</title>
    <script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>
    <script type="text/javascript">
        $(function () {
            $("#no").blur(function () {
                var content = $("#no").val();
                $.ajax({
                     url:"/check",
                     type:"post",
                     data:{"no":content},
                     success:function (res) {
                         alert(res);
                         if(res==0){
                             /*清空内容*/
                             $("#span").empty();
                             $("#btn").prop("disabled",false);
                         }else{
                             $("#span").html("用户名已存在！");
                             $("#btn").prop("disabled",true);
                         }
                     },
                    error:function (res) {
                        alert("error");
                    }
                })
            })
        })
    </script>
</head>
<body>
  <form action="/reg" method="post">
      账号名：<input type="text" name="username" id="no"/><span id="span"></span><br/>
      密码：<input type="password" name="password"/><br/>
      等级：<select name="grade">
          <option value="1">白银</option>
          <option value="2">黄金</option>
          <option value="3">白金</option>
      </select><br/>
      身份证号：<input type="text" name="idCard"/><br/>
      真实姓名：<input type="text" name="name"/><br/>
      邮箱：<input type="text" name="email"/><br/>
      手机号：<input type="text" name="phoneNum"/><br/>
      <input type="submit" value="注册" id="btn">
  </form>
</body>
</html>
