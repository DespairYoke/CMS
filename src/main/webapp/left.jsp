<%@ page pageEncoding="utf-8" contentType="text/html; charset=utf-8"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>左侧导航menu</title>
<link href="css/css.css" type="text/css" rel="stylesheet" />
<script type="text/javascript" src="js/sdmenu.js"></script>
<script type="text/javascript">
	// <![CDATA[
	var myMenu;
	window.onload = function() {
		myMenu = new SDMenu("my_menu");
		myMenu.init();
	};
	// ]]>
</script>
<style type=text/css>s
html{ SCROLLBAR-FACE-COLOR: #538ec6; SCROLLBAR-HIGHLIGHT-COLOR: #dce5f0; SCROLLBAR-SHADOW-COLOR: #2c6daa; SCROLLBAR-3DLIGHT-COLOR: #dce5f0; SCROLLBAR-ARROW-COLOR: #2c6daa;  SCROLLBAR-TRACK-COLOR: #dce5f0;  SCROLLBAR-DARKSHADOW-COLOR: #dce5f0; overflow-x:hidden;}
body{overflow-x:hidden; background:url(images/main/leftbg.jpg) left top repeat-y #f2f0f5; width:194px;}
</style>
</head>
<body onselectstart="return false;" ondragstart="return false;" oncontextmenu="return false;">
<div id="left-top">
	<div><img src="images/main/member.gif" width="44" height="44" /></div>
    <span>用户:admin<br>角色:超级管理员</span>
</div>
    <div style="float: left" id="my_menu" class="sdmenu">
      <div class="collapsed">
        <span>后台首页</span>
        
        <a href="main.jsp" target="mainFrame" onFocus="this.blur()">回到首页</a>
        <!-- <a href="main_list.html" target="mainFrame" onFocus="this.blur()">ç¨æ·ç®¡ç</a>
        <a href="main_info.html" target="mainFrame" onFocus="this.blur()">åè¡¨è¯¦ç»é¡µ</a>
        <a href="main_message.html" target="mainFrame" onFocus="this.blur()">çè¨é¡µ</a>
        <a href="main_menu.html" target="mainFrame" onFocus="this.blur()">æ ç®ç®¡ç</a> -->
      </div>
      <div>
        <span>用户管理</span>
        <a href="addUser.jsp" target="mainFrame" onFocus="this.blur()">增加用户</a> <!-- å¢å ç¨æ·;main.html -->
        <a href="admin.dp" target="mainFrame" onFocus="this.blur()">查看管理员信息</a>
        <a href="list.do" target="mainFrame" onFocus="this.blur()">查看员工信息</a>
        <a href="user.jsp" target="mainFrame" onFocus="this.blur()">查看客户信息</a>
      </div>
      <div>
        <span>留言管理</span>
        <a href="main_message.jsp" target="mainFrame" onFocus="this.blur()">留言列表</a>
        <a href="message_add.jsp" target="mainFrame" onFocus="this.blur()">发布留言</a>
        <!-- <a href="message_replay.jsp" target="mainFrame" onFocus="this.blur()">留言回复</a> -->
      </div>
      <div>
        <span>商品信息</span>
        <a href="fruit_info.jsp" target="mainFrame" onFocus="this.blur()">商品详情</a>
        <a href="order_info.jsp" target="mainFrame" onFocus="this.blur()">订单详情</a>
        <!-- <a href="message_replay.jsp" target="mainFrame" onFocus="this.blur()">留言回复</a> -->
      </div>
      <div>
        <span>信息管理</span>
        <a href="company_info.jsp" target="mainFrame" onFocus="this.blur()">公司信息</a>
        <a href="main_list.html" target="mainFrame" onFocus="this.blur()">财务信息</a>
        <a href="main_info.html" target="mainFrame" onFocus="this.blur()">招聘信息</a>
        <!-- <a href="main.html" target="mainFrame" onFocus="this.blur()">èªå®ä¹æé</a> -->
      </div>
    </div>
</body>
</html>