<%@page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;charset=utf-8" >
<style type="text/css">
body{
background:#f2f0f5;
}
.a1{
width:280px;
height:400px;
margin:150 auto;
border:1px solid rgb(192,192,192); 
border-radius:25px;
-moz-border-radius:25px; /* Old Firefox */
box-shadow: 10px 10px 5px #888888;
background:#fff;
opacity:0.8;
}
.a2{
width:260px;
height:180px;
margin:88 auto;
}
</style>
<script type="text/javascript">
	function chang(){
		console.log(1);
		var initpwd=document.getElementById("initpwd").value;
		var newpwd=document.getElementById("newpwd").value;
		var reallypwd=document.getElementById("reallypwd").value;
		if(initpwd==newpwd)
			{
			alert("密码不能与初始密码相同!");
			return false;
			}
		else if(newpwd!=reallypwd)
			{                   
			alert("密码不匹配请重新输入!");
			return false;
			}
		return true;
	}
</script>
</head>
<body>
<form action="UpdatePassword" onsubmit="return chang();" method="post">
<div class="a1">
<div class="a2"><label>原始密码:</label><input type="password"/ id="initpwd" name="initpwd"/><br/><br/>
<label>新密码:</label>&nbsp;<input type="password" id="newpwd" name="newpwd"/><br/><br/>
<label>确认密码:</label><input type="password" id="reallypwd"/><br/><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="submit" value="确认更改"/>
</div></div>
</form>
</body>
</html>