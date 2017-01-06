<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%--
  Created by IntelliJ IDEA.
  User: homer
  Date: 16-12-16
  Time: 上午8:49
  To change this template use File | Settings | File Templates.
--%>

<html>
<head>
    <meta charset="utf-8">
    <title>添加论文</title>
    <!--my css-->
    <link rel="stylesheet" href="/css/person.css">
</head>
<body>
<div class="container">

    <c:if test="${is_add_page == 1}">
        <form class="paper_form" onsubmit="return checkForm()" method="post" enctype="multipart/form-data" action="/papers/manage">
            <div class="input_wrapper">

                <input class="person_input" type="text" placeholder="论文题目" name="title" required />
            </div>

            <textarea class="introduction" required name="desc" placeholder="论文简介" rows="3"></textarea>

    </c:if>
    <c:if test="${is_add_page == 0}">
            <form class="paper_form" onsubmit="return checkForm()" method="post" enctype="multipart/form-data" action="/papers/manage/update/${paper_detail.data.id}">
                <div class="input_wrapper">

                    <input class="person_input" type="text" placeholder="论文题目" name="title" required value="${paper_detail.data.title}"/>
                </div>

                <textarea class="introduction" required name="desc" placeholder="论文简介" rows="3"  >
                        ${fn:trim(paper_detail.data.desc)}
                </textarea>
                <label>原论文：</label><a href="${paper_detail.data.url}">点击预览 </a></span>
                </c:if>
                <input type="file" name="pdf" id="pdf" accept="application/pdf" >
                <div class="form_footer">
            <button type="submit" class="form_button submit">提交</button>
        </div>
    </form>
</div>
</body>
</html>

