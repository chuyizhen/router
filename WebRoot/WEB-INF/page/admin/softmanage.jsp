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
		menu2.className='current';
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
            	<h2>上传APK文件</h2>       
		     	<div class="lab_ipt_item">
                	<span class="lab100">当前APK版本:</span>
                    <div class="ipt-box">
                    	<input type="text" class="ipt_text_w150" />
                        <span class="asterisk">*</span>
                    </div>
                </div>
                <div class="lab_ipt_item">
                	<span class="lab100">上传APK版本:</span>
                    <div class="ipt-box">
                    	<input type="text" class="ipt_text_w150" />
                        <span class="asterisk">*</span>
                    </div>
                </div>
                <div class="lab_ipt_item">
                	<span class="lab100">APK文件:</span>
                    <div class="ipt-box">
                    	<input type="text" class="ipt_text_w150" />
                        <span class="asterisk">*</span>
                    </div>
                </div>
                <div class="lab_ipt_item h132">
                	<span class="lab100">升级描述:</span>
                    <div class="ipt-box h132">
                    	<textarea name="content" class="ipt_textarea_w300"></textarea>
                        <span class="asterisk"></span>
                    </div>
                </div>
                <div class="lab_ipt_item">
                	<span class="lab100"></span>
                	<div class="ipt-box"><input class="btn2" value="提 交" type="submit"></div>
            	</div>
	     	</div>   
  		</div>
		<div class="clear"></div>
    </div>
    <jsp:include page="/WEB-INF/page/common/footer.jsp"></jsp:include>
</div>		
</body>
</html>
