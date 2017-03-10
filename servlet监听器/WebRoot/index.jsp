<%@page import="java.sql.ResultSet"%>
<%@page import="bean.DbDao"%>
<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<%
	DbDao dd = new DbDao("com.mysql.jdbc.Driver",
			"jdbc:mysql://localhost:3306/myssh", "root", "");
	ResultSet rs = dd.query("select * from online_inf");
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
	This is my JSP page.
	<br>
	<table>

		<%
			while (rs.next()) {
		%>
		<tr>
			<td><%=rs.getString("sessionId")%>
			<td><%=rs.getString("user")%>
			<td><%=rs.getString("ip")%>
			<td><%=rs.getString("page")%>
			<td><%=rs.getLong("currentTime")%>
		</tr>
		<%
			}
		%>
	</table>
</body>
</html>
