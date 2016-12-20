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

    <script src="js/jquery.js"></script>
    <!-- End Gallery Specific Elements -->
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
<div class="wrapper row3">
    <div class="rnd">
        <div class="ss-general-info">
            <h4>院士：</h4>
            <p class="p_font_mid clearfix" style="margin: 0 0 20px 40px;"><span class="block-text">院士1</span></p>
            <h4>教授：</h4>
            <p class="p_font_mid clearfix" style="margin: 0 0 20px 40px;"><a class="block-text" href="http://www.ss.pku.edu.cn/index.php/teacherteam/teacherlist/1655-%E6%9B%B9%E5%96%9C%E4%BF%A1">教授1</a> <span class="block-text">教授2</span><a class="block-text" href="http://www.ss.pku.edu.cn/index.php/teacherteam/teacherlist/1666-%E7%AA%A6%E5%B0%94%E7%BF%94">教授3</a> </p>
            <h4>博士生：</h4>
            <p class="p_font_mid clearfix" style="margin: 0 0 20px 40px;"><span class="block-text">博士生1</span> <span class="block-text">博士2</span> <span class="block-text">博士生3</span> </p>
            <p class="pull-right" style="margin: 20px 40px; color: #585754;">* 按姓氏拼音排序，更新于2015年1月</p>
            <br style="clear: both;"></div>
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





