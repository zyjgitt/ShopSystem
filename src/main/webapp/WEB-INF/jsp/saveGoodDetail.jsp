<%--
  Created by IntelliJ IDEA.
  User: lenvovo
  Date: 2017/12/28
  Time: 13:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>添加商品明细</title>
    <script type="text/javascript" src="/js/jquery-3.2.1.min.js"></script>
    <script type="text/javascript">
        $(function () {
            var num = ${num};
            if(num==1){
                alert("添加成功");
            }
        })
    </script>
</head>
<body>
     <form action="/saveGoodDetail" method="post" enctype="multipart/form-data">
         商品编码:<input type="text" name="goodCode" id="goodCode" value="${code}"/><br/>
         商品明细编码:<input type="text" name="goodDetailCode" id="goodDetailCode"/><br/>
         商品描述:<input type="text" name="description" id="description"/><br/>
         商品图片:<input type="file" name="imgFile" id="imgFile"/><br/>
         成本价格:<input type="text" name="costPrice" id="costPrice"/><br/>
         销售价格:<input type="text" name="salePrice" id="salePrice"/><br/>
         库存数量:<input type="number" name="num" id="num"/><br/>
         <input type="submit" value="添加">
     </form>
</body>
</html>
