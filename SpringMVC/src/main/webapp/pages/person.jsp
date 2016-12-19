<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.nju.ee.vo.ArticleVo" %>
<%@ page import="com.nju.ee.vo.PersonDescVo" %>
<%@ page import="com.nju.ee.entity.Person" %>
<%@ page import="com.nju.ee.vo.RestResult" %>
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

    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/person_show.css" type="text/css" />

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
                <div class="row-fluid">
                    <div class="span3 a_photo">
                        <div class="section-block no-border">
                            <div class="sec-img-div">
                                <div class="sec-img-div-inner"><img class="img-polaroid" src="${person_detail.data.imageUrl}" alt=""></div>
                            </div>
                            <p style="margin: 0px 5px;"><span class="teacher-name">${person_detail.data.name}</span></p>
                            <ul class="inline">
                                <li>${person_detail.data.level}</li>
                            </ul>
                        </div>
                    </div>
                    <div class="span9 a_words">
                        ${person_detail.data.introduction}
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






