<%@ page pageEncoding="utf-8" contentType="text/html; charset=utf-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>首页</title>
<link rel="shortcut icon" href="images/favicon.ico" />
<link href="css/css.css" type="text/css" rel="stylesheet" />
</head>
<!--æ¡æ¶æ ·å¼-->
<frameset rows="95,*,30" cols="*" frameborder="no" border="0" framespacing="0">
<!--topæ ·å¼-->
	<frame src="top.html" name="topframe" scrolling="no" noresize id="topframe" title="topframe" />
<!--contactæ ·å¼-->
	<frameset id="attachucp" framespacing="0" border="0" frameborder="no" cols="194,12,*" rows="*">
		<frame scrolling="auto" noresize="" frameborder="no" name="leftFrame" src="left.jsp"></frame>
		<frame id="leftbar" scrolling="no" noresize="" name="switchFrame" src="swich.html"></frame>
		<frame scrolling="auto" noresize="" border="0" name="mainFrame" src="main.jsp"></frame>
	</frameset>
<!--bottomæ ·å¼-->
	<frame src="bottom.html" name="bottomFrame" scrolling="No" noresize="noresize" id="bottomFrame" title="bottomFrame" />
</frameset><noframes></noframes>
<!--ä¸å¯ä»¥å é¤-->
</html>