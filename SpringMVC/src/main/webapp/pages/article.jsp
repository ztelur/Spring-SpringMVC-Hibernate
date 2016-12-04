<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.nju.ee.po.ArticlePo" %><%--
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
    <link rel="stylesheet" href="/styles/layout.css" type="text/css" />

    <link rel="shortcut icon" href="/images/favicon.ico" />
    <link rel="stylesheet" href="/styles/touchTouch.css">

    <link rel="stylesheet" href="/styles/style.css">
    <script src="/js/jquery.js"></script>
    <script src="/js/jquery-migrate-1.1.1.js"></script>
    <script src="/js/jquery.easing.1.3.js"></script>
    <script src="/js/script.js"></script>
    <script src="/js/superfish.js"></script>
    <script src="/js/jquery.equalheights.js"></script>
    <script src="/js/jquery.mobilemenu.js"></script>
    <script src="/js/tmStickUp.js"></script>
    <script src="/js/jquery.ui.totop.js"></script>
    <script src="/js/touchTouch.jquery.js"></script>


    <link rel="stylesheet" href="/styles/articles-list.css" type="text/css"/>
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
        <div class="article-list">
        <%
            List<ArticlePo>  articlesList = new ArrayList<ArticlePo>();
            ArticlePo articlePo = new ArticlePo();
            articlePo.setTitle("第一篇文章在第一个场雪的下午进行");


            for(ArticlePo po : articlesList){
        %>
        <h1 class="article-list-title">
            <span style="font-size: 12pt;">
                <%=po.getTitle() %><br>
            </span>
        </h1>
        <p>11/05/2016 - Le 17 mai prochain, à 11h, une cérémonie aura lieu à l’ISEP afin de déposer une plaque dans ses locaux, honorant les différentes collaborations entre la grande école d’ingénieurs et Texas Instruments...
            <br>
            <a href="/images/ISEP/Communication/Presse/cp_ceremonie_TI_ISEP.pdf">
                Lire la suite...
            </a>
            <a href="/images/ISEP/Communication/Presse/CP_2015_Isep_qualification_EESPIG.pdf">
                <img src="/images/pdf_button.png" border="0">
            </a>
        </p>
        <%}
        %>
        </div>
    </div>
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
<div class="wrapper">
    <div id="copyright" class="clear">
        <p class="fl_left">Copyright &copy; 2011 - All Rights Reserved - <a href="#">Domain Name</a></p>
        <p class="fl_right">Template from <a href="http://www.cssmoban.com/" title="模板之家">网站模板</a></p>
    </div>
</div>

</body>
</html>


