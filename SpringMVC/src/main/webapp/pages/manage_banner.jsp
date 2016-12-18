<%--
  Created by IntelliJ IDEA.
  User: zangxiaojie
  Date: 2016/12/6
  Time: 10:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.nju.ee.vo.RestResult" %>
<!DOCTYPE html>
<html>
<head profile="http://gmpg.org/xfn/11">
    <title> 轮播页管理</title>
    <meta charset="utf-8">
    <meta http-equiv="imagetoolbar" content="no" />
    <link rel="stylesheet" href="<%=request.getContextPath() %>/styles/layout.css" type="text/css" />
    <link rel="shortcut icon" href="<%=request.getContextPath() %>/images/favicon.ico" />
    <link rel="stylesheet" href="<%=request.getContextPath() %>/styles/touchTouch.css">
    <link rel="stylesheet" href="<%=request.getContextPath() %>/styles/manage.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/pagination.css"/>
    <link rel="stylesheet" href="<%=request.getContextPath() %>/styles/style.css"/>
    <link rel="stylesheet" href="<%=request.getContextPath() %>/css/person.css"/>
    <script src="<%=request.getContextPath() %>/js/jquery.js"></script>
    <%-- <script src="http://lib.sinaapp.com/js/jquery/1.9.1/jquery-1.9.1.min.js"></script> --%>
    <script src="<%=request.getContextPath()%>/js/manage_banner.js"></script>



    <link rel="stylesheet" href="<%=request.getContextPath() %>/styles/news.css" type="text/css" />
    <link rel="stylesheet" href="<%=request.getContextPath() %>/styles/manage_banner.css" type="text/css" />
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
                <li><a href="/equipments/manage/list">设备</a></li>
                <li><a href="/papers/manage/list">论文</a></li>
                <li><a href="/teams/manage/list">团队</a></li>
                <li ><a href="/articles/manage/list">新闻</a></li>
                <li><a href="/people/manage/list">人员</a></li>
                <li class="active"><a href="/banners/manage/list">轮播页</a></li>

            </ul>
        </div>
        <!-- ###### -->
    </div>
</div>



<div class="wrapper row3">
    <div class="rnd">
            <ul class="news_list_container">
              <form method="post" action="/banners/manage/update">
              <c:forEach items="${banners.data}" var="banner" varStatus="loop">
                  <div class="container banner_manager_div">
                    <h1 >轮播页${banner.id}</h1>
                    <div class="input_wrapper">
                      <input class="person_input" type="text" placeholder="标题" name="banners[${loop.index}].title" id="name" />
                    </div>
                    <textarea class="introduction"  name="banners[${loop.index}].brief" placeholder="简介" rows="5" id="introduction"></textarea>
                    <div class="input_wrapper">
                      <input class="person_input" type="text" placeholder="详情链接" name="banners[${loop.index}].infoUrl" id="name" />
                    </div>
                    <div class="head_wrapper">
                        <input type="file" name="banners[${loop.index}].picture" id="image${banner.id}" accept="image/gif, image/jpeg" style="display: none;">
                        <img id="img_head${banner.id}" src="" style="width: 120px;height: 120px;text-align: center;border-radius: 50%" onclick="click_upload(${banner.id})"/>
                        <span type="button" class="upload_button" onclick="click_upload(${banner.id})">点击上传图片</span>
                    </div>
                    <%-- <input type="file" name="banners[0].picture" id="image" accept="image/gif, image/jpeg" style="display: none;">
                    <button type="button" onclick="image.click()" class="upload_button">上传图片</button> --%>
                    <div class="input_wrapper banner_display_div">
                    <label >是否展示：
                      <input class="banner_radio" type="radio" name="banners[${loop.index}].enable" value="true">是</input>
                      <input class="banner_radio" type="radio" name="banners[${loop.index}].enable" value="false">否</input>
                    </label>
                    </div>
                  </div>
            </c:forEach>
            <div class="form_footer">
              <button type="submit" class="form_button submit">提交</button>
            </div>
          </form>
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
