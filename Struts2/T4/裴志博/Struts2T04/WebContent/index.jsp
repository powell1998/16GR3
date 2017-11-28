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
<s:form action="user" method="post" theme="simple">
	用户名：<s:textfield name="userinfo.name"></s:textfield><br>
	密码：<s:password name="userinfo.password"></s:password><br>
	出生日期：<s:textfield name="userinfo.birthday"></s:textfield><br>
	性别：<s:radio name="userinfo.sex" list="#{'1':'男','0':'女' }" value="'1'"></s:radio><br>
	爱好：<s:checkboxlist name="userinfo.love" list="{'唱歌','跳舞','旅游','TV'}"></s:checkboxlist><br>
	是否启用：<s:checkbox name="userinfo.active" fieldValue="true"></s:checkbox><br>
	籍贯：<s:select name="userinfo.nativeplace" list="{'湖北','湖南','广东'}" headerKey="" headerValue="请选择..." emptyOption="true"></s:select><br>
	说明：<s:textarea name="userinfo.memo" cols="20" rows="5"></s:textarea><br>
	<input type="submit" value="保存">
</s:form>
</body>
</html>