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
    <title>新闻管理</title>
    <meta charset="utf-8">
    <meta http-equiv="imagetoolbar" content="no" />
    <link rel="stylesheet" href="<%=request.getContextPath() %>/styles/layout.css" type="text/css" />
    <link rel="shortcut icon" href="<%=request.getContextPath() %>/images/favicon.ico" />
    <link rel="stylesheet" href="<%=request.getContextPath() %>/styles/touchTouch.css">
    <link rel="stylesheet" href="<%=request.getContextPath() %>/styles/manage.css">
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
                    <input type="image" src="images/search.gif" id="search" alt="Search" />
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
                <li><a href="/manage/devices">设备</a></li>
                <li><a href="/manage/articles">文章</a></li>
                <li><a href="/manage/teams">团队</a></li>
                <li class="active"><a href="/manage/news">新闻</a></li>
                
            </ul>
        </div>
        <!-- ###### -->
    </div>
</div>
<div class="wrapper manage-div">
    <div class="add-div">
        <a  type="button"  href ="/articles/add" class="btn add-button">
            添加新闻
        </a>
    </div>
</div>
<!-- ####################################################################################################### -->
<div class="wrapper row3">
    <div class="rnd">

        <div class="news_list2">

             <ul>
                <c:forEach var="listValue" items="${articles.data.articles}">
                   <li> 
                        <span class="title"><a href="http://www.ime.pku.edu.cn/newsshow.php?id=7&amp;cid=197"  title="武常岐教授受聘微纳电子与集成系统协同创新中心顾问委员会委员">${listValue.title}</a></span>
                        <span class="hits">
                                <button>编辑</button>
                                <form method="delete" action="/articles/manage/${listValue.id}"><button>删除</button></form>
                        </span>
                        <br>
                        <span class="time">2016-07-14 13:14:28</span> <span class="class">分类：<a href="http://www.ime.pku.edu.cn/newsshow.php?id=7&amp;cid">${listValue.category}</a></span> 
                    </li>
                </c:forEach>
            </ul>
            
        </div>
    </div>
</div>

<!-- ####################################################################################################### -->

    <div class="page">
         <span class="disabled"> < </span>
         <span class="current">1</span>
         <a href="http://www.111cn.net">2</a>
         <a href="http://www.111cn.net">3</a>
         <a href="http://www.111cn.net">4</a>
         <a href="http://www.111cn.net">5</a>
         <a href="http://www.111cn.net">6</a>
         <a href="http://www.111cn.net">7</a>
         ...
         <a href="http://www.111cn.net">199</a>
         <a href="http://www.111cn.net">200</a>
         <a href="http://www.111cn.net"> > </a>
</div>


<!-- ####################################################################################################### -->
<div class="wrapper">
    <div id="copyright" class="clear">
        <p class="fl_left">Copyright &copy; 2011 - All Rights Reserved - <a href="#">Domain Name</a></p>
        <p class="fl_right">Template from <a href="http://www.cssmoban.com/" title="模板之家">网站模板</a></p>
    </div>
</div>

</body>
</html>
