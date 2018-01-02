<%--
  Created by IntelliJ IDEA.
  User: lenvovo
  Date: 2017/12/27
  Time: 11:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>添加商品信息</title>
    <%--src="/js/jquery-3.2.1.min.js":/是相对路径
      <script type="text/javascript" src="/js/jquery-3.2.1.min.js"></script>
    --%>
    <script type="text/javascript" src="/js/jquery-3.2.1.min.js"></script>
    <script type="text/javascript">
        $(function () {
            var num = ${num};
            if(num==1){
                alert("添加成功");
            }
        })
        function checkNotNull(){
            var code = $("#code").val();
            var name = $("#name").val();
            var briefCode =$("#briefCode").val();
            var storeName =$("#storeName").val();
            var imgFile =$("#imgFile").val();
            if(code==null){
                $("#code").append("<span>商品编码不能为空</span>")
                return false;
            }
            if(name==null){
                return false;
            }
            if(price==null){
                return false;
            }
            if(briefCode==null){
                return false;
            }
            if(storeName==null){
                return false;
            }
            if(imgFile==null){
                return false;
            }
            return true;
        }
    </script>
</head>
<body>
   <%-- size2::${types.size()};--%>
   <%--从controller拿来的数据想要显示在表单里：
      input：value="${name}"
      数据是集合时，在select中用jstl的foreach
   --%>
    <form action="/saveGood" method="post" enctype="multipart/form-data" onsubmit="return checkNotNull()">
        商品编码:<input type="text" name="code" id="code"/><br/>
        商品名称:<input type="text" name="name" id="name"/><br/>
        商品价格:<input type="text" name="price" id="price"/><br/>
        商品简码:<input type="text" name="briefCode" id="briefCode"/><br/>
        商品类型:
        <select name="typeId" id="type">
            <c:forEach items="${types}" var="type">
                <option value="${type.id}">${type.name}</option>
            </c:forEach>
        </select><br/>
        供货商名称:
        <select name="supplierId" id="supplierId">
            <c:forEach items="${suppliers}" var="supplier">
                <option value="${supplier.id}">${supplier.name}</option>
            </c:forEach>
        </select><br/>
        店铺名称:<input type="text" name="storeName" id="storeName"/><br/>
        <%--上架时间:<input type="text" name="registerDate"/><br/>--%>

        商品图片:<input type="file" name="imgFile" id="imgFile"/><br/>
        是否是赠品:
        <input type="radio" name="ifGift" value="是">是
        <input type="radio" name="ifGift" value="否" checked="checked">否<br/>
        是否支持退换:
        <input type="radio" name="ifReturn" value="是" checked="checked">是
        <input type="radio" name="ifReturn" value="否">否<br/>
        <input type="submit" value="添加">
    </form>
</body>
</html>
