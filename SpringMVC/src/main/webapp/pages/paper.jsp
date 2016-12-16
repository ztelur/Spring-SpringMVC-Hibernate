<%--
  Created by IntelliJ IDEA.
  User: homer
  Date: 16-12-16
  Time: 下午12:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head profile="http://gmpg.org/xfn/11">
    <title>论文</title>
    <meta charset="utf-8">
    <meta http-equiv="imagetoolbar" content="no" />
    <link rel="stylesheet" href="<%=request.getContextPath()%>/styles/layout.css" type="text/css" />

    <link rel="shortcut icon" href="<%=request.getContextPath()%>/images/favicon.ico" />
    <link rel="stylesheet" href="<%=request.getContextPath()%>/styles/touchTouch.css"/>

    <link rel="stylesheet" href="<%=request.getContextPath()%>/styles/style.css"/>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/pagination.css"/>
    <script src="<%=request.getContextPath()%>/js/jquery.js"></script>
    <script src="<%=request.getContextPath()%>/js/jquery-migrate-1.1.1.js"></script>
    <script src="<%=request.getContextPath()%>/js/jquery.easing.1.3.js"></script>
    <script src="<%=request.getContextPath()%>/js/script.js"></script>
    <script src="<%=request.getContextPath()%>/js/superfish.js"></script>
    <script src="<%=request.getContextPath()%>/js/jquery.equalheights.js"></script>
    <script src="<%=request.getContextPath()%>/js/jquery.mobilemenu.js"></script>
    <script src="<%=request.getContextPath()%>/js/tmStickUp.js"></script>
    <script src="<%=request.getContextPath()%>/js/jquery.ui.totop.js"></script>
    <script src="<%=request.getContextPath()%>/js/touchTouch.jquery.js"></script>

    <script src="<%=request.getContextPath()%>/js/jquery.pagination.js"></script>
    <script src="<%=request.getContextPath()%>/js/paper.js"></script>


    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/paper.css" type="text/css" />

    <!-- End Gallery Specific Elements -->
</head>
<body id="top">


<div class="wrapper row1">
    <div id="header" class="clear">
        <div class="fl_left">
            <h1><a href="index.html">Academic Education</a></h1>
            <p>Free CSS Website Template</p>
        </div>
        <div class="fl_right">
            <ul>

            </ul>
            <form action="#" method="post" id="sitesearch">
                <fieldset>
                    <strong>Search:</strong>
                    <input type="text" value="Search Our Website&hellip;" onfocus="this.value=(this.value=='Search Our Website&hellip;')? '' : this.value ;" />
                    <input type="image" src="/images/search.gif" id="search" alt="Search" />
                </fieldset>
            </form>
        </div>
    </div>
</div>
<!-- ####################################################################################################### -->
<div class="wrapper row2">
    <div class="rnd">
        <!-- ###### -->
        <div id="topnav">
            <ul>
                <li class="active"><a href="/">主页</a></li>
                <li><a href="/devices">设备</a></li>
                <li><a href="/articles">文章</a></li>
                <li><a href="/teams">团队</a></li>
                <li><a href="/news">新闻</a></li>
                <li><a href="/contact">联系我们</a></li>
            </ul>
        </div>
        <!-- ###### -->
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
<%@ include file="footer.jsp" %>
<!-- ####################################################################################################### -->


</body>
</html>