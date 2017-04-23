<%--
  Created by IntelliJ IDEA.
  User: zangxiaojie
  Date: 2016/12/6
  Time: 10:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head profile="http://gmpg.org/xfn/11">
    <title>人员管理</title>
    <meta charset="utf-8">
    <meta http-equiv="imagetoolbar" content="no" />
    <link rel="stylesheet" href="<%=request.getContextPath() %>/styles/manage_layout.css" type="text/css" />

    <link rel="stylesheet" href="<%=request.getContextPath() %>/styles/manage.css">
    <link rel="stylesheet" href="<%=request.getContextPath() %>/styles/style.css">
    <link rel="stylesheet" href="<%=request.getContextPath() %>/styles/articles-list.css">
    <link rel="stylesheet" href="<%=request.getContextPath() %>/css/pagination.css">

    <script src="<%=request.getContextPath() %>/js/jquery-1.4.1.min.js"></script>

    <script src="<%=request.getContextPath()%>/js/jquery.pagination.js"></script>
    <script src="<%=request.getContextPath()%>/js/manage_person.js"></script>


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
                <li><a href="/equipments/manage/list">设备</a></li>
                <li><a href="/papers/manage/list">论文</a></li>
                <li><a href="/articles/manage/list">新闻</a></li>
                <li class="active"><a href="/people/manage/list">人员</a></li>
                <li><a href="/banners/manage/list">轮播页</a></li>
                <li><a href="/otherInfos/manage/list">其他信息</a></li>

            </ul>
        </div>
        <!-- ###### -->
    </div>
</div>
<div class="wrapper manage-div">
    <div class="add-div">
        <a type="button"  href ="/people/manage/add" class="btn add-button">
            添加人员
        </a>
    </div>
</div>

<div class="wrapper row3">
    <div class="rnd">
        <div class="news_list2" id="manage_people_div">
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


</body>
</html>
