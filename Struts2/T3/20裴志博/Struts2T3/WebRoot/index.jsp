<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>
  	<form action="login" method="post">
  		用户名：<input type="text" name="name" value=""><br>
  		密码：<input type="password" name="password" value=""><br>
  		生日：<input type="text" name="userinfo.birthday"><br>
  		<input type="submit" value="登录">
  	</form>
  	<p style="color: red">${errorMsg }</p>
  	<hr>
  	<s:set name="stu" value="#{'name':'xxx有限公司','address':'湖北襄阳','phone':'0710-3333333','products':{'系统集成','软件开发'} }"></s:set>
  	技术支持：<s:property value="#stu['name']"/>
  	位于：<s:property value="#stu['address']"/>
  	联系方式：<s:property value="#stu['phone']"/>
  	主营产品：<s:property value="#stu['products'][0]"/>,<s:property value="#stu['products'][1]"/>
  </body>
</html>
