<%@page contentType="text/html;charset=utf-8" pageEncoding="utf-8" %>
<html>
<head runat="server">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>后台管理登录界面</title>
    <link href="css/alogin.css" rel="stylesheet" type="text/css" />
    <script type="text/javascript">
    if(window!=top)
    	{
    	top.location.href=location.href;
    	}
    </script>
</head>
<body>
    <form id="form1" runat="server" action="login" method="post">
    <div class="Main">
        <ul>
            <li class="top"></li>
            <li class="top2"></li>
            <li class="topA"></li>
            <li class="topB"><span><img src="images/login/logo.gif" alt="" style="" /></span></li>
            <li class="topC"></li>
            <li class="topD">
                <ul class="login">
                    <li><span class="left login-text">用户名：</span> <span style="left">
                        <input id="Text1" type="text" class="txt" name="username"/>  
                     
                    </span></li>
                    <li><span class="left login-text">密码：</span> <span style="left">
                       <input id="Text2" type="password" class="txt" name="pwd" />  
                    </span></li>
					
                </ul>
            </li>
            <li class="topE"></li>
            <li class="middle_A"></li>
            <li class="middle_B"><%=request.getAttribute("msg")==null?"":request.getAttribute("msg")%></li>
            <li class="middle_C">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="radio" name="admin" value="a" checked="checked"/>超级管理员&nbsp;&nbsp;&nbsp;
					<input type="radio" name="admin" value="b"/>管理员<br/><br/><br/>
            &nbsp;&nbsp;&nbsp;&nbsp;<span class="btn"><input name="" type="image" src="images/login/btnlogin.gif" /></span></li>
            <li class="middle_D"></li>
            <li class="bottom_A"></li>
            <li class="bottom_B">网站后台管理系统&nbsp;&nbsp;</li>
        </ul>
    </div>
    </form>
</body>
</html>