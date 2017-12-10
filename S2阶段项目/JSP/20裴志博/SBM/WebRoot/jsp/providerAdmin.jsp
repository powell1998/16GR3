<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
<link type="text/css" rel="stylesheet" href="css/style.css">
<script type="text/javascript">
	function doit(flag, id) {
		if (flag == "del") {
			if (confirm("确认删除吗？") != true)
				return;
		}
		window.location = "provider.do?id=" + id + "&flag=" + flag;
	}
</script>
</head>
<body>
	<div class="menu">
		<div class="menu">
			<form method="get" action="">
				用户名称：<input type="text" name="productName" class="input-text" />&nbsp;&nbsp;
				供应商描述：<input type="text" name="providerDesc" class="input-text" />&nbsp;&nbsp;
				&nbsp;&nbsp; <input type="submit" name="submit" value="组合查询"
					class="button" />
			</form>
		</div>
	</div>
	<div class="main">
		<div class="optitle clearfix">
			<em><input value="添加数据" class="input-button"
				onclick="window.location='jsp/providerAdd.jsp'" type="button"></em>
			<div class="title">供应商管理&gt;&gt;</div>
		</div>

		<div class="content">
			<table class="list">
				<tbody>
					<tr>
						<td width="70" height="29"><div class="STYLE1" align="center">编号</div></td>
						<td width="100"><div class="STYLE1" align="center">供应商名称</div></td>
						<td width="100"><div class="STYLE1" align="center">供应商描述</div></td>
						<td width="100"><div class="STYLE1" align="center">联系人</div></td>
						<td width="100"><div class="STYLE1" align="center">电话</div></td>
						<td width="100"><div class="STYLE1" align="center">地址</div></td>
						<td width="100"><div class="STYLE1" align="center">操作</div></td>
					</tr>
					<c:forEach items="${pageBean.data }" var="Provider">
						<tr>
							<td>${Provider.providerId }</td>
							<td>${Provider.providerName }</td>
							<td>${Provider.providerDetail }</td>
							<td>${Provider.contact }</td>
							<td>${Provider.telephone }</td>
							<td>${Provider.address }</td>

							<td>
								<a href="provider?cmd=delProvider&&providerId=${Provider.providerId } " style="text-decoration: none;>
								<font style="font-size: 14px">删除</font></a>
								<a href="provider?cmd=getproviderById&providerId=${Provider.providerId }&act=updprovider" style="text-decoration: none;">
								<font style="font-size: 14px">修改</font></a>
							</td>
						</tr>
					</c:forEach>
</body>
</table>
</div>
<form id="form" action="provider?cmd=getSm">
	<label class="input-button">跳转到</label> <select name="p"
		onchange="getPageBeanByP();">
		<c:forEach var="j" begin="1" end="${pageBean.getPagetotal()}">
			<c:if test="${pageBean.getP() == j}">
				<option selected="selected" value="${j}">第${j}页</option>
			</c:if>
			<c:if test="${pageBean.getP() != j}">
				<option value="${j}">第${j}页</option>
			</c:if>
		</c:forEach>
	</select> <a class="input-button" href="provider?cmd=getSm&p=${pageBean.p - 1 }">上一页</a>
	<a class="input-button" href="provider?cmd=getSm&p=${pageBean.p + 1 }">下一页</a>
</form>
</div>
</body>
</html>
