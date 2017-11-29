<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
${userinfo.name }<br>
${userinfo.password }<br>
${userinfo.birthday }<br>
${userinfo.sex }<br>
${userinfo.love }<br>
${userinfo.active }<br>
${userinfo.nativeplace }<br>
${userinfo.memo }<br>
<a href="jsp/test.jsp">点击跳转其他练习结果页面</a>
</body>
</html>