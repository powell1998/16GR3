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
	}
</script>
</head>
<body onload="setP();">
<c:if test="${!empty param.sele }">
<script type="text/javascript">
alert("用户查询失败！");
</script>
</c:if>
<c:if test="${!empty param.ins }">
<script type="text/javascript">
alert("用户添加失败！");
</script>
</c:if>
<c:if test="${!empty param.ups }">
<script type="text/javascript">
alert("用户修改失败！");
</script>
</c:if>

<div class="menu">
	<form method="get" action="user?cmd=getUser">
		用户名称：<input type="text" name="productName" class="input-text" />&nbsp;&nbsp;&nbsp;&nbsp;
	<input type="submit" name="submit" value="查  询" class="button" />
	</form>
</div>
<div class="main">
<div class="optitle clearfix">
	<em><input value="添加数据" class="input-button"
		onclick="window.location='jsp/userAdd.jsp'" type="button"></em>
	<div class="title">用户管理&gt;&gt;</div>
</div>
<div class="content">
	<table class="list">
		<tbody>
			<tr>
				<td width="70" height="29"><div class="STYLE1" align="center">编号</div></td>
				<td width="80"><div class="STYLE1" align="center">用户名称</div></td>
				<td width="100"><div class="STYLE1" align="center">性别</div></td>
				<td width="100"><div class="STYLE1" align="center">年龄</div></td>
				<td width="150"><div class="STYLE1" align="center">电话</div></td>
				<td width="150"><div class="STYLE1" align="center">地址</div></td>
				<td width="150"><div class="STYLE1" align="center">权限</div></td>
				<c:if test="${seeionScope.user.type == 0 }"></c:if>
				<td width="150"><div class="STYLE1" align="center">操作</div></td>
			</tr>
			<c:forEach items="${pagebean.data }" var="user">
			<tr>
				<td><span class="STYLE1">${user.userId }</span></td>
				<td><span class="STYLE1">${user.userName }</span></td>
				<td><span class="STYLE1">${user.userSex }</span></td>
				<td><span class="STYLE1">${user.userAge }</span></td>
				<td><span class="STYLE1">${user.telephone }</span></td>
				<td><span class="STYLE1">${user.address }</span></td>
				<c:if test="${user.type == 0 }">
					<td><span class="STYLE1">经理</span></td>
				</c:if>
				<c:if test="${user.type == 1 }">
					<td><span class="STYLE1">普通职工</span></td>
				</c:if>
				<td>
					<span class="STYLE1"> 
						<a href="user?cmd=retrievalUser&userId=${user.userId }" style="text-decoration: none;">
						<font style="font-size: 14px">修改</font></a>
						<a href="user?cmd=delUser&userId=${user.userId }" style="text-decoration: none;">
						<font style="font-size: 14px">删除</font></a>
					</span>
				</td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
		共${pagebean.count }条记录,&nbsp第${pagebean.p }页/共${pagebean.pagetotal }页&nbsp 
			<a href="user?cmd=selectUsers&p=1&addd=yes">首页</a>&nbsp 
			<a href="user?cmd=selectUsers&p=${pagebean.p-1 }">上一页</a>&nbsp 
			<a href="user?cmd=selectUsers&p=${pagebean.p+1 }">下一页</a>&nbsp 
			<a href="user?cmd=selectUsers&p=${pagebean.pagetotal }">尾页</a>&nbsp
			跳到第<select id="s1" onchange=toPage(this.value);>
			 <c:set var="i" value="0"  scope="page" />
			<c:forEach begin="1" end="${pagebean.pagetotal }" step="1">
			<c:set var="i" value="${i+1 }"/>
				<option value="${i }" ${i == pagebean.p?"selected":"" }>${i }</option>
			</c:forEach>
		</select> 页
</div>
</div>
<script type="text/javascript">
	function toPage(a){
		location="user?cmd=selectUsers&p="+a;
	}
	function setP(){
		document.getElementById("s1").value="${pagebean.p}";
	}
</script>
</body>
</html>
