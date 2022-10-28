<%--
  Created by IntelliJ IDEA.
  User: silver-brick
  Date: 2022/10/28
  Time: 19:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <style >
        .url_button:hover,.url_button:link,.url_button:visited,.url_button:active,.url_button:focus{
            color: black;
            text-decoration: none;
        }
        .url_button{
            display: inline-block;
            padding: 1px 6px 1px 6px;
            font-size: 13px;
            background-color: orange;
            border: 1px solid #000;
            border-radius: 2px;
        }
        .url_button:hover{
            background-color: rgb(188, 122, 0);
        }
    </style>
    <title>VariantMapFrame</title>
</head>
<body>

  <a class ="url_button" href="ICES_present_variantMap1.jsp" target="bottomframe2"/>Variant1&emsp;&emsp;
  <a class ="url_button" href="ICES_present_variantMap2.jsp" target="bottomframe2"/>Variant2&emsp;&emsp;
  <a class ="url_button" href="ICES_present_variantMap3.jsp" target="bottomframe2"/>Variant3&emsp;&emsp;
  <a class ="url_button" href="ICES_present_variantMap4.jsp" target="bottomframe2"/>Variant4&emsp;&emsp;
  <a class ="url_button" href="ICES_present_variantMap5.jsp" target="bottomframe2"/>Variant5&emsp;&emsp;
</body>
</html>
