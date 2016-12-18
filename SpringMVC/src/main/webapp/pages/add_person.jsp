<%--
  Created by IntelliJ IDEA.
  User: 张韶阳
  Date: 16/12/7
  Time: 21:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <meta charset="utf-8">
  <!--my css-->
    <link rel="stylesheet" href="/css/person.css">
    <script src="http://lib.sinaapp.com/js/jquery/1.9.1/jquery-1.9.1.min.js"></script>
</head>
<body>
<div class="container">
<c:if test="${is_add_page == 0}">
  <form method="post" action="/people/manage/${person_detail.data.id}">
</c:if>
<c:if test="${is_add_page == 1}">
  <form method="post" action="/people/manage">
</c:if>
    <div class="head_wrapper">
        <input type="file" name="image" id="image" accept="image/gif, image/jpeg" style="display: none;">
        <img id="img_head" src="../img/head.png" style="width: 120px;height: 120px;text-align: center;border-radius: 50%" onclick="click_upload()"/>
        <span type="button" onclick="click_upload()" class="upload_button">点击上传头像</span>
    </div>
    <div class="input_wrapper">
      <input class="person_input" type="text" placeholder="姓名" name="name" id="name" required/>
    </div>
    <div class="input_wrapper">
      <select class="person_input" name="level" id="level">
        <option value="博导">博导</option>
        <option value="教授">教授</option>
        <option value="副教授">副教授</option>
        <option value="讲师">讲师</option>
        <option value="助教">助教</option>
        <option value="博士">博士</option>
        <option value="硕士">硕士</option>
        <option value="无">无</option>
      </select>
    </div>
    <textarea class="introduction" required name="introduction" placeholder="个人简介" rows="8" id="introduction"></textarea>
    <div class="form_footer">
      <button type="submit" class="form_button submit">提交</button>
    </div>
  </form>
</div>

<script>
    <c:if test="${is_add_page == 0}">
    <!--进入编辑,需要对表单进行赋值-->
    $('#name').attr("value",'${person_detail.data.name}');
    //level 赋值
    //头像暂不处理;
    $('#introduction').attr("value",'${person_detail.data.introduction}');
    </c:if>
</script>
<script>
    $("#image").change(function(e) {
        for (var i = 0; i < e.target.files.length; i++) {
            var file = e.target.files.item(i);
            var freader = new FileReader();
            freader.readAsDataURL(file);
            freader.onload = function(e) {
                var src = e.target.result;
                $("#img_head").attr("src",src);
            }
        }
    });
    function click_upload(){
        $("#image").click();
    }
</script>
</body>
</html>
