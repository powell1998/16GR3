<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<% java.util.Date date = java.util.Calendar.getInstance().getTime();
	pageContext.setAttribute("now", date);
%>
<%
	java.util.List list = new java.util.ArrayList();
	list.add("一季度");
	list.add("二季度");
	list.add("三季度");
	list.add("四季度");
	request.setAttribute("names", list);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<s:set name="QQ" value="'qq你好'"></s:set>
<s:property value="#QQ" default="没有找到"/>
<hr>

现在的时间是：<s:property value="#attr.now"/>
<s:if test="#attr.now.hours<12">
	早上好！
</s:if>
<s:elseif test="#attr.now.hours<18">
	下午好！
</s:elseif>
<s:else>
	晚上好！
</s:else>
<hr>

<ol>
	<s:iterator value="#request.names" status="stuts">
		<s:if test="#stuts.odd">
			<li style="background-color: white">
		</s:if>
		<s:else>
			<li style="background-color: grqy">
		</s:else>
	</s:iterator>
</ol>
</body>
</html>