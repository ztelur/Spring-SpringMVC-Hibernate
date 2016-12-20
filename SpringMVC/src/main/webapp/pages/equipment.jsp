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
        <div id="container" class="clear">
            <!-- ####################################################################################################### -->
            <div class="row">
                <div class="grid_4">
                    <div class="box">
                        <a href="images/equipment1.jpg" class="gall_item"><img src="/images/equipment1.jpg" alt=""></a>
                        <div class="box_bot">
                            <div class="box_bot_title">长城温控单轴速率位置转台</div>
                            <p> 购于2016年，主要用于分析</p>
                            <a href="#" class="btn">more</a>
                        </div>
                    </div>
                </div>


            </div>
            <!-- ####################################################################################################### -->
            <div  id="Pagination" class="pagination">

            </div>
            <!-- ####################################################################################################### -->
        </div>
    </div>
</div>
<%@ include file="footer.jsp" %>
</body>
</html>

