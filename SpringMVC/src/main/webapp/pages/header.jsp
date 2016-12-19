<%--
  Created by IntelliJ IDEA.
  User: homer
  Date: 16-12-19
  Time: 上午9:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <div id="header" class="clear">
        <div class="fl_left">
            <h1><a href="index.html">科研组</a></h1>
            <p>南京大学电子学院</p>
        </div>
        <div class="fl_right">
            <ul>
                <li><a href="#">主页</a></li>
                <li><a href="#">联系我们</a></li>
                <li><a href="#">如何找到我们</a></li>
            </ul>
            <form action="#" method="post" id="sitesearch">
                <fieldset>
                    <strong>Search:</strong>
                    <input type="text" value="Search Our Website&hellip;" onfocus="this.value=(this.value=='Search Our Website&hellip;')? '' : this.value ;" />
                    <input type="image" src="images/search.gif" id="search" alt="Search" />
                </fieldset>
            </form>
        </div>
    </div>
