<%--
  Created by IntelliJ IDEA.
  User: lenvovo
  Date: 2017/12/26
  Time: 10:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>主页面</title>
</head>
   <frameset rows="20%,*">
       <frame src="/frame/welcome" name="top"/>
       <frameset cols="20%,*">
           <frame src="/frame/function" name="left" noresize="noresize"/>
           <frame name="right">
       </frameset>
   </frameset>
</html>
