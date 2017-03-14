<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
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
<h1>类型转换的错误处理</h1>
<s:fielderror></s:fielderror>
	<s:form action="login">
		<s:textfield name="user.name" key="user"></s:textfield>
		<s:textfield name="user.pass" key="pass"></s:textfield>
		<s:textfield name="user.birth" key="birth"></s:textfield>
		<tr>
			<td colspan="2"><s:submit value="转换" theme="simple"></s:submit>
				<s:reset value="重填" theme="simple"></s:reset>
		</tr>
	</s:form>
</body> 
</html>
