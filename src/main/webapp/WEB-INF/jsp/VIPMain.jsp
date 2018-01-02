<%--
  Created by IntelliJ IDEA.
  User: lenvovo
  Date: 2017/12/28
  Time: 14:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>首页</title>
    <link href="/bootstrap/css/bootstrap.css" rel="stylesheet">
    <script src="/js/jquery-3.2.1.min.js" type="text/javascript"></script>
    <script src="/bootstrap/js/bootstrap.js" type="text/javascript"></script>
    <style type="text/css">
        #main{
            width: 100%;
            height: 100%;
        }
        #top1{
            width:100%;
            height: 50px;
            position: absolute;
            background-color: darkgray;
        }
        #top1-left{
            float: left;
            margin-left: 20%;
        }
        a{
            text-decoration: none;
        }
        a:hover{
            color:red;
        }
        #search{
            width:100%;
            height:56px;
            padding-top:100px;
            padding-left: 45%;
        }
        #middle-left{
            padding-top: 40px;
            padding-left: 20%;
            height: 280px;
            float: left;
        }
        #type:hover{
            background-color: burlywood;
        }
        #type{
            margin-top: 25px;
            padding-left:25%;
            width:150px;
        }
        #chinese{
            padding-left: 10px;
           /* padding-right: 40px;*/
        }
        #tab{
            border: 1px solid orange;
        }
        #middle-right{
            padding-top: 40px;
            float: left;
            padding-left:60px;
            height: auto;
            width:900px;
        }

    </style>
    <script type="text/javascript">
        $(function () {
            $("#slidershow").carousel({
                interval :2000
            });
        })
    </script>
</head>
<body>
   <div id="main">
       <div id="top1">
           <div id="top1-left">
               <a href="login.jsp">${name}</a>&nbsp;&nbsp;&nbsp;&nbsp;
               <a href="reg.jsp">注册</a>&nbsp;&nbsp;&nbsp;&nbsp;
               <a href="/peopleInformation">个人信息</a>
               <a href="/logout">退出</a>
           </div>
       </div>
       <%--搜索栏--%>
       <div id="search">
           <form>
               <input type="text" name="name"/><input type="submit" value="搜索"/>
           </form>
       </div>
       <%--显示商品种类--%>
       <div id="middle-left">
           <table id="tab">
               <c:forEach items="${types}" var="type">
                   <%--href是url到control中查出所有此类型的商品信息--%>
                   <div id="type">
                     <a href="selAllGoodByType/${type.id}" id="chinese">${type.name}</a><br>
                   </div>
               </c:forEach>
           </table>
       </div>
       <%--图片轮播--%>
         <div id="middle-right">
           <div class="carousel slider" id="slidershow" data-ride="carouse1">
               <!--设置轮播图片的顺序-->
               <ol class="carousel-indicators">
                   <li class="active" data-target="#slidershow" data-slide-to="0"></li>
                   <li data-target="#slidershow" data-slide-to="1"></li>
                   <li data-target="#slidershow" data-slide-to="2"></li>
               </ol>
               <!--设置轮播图片-->
               <div class="carousel-inner">
                   <div class="item active">
                       <img  src="/images/index-1.jpg" style="width: 900px" alt="" />
                   </div>
                   <div class="item">
                       <img src="/images/index-2.jpg" style="width: 900px" alt=""/>
                   </div>
                   <div class="item">
                       <img src="/images/index-3.jpg" style="width: 900px" alt=""/>
                   </div>
               </div>
               <!--设置轮播图片控制器-->
               <a href="#slidershow" data-slide="prev" class="left carousel-control" role="button">
                   <span class="glyphicon glyphicon-chevron-left"></span>
               </a>
               <a>
                   <a href="#slidershow" data-slide="next" class="right carousel-control" role="button">
                       <span class="glyphicon glyphicon-chevron-right"></span>
                   </a>
               </a>
           </div>
           <div id="below" class="row">
               <%--
               Property 'imgUrl' not found on type java.lang.String
               原因是：items的${}没写，直接写成了集合名称
               --%>
               <c:forEach items="${goods}" var="good">
                       <div class="col-sm-4">
                           <img class="img-rounded"   src="${good.imgUrl}" style="width: 220px;height: 220px"><br/>
                           <a href="selGoodDetailByGoodCode/${good.code}">${good.name}</a>
                       </div>
               </c:forEach>

           </div>
         </div>









   </div>
</body>
</html>
