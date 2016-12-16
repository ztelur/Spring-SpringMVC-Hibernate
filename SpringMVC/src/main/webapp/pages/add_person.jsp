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
</head>
<body>
<div class="container">
<c:if test="${is_add_page == 0}">
  <form method="post" action="/people/manage/${person_detail.data.id}">
</c:if>
<c:if test="${is_add_page == 1}">
  <form method="post" action="/people/manage">
</c:if>
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
    <textarea class="introduction" required name="introduction" placeholder="个人简介" rows="5" id="introduction"></textarea>
    <input type="text" hidden id="image" name="image"/>
    <input type="file" name="image" id="image" accept="image/gif, image/jpeg" style="display: none;">
    <button type="button" onclick="image.click()" class="upload_button">上传头像</button>
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
  });
  function reset(){
    $('#edit').froalaEditor('html.set', '');
  };
  function checkForm(){
    return true;
  }
</script>
</body>
</html>
