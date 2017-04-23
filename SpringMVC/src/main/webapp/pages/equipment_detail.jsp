<%--
  Created by IntelliJ IDEA.
  User: homer
  Date: 16-12-19
  Time: 上午10:33
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
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/equipment_show.css" type="text/css" />
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
        <div  class="equipment-show">
            <div class="article-title">${equipment.data.name}</div>
            <div id="description">
                <div class = "imgholder">
                    <img src="${equipment.data.url}" width="40%">
                </div>
                <div class="fr-view">
                    ${equipment.data.description}
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
<%@ include file="footer.jsp" %>
</body>
</html>
