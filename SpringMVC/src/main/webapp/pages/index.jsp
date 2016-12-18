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
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/unslider.css">

    <script src="//code.jquery.com/jquery-2.1.4.min.js"></script>

    <!-- Homepage Specific Elements -->
    <script type="text/javascript" src="<%=request.getContextPath()%>/js/index.js"></script>
    <!-- End Homepage Specific Elements -->
</head>
<body id="top">
<div class="wrapper row1">
    <div id="header" class="clear">
        <div class="fl_left">
            <h1><a href="index.html">科研组</a></h1>
            <p>南京大学电子学院</p>
        </div>
        <div class="fl_right">
            <ul>
                <li><a href="#">主页</a></li>
                <li><a href="#">联系我们</a></li>
                <li><a href="#">如何找到我们</a></li>
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
<div class="wrapper row2">
    <div class="rnd">
        <!-- ###### -->
        <div id="topnav">
            <ul>
                <li class="active"><a href="/">主页</a></li>
                <li><a href="/equipments/main">设备</a></li>
                <li><a href="/papers/main">论文</a></li>
                <li><a href="/teams">团队</a></li>
                <li><a href="/news">新闻</a></li>
                <li><a href="/contact">联系我们</a></li>

            </ul>
        </div>
        <!-- ###### -->
    </div>
</div>
<!-- ####################################################################################################### -->
<div class="wrapper">
    <div id="featured_slide" class="clear">
        <!-- ###### -->
        <div class="overlay_left"></div>
        <div id="featured_content">
                <ul id="banner_container">

                </ul>
            <div class="floater">
                <h2>新闻２</h2>
                <p>banner.brief </p><p class="readmore"><a href="">Continue Reading &raquo;</a></p>
            </div>
        </div>

        <!-- ###### -->
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
                    <ul>
                        <li class="clear">
                            <div class="imgl"><img src="images/10.jpg" alt="" /></div>
                            <div class="latestnews">
                                <p><a href="#">团队成员到xxxx一游</a></p>
                                <p>xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx xxxxxxx xxxxxxxxxxxxxxxxxxxx xxxxxxxxxxxxxxxxxxxxxx xxxxxxxxxxxxxxxx</p>
                            </div>
                        </li>
                        <li class="clear">
                            <div class="imgl"><img src="images/11.jpg" alt="" /></div>
                            <div class="latestnews">
                                <p><a href="#">团队成员获得学校奖学金</a></p>
                                <p> xxxxxxxxxxxxxxxxxxxx xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx xxxxxxxxxxxxxxxxxxxxxxxxxxxxxx</p>
                            </div>
                        </li>
                        <li class="last clear">
                            <div class="imgl"><img src="images/12.jpg" alt="" /></div>
                            <div class="latestnews">
                                <p><a href="#">团队老师获得花旗银行优秀教师奖</a></p>
                                <p>sdfsdfsdf sdfsdfadafdafasdfsadfasdfasdfasdfasdfasdf dsfasdfjadsjfkadjfkjasdlfkjsdlkfjalsdkf dsfkasdjflkajsdflkjadfksjadflkjdfkasdjfalkd adfkajdsflkjaf</p>
                            </div>
                        </li>
                    </ul>
                    <p class="readmore"><a href="#">Click here to view all of the latest news and events &raquo;</a></p>
                </div>
                <!-- ###### -->
                <div id="right_column">
                    <div class="holder">
                        <h2>介绍视频</h2>
                        <a href="#"><img src="images/video.gif" alt="" /></a> </div>
                    <div class="holder">
                        <h2>Quick Information</h2>
                        <div class="apply"><a href="#"><img src="images/13.jpg" alt="" /> <strong>Make An Application</strong></a></div>
                        <div class="apply"><a href="#"><img src="images/14.jpg" alt="" /> <strong>Order A Prospectus</strong></a></div>
                    </div>
                </div>
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


<script src="<%=request.getContextPath()%>/js/unslider-min.js"></script> <!-- but with the right path! -->


</body>
</html>

