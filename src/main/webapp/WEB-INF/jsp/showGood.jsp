<%--
  Created by IntelliJ IDEA.
  User: lenvovo
  Date: 2017/12/29
  Time: 10:55
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

        /*.table > thead > tr > th,
        .table > tbody > tr > td{
            padding: 8px;
            line-height: 1.42857143;
            vertical-align:middle;
            border-top: 1px solid #97FFFF;
        }*/
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
      <thead>
        <tr>
            <th>商品编码</th>
            <th>商品名称</th>
            <th>商品价格</th>
            <th>商品上架时间</th>
            <th>商品类型</th>
            <th>查看详细信息</th>
            <th>添加商品明细</th>
        </tr>
       </thead>
        <tbody>
               <c:forEach items="${goods}" var="good">
                   <tr>
                       <td>${good.code}</td>
                       <td>${good.name}</td>
                       <td>${good.price}</td>
                       <td>${good.registerDate}</td>
                       <td>${good.goodType.name}</td>
                       <td><a href="selGoodALLMessage/${good.storeName}">详细信息</a></td>
                       <td><a href="enterSpecFunction/goodDetail/${good.code}">添加商品明细</a></td>
                   </tr>

               </c:forEach>
        </tbody>
    </table>
</body>
</html>
