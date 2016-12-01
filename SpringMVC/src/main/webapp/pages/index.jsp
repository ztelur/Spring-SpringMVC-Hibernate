<%--
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
    <link rel="stylesheet" href="styles/layout.css" type="text/css" />
    <!-- Homepage Specific Elements -->
    <script type="text/javascript" src="js/jquery-1.4.1.min.js"></script>
    <script type="text/javascript" src="js/jquery-ui-1.7.2.custom.min.js"></script>
    <script type="text/javascript" src="js/jquery.tabs.setup.js"></script>
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
<div class="wrapper">
    <div id="featured_slide" class="clear">
        <!-- ###### -->
        <div class="overlay_left"></div>
        <div id="featured_content">
            <div class="featured_box" id="fc1"><img src="images/1.jpg" alt="" />
                <div class="floater">
                    <h2>新闻1</h2>
                    <p> 团队人员获得国家重大科研突破奖xxxxxxxxx ddddddddddd</p>
                    <p class="readmore"><a href="#">Continue Reading &raquo;</a></p>
                </div>
            </div>
            <div class="featured_box" id="fc2"><img src="images/2.jpg" alt="" />
                <div class="floater">
                    <h2>新闻2</h2>
                    <p> 团队成员在《Science》上发布头条文章</p>
                    <p class="readmore"><a href="#">Continue Reading &raquo;</a></p>
                </div>
            </div>
            <div class="featured_box" id="fc3"><img src="images/3.jpg" alt="" />
                <div class="floater">
                    <h2>Aliquatjusto quisque nam</h2>
                    <p> 团队成员在《Science》上发布头条文章</p>
                    <p class="readmore"><a href="#">Continue Reading &raquo;</a></p>
                </div>
            </div>
            <div class="featured_box" id="fc4"><img src="images/4.jpg" alt="" />
                <div class="floater">
                    <h2>新闻3</h2>
                    <p> 有一个新闻发生了，但是大多数人还不知道</p>
                    <p class="readmore"><a href="#">Continue Reading &raquo;</a></p>
                </div>
            </div>
            <div class="featured_box" id="fc5"><img src="images/5.jpg" alt="" />
                <div class="floater">
                    <h2>新闻3</h2>
                    <p> 有一个新闻发生了，但是大多数人还不知道</p>
                    <p class="readmore"><a href="#">Continue Reading &raquo;</a></p>
                </div>
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
        <p class="fl_left">Copyright &copy; 2011 - All Rights Reserved - <a href="#">南京大学电子学院</a></p>
    </div>
</div>
</body>
</html>

