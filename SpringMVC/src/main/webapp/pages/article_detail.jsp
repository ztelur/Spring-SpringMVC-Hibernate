<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.nju.ee.vo.ArticleVo" %>
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
    <title>${article.data.title}</title>
    <meta charset="utf-8">
    <meta http-equiv="imagetoolbar" content="no" />
    <link rel="stylesheet" href="<%=request.getContextPath()%>/styles/layout.css" type="text/css" />

    <link rel="shortcut icon" href="<%=request.getContextPath()%>/images/favicon.ico" />
    <link rel="stylesheet" href="<%=request.getContextPath()%>/styles/touchTouch.css"/>

    <link rel="stylesheet" href="<%=request.getContextPath()%>/styles/style.css"/>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/pagination.css"/>
    <!-- Include Font Awesome. -->
    <link href="//cdnjs.cloudflare.com/ajax/libs/font-awesome/4.4.0/css/font-awesome.min.css" rel="stylesheet" type="text/css" />

    <!-- Include Editor style. -->
    <link href="/node_modules/froala-editor/css/froala_editor.min.css" rel="stylesheet" type="text/css" />
    <link href="/node_modules/froala-editor/css/froala_style.min.css" rel="stylesheet" type="text/css" />

    <!-- Include Code Mirror style -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/codemirror/5.3.0/codemirror.min.css">

    <!-- Include Editor Plugins style. -->
    <link rel="stylesheet" href="<%=request.getContextPath()%>/node_modules/froala-editor/css/plugins/char_counter.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/node_modules/froala-editor/css/plugins/code_view.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/node_modules/froala-editor/css/plugins/colors.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/node_modules/froala-editor/css/plugins/emoticons.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/node_modules/froala-editor/css/plugins/file.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/node_modules/froala-editor/css/plugins/fullscreen.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/node_modules/froala-editor/css/plugins/image.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/node_modules/froala-editor/css/plugins/image_manager.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/node_modules/froala-editor/css/plugins/line_breaker.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/node_modules/froala-editor/css/plugins/quick_insert.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/node_modules/froala-editor/css/plugins/table.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/node_modules/froala-editor/css/plugins/video.css">

    <!--my css-->
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/article.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/styles/article_detail.css" type="text/css" />


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
            <div class="content">
                ${article.data.content}
            </div>
        </div>
    </div>
    <!-- ####################################################################################################### -->
    <!-- ####################################################################################################### -->
</div>
<!-- ####################################################################################################### -->
<%@ include file="footer.jsp" %>
<!-- ####################################################################################################### -->


</body>
</html>


