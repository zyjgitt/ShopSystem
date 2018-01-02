<%--
  Created by IntelliJ IDEA.
  User: lenvovo
  Date: 2017/12/27
  Time: 11:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加供货商</title>
</head>
<body>
  <form action="/saveSupplier" method="post">
        供货商编码：<input type="text" name="code"/><br/>
        供货商名称：<input type="text" name="name"/><br/>
        注册公司：<input type="text" name="regCompany"/><br/>
        所在地：<input type="text" name="address"><br/>
         <input type="submit" value="提交">
  </form>
</body>
</html>
