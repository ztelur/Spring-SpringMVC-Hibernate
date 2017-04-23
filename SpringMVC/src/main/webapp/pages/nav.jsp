<%--
  Created by IntelliJ IDEA.
  User: homer
  Date: 16-12-19
  Time: 上午9:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div id="topnav">
    <ul>
        <%
            String url = request.getRequestURL().toString();
            boolean isEquipments = false;
            boolean isPapers = false;
            boolean isTeams = false;
            boolean isArticles = false;
            boolean isMain = false;
            boolean isContact = false;
            isEquipments = url.contains("equipment");
            isPapers = url.contains("paper");
            isTeams = url.contains("team") || url.contains("person");
            isArticles = url.contains("article");
            isContact = url.contains("contact");
            isMain = !(isEquipments || isPapers || isTeams || isArticles || isContact);
            System.out.println("the url is " + url + " " + isEquipments);
        %>
        <li class="<%=isMain?"active nav-li":"nav-li"%>"><a href="<%=request.getContextPath()%>/">主页</a></li>
        <li class="<%=isEquipments?"active nav-li":"nav-li"%>"><a href="<%=request.getContextPath()%>/equipments/main">设备</a></li>
        <li class="<%=isPapers?"active nav-li":"nav-li"%>"><a href="<%=request.getContextPath()%>/papers/main">论文</a></li>
        <li class="<%=isTeams?"active nav-li":"nav-li"%>"><a href="<%=request.getContextPath()%>/teams">团队</a></li>
        <li class="<%=isArticles?"active nav-li":"nav-li"%>"><a href="<%=request.getContextPath()%>/articles/main">新闻</a></li>
        <li class="<%=isContact?"active nav-li":"nav-li"%>"><a href="<%=request.getContextPath()%>/contact/main">联系我们</a></li>
    </ul>
</div>

