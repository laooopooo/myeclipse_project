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
<h2>请输入您的注册信息</h2>
<s:fielderror></s:fielderror>
	<s:form action="regist" validate="true">
		<s:textfield name="name" label="用户名"></s:textfield>
		<s:textfield name="pass" label="密码"></s:textfield>
		<s:textfield name="age" label="年龄"></s:textfield>
		<s:textfield name="birth" label="生日"></s:textfield>
		<s:submit value="注册"></s:submit>
	</s:form>
</body>
</html>
