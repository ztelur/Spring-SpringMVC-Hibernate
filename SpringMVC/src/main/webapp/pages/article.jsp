<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.nju.ee.vo.ArticleVo" %>
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
    <link rel="stylesheet" href="<%=request.getContextPath()%>/styles/layout.css" type="text/css" />
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/pagination.css"/>

    <script src="<%=request.getContextPath()%>/js/jquery-1.4.1.min.js"></script>
    <script src="<%=request.getContextPath()%>/js/jquery.pagination.js"></script>
    <script src="<%=request.getContextPath()%>/js/article.js"></script>


    <link rel="stylesheet" href="<%=request.getContextPath()%>/styles/news.css" type="text/css" />

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
        <div class="news_list2">
            <ul class="news_list_container">
            </ul>
        </div>
    </div>
    <!-- ####################################################################################################### -->
    <div  id="Pagination" class="pagination">

    </div>
    <!-- ####################################################################################################### -->
</div>
<!-- ####################################################################################################### -->
<%@ include file="footer.jsp" %>
<!-- ####################################################################################################### -->


</body>
</html>


