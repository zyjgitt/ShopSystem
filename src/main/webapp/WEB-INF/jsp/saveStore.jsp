<%--
  Created by IntelliJ IDEA.
  User: lenvovo
  Date: 2017/12/27
  Time: 11:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="/bootstrap/css/bootstrap.min.css">
    <script src="/js/jquery-3.2.1.min.js"></script>
    <script src="/bootstrap/js/bootstrap.min.js"></script>

    <link rel="stylesheet" type="text/css" href="css/normalize.css"/>
    <script src="js/common.js" type="text/javascript" charset="utf-8"></script>
    <script type="text/javascript">
        $(document).ready(function(){
            var showproduct = {
                "boxid":"showbox",
                "sumid":"showsum",
                "boxw":400,//宽度,该版本中请把宽高填写成一样
                "boxh":400,//高度,该版本中请把宽高填写成一样
                "sumw":60,//列表每个宽度,该版本中请把宽高填写成一样
                "sumh":60,//列表每个高度,该版本中请把宽高填写成一样
                "sumi":7,//列表间隔
                "sums":5,//列表显示个数
                "sumsel":"sel",
                "sumborder":1,//列表边框，没有边框填写0，边框在css中修改
                "lastid":"showlast",
                "nextid":"shownext"
            };//参数定义
            $.ljsGlasses.pcGlasses(showproduct);//方法调用，务必在加载完后执行
        });
    </script>
    <script type="text/javascript">
        $(function () {
            $("#glist li").click(function(){
                $(this).siblings("li").removeClass("selected");
                $(this).addClass("selected");
                var g=$("#glist .selected a").html();
                <c:forEach items="${listGoodInfo}" var="goodInfo">
                var info="${goodInfo.good_info}";
                if(info==g){
                    $(".nowprice a").html("${goodInfo.good_price}");
                    $(".Hgt").html("库存(${goodInfo.good_count})");
                    $("#info_id").val("${goodInfo.good_info}");
                    $("#good_price").val("${goodInfo.good_price}")
                }
                </c:forEach>
            });
        });
        $(function () {
            $("#addsc").click(function () {
                $("#mysc").submit();
            });
        });
        $(function () {
            if(${rows==1}){
                alert("已成功加入购物车！");
            }
        });
    </script>
</head>
<body>

<%--******************************************************************************--%>
<div class="showall">
    <!--left -->
    <div class="showbot">
        <div id="showbox">
            <img src="${good.good_imageurl}" width="400" height="400">
            <c:forEach items="${listGoodInfo}" var="goodInfo">
                <img src="${goodInfo.goodinfo_imageurl}" width="400" height="400">
            </c:forEach>

        </div><!--展示图片盒子-->
        <div id="showsum">
            <!--展示图片里边-->
        </div>
        <p class="showpage">
            <a href="javascript:void(0);" id="showlast"> < </a>
            <a href="javascript:void(0);" id="shownext"> > </a>
        </p>
    </div>
    <!--conet -->
    <div class="tb-property">
        <div class="tr-nobdr">
            <h3>${good.good_name}</h3>
        </div>
        <div class="txt">

                <span class="nowprice">￥<a href="#">
                    <c:forEach items="${listGoodInfo}" var="goodInfo" begin="0" end="0">
                        ${goodInfo.good_price}
                    </c:forEach>
                </a></span>

        </div>
        <div class="txt-h">
            <span class="tex-o">分类</span>
            <ul class="glist" id="glist" data-monitor="goodsdetails_fenlei_click">
                <c:forEach items="${listGoodInfo}" var="goodInfo">
                    <li><a title="${goodInfo.good_info}" href="javascript:void(0);">${goodInfo.good_info}</a></li>
                </c:forEach>
            </ul>
        </div>
        <script>
            $(document).ready(function(){

                var t = $("#text_box");

                $('#min').attr('disabled',true);

                $("#add").click(function(){
                    t.val(parseInt(t.val())+1)
                    if (parseInt(t.val())!=1){
                        $('#min').attr('disabled',false);
                    }

                })

                $("#min").click(function(){
                    t.val(parseInt(t.val())-1);
                    if (parseInt(t.val())==1){
                        $('#min').attr('disabled',true);
                    }

                })
            });
        </script>
        <form id="mysc" action="/addShopCar" method="post">
            <input type="text" name="good_name" value="${good.good_name}" style="display: none"/>
            <input id="info_id" type="text" name="good_info" style="display: none"/>
            <input id="good_price" type="text" name="good_price" style="display: none"/>
            <input type="text" name="good_id" value="${good.good_id}" style="display: none"/>

            <div class="gcIpt">
                <span class="guT">数量</span>
                <input id="min" name="" type="button" value="-" />
                <input id="text_box" name="info_count" type="text" value="1" style="width:30px; text-align: center; color: #0F0F0F;"/>
                <input id="add" name="" type="button" value="+" />
                <span class="Hgt">库存（9999）</span>
            </div>
            <div class="nobdr-btns">
                <button id="addsc" class="addcart hu"><img src="images/shop.png" width="25" height="25"/>加入购物车</button>
                <button id="selsc" class="addcart yh"><img src="images/ht.png" width="25" height="25"/>立即购买</button>
            </div>
        </form>
        <div class="guarantee">
            <span>邮费：包邮&nbsp;&nbsp;支持货到付款 <a href=""><img src="images/me.png"/></a></span>
            <a href="/selShopCar">我的购物车</a>
        </div>
    </div>
</body>
</html>
