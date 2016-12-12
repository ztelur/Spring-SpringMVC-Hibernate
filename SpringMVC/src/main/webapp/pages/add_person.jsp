<%--
  Created by IntelliJ IDEA.
  User: 张韶阳
  Date: 16/12/7
  Time: 21:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <meta charset="utf-8">
  <!--my css-->
  <link rel="stylesheet" href="/css/person.css">
</head>
<body>
<div class="container">
  <form method="post" action="/people/manage">
    <div class="input_wrapper">
      <input class="person_input" type="text" placeholder="姓名" name="name" required/>
    </div>
    <div class="input_wrapper">
      <select class="person_input" name="level">
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
    <textarea class="introduction" required name="introduction" placeholder="个人简介" rows="5"></textarea>
    <input type="text" hidden id="imageUrl" name="imageUrl" name="imageUrl"/>
    <input type="file" name="image" id="image" accept="image/gif, image/jpeg" style="display: none;">
    <button type="button" onclick="image.click()" class="upload_button">上传头像</button>
    <div class="form_footer">
      <button type="submit" class="form_button submit">提交</button>
    </div>
  </form>
</div>
</body>
</html>
