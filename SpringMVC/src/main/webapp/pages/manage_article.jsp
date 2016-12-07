<%--
  Created by IntelliJ IDEA.
  User: zangxiaojie
  Date: 2016/12/6
  Time: 10:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
                <li> 
                    <span class="title"><a href="http://www.ime.pku.edu.cn/newsshow.php?id=7&amp;cid=197"  title="武常岐教授受聘微纳电子与集成系统协同创新中心顾问委员会委员">团队成员获得重大科技突破奖</a></span>
                    <span class="hits">
                            <button>编辑</button>
                            <button>删除</button>
                    </span>
                    <br>
                    <span class="time">2016-07-14 13:14:28</span> <span class="class">分类：<a href="http://www.ime.pku.edu.cn/newsshow.php?id=7&amp;cid"></a></span> </li>
                <li> <span class="title"><a href="http://www.ime.pku.edu.cn/newsshow.php?id=7&amp;cid=194"  title="张海霞教授课题组在摩擦诱导静电放电的研究中取得重要进展">课题组在膜电子领域获得突破</a></span><span class="hits">阅读次数：1570</span><br>
                    <span class="time">2016-06-05 21:02:50</span> <span class="class">分类：<a href="http://www.ime.pku.edu.cn/newsshow.php?id=7&amp;cid"></a></span> </li>
                <li> <span class="title"><a href="http://www.ime.pku.edu.cn/newsshow.php?id=7&amp;cid=193"  title="学校科学研究部周辉部长一行调研微纳电子学研究院">南京大学校领导一行调研微纳电子学研究院</a></span><span class="hits">阅读次数：1777</span><br>
                    <span class="time">2016-05-31 09:46:45</span> <span class="class">分类：<a href="http://www.ime.pku.edu.cn/newsshow.php?id=7&amp;cid"></a></span> </li>
                <li> <span class="title"><a href="http://www.ime.pku.edu.cn/newsshow.php?id=7&amp;cid=192"  title="微电子工艺实验室参观走廊开放展示">微电子工艺实验室参观走廊开放展示</a></span><span class="hits">阅读次数：1958</span><br>
                    <span class="time">2016-05-21 11:57:51</span> <span class="class">分类：<a href="http://www.ime.pku.edu.cn/newsshow.php?id=7&amp;cid"></a></span> </li>
                <li> <span class="title"><a href="http://www.ime.pku.edu.cn/newsshow.php?id=7&amp;cid=191"  title="微纳电子与集成系统协同创新中心2016年度战略研讨会暨青年科学家论坛成功举行">全国电子大会成功召开</a></span><span class="hits">阅读次数：2414</span><br>
                    <span class="time">2016-05-13 11:21:24</span> <span class="class">分类：<a href="http://www.ime.pku.edu.cn/newsshow.php?id=7&amp;cid"></a></span> </li>
                <li> <span class="title"><a href="http://www.ime.pku.edu.cn/newsshow.php?id=7&amp;cid=188"  title="国际电工委员会第47技术委员会第6和第7工作组会议在北京大学举行">xxxxxxxxxxxxxxxxxxxxxxxxxxxx</a></span><span class="hits">阅读次数：2420</span><br>
                    <span class="time">2016-04-22 15:19:53</span> <span class="class">分类：<a href="http://www.ime.pku.edu.cn/newsshow.php?id=7&amp;cid"></a></span> </li>
                <li> <span class="title"><a href="http://www.ime.pku.edu.cn/newsshow.php?id=7&amp;cid=187"  title="日本电子株式会社执行副总裁渡边慎一先生一行 访问北京大学微纳电子学研究院">xxxxxxxxxxxxxxxxxx</a></span><span class="hits">阅读次数：3055</span><br>

            </ul>
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
