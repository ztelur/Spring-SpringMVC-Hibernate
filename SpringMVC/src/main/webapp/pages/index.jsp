<%@ page import="java.util.ArrayList" %>
<%@ page import="com.nju.ee.vo.BannerVo" %><%--
  Created by IntelliJ IDEA.
  User: mark
  Date: 4/24/15
  Time: 2:33 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head profile="http://gmpg.org/xfn/11">
    <title>Academic Education</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta http-equiv="imagetoolbar" content="no" />
    <link rel="stylesheet" href="<%=request.getContextPath()%>/styles/layout.css" type="text/css" />
    <link rel="stylesheet" href="<%=request.getContextPath()%>/styles/featured_slide.css" type="text/css" />
    <script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-1.4.1.min.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery.slidepanel.setup.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery.cycle.min.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/js/index.js"></script>

    <link rel="stylesheet" href="<%=request.getContextPath()%>/styles/index.css" type="text/css" />

    <!-- Homepage Specific Elements -->
    <!-- End Homepage Specific Elements -->
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
<div class="wrapper">
    <div id="featured_slide">


    </div>
</div>
<!-- ####################################################################################################### -->
<div class="wrapper row3">
    <div class="rnd">
        <div id="container" class="clear">
            <!-- ####################################################################################################### -->
            <div id="homepage" class="clear">
                <!-- ###### -->
                <!-- ###### -->
                <div id="latestnews">
                    <h2>最近新闻和事件</h2>
                    <ul id="news_container">
                    </ul>
                    <p class="readmore"><a href="<%=request.getContextPath()%>/articles/main">查看所有新闻</a></p>
                </div>
                <!-- ###### -->
                <%--<div id="right_column">--%>
                    <%--<div class="holder">--%>
                        <%--<h2>快速链接</h2>--%>
                        <%--<div class="apply"><a href="#"><img src="images/13.jpg" alt="" /> <strong>Make An Application</strong></a></div>--%>
                        <%--<div class="apply"><a href="#"><img src="images/14.jpg" alt="" /> <strong>Order A Prospectus</strong></a></div>--%>
                    <%--</div>--%>
                <%--</div>--%>
                <!-- ###### -->
            </div>
            <!-- ####################################################################################################### -->
            <!-- ####################################################################################################### -->
        </div>
    </div>
</div>
<!-- ####################################################################################################### -->
<%@ include file="footer.jsp" %>
<!-- ####################################################################################################### -->




</body>
</html>

