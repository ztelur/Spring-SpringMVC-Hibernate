<%--
  Created by IntelliJ IDEA.
  User: 克崽兽
  Date: 2016/12/20
  Time: 21:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head profile="http://gmpg.org/xfn/11">
    <title> 其它信息管理</title>
    <meta charset="utf-8">
    <meta http-equiv="imagetoolbar" content="no"/>
    <link rel="stylesheet" href="<%=request.getContextPath() %>/styles/layout.css" type="text/css"/>
    <link rel="shortcut icon" href="<%=request.getContextPath() %>/images/favicon.ico"/>
    <link rel="stylesheet" href="<%=request.getContextPath() %>/styles/touchTouch.css">
    <link rel="stylesheet" href="<%=request.getContextPath() %>/styles/manage.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/pagination.css"/>
    <link rel="stylesheet" href="<%=request.getContextPath() %>/styles/style.css">
    <script src="<%=request.getContextPath() %>/js/jquery.js"></script>



    <link rel="stylesheet" href="<%=request.getContextPath() %>/styles/news.css" type="text/css"/>
    <!-- End Gallery Specific Elements -->
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/manage_other_info.css"/>
    <script src="http://api.map.baidu.com/api?v=2.0&ak=Ai0m8G67QbgALKDDHA1U24hnYHP8rgSF"></script>

</head>
<body id="top">
<div class="wrapper row1">
    <%@ include file="header.jsp" %>
</div>
<!-- ####################################################################################################### -->
<div class="wrapper manage-div">
    <div class="rnd">
        <%@ include file="nav.jsp" %>
    </div>
</div>

<!-- ####################################################################################################### -->


<div class="wrapper row3">
    <div class="rnd">
        <div id="allmap"></div>
        <div id="form_container">
            <form id="form">
                <input type="hidden" name="longitude" id="longitude" value = "${otherInfo.data.longitude}" />
                <input type="hidden" name="latitude" id="latitude" value = "${otherInfo.data.latitude}" />
            </form>
        </div>
    </div>
</div>

<!-- ####################################################################################################### -->


<!-- ####################################################################################################### -->
<div class="wrapper">
    <div id="copyright" class="clear">
        <p class="fl_left">Copyright &copy; 2011 - All Rights Reserved - <a href="#">Domain Name</a></p>
        <p class="fl_right">Template from <a href="http://www.cssmoban.com/" title="模板之家">网站模板</a></p>
    </div>
</div>
<script src="<%=request.getContextPath()%>/js/manage_other_info.js"></script>
</body>
</html>
