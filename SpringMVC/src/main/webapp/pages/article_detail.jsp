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
    <title>${article.data.title}</title>
    <meta charset="utf-8">
    <meta http-equiv="imagetoolbar" content="no" />
    <link rel="stylesheet" href="<%=request.getContextPath()%>/styles/layout.css" type="text/css" />
    <!-- Include Font Awesome. -->
    <link href="//cdnjs.cloudflare.com/ajax/libs/font-awesome/4.4.0/css/font-awesome.min.css" rel="stylesheet" type="text/css" />

    <!-- Include Editor style. -->
    <link href="/node_modules/froala-editor/css/froala_editor.min.css" rel="stylesheet" type="text/css" />
    <link href="/node_modules/froala-editor/css/froala_style.min.css" rel="stylesheet" type="text/css" />

    <!-- Include Code Mirror style -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/codemirror/5.3.0/codemirror.min.css">

    <!-- Include Editor Plugins style. -->
    <link rel="stylesheet" href="<%=request.getContextPath()%>/node_modules/froala-editor/css/plugins/char_counter.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/node_modules/froala-editor/css/plugins/code_view.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/node_modules/froala-editor/css/plugins/colors.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/node_modules/froala-editor/css/plugins/emoticons.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/node_modules/froala-editor/css/plugins/file.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/node_modules/froala-editor/css/plugins/fullscreen.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/node_modules/froala-editor/css/plugins/image.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/node_modules/froala-editor/css/plugins/image_manager.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/node_modules/froala-editor/css/plugins/line_breaker.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/node_modules/froala-editor/css/plugins/quick_insert.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/node_modules/froala-editor/css/plugins/table.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/node_modules/froala-editor/css/plugins/video.css">

    <!--my css-->
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/article.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/styles/article_detail.css" type="text/css" />
    <script src="<%=request.getContextPath()%>/js/jquery-1.4.1.min.js"></script>

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
            <div class="content">
                <div class="article-title">${article.data.title}</div>

                <span><i class="icon-calendar "></i>类别：${article.data.category}</span>
                <span><i class="icon-calendar "></i>发表时间：${article.data.date}</span>
                <p>
                    ${article.data.content}
                </p>
            </div>
        </div>
    </div>
    <!-- ####################################################################################################### -->
    <!-- ####################################################################################################### -->
</div>
<!-- ####################################################################################################### -->
<%@ include file="footer.jsp" %>
<!-- ####################################################################################################### -->


</body>
</html>


