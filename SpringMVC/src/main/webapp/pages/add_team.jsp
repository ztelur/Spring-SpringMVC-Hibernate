<%--
  Created by IntelliJ IDEA.
  User: 张韶阳
  Date: 16/12/9
  Time: 21:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <meta charset="utf-8">
  <!--my css-->
  <link rel="stylesheet" href="<%=request.getContextPath()%>/css/team.css">
</head>
<body>
<div class="container">
  <form onsubmit="return false">
    <div class="input_wrapper">
      <input class="person_input" type="text" placeholder="项目组名称" name="name" required/>
    </div>
    <textarea class="introduction"  name="introduction" placeholder="项目组简介" rows="5"></textarea>
    <div class="select_container">
      <select multiple size="10" class="person_select" id="person_select" >
        <option value="TPZ">TPZ</option>
        <option value="哇哦丫头">哇哦丫头</option>
        <option value="Jo">Jp</option>
        <option value="Faruline">Faruline</option>
        <option value="Yyad">Yyad</option>
        <option value="Minko">Minko</option>
      </select>
      <div class="select_button_group">
        <button type="button" class="s_btn" onclick="add()">添加>></button>
        <button type="button" class="s_btn" onclick="remove()"><<移除</button>
      </div>
      <select  size="10" class="person_result" id="person_result">
      </select>
    </div>
    <div class="form_footer">
      <button type="submit" class="form_button submit">提交</button>
    </div>
  </form>
</div>
<!-- Include jQuery. -->
<script type="text/javascript" src="//cdnjs.cloudflare.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/team.js"></script>
</body>
</html>
