<%--
  Created by IntelliJ IDEA.
  User: lenvovo
  Date: 2017/12/28
  Time: 17:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <style type="text/css">
        #myImg{
            width:200px;
            height: 500px;
            float: left;
        }
        #main{
            padding-left: 20%;
            padding-right: 20%;
        }
    </style>
</head>
<body>
    <div id="search">
       <form>
           <input type="text" name="name"/><input type="submit" value="搜索"/>
       </form>
    </div>
    <div id="main">
    <c:forEach items="${goods}" var="good">
      <div id="myImg">
         <img src="${good.imgUrl}">
      </div>
      <div>
          <p>${good.name}</p>
      </div>
   </c:forEach>
   </div>
</body>
</html>
