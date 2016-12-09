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
    <title>文章</title>
    <meta charset="utf-8">
    <meta http-equiv="imagetoolbar" content="no" />
    <link rel="stylesheet" href="styles/layout.css" type="text/css" />

    <link rel="shortcut icon" href="images/favicon.ico" />
    <link rel="stylesheet" href="styles/touchTouch.css"/>

    <link rel="stylesheet" href="styles/style.css"/>
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


    <link rel="stylesheet" href="styles/news.css" type="text/css" />

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
<<<<<<< HEAD
            <ul class="news_list_container">
=======
            <ul>
                <%
                    List<ArticleVo>  articlesList = new ArrayList<ArticleVo>();
                    ArticleVo articleVo = new ArticleVo(article);
                    articleVo.setTitle("第一篇文章在第一个场雪的下午进行");
                    articlesList.add(articleVo);
                    articlesList.add(articleVo);
                    articlesList.add(articleVo);
                    articlesList.add(articleVo);

                    for(ArticleVo po : articlesList){
                %>
                <li> <span class="title"><a href="http://www.ime.pku.edu.cn/newsshow.php?id=7&amp;cid=197"  title="武常岐教授受聘微纳电子与集成系统协同创新中心顾问委员会委员">团队成员获得重大科技突破奖</a></span><span class="hits">阅读次数：1487</span><br>
                    <span class="time">2016-07-14 13:14:28</span> <span class="class">分类：<a href="http://www.ime.pku.edu.cn/newsshow.php?id=7&amp;cid"></a></span>
                </li>

                <% } %>
>>>>>>> c3399cc1239347cbc9b6e55795045e8df41eea20
            </ul>
        </div>
    </div>
    <!-- ####################################################################################################### -->
    <div  id="Pagination" class="pagination">

    </div>
    <!-- ####################################################################################################### -->
</div>
<!-- ####################################################################################################### -->
<div class="wrapper row4">
    <div class="rnd">
        <div id="footer" class="clear">
            <!-- ####################################################################################################### -->
            <div class="fl_left clear">
                <div class="fl_left center"><img src="images/demo/worldmap.gif" alt="" /><br />
                    <a href="#">Find Us With Google Maps &raquo;</a></div>
                <address>
                    Address Line 1<br />
                    Address Line 2<br />
                    Town/City<br />
                    Postcode/Zip<br />
                    <br />
                    Tel: xxxx xxxx xxxxxx<br />
                    Email: <a href="#">contact@domain.com</a>
                </address>
            </div>
            <div class="fl_right">
                <div id="social" class="clear">
                    <p>Stay Up to Date With Whats Happening</p>
                    <ul>
                        <li><a style="background-position:0 0;" href="#">Twitter</a></li>
                        <li><a style="background-position:-72px 0;" href="#">LinkedIn</a></li>
                        <li><a style="background-position:-142px 0;" href="#">Facebook</a></li>
                        <li><a style="background-position:-212px 0;" href="#">Flickr</a></li>
                        <li><a style="background-position:-282px 0;" href="#">RSS</a></li>
                    </ul>
                </div>
                <div id="newsletter">
                    <form action="#" method="post">
                        <fieldset>
                            <legend>Subscribe To Our Newsletter:</legend>
                            <input type="text" value="Enter Email Here&hellip;" onfocus="this.value=(this.value=='Enter Email Here&hellip;')? '' : this.value ;" />
                            <input type="text" id="subscribe" value="Submit" />
                        </fieldset>
                    </form>
                </div>
            </div>
            <!-- ####################################################################################################### -->
        </div>
    </div>
</div>
<!-- ####################################################################################################### -->


</body>
</html>


