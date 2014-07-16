<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>My WiFi Manage System</title>
<script type="text/javascript" src="script/jquery.min.js"></script>
<link rel="stylesheet" type="text/css" href="style/common.css" />
<link rel="stylesheet" type="text/css" href="style/layout.css" />
<script type="text/javascript">
	$(function($) {
		menu1.className='current';
	});
</script>
</head>
<body>
<div id="main_container">
	<jsp:include page="/WEB-INF/page/common/header.jsp"></jsp:include>
    <div class="main_content">
		<jsp:include page="/WEB-INF/page/common/menu.jsp"></jsp:include>
    	<div class="center_content">  
    		<div class="left_content">     
            	<h2>欢迎进入MyWiFi后台管理系统</h2>       
	     	</div>
  		</div>
		<div class="clear"></div>
    </div>
    <jsp:include page="/WEB-INF/page/common/footer.jsp"></jsp:include>
</div>		
</body>
</html>
