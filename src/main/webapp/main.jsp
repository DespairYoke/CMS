
<%@page import="entity.Count"%>
<%@ page contentType="text/html; charset=utf-8"  pageEncoding="utf-8"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>主要内容区main</title>
<link href="css/css.css" type="text/css" rel="stylesheet" />
<link href="css/main.css" type="text/css" rel="stylesheet" />
<link rel="shortcut icon" href="images/main/favicon.ico" />
<style>
body{overflow-x:hidden; background:#f2f0f5; padding:15px 0px 10px 5px;}
#main{ font-size:12px;}
#main span.time{ font-size:14px; color:#528dc5; width:100%; padding-bottom:10px; float:left}
#main div.top{ width:100%; background:url(images/main/main_r2_c2.jpg) no-repeat 0 10px; padding:0 0 0 15px; line-height:35px; float:left}
#main div.sec{ width:100%; background:url(images/main/main_r2_c2.jpg) no-repeat 0 15px; padding:0 0 0 15px; line-height:35px; float:left}
.left{ float:left}
#main div a{ float:left}
#main span.num{  font-size:30px; color:#538ec6; font-family:"Georgia","Tahoma","Arial";}
.left{ float:left}
div.main-tit{ font-size:14px; font-weight:bold; color:#4e4e4e; background:url(images/main/main_r4_c2.jpg) no-repeat 0 33px; width:100%; padding:30px 0 0 20px; float:left}
div.main-con{ width:100%; float:left; padding:10px 0 0 20px; line-height:36px;}
div.main-corpy{ font-size:14px; font-weight:bold; color:#4e4e4e; background:url(images/main/main_r6_c2.jpg) no-repeat 0 33px; width:100%; padding:30px 0 0 20px; float:left}
div.main-order{ line-height:30px; padding:10px 0 0 0;}
</style>
</head>
<body>
<!--main_top-->
<form method="post" action="main">
<table width="99%" border="0" cellspacing="0" cellpadding="0" id="main">
  <tr>
    <td colspan="2" align="left" valign="top">
   <%
       Count count=(Count)application.getAttribute("count");
   %>
    <span class="time"><strong>上午好！<%=count.getUname() %></strong><u>[超级管理员]</u></span>
    <div class="top"><span class="left">您上次的登灵时间：<%=count.getLasttime() %>   &nbsp; &nbsp;  welcome！  &nbsp;&nbsp;&nbsp;&nbsp;如非您本人操作，请及时</span><a href="updatePassword.jsp" target="mainFrame" onFocus="this.blur()">更改密码</a></div>
    <div class="sec">这是您第<span class="num"><%=count.getCount()+1 %></span>次,登录！</div>
    </td>
  </tr>
  <tr>
    <td align="left" valign="top" width="50%">
    <div class="main-tit">网站信息</div>
    <div class="main-con">
    员共员工人数:<font color="#538ec6"><strong>6</strong></font> 人<br/>
    管理员个数：<font color="#538ec6"><strong>6</strong></font> 人<br/>
    登陆者角色：超级管理员<br/>
    </div>
    </td>
    <td align="left" valign="top" width="49%">
    <div class="main-tit">功能权限</div>
    <div class="main-con">
<a href="addUser.jsp">添加员工</a><br/>
<a href="list.do">查看员工</a><br/>
<a href="">查看管理员</a><br/>
<a href="">查看员工工资</a> <br/>
    </div>
    </td>
  </tr>
  <tr>
    <td colspan="2" align="left" valign="top">
    <div class="main-corpy">系统提示</div>
    <div class="main-order">1=>如您在使用过程有发现出错请及时与我们取得联系；为保证您得到我们的后续服务，强烈建议您购买我们的正版系统或向我们定制系统！<br/>
2=>强烈建议您将IE7以上版本或其他的浏览器</div>
    </td>
  </tr>
</table>
</form>
</body>
</html>