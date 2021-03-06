<%--
  Created by IntelliJ IDEA.
  User: 张韶阳
  Date: 16/12/6
  Time: 22:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.nju.ee.vo.RestResult" %>
<!-- title date category content-->
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">

  <!-- Include Font Awesome. -->
  <link href="//cdnjs.cloudflare.com/ajax/libs/font-awesome/4.4.0/css/font-awesome.min.css" rel="stylesheet" type="text/css" />

  <!-- Include Editor style. -->
  <link href="<%=request.getContextPath()%>/node_modules/froala-editor/css/froala_editor.min.css" rel="stylesheet" type="text/css" />
  <link href="<%=request.getContextPath()%>/node_modules/froala-editor/css/froala_style.min.css" rel="stylesheet" type="text/css" />

  <!-- Include Code Mirror style -->
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/codemirror/5.3.0/codemirror.min.css">

  <!-- Include Editor Plugins style. -->
  <link rel="stylesheet" href="<%=request.getContextPath()%>/node_modules/froala-editor/css/plugins/char_counter.css">
  <link rel="stylesheet" href="<%=request.getContextPath()%>/node_modules/froala-editor/css/plugins/code_view.css">
  <link rel="stylesheet" href="<%=request.getContextPath()%>/node_modules/froala-editor/css/plugins/colors.css">
  <link rel="stylesheet" href="<%=request.getContextPath()%>/node_modules/froala-editor/css/plugins/emoticons.css">
  <link rel="stylesheet" href="<%=request.getContextPath()%>/node_modules/froala-editor/css/plugins/file.css">
  <link rel="stylesheet" href="<%=request.getContextPath()%>/node_modules/froala-editor/css/plugins/fullscreen.css">
  <link rel="stylesheet" href="<%=request.getContextPath()%>/node_modules/froala-editor/css/plugins/image.css">
  <link rel="stylesheet" href="<%=request.getContextPath()%>/node_modules/froala-editor/css/plugins/image_manager.css">
  <link rel="stylesheet" href="<%=request.getContextPath()%>/node_modules/froala-editor/css/plugins/line_breaker.css">
  <link rel="stylesheet" href="<%=request.getContextPath()%>/node_modules/froala-editor/css/plugins/quick_insert.css">
  <link rel="stylesheet" href="<%=request.getContextPath()%>/node_modules/froala-editor/css/plugins/table.css">
  <link rel="stylesheet" href="<%=request.getContextPath()%>/node_modules/froala-editor/css/plugins/video.css">

  <!--my css-->
  <link rel="stylesheet" href="<%=request.getContextPath()%>/css/article.css">
</head>
<body>
<!-- Create a tag that we will use as the editable area.
     You can use a div tag as well. -->
<div class="container">
  <c:if test="${is_add_page == 0}">
  <form class="article_form" onsubmit="return checkForm()" method="post" action="<%=request.getContextPath()%>/articles/manage/update/${article_detail.data.id}">
  </c:if>
  <c:if test="${is_add_page == 1}">
  <form class="article_form" onsubmit="return checkForm()" method="post" action="<%=request.getContextPath()%>/articles/manage">
  </c:if>
    <input type="text" class="title_input" placeholder="请输入标题" id="title" name="title" required/>
    <textarea id="edit" name="content"></textarea>
    <input type="text" class="title_input" placeholder="请输入类别" id="category" name="category"/>
    <div class="form_footer">
      <button type="button" onclick="reset()" class="form_button reset">清空</button>
      <button type="submit" class="form_button submit">提交</button>
    </div>
  </form>

</div>

<!-- Include jQuery. -->
<script type="text/javascript" src="//cdnjs.cloudflare.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
<%--<script type="text/javascript" src="../js/jquery-1.4.1.min.js"></script>--%>
<!-- Include JS files. -->
<script type="text/javascript" src="<%=request.getContextPath()%>/node_modules/froala-editor/js/froala_editor.min.js"></script>

<!-- Include Code Mirror. -->
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/codemirror/5.3.0/codemirror.min.js"></script>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/codemirror/5.3.0/mode/xml/xml.min.js"></script>

<!-- Include Plugins. -->
<script type="text/javascript" src="<%=request.getContextPath()%>/node_modules/froala-editor/js/plugins/align.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/node_modules/froala-editor/js/plugins/char_counter.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/node_modules/froala-editor/js/plugins/code_beautifier.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/node_modules/froala-editor/js/plugins/code_view.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/node_modules/froala-editor/js/plugins/colors.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/node_modules/froala-editor/js/plugins/emoticons.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/node_modules/froala-editor/js/plugins/entities.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/node_modules/froala-editor/js/plugins/file.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/node_modules/froala-editor/js/plugins/font_family.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/node_modules/froala-editor/js/plugins/font_size.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/node_modules/froala-editor/js/plugins/fullscreen.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/node_modules/froala-editor/js/plugins/image.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/node_modules/froala-editor/js/plugins/image_manager.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/node_modules/froala-editor/js/plugins/inline_style.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/node_modules/froala-editor/js/plugins/line_breaker.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/node_modules/froala-editor/js/plugins/link.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/node_modules/froala-editor/js/plugins/lists.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/node_modules/froala-editor/js/plugins/paragraph_format.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/node_modules/froala-editor/js/plugins/paragraph_style.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/node_modules/froala-editor/js/plugins/quick_insert.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/node_modules/froala-editor/js/plugins/quote.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/node_modules/froala-editor/js/plugins/table.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/node_modules/froala-editor/js/plugins/save.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/node_modules/froala-editor/js/plugins/url.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/node_modules/froala-editor/js/plugins/video.min.js"></script>

<!-- Include Language file if we want to use it. -->
<script type="text/javascript" src="<%=request.getContextPath()%>/node_modules/froala-editor/js/languages/ro.js"></script>

<!-- Initialize the editor. -->
<script>
  $(function() {
    $('#edit').froalaEditor({
      charCounterMax:10000,
      heightMin:400,
      // Set the image upload URL.
      imageUploadURL: '<%=request.getContextPath()%>/files',
      // Set request type.
      imageUploadMethod: 'POST',
      imageUploadParam:'file',
      // Set max image size to 10MB.
      imageMaxSize: 10 * 1024 * 1024,
      // Allow to upload PNG and JPG.
      imageAllowedTypes: ['jpeg', 'jpg', 'png']
    });
    <c:if test="${is_add_page == 0}">
    <!--进入编辑，需要对表单进行赋值-->
      $('#edit').froalaEditor('html.set', '<c:out value="${article_detail.data.content}" escapeXml="false"/>');
      $('#title').attr("value",'${article_detail.data.title}');
      $('#category').attr("value",'${article_detail.data.category}');
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