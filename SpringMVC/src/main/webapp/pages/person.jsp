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
    <script src="<%=request.getContextPath()%>/js/jquery-1.4.1.min.js"></script>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/person_show.css" type="text/css" />
    <link href="<%=request.getContextPath()%>/node_modules/froala-editor/css/froala_style.min.css" rel="stylesheet" type="text/css" />
    <!-- End Gallery Specific Elements -->
</head>
<body id="top">

<header class="wrapper row1">
    <%@ include file="header.jsp" %>
</header>

<!-- ####################################################################################################### -->

<!-- ####################################################################################################### -->
<div  id="container">
    <div id="main">
        <div  class="clear">
            <div class="row-fluid">
                <div class="span3">
                    <div class="section-block no-border">
                        <div class="sec-img-div">
                            <div class="sec-img-div-inner"><img class="img-polaroid" src="${person_detail.data.imageUrl}" alt=""></div>
                        </div>
                        <p class="person_info"><span class="teacher-name">${person_detail.data.name}</span></p>
                        <p class="person_info"><span class="teacher-level">${person_detail.data.level}</span></p>
                    </div>
                </div>
                <div class="person_desc">
                    ${person_detail.data.introduction}
                </div>
            </div>
        </div>
    </div>
    <div id="asidepart">
        <%@ include file="nav.jsp"%>
    </div>
</div>

<!-- ####################################################################################################### -->
<div class="wrapper row3">
    <div class="rnd">

        </div>
    </div>

    <!-- ####################################################################################################### -->
</div>
<!-- ####################################################################################################### -->
<%@ include file="footer.jsp" %>
<!-- ####################################################################################################### -->


</body>
</html>






