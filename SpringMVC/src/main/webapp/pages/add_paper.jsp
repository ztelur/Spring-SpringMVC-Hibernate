<%--
  Created by IntelliJ IDEA.
  User: homer
  Date: 16-12-16
  Time: 上午8:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>添加论文</title>
    <!--my css-->
    <link rel="stylesheet" href="/css/person.css">
</head>
<body>
<div class="container">
    <c:if test="${is_add_page == 0}">
        <form class="paper_form" onsubmit="return checkForm()" method="post" enctype="multipart/form-data" action="/papers/manage/${page_detail.data.id}">
        </c:if>
        <c:if test="${is_add_page == 1}">
        <form class="paper_form" onsubmit="return checkForm()" method="post" enctype="multipart/form-data" action="/papers/manage">
            </c:if>
        <div class="input_wrapper">
            <input class="person_input" type="text" placeholder="论文题目" name="title" required/>
        </div>

        <textarea class="introduction" required name="desc" placeholder="论文简介" rows="3"></textarea>

        <input type="file" name="pdf" id="pdf" accept="application/pdf" >
        <div class="form_footer">
            <button type="submit" class="form_button submit">提交</button>
        </div>
    </form>
</div>
</body>
</html>

