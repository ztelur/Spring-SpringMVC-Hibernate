<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.nju.ee.vo.ArticleVo" %>
<%@ page import="com.nju.ee.vo.PersonDescVo" %>
<%@ page import="com.nju.ee.entity.Person" %>
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
    <title>人员简介</title>
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
    <script src="<%=request.getContextPath()%>/js/news.js"></script>


    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/person_show.css" type="text/css" />

    <!-- End Gallery Specific Elements -->
</head>
<body id="top">


<%
    PersonDescVo personDescVo = (PersonDescVo) session.getAttribute("people");

    if (personDescVo == null) {
        personDescVo = new PersonDescVo();
        personDescVo.setName("曹鸥");
        personDescVo.setPosition("软院院长");
        personDescVo.setDepartment("软件学院");
        personDescVo.setTitle("博导");
        personDescVo.setAvatar("");
    }
%>

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
            <div class="section-block no-border a_wrapper_no_top">
                <div class="row-fluid">
                    <div class="span3 a_photo">
                        <div class="section-block no-border">
                            <div class="sec-img-div">
                                <div class="sec-img-div-inner"><img class="img-polaroid" src="<%=request.getContextPath()%>/images/cxx.jpg" alt=""></div>
                            </div>
                            <p style="margin: 0px 5px;"><span class="teacher-name"><%=personDescVo.getName()%></span></p>
                            <ul class="inline">
                                <li><%=personDescVo.getTitle()%></li>
                                <li><%=personDescVo.getDepartment()%></li>
                                <li><%=personDescVo.getPosition()%></li>

                            </ul>
                        </div>
                    </div>
                    <div class="span9 a_words">

                    </div>
                </div>
            </div>

        </div>
    </div>

    <!-- ####################################################################################################### -->
</div>
<!-- ####################################################################################################### -->
<%@ include file="footer.jsp" %>
<!-- ####################################################################################################### -->


</body>
</html>






