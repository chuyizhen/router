<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>My WiFi Manage System</title>
	<link rel="stylesheet" type="text/css" href="style/common.css" />
	<link rel="stylesheet" type="text/css" href="style/layout.css" />
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
</head>

<body>
<div id="main_container">
	<div class="header_login">
        <div class="login_logo"><a href="#"><img src="images/logo.png" alt="" title="" border="0" /></a></div>
	</div>
	<div class="login_form">    
		<h3>管理员登录</h3>
        <a href="#" class="forgot_pass">忘记密码</a> 
        <form action="index-digital.html" method="post" class="form">
			<div class="lab_ipt_item_tit"></div>
            <div class="lab_ipt_item">
                <span class="lab100">账号:</span>
                <div class="ipt-box">
                    <input type="text" class="ipt_text_w150" />
                    <span class="asterisk"></span>
                </div>
            </div>
            <div class="lab_ipt_item">
                <span class="lab100">密码:</span>
                <div class="ipt-box">
                    <input type="password" class="ipt_text_w150" />
                    <span class="asterisk"></span>
                </div>
            </div>
            <div class="error-mess" style="display:none;">
				<span class="error-icon"></span>
                <span id="error-message">请输入用户名！</span>
			</div>
            <div class="lab_ipt_item">
                <span class="lab100"></span>
                <div class="ipt-box"><input class="btn2" value="登录" type="submit"></div>
            </div>
		</form>
	</div> 
</div>	
</body>
</html>
