<%--
  Created by IntelliJ IDEA.
  User: zangxiaojie
  Date: 2016/12/6
  Time: 10:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head profile="http://gmpg.org/xfn/11">
    <title> 文章管理</title>
    <meta charset="utf-8">
    <meta http-equiv="imagetoolbar" content="no" />
    <link rel="stylesheet" href="<%=request.getContextPath() %>/styles/manage_layout.css" type="text/css" />
    <link rel="shortcut icon" href="<%=request.getContextPath() %>/images/favicon.ico" />
    <link rel="stylesheet" href="<%=request.getContextPath() %>/styles/touchTouch.css">
    <link rel="stylesheet" href="<%=request.getContextPath() %>/styles/manage.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/pagination.css"/>
    <link rel="stylesheet" href="<%=request.getContextPath() %>/styles/style.css">
    <script src="<%=request.getContextPath() %>/js/jquery.js"></script>
    <script src="<%=request.getContextPath()%>/js/jquery.pagination.js"></script>
    <script src="<%=request.getContextPath()%>/js/manage_article.js"></script>


    <link rel="stylesheet" href="<%=request.getContextPath() %>/styles/articles-list.css" type="text/css" />
    <link rel="stylesheet" href="<%=request.getContextPath() %>/styles/news.css" type="text/css" />
    <!-- End Gallery Specific Elements -->
</head>
<body id="top">
<div class="wrapper row1">
    <%@ include file="manage_header.jsp" %>
</div>
<!-- ####################################################################################################### -->
<div class="wrapper manage-div">
    <div class="rnd">
        <!-- ###### -->
        <div id="topnav">
            <ul>
                <li><a href="<%=request.getContextPath() %>/equipments/manage/list">设备</a></li>
                <li><a href="<%=request.getContextPath() %>/papers/manage/list">论文</a></li>
                <li class="active"><a href="<%=request.getContextPath() %>/articles/manage/list">新闻</a></li>
                <li><a href="<%=request.getContextPath() %>/people/manage/list">人员</a></li>
                <li><a href="<%=request.getContextPath() %>/banners/manage/list">轮播页</a></li>
                <li><a href="<%=request.getContextPath() %>/otherInfos/manage/list">其他信息</a></li>

            </ul>
        </div>
        <!-- ###### -->
    </div>
</div>
<div class="wrapper manage-div">
    <div class="add-div">
        <a  type="button"  href ="<%=request.getContextPath() %>/articles/manage/add" class="btn add-button">
            添加新闻
        </a>
    </div>
</div>
<!-- ####################################################################################################### -->


<div class="wrapper row3">
    <div class="rnd">
        <div class="news_list2">
            <ul class="news_list_container">
            </ul>
        </div>
    </div>
    <!-- ####################################################################################################### -->
    <div  id="Pagination" class="pagination">

    </div>
    <!-- ####################################################################################################### -->
</div>

<!-- ####################################################################################################### -->




<!-- ####################################################################################################### -->

</body>
</html>
