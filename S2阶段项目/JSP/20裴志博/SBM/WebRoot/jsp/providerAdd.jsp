<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<link type="text/css" rel="stylesheet" href="css/style.css" />
</head>
<body>
	<div class="main">
		<div class="optitle clearfix">
			<div class="title">供应商管理&gt;&gt;</div>
		</div>
		<form id="form1" name="form1" method="post"
			action="provider?cmd=addProvider">
			<div class="content">
				<font color="red"></font> <input name="flag" value="doAdd"
					type="hidden">
				<table class="box">
					<tbody>
						<tr>
							<td class="field">供应商名称：</td>
							<td><input name="providerName" id="providerName"
								class="text" type="text"> <font color="red">*</font></td>
						</tr>
						<tr>
							<td class="field">供应商描述：</td>
							<td><textarea name="providerDetail" id="providerDetail"
									cols="45" rows="5"></textarea></td>
						</tr>
						<tr>
							<td class="field">供应商联系人：</td>
							<td><input name="contact" id="contact" class="text"
								type="text"></td>
						</tr>
						<tr>
							<td class="field">供应商电话：</td>
							<td><input name="telephone" id="telephone" class="text"
								type="text"></td>
						</tr>
						<tr>
							<td class="field">供应商传真：</td>
							<td><input name="facsimile" id="facsimile" class="text"
								type="text"></td>
						</tr>
						<tr>
							<td class="field">供应商地址：</td>
							<td><input name="address" id="address" class="text"
								type="text"></td>
						</tr>
					</tbody>
				</table>
			</div>

			<div class="buttons">
				<input type="submit" name="button" id="button" value="数据提交"
					class="input-button" onclick="CheckFrom()"/> <input
					type="button" name="button" id="button"
					onclick="window.location='provider.do';" value="返回"
					class="input-button" />
			</div>
		</form>
	</div>
<c:if test="${!empty provider }">
	<script type="text/javascript">
		document.getElementById("providerName").value="${provider.providerName}";
		document.getElementById("providerDetail").value="${provider.providerDetail}";
		document.getElementById("contact").value="${provider.contact}";
		document.getElementById("telephone").value="${provider.telephone}";
		document.getElementById("facsimile").value="${provider.facsimile}";
		document.getElementById("address").value="${provider.address}";
	</script>
</c:if>
<script type="text/javascript">
	function CheckFrom() {
		var form1 = document.getElementById("form1");
		if(
			CheckItems("providerName")&&
			CheckItems("providerDetail")&&
			CheckItems("contact")&&
			CheckItems("telephone")&&
			CheckItems("facsimile")&&
			CheckItems("address")
		){
			form1.submit();
			}
		else{
			alert("数据修改不允许空值");
		}
	}
	
	function CheckItems(id) {
		var ider=document.getElementById(id).value;
		if(ider != null && ider != ""){
			return true;
		}else{
			return false;
		}
	}	
</script>
</body>
</html>
