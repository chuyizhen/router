<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>My WiFi Manage System</title>
<script type="text/javascript" src="script/jquery.min.js"></script>
<script type="text/javascript" src="script/jquery.jclock-1.2.0.js"></script>
<link rel="stylesheet" type="text/css" href="style/common.css" />
<link rel="stylesheet" type="text/css" href="style/layout.css" />
<script type="text/javascript">
	$(function($) {
		$('.jclock').jclock();
	});
</script>
</head>
<div class="header">
	<div class="main_logo"><a href="#"><img src="images/logo.png" height="44px;" alt="" title="" border="0" /></a></div>
	<div class="right_header">欢迎 <s:property value="#session.vts.username"/>, <a href="${pageContext.request.contextPath }/index.action" class="logout">退出</a></div>
	<div class="jclock"></div>
</div>
    