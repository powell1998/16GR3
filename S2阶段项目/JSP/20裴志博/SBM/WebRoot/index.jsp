<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<title>系统登录 - 超市账单管理系统</title>
<link type="text/css" rel="stylesheet" href="css/style.css" />
</head>
<body class="blue-style">
	<div id="login">
		<div class="icon"></div>
		<div class="login-box">
			<form id="fromLogin" method="post" action="user?cmd=doLogin">
				<dl>
					<dt>用户名：</dt>
					<dd>
						<input type="text" id="userName" name="userName" class="input-text" />
					</dd>
					<dt>密 码：</dt>
					<dd>
						<input type="password" id="userPassword" name="userPassword" class="input-text" />
					</dd>
				</dl>
				<div class="buttons">
					<input type="button" value="登录系统" class="input-button" onclick="loginCheck();" />
					<input type="reset" value="重　　填" class="input-button" />
				</div>
			</form>
		</div>
	</div>
<script type="text/javascript">
	function loginCheck(){
		var fromLogin = document.getElementById("fromLogin");
		var userName = document.getElementById("userName").value;
		var userPassword = document.getElementById("userPassword").value;
		if(userName != null && userName != "" && userPassword != null && userPassword != ""){
			fromLogin.submit();
		}else{
			alert("用戶名或密码不能为空")
		}
	}	
</script>
</body>
</html>

