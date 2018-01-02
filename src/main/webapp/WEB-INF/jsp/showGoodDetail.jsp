<%--
  Created by IntelliJ IDEA.
  User: lenvovo
  Date: 2018/1/1
  Time: 15:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link href="/bootstrap/css/bootstrap.css" rel="stylesheet">
    <script src="/js/jquery-3.2.1.min.js" type="text/javascript"></script>
    <script src="/bootstrap/js/bootstrap.js" type="text/javascript"></script>
    <style type="text/css">
        .table-bordered th,
        .table-bordered td {
            border: 2px solid #97FFFF !important;
        }
        a{
            text-decoration: none;
        }
    </style>
</head>
<body>
<table class="table table-bordered">
    <thead>
      <tr>
        <th>商品ID</th>
        <th>商品编码</th>
        <th>商品明细编码</th>
        <th>商品描述</th>
        <th>成本价格</th>
        <th>销售价格</th>
        <th>上架时间</th>
        <th>库存数量</th>
        <th>商品图片</th>
      </tr>
    </thead>
    <tbody>
      <c:forEach items="${goodDetails}" var="goodDetail">
        <tr>
            <td>${goodDetail.id}</td>
            <td>${goodDetail.goodCode}</td>
            <td>${goodDetail.goodDetailCode}</td>
            <td>${goodDetail.description}</td>
            <td>${goodDetail.costPrice}</td>
            <td>${goodDetail.salePrice}</td>
            <td>${goodDetail.createTime}</td>
            <td>${goodDetail.num}</td>
            <td><img src="${goodDetail.imgUrl}"></td>
        </tr>
       </c:forEach>
    </tbody>
</table>
</body>
</html>

