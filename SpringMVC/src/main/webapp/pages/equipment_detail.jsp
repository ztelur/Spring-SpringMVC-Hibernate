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
            <div class="article-title">${equipment.data.name}</div>
            <div id="description">
                <p>
                    ${equipment.data.description}
                </p>
            </div>
        </div>
    </div>
</div>
<%@ include file="footer.jsp" %>
</body>
</html>
