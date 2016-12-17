<%--
  Created by IntelliJ IDEA.
  User: zangxiaojie
  Date: 2016/12/6
  Time: 10:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.nju.ee.vo.RestResult" %>
<!DOCTYPE html>
<html>
<head profile="http://gmpg.org/xfn/11">
    <title> 轮播页管理</title>
    <meta charset="utf-8">
    <meta http-equiv="imagetoolbar" content="no" />
    <link rel="stylesheet" href="<%=request.getContextPath() %>/styles/layout.css" type="text/css" />
    <link rel="shortcut icon" href="<%=request.getContextPath() %>/images/favicon.ico" />
    <link rel="stylesheet" href="<%=request.getContextPath() %>/styles/touchTouch.css">
    <link rel="stylesheet" href="<%=request.getContextPath() %>/styles/manage.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/pagination.css"/>
    <link rel="stylesheet" href="<%=request.getContextPath() %>/styles/style.css">
    <script src="<%=request.getContextPath() %>/js/jquery.js"></script>
    <script src="<%=request.getContextPath() %>/js/jquery-migrate-1.1.1.js"></script>
    <script src="<%=request.getContextPath() %>/js/jquery.easing.1.3.js"></script>
    <script src="<%=request.getContextPath() %>/js/script.js"></script>
    <script src="<%=request.getContextPath() %>/js/superfish.js"></script>
    <script src="<%=request.getContextPath() %>/js/jquery.equalheights.js"></script>
    <script src="<%=request.getContextPath() %>/js/jquery.mobilemenu.js"></script>
    <script src="<%=request.getContextPath() %>/js/tmStickUp.js"></script>
    <script src="<%=request.getContextPath() %>/js/jquery.ui.totop.js"></script>
    <script src="<%=request.getContextPath() %>/js/touchTouch.jquery.js"></script>
    <script src="<%=request.getContextPath()%>/js/jquery.pagination.js"></script>
    <script src="<%=request.getContextPath()%>/js/manage_banner.js"></script>



    <link rel="stylesheet" href="<%=request.getContextPath() %>/styles/news.css" type="text/css" />
    <!-- End Gallery Specific Elements -->
</head>
<body id="top">
<div class="wrapper row1">
    <div id="header" class="clear">
        <div class="fl_left">
            <h1><a href="index.html">管理端</a></h1>
            <p>Free CSS Website Template</p>
        </div>
        <div class="fl_right">
            <ul>

            </ul>
            <form action="#" method="post" id="sitesearch">
                <fieldset>
                    <strong>Search:</strong>
                    <input type="text" value="Search Our Website&hellip;" onfocus="this.value=(this.value=='Search Our Website&hellip;')? '' : this.value ;" />
                </fieldset>
            </form>
        </div>
    </div>
</div>
<!-- ####################################################################################################### -->
<div class="wrapper manage-div">
    <div class="rnd">
        <!-- ###### -->
        <div id="topnav">
            <ul>
                <li><a href="/manage/equipments/list">设备</a></li>
                <li><a href="/manage/papers/list">论文</a></li>
                <li><a href="/manage/teams/list">团队</a></li>
                <li ><a href="/manage/articles/list">新闻</a></li>
                <li><a href="/manage/people/list">人员</a></li>
                <li class="active"><a href="/manage/banners/list">轮播页</a></li>

            </ul>
        </div>
        <!-- ###### -->
    </div>
</div>
<div class="wrapper manage-div">
    <div class="add-div">
        <a  type="button"  href ="/banners/manage/add" class="btn add-button">
            添加轮播页
        </a>
    </div>
</div>
<!-- ####################################################################################################### -->


<div class="wrapper row3">
    <div class="rnd">
        <div class="news_list2">
            <ul class="news_list_container">
              <c:forEach items="${banners.data}" var="banner">
                <li>



                  <span class="title">
                    <input id="banner_set" name="banner_set" type="checkbox" value=""/>nn
                    <a href='/banners/${banner.brief}'> ${banner.brief}</a>

                  </span><br>
                  <span class="hits">
                      <a type="button" class="delete_button" onclick="delete_banner(${banner.brief})">删除</a>
                </span>
              </li>
            </c:forEach>
            </ul>
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

</body>
</html>
