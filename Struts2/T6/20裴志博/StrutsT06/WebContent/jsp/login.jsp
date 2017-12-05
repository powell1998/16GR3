<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><s:text name="login.title"></s:text></title>
</head>
<body>
	<s:form action="user" method="post">
		<s:textfield key="label.uname" name="user.uname"></s:textfield>
		<s:password key="label.upwd" name="user.upwd"></s:password>
		<s:submit key="label.login"></s:submit>
	</s:form>
</body>
</html>