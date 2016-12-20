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
            isEquipments = url.contains("equipment");
            isPapers = url.contains("paper");
            isTeams = url.contains("team");
            isArticles = url.contains("article");
            isMain = !(isEquipments || isPapers || isTeams || isArticles);
            System.out.println("the url is " + url + " " + isEquipments);
        %>
        <li class="<%=isMain?"active":""%>"><a href="/">主页</a></li>
        <li class="<%=isEquipments?"active":""%>"><a href="/equipments/main">设备</a></li>
        <li class="<%=isPapers?"active":""%>"><a href="/papers/main">论文</a></li>
        <li class="<%=isTeams?"active":""%>"><a href="/teams">团队</a></li>
        <li class="<%=isArticles?"active":""%>"><a href="/articles/main">新闻</a></li>
        <li class="<%=isArticles?"active":""%>"><a href="/contact">联系我们</a></li>

    </ul>
</div>

