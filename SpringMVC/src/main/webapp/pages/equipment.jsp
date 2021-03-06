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
    <title>Academic Education | Gallery</title>
    <meta charset="utf-8">
    <meta http-equiv="imagetoolbar" content="no" />
    <link rel="stylesheet" href="<%=request.getContextPath()%>/styles/layout.css" type="text/css" />
    <link rel="stylesheet" href="<%=request.getContextPath()%>/styles/style.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/pagination.css"/>
    <script src="<%=request.getContextPath()%>/js/jquery-1.4.1.min.js"></script>

    <script src="<%=request.getContextPath()%>/js/equipment.js"></script>
    <script src="<%=request.getContextPath()%>/js/jquery.pagination.js"></script>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/equipment_show.css" type="text/css" />

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
        <div class="wrapper">
            <div id="featured_slide">
            </div>
        </div>

        <div id="homepage" class="clear">
            <div >
                <div class="row-list">
                </div>
                <!-- ####################################################################################################### -->
                <div  id="Pagination" class="pagination" >
            </div>
        </div>
    </div>
        </div>
    <div id="asidepart">
        <%@ include file="nav.jsp"%>
    </div>
</div>

<%@ include file="footer.jsp" %>
</body>
</html>

