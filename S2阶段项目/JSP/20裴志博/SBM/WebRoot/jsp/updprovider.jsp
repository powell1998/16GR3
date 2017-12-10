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
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

</head>

<body>
<div class="main">
	<div class="optitle clearfix">
			<div class="title">用户管理&gt;&gt;</div>
		</div>
		<form action="provider?cmd=updprovider" id="from1"  method="post">
			<div class="content">
			<input type="hidden" name="act" value="${param.act }"/>
			<input type="hidden" name="providerId" value="${provider.providerId }"/>
				<table class="box">
					<tr>
						<td class="field">供应商名称：</td>
						<td><input type="text" name="providerName" class="text"
							id="providerName" /> <font color="red">*</font></td>
					</tr>
					<tr>
						<td class="field">供应商描述：</td>

						<td><input type="text" name="providerDetail" class="text"
							id="providerDetail" /> <font color="red">*</font></td>
					</tr>
					<tr>
						<td class="field">联  系  人：</td>
						<td><input type="text" name="contact" class="text"
							id="contact" /> <font color="red">*</font></td>
					</tr>
					<tr>
						<td class="field">供应商电话：</td>
						<td><input type="text" name="telephone" class="text"
							id="telephone" /> <font color="red">*</font></td>

					</tr>
					<tr>
						<td class="field">供应商传真：</td>
						<td><textarea name="facsimile" id="facsimile" class="text"
								cols="45" rows="5"></textarea></td>
					</tr>
					<tr>
						<td class="field">供应商地址：</td>
						<td><textarea name="address" id="address" class="text"
								cols="45" rows="5"></textarea></td>
					</tr>
				</table>
			</div>
			<div class="buttons">
				<c:if test="${param.act eq 'updprovider' }">
					<input type="button" name="button" id="button" value="确认修改" onclick="CheckFrom()" class="input-button"/>
				</c:if>
				<input type="button" name="button" id="button" onclick="window.location='provider?cmd=getSm';" 
					value="返回" class="input-button" />
			</div>
		</form>
	</div>
	<c:if test="${!empty provider }">
	<script type="text/javascript">
		document.getElementById("providerName").value = "${provider.providerName}";
		document.getElementById("providerDetail").value = "${provider.providerDetail}";
		document.getElementById("contact").value = "${provider.contact}";
		document.getElementById("telephone").value = "${provider.telephone}";
		document.getElementById("facsimile").value = "${provider.facsimile}";
		document.getElementById("address").value = "${provider.address}";
	</script>
	</c:if>
	<script type="text/javascript">
		function CheckFrom() {
			var PupForm = document.getElementById("from1");
			if (
				CheckItems("providerName") &&
				CheckItems("providerDetail") &&
				CheckItems("contact") &&
				CheckItems("telephone") &&
				CheckItems("facsimile") &&
				CheckItems("address")
			) {
				PupForm.submit();
			} else {
				alert("数据修改不允许空值");
			}
		}
	
		function CheckItems(id) {
			var ider = document.getElementById(id).value;
			if (ider != null && ider != "") {
				return true;
			} else {
				return false;
			}
		}
	</script>
  </body>
</html>
