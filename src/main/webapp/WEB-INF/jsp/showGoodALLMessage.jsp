<%--
  Created by IntelliJ IDEA.
  User: lenvovo
  Date: 2017/12/29
  Time: 15:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link href="/bootstrap/css/bootstrap.css" rel="stylesheet">
    <script src="/js/jquery-3.2.1.min.js" type="text/javascript"></script>
    <script src="/bootstrap/js/bootstrap.js" type="text/javascript"></script>
    <script type="text/javascript">
        $(function(){
            $("#cont").keyup(function (e){
                $("tbody tr").hide().filter(":contains('"+$(this).val()+"')").show();
            });
        })
    </script>
    <style type="text/css">
        .table-bordered th,
        .table-bordered td {
            border: 2px solid #97FFFF !important;
        }
        #find{
            padding-left: 35%;
            padding-bottom: 20px;
        }
        a{
            text-decoration: none;
        }
    </style>
</head>
<body>
   <div id="find">搜索：<input type="text" name="cont" id="cont"></div>
  <table class="table table-bordered">
    <tr>
        <th>商品ID</th>
        <th>商品编码</th>
        <th>商品名称</th>
        <th>商品简码</th>
        <th>商品类型ID</th>
        <th>供货商ID</th>
        <th>店铺名称</th>
        <th>上架时间</th>

        <th>商品价格</th>
        <th>商品显示图片</th>
        <th>是否是赠品</th>
        <th>是否支持退换</th>
    </tr>

    <c:forEach items="${goods}" var="good">
        <tr>
            <td>${good.id}</td>
            <td>${good.code}</td>
            <td>${good.name}</td>
            <td>${good.briefCode}</td>
            <td>${good.typeId}</td>
            <td>${good.supplierId}</td>
            <td>${good.storeName}</td>
            <td>${good.registerDate}</td>
            <td>${good.price}</td>
            <td><img src="${good.imgUrl}"></td>
            <td>${good.ifGift}</td>
            <td>${good.ifReturn}</td>
        </tr>
    </c:forEach>
  </table>
</body>
</html>
