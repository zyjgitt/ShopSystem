<%--
  Created by IntelliJ IDEA.
  User: lenvovo
  Date: 2017/12/31
  Time: 21:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>商品详情页面</title>
    <link rel="stylesheet" type="text/css" href="/bootstrap/css/bootstrap.min.css">
    <script src="/js/jquery-3.2.1.min.js" type="text/javascript"></script>
    <script src="/bootstrap/js/bootstrap.min.js"></script>

    <link rel="stylesheet" type="text/css" href="/css/normalize.css"/>
    <script src="/js/common.js" type="text/javascript" charset="utf-8"></script>

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
            $("#glist li").click(function () {
                $(this).siblings("li").removeClass("selected");
                $(this).addClass("selected");
                var type=$("#glist .selected a").html();
                <c:forEach items="${good.goodDetails}" var="detail">
                    /*  必须加双引号 ,否则下面的判断相等不了*/
                    var t="${detail.description}";
                if(type==t){
                    $(".nowprice a").html("${detail.salePrice}");
                    $(".Hgt").html("库存 ${detail.num}");
                    /* EL 表达式val里要加双引号*/
                    $("#did").val("${detail.id}");
                    $("#imgUrl").val("${detail.imgUrl}");
                    $("#desc").val("${detail.description}");
                    $("#price").val("${detail.salePrice}");
                }
                </c:forEach>

            });
        })
        $(function () {
            $("#shopCart").click(function () {
                var num = $("#text_box").val();
                /*num是变量val里不用加双引号*/
                $("#number").val(num);
                $("#myForm").submit();
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

   <div class="showall">
       <!--left -->
       <div class="showbot">
           <div id="showbox">
              <c:forEach items="${good.goodDetails}" var="detail" varStatus="status">
                   <img src="${detail.imgUrl}" width="400" height="400">
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
               <h3>
                   ${good.name}
               </h3>
           </div>
           <div class="txt">
               <span class="nowprice">￥<a href="#">
                       <c:forEach items="${good.goodDetails}" var="detail" begin="0" end="0">
                           ${detail.salePrice}
                       </c:forEach>
                   </a>
               </span>
           </div>
           <div class="txt-h">
                   <span class="tex-o">分类</span>
                   <ul class="glist" id="glist" data-monitor="goodsdetails_fenlei_click">
                       <c:forEach items="${good.goodDetails}" var="detail" varStatus="status">
                           <li><a title="${detail.description}" href="javascript:void(0);">${detail.description}</a></li>
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




               <div class="gcIpt">
                   <span class="guT">数量</span>
                   <input id="min" name="" type="button" value="-" />
                   <input id="text_box" name="" type="text" value="1" style="width:30px; text-align: center; color: #0F0F0F;"/>
                   <input id="add" name="" type="button" value="+" />
                   <span class="Hgt">库存
                      <c:forEach items="${good.goodDetails}" var="detail" begin="0" end="0">
                          ${detail.num}
                      </c:forEach>
                   </span>
               </div>
               <div class="nobdr-btns">
                   <button class="addcart hu" id="shopCart"><img src="/images/shop.png" width="25" height="25"/>加入购物车</button>
                   <button class="addcart yh" id="imme"><img src="/images/ht.png" width="25" height="25"/>立即购买</button>
               </div>
               <div class="guarantee">
                   <span>邮费：包邮&nbsp;&nbsp;支持货到付款 <a href=""><img src="/images/me.png"/></a></span>
               </div>
       </div>

   </div>

   <form action="/sc" method="post" id="myForm">
       <input type="text" id="imgUrl" name="imgUrl" style="display: none"/><br/>
       <input type="text" id="goodName" name="goodName" value="${good.name}" style="display: none"/><br/>
       <input type="text" id="did" name="did" style="display: none"/><br/>
       <input type="text" id="desc" name="descr" style="display: none"/><br/>
       <input type="text" id="price" name="price" style="display: none"/><br/>
       <input type="text" id="number" name="number" style="display: none"/><br/>
       <input type="text" id="goodCode" name="goodCode" value="${code}" style="display: none"/><br/>
   </form>

<%--
 private int id;
    //商品明细的id
    private int did;
    private String goodName;
    private String imgUrl;
    //商品的描述：白色...
    private String desc;
    private Double price;
    //加入购物车的商品的数量
    private int number;

--%>
</body>
</html>
