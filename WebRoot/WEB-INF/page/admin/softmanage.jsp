<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>My WiFi Manage System</title>
<link rel="stylesheet" type="text/css" href="style/common.css" />
<link rel="stylesheet" type="text/css" href="style/layout.css" />
<script type="text/javascript" src="script/jquery.min.js"></script>
<script type="text/javascript" src="script/soft_manage.js"></script>
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
                        <span><s:property value="#session.vts.map.curver"/></span>
                    </div>
                </div>
                <div class="lab_ipt_item">
                	<span class="lab100">文件名称:</span>
                    <div class="ipt-box">
                        <span><s:property value="#session.vts.map.apkname"/></span>
                    </div>
                </div>
                <div class="lab_ipt_item">
                	<span class="lab100">上次更新时间:</span>
                    <div class="ipt-box">
                        <span><s:property value="#session.vts.map.updt"/></span>
                    </div>
                </div>
                <form name="apkForm" action="" method="post" enctype="multipart/form-data">
                <div class="lab_ipt_item">
                	<span class="lab100">上传APK版本:</span>
                    <div class="ipt-box">
                    	<input type="text" id="ver" name="version" class="ipt_text_w150" />
                        <span class="asterisk">*</span>
                    </div>
                </div>
                <div class="lab_ipt_item">
                	<span class="lab100">APK文件:</span>
                    <div class="ipt-box">
                    	<input type="file" id="apkFile" name="apkFile" class="ipt_text_w150" />
                        <span class="asterisk">*</span>
                    </div>
                </div>
                <div class="lab_ipt_item h132">
                	<span class="lab100">升级描述:</span>
                    <div class="ipt-box h132">
                    	<textarea name="describe" class="ipt_textarea_w300"></textarea>
                        <span class="asterisk"></span>
                    </div>
                </div>
                </form>
                <div class="lab_ipt_item">
                	<span class="lab100"></span>
                	<div class="ipt-box"><input type="button" class="btn2" value="提 交" onclick="uploadApkFile()"></div>
            	</div>
	     	</div>   
  			<div class="right_content">
  				<h2>App更新记录</h2>
  				<div>
  					<table>
  						<thead>
  							<tr>
  								<th>版本</th>
  								<th>文件名称</th>
  								<th>更新日期</th>
  							</tr>
  						</thead>
  						<s:iterator id="ls" value="#session.vts.list">
  							<tr>
  								<td><s:property value="#ls.curver"/></td>
  								<td><s:property value="#ls.apkname"/></td>
  								<td><s:property value="#ls.updt"/></td>
  							</tr>
  						</s:iterator>
  					</table>
  				</div> 
  			</div>
  		</div>
		<div class="clear"></div>
    </div>
    <jsp:include page="/WEB-INF/page/common/footer.jsp"></jsp:include>
</div>		
</body>
</html>
