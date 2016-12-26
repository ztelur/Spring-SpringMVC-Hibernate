<%--
  Created by IntelliJ IDEA.
  User: homer
  Date: 16-10-30
  Time: 下午9:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head profile="http://gmpg.org/xfn/11">
    <title>Academic Education | Gallery</title>
    <meta charset="utf-8">
    <meta http-equiv="imagetoolbar" content="no" />
    <link rel="stylesheet" href="<%=request.getContextPath()%>/styles/layout.css" type="text/css" />
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/contact.css" type="text/css" />
    <script src="<%=request.getContextPath()%>/js/jquery-1.4.1.min.js"></script>

    <script src="http://api.map.baidu.com/api?v=2.0&ak=Ai0m8G67QbgALKDDHA1U24hnYHP8rgSF"></script>
    <!-- End Gallery Specific Elements -->
</head>
<body id="top">
<div class="wrapper row1">
    <%@ include file="header.jsp" %>
</div>
<!-- ####################################################################################################### -->
<div class="wrapper row2">
    <div class="rnd">
        <%@ include file="nav.jsp" %>
    </div>
</div>
<!-- ####################################################################################################### -->
<div class="wrapper row3">
    <div class="rnd">
        <div id="container" class="clear">
            <!-- ####################################################################################################### -->
            <div id="allmap"></div>


            <div class="subcontent">
                <p>
                    <br>
                </p>
                <p class="MsoPlainText">
                    <span style="font-family:宋体;" id="location"></span>
                </p>
                <p class="MsoPlainText">
                    <span style="font-family:宋体;">电话：</span><span id="phone" lang="EN-US"></span>
                </p>
                <p class="MsoPlainText">
                    <span style="font-family:宋体;">传真：</span><span lang="EN-US"></span>
                </p>
                <p class="MsoPlainText">
                    <span style="font-family:宋体;">电邮：</span><span lang="EN-US"><a href="" id="email"></a></span>
                </p>
                <p>
                    <br>
                </p></div>

            <!-- ####################################################################################################### -->
        </div>
    </div>
</div>
<script src="<%=request.getContextPath()%>/js/contact.js"></script>
<%@ include file="footer.jsp" %>
</body>
</html>


