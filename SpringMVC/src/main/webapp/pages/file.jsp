<%--
  Created by IntelliJ IDEA.
  User: 克崽兽
  Date: 2016/12/6
  Time: 21:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form name="uploadForm" id="uploadForm" method="post" action="<%= request.getContextPath() %>/files"
      enctype="multipart/form-data">
    <input type="file" name="file"/><br/>
    <input type="submit" value="上传" class="btn4"/>
</form>
</body>
</html>
