<%@page import="dao.messageDao"%>
<%@page import="entity.Message"%>
<%@page import="java.util.List"%>
<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>主要内容区main</title>
<link href="css/css.css" type="text/css" rel="stylesheet" />
<link href="css/main.css" type="text/css" rel="stylesheet" />
<link rel="shortcut icon" href="images/main/favicon.ico" />
<style>
body {
	overflow-x: hidden;
	background: #f2f0f5;
	padding: 15px 0px 10px 5px;
}

#searchmain {
	font-size: 12px;
}

#search {
	font-size: 12px;
	background: #548fc9;
	margin: 10px 10px 0 0;
	display: inline;
	width: 100%;
	color: #FFF
}

#search form span {
	height: 40px;
	line-height: 40px;
	padding: 0 0px 0 10px;
	float: left;
}

#search form input.text-word {
	height: 24px;
	line-height: 24px;
	width: 180px;
	margin: 8px 0 6px 0;
	padding: 0 0px 0 10px;
	float: left;
	border: 1px solid #FFF;
}

#search form input.text-but {
	height: 24px;
	line-height: 24px;
	width: 55px;
	background: url(images/main/list_input.jpg) no-repeat left top;
	border: none;
	cursor: pointer;
	font-family: "Microsoft YaHei", "Tahoma", "Arial", '宋体';
	color: #666;
	float: left;
	margin: 8px 0 0 6px;
	display: inline;
}

#search a.add {
	background: url(images/main/add.jpg) no-repeat 0px 6px;
	padding: 0 10px 0 26px;
	height: 40px;
	line-height: 40px;
	font-size: 14px;
	font-weight: bold;
	color: #FFF
}

#search a:hover.add {
	text-decoration: underline;
	color: #d2e9ff;
}

#main-tab {
	border: 1px solid #eaeaea;
	background: #FFF;
	font-size: 12px;
}

#main-tab th {
	font-size: 12px;
	background: url(images/main/list_bg.jpg) repeat-x;
	height: 32px;
	line-height: 32px;
}

#main-tab td {
	font-size: 12px;
	line-height: 40px;
}

#main-tab td a {
	font-size: 12px;
	color: #548fc9;
}

#main-tab td a:hover {
	color: #565656;
	text-decoration: underline;
}

.bordertop {
	border-top: 1px solid #ebebeb
}

.borderright {
	border-right: 1px solid #ebebeb
}

.borderbottom {
	border-bottom: 1px solid #ebebeb
}

.borderleft {
	border-left: 1px solid #ebebeb
}

.gray {
	color: #dbdbdb;
}

td.fenye {
	padding: 10px 0 0 0;
	text-align: right;
}

.bggray {
	background: #f9f9f9
}

#addinfo {
	padding: 0 0 10px 0;
}
</style>
</head>
<body>
<!--main_top-->
<table width="99%" border="0" cellspacing="0" cellpadding="0" id="searchmain">
  <tr>
    <td width="99%" align="left" valign="top" id="addinfo">您的位置：留言板</td>
  </tr>
  <tr>
    <td align="left" valign="top">
    
    <table width="100%" border="0" cellspacing="0" cellpadding="0" id="main-tab">
      <tr>
        <th align="center" valign="middle" class="borderright">用户名</th>
       <!--  <th align="center" valign="middle" class="borderright">留言类型</th> -->
  		<th align="center" valign="middle" class="borderright">标题</th>
  		<th align="center" valign="middle" class="borderright">内容</th>
        <th align="center" valign="middle" class="borderright">联系方式</th>
        <th align="center" valign="middle" class="borderright">留言时间</th>
        <th align="center" valign="middle">操作</th>
     </tr>
     
     <%messageDao dao = new messageDao();
     	List<Message>list =dao.findAll();
     
     	for(int i = 0;i<list.size();i++){
     		Message m = list.get(i);
     	
     	
     	%>
      <tr onMouseOut="this.style.backgroundColor='#ffffff'" onMouseOver="this.style.backgroundColor='#edf5ff'">
        <td align="center" valign="middle" class="borderright borderbottom" style="color:red"><%=m.getUname()%></td>
        <td align="center" valign="middle" class="borderright borderbottom"><a href="message_info.html" target="mainFrame" onFocus="this.blur()"><%=m.getTitle() %></a></td>
        <td align="center" valign="middle" class="borderright borderbottom"><%=m.getContent()%></td>
        <td align="center" valign="middle" class="borderright borderbottom"><%=m.getEmail() %></td>
        <td align="center" valign="middle" class="borderright borderbottom"><%=m.getMestime() %></td>
		<td align="center" valign="middle" class="borderbottom">
				<a href="Message_replay?id=<%=m.getId()%>" target="mainFrame" onFocus="this.blur()" class="add">回复</a><span class="gray">&nbsp;|&nbsp;</span>
				<a href="add.html" target="mainFrame" onFocus="this.blur()"class="add">查看所有回复</a><span class="gray">&nbsp;|&nbsp;</span>
				<a href="delete?id=<%=m.getId()%>" target="mainFrame"onFocus="this.blur()" class="add">删除</a><span class="gray">&nbsp;|&nbsp;</span>
				<a href="message_info?id=<%=m.getId()%>" target="mainFrame" onFocus="this.blur()"class="add">查看</a>
		</td>
		</tr>
      <%} %> 
    </table></td>
    </tr>
  <tr>
    <td align="left" valign="top" class="fenye">11 条数据 1/1 页&nbsp;&nbsp;<a href="#" target="mainFrame" onFocus="this.blur()">首页</a>&nbsp;&nbsp;<a href="#" target="mainFrame" onFocus="this.blur()">上一页</a>&nbsp;&nbsp;<a href="#" target="mainFrame" onFocus="this.blur()">下一页</a>&nbsp;&nbsp;<a href="#" target="mainFrame" onFocus="this.blur()">尾页</a></td>
  </tr>
</table>
</body>
</html>