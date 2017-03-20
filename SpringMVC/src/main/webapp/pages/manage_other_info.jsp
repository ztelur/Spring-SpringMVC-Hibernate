<%--
  Created by IntelliJ IDEA.
  User: 克崽兽
  Date: 2016/12/20
  Time: 21:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head profile="http://gmpg.org/xfn/11">
    <title> 其它信息管理</title>
    <meta charset="utf-8">
    <meta http-equiv="imagetoolbar" content="no"/>
    <link rel="stylesheet" href="<%=request.getContextPath() %>/styles/layout.css" type="text/css"/>
    <link rel="shortcut icon" href="<%=request.getContextPath() %>/images/favicon.ico"/>
    <link rel="stylesheet" href="<%=request.getContextPath() %>/styles/touchTouch.css">
    <link rel="stylesheet" href="<%=request.getContextPath() %>/styles/manage.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/pagination.css"/>
    <link rel="stylesheet" href="<%=request.getContextPath() %>/styles/style.css">
    <script src="<%=request.getContextPath() %>/js/jquery-1.4.1.min.js"></script>



    <link rel="stylesheet" href="<%=request.getContextPath() %>/css/person.css" type="text/css"/>
    <!-- End Gallery Specific Elements -->
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/manage_other_info.css"/>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/styles/news.css"/>
    <script src="http://api.map.baidu.com/api?v=2.0&ak=Ai0m8G67QbgALKDDHA1U24hnYHP8rgSF"></script>

</head>
<body id="top">
  <div class="wrapper row1">
      <%@ include file="manage_header.jsp" %>
  </div>
  <!-- ####################################################################################################### -->
  <div class="wrapper manage-div">
      <div class="rnd">
          <!-- ###### -->
          <div id="topnav">
              <ul>
                  <li><a href="/equipments/manage/list">设备</a></li>
                  <li><a href="/papers/manage/list">论文</a></li>
                  <li ><a href="/articles/manage/list">新闻</a></li>
                  <li><a href="/people/manage/list">人员</a></li>
                  <li><a href="/banners/manage/list">轮播页</a></li>
                  <li class="active"><a href="/otherInfos/manage/list">其他信息</a></li>

              </ul>
          </div>
          <!-- ###### -->
      </div>
  </div>

<div class="wrapper row3">
    <div class="rnd">
        <div id="allmap"></div>
        <div id="form_container">
            <form id="form" method="post" action="/otherInfos/manage/update">

                <input type="hidden" name="id" value="${otherInfo.data.id}">
                <input type="hidden" name="longitude" id="longitude" value = "${otherInfo.data.longitude}" />
                <input type="hidden" name="latitude" id="latitude" value = "${otherInfo.data.latitude}" />

                <div class="email_div">
                  <label class="email_label" for="email">联系邮箱：</label>
                  <input class="email_input" type="text" placeholder="邮箱" name="email" id="email" value="${otherInfo.data.email}" />
                </div>

                <div class="email_div">
                  <label class="email_label" for="telephone">联系电话：</label>
                  <input class="email_input" type="text" placeholder="电话" name="telephone" id="telephone" value="${otherInfo.data.telephone}" />
                </div>

                <div class="email_div">
                  <label class="email_label" for="fax">传&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp真：</label>
                  <input class="email_input" type="text" placeholder="传真" name="fax" id="fax" value="${otherInfo.data.fax}" />
                </div>


                <div class="form_footer">
                  <button type="submit" class="form_button submit">提交</button>
                </div>
            </form>
        </div>
    </div>
</div>

<!-- ####################################################################################################### -->

<!-- ####################################################################################################### -->
<script src="<%=request.getContextPath()%>/js/manage_other_info.js"></script>
</body>
</html>
