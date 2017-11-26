
<%@ page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page contentType="text/html; charset=utf-8"  pageEncoding="utf-8"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>新增用户</title>
<link href="css/css.css" type="text/css" rel="stylesheet" />
<link href="css/main.css" type="text/css" rel="stylesheet" />
<link rel="shortcut icon" href="images/main/favicon.ico" />
<link rel="stylesheet" href="css/info.css"/>
</head>
<body>
<!--main_top-->
<table width="99%" border="0" cellspacing="0" cellpadding="0" id="searchmain">
  <tr>
    <td width="99%" align="left" valign="top">您的位置：用户管理&nbsp;&nbsp;>&nbsp;&nbsp;添加用户</td>
  </tr>
  <tr>
    <td align="left" valign="top" id="addinfo">
    <a href="addUser.jsp" target="mainFrame" onFocus="this.blur()" class="add">新增管理员</a>
    </td>
  </tr>
  <tr>
    <td align="left" valign="top">
    <form method="post" action="addemp">
    <table width="100%" border="0" cellspacing="0" cellpadding="0" id="main-tab">
      <tr onMouseOut="this.style.backgroundColor='#ffffff'" onMouseOver="this.style.backgroundColor='#edf5ff'">
        <td align="right" valign="middle" class="borderright borderbottom bggray">用户名：</td>
        <td align="left" valign="middle" class="borderright borderbottom main-for">
        <input type="text" name="uname" class="text-word">
        </td>
        </tr>
        
        <tr onMouseOut="this.style.backgroundColor='#ffffff'" onMouseOver="this.style.backgroundColor='#edf5ff'">
        <td align="right" valign="middle" class="borderright borderbottom bggray">真实姓名：</td>
        <td align="left" valign="middle" class="borderright borderbottom main-for">
        <input type="text" name="name" class="text-word">
        </td>
        </tr>
        
      <tr onMouseOut="this.style.backgroundColor='#ffffff'" onMouseOver="this.style.backgroundColor='#edf5ff'">
        <td align="right" valign="middle" class="borderright borderbottom bggray">用户密码：</td>
        <td align="left" valign="middle" class="borderright borderbottom main-for">
        <input type="password" name="password" class="text-word">
        </td>
        </tr>
      
      
       <tr onMouseOut="this.style.backgroundColor='#ffffff'" onMouseOver="this.style.backgroundColor='#edf5ff'">
        <td align="right" valign="middle" class="borderright borderbottom bggray">部门名称：</td>
        <td align="left" valign="middle" class="borderright borderbottom main-for">
        <input type="text" name="department" class="text-word">
        </td>
        </tr>
      <tr onMouseOut="this.style.backgroundColor='#ffffff'" onMouseOver="this.style.backgroundColor='#edf5ff'">
        <td align="right" valign="middle" class="borderright borderbottom bggray">薪资：</td>
        <td align="left" valign="middle" class="borderright borderbottom main-for">
        <input type="text" name="salary" class="text-word">
        </td>
        </tr>
      
       <tr onMouseOut="this.style.backgroundColor='#ffffff'" onMouseOver="this.style.backgroundColor='#edf5ff'">
        <td align="right" valign="middle" class="borderright borderbottom bggray">年龄：</td>
        <td align="left" valign="middle" class="borderright borderbottom main-for">
        <input type="text" name="age" class="text-word">
        </td>
        </tr>
      
      
       <tr onMouseOut="this.style.backgroundColor='#ffffff'" onMouseOver="this.style.backgroundColor='#edf5ff'">
        <td align="right" valign="middle" class="borderright borderbottom bggray">性别：</td>
        <td align="left" valign="middle" class="borderright borderbottom main-for">
        男
		<input type="radio" class="inputgri" name="gender" value="男" checked="checked"/>
		女
		<input type="radio" class="inputgri" name="gender" value="女"/>
        </td>
        </tr>
      
      <input type="hidden" name="registdate" value=<%=new SimpleDateFormat("yyyy-MM-dd").format(new Date()) %>>
     
     
     
     
      <tr onMouseOut="this.style.backgroundColor='#ffffff'" onMouseOver="this.style.backgroundColor='#edf5ff'">
        <td align="right" valign="middle" class="borderright borderbottom bggray">验证码：
        </td>
       
        <td align="left" valign="middle" class="borderright borderbottom main-for">
        
        <img id="num" src="checkcode" border="1" 
					 onclick="this.src='checkcode?'+Math.random()"/>&nbsp;&nbsp;&nbsp;&nbsp;
		 <input style="border:1px solid blue;line-height: 3em;" class="borderright borderbottom bggray" name="number" />
            <%
			 String msg2=(String)request.getAttribute("number_error");
				%>
			 <span style="color:green;font-size:20px;">
			 <%=(msg2==null?"":msg2) %></span>
        </td>
        </tr>
     
     
     
     
     
     
     
     
					
      <tr onMouseOut="this.style.backgroundColor='#ffffff'" onMouseOver="this.style.backgroundColor='#edf5ff'">
        <td align="right" valign="middle" class="borderright borderbottom bggray">&nbsp;</td>
        <td align="left" valign="middle" class="borderright borderbottom main-for">
        <input type="submit" value="提交" class="text-but">
        <input type="reset" value="重置" class="text-but">
        </td>
        </tr>
    </table>
    </form>
    </td>
    </tr>
</table>
</body>
</html>