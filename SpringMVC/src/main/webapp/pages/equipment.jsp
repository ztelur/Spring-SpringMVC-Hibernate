<%--
  Created by IntelliJ IDEA.
  User: homer
  Date: 16-10-30
  Time: 下午9:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head profile="http://gmpg.org/xfn/11">
    <title>Academic Education | Gallery</title>
    <meta charset="utf-8">
    <meta http-equiv="imagetoolbar" content="no" />
    <link rel="stylesheet" href="<%=request.getContextPath()%>/styles/layout.css" type="text/css" />

    <link rel="shortcut icon" href="<%=request.getContextPath()%>/images/favicon.ico" />
            <link rel="stylesheet" href="<%=request.getContextPath()%>/styles/touchTouch.css">

            <link rel="stylesheet" href="<%=request.getContextPath()%>/styles/style.css">
            <script src="<%=request.getContextPath()%>/js/jquery.js"></script>
    <script src="<%=request.getContextPath()%>/js/jquery-migrate-1.1.1.js"></script>
    <script src="<%=request.getContextPath()%>/js/jquery.easing.1.3.js"></script>
    <script src="<%=request.getContextPath()%>/js/script.js"></script>
    <script src="<%=request.getContextPath()%>/js/superfish.js"></script>
    <script src="<%=request.getContextPath()%>/js/jquery.equalheights.js"></script>
    <script src="<%=request.getContextPath()%>/js/jquery.mobilemenu.js"></script>
    <script src="<%=request.getContextPath()%>/js/tmStickUp.js"></script>
    <script src="<%=request.getContextPath()%>/js/jquery.ui.totop.js"></script>
    <script src="<%=request.getContextPath()%>/js/touchTouch.jquery.js"></script>
    <script src="<%=request.getContextPath()%>/js/equipment.js"></script>

    <!-- End Gallery Specific Elements -->
</head>
<body id="top">
<div class="wrapper row1">
    <%@ include file="header.jsp" %>
</div>
<!-- ####################################################################################################### -->
<div class="wrapper row2">
    <div class="rnd">
        <%@ include file="nav.jsp" %>
    </div>
</div>
<!-- ####################################################################################################### -->
<div class="wrapper row3">
    <div class="rnd">
        <div id="container" class="clear">
            <!-- ####################################################################################################### -->
            <div class="row">
                <div class="grid_4">
                    <div class="box">
                        <a href="images/equipment1.jpg" class="gall_item"><img src="/images/equipment1.jpg" alt=""><span></span></a>
                        <div class="box_bot">
                            <div class="box_bot_title">长城温控单轴速率位置转台</div>
                            <p> 购于2016年，主要用于分析</p>
                            <a href="#" class="btn">more</a>
                        </div>
                    </div>
                </div>
                <div class="grid_4">
                    <div class="box">
                        <a href="images/equipment2.jpg" class="gall_item"><img src="/images/equipment2.jpg" alt=""><span></span></a>
                        <div class="box_bot">
                            <div class="box_bot_title">Y5340/2F恒加速度试验机</div>
                            <p>Dorem ipsum dolor sit amet, consectetur adipiscing elit. In mollis erat ma</p>
                        </div>
                    </div>
                </div>
                <div class="grid_4">
                    <div class="box">
                        <a href="images/equipment3.jpg" class="gall_item"><img src="/images/equipment3.jpg" alt=""><span></span></a>
                        <div class="box_bot">
                            <div class="box_bot_title">通用台式仪器</div>
                            <p>Dorem ipsum dolor sit amet, consectetur adipiscing elit. In mollis erat mattis neque facilisis, sit amet ultricies erat rutrum. Cras facilisis, nulla vel viverra auctor, leo magna sodales felis, quis malesuada nibh odio ut velit</p>
                        </div>
                    </div>
                </div>
                <div class="grid_4">
                    <div class="box">
                        <a href="images/equipment4.jpg" class="gall_item"><img src="/images/equipment4.jpg" alt=""><span></span></a>
                        <div class="box_bot">
                            <div class="box_bot_title">HP83711A正弦波发生器</div>
                            <p>Dorem ipsum dolor sit amet, consectetur adipiscing elit. In mollis erat mattis neque facilisis, sit amet ultricies erat rutrum. Cras facilisis, nulla vel viverra auctor, leo magna sodales felis, quis malesuada nibh odio ut velit</p>
                        </div>
                    </div>
                </div>
                <div class="grid_4">
                    <div class="box">
                        <a href="images/equipment5.jpg" class="gall_item"><img src="/images/equipment5.jpg" alt=""><span></span></a>
                        <div class="box_bot">
                            <div class="box_bot_title">HP8133A脉冲信号发生器</div>
                            <p>Dorem ipsum dolor sit amet, consectetur adipiscing elit. In mollis erat mattis neque facilisis, sit amet ultricies erat rutrum. Cras facilisis, nulla vel viverra auctor, leo magna sodales felis, quis malesuada nibh odio ut velit</p>
                        </div>
                    </div>
                </div>
                <div class="grid_4">
                    <div class="box">
                        <a href="images/equipment6.jpg" class="gall_item"><img src="/images/equipment6.jpg" alt=""><span></span></a>
                        <div class="box_bot">
                            <div class="box_bot_title">安捷伦 8417 ET网络分析仪</div>
                            <p>Dorem ipsum dolor sit amet, consectetur adipiscing elit. In mollis erat mattis neque facilisis, sit amet ultricies erat rutrum. Cras facilisis, nulla vel viverra auctor, leo magna sodales felis, quis malesuada nibh odio ut velit</p>
                        </div>
                    </div>
                </div>

            </div>
            <!-- ####################################################################################################### -->
            <div  id="Pagination" class="pagination">

            </div>
            <!-- ####################################################################################################### -->
        </div>
    </div>
</div>
<%@ include file="footer.jsp" %>
</body>
</html>

