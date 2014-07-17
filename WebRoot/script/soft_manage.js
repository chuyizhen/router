function uploadApkFile()
{
	var v = $("#ver").val();
    if(v=="")
    {
        alert("请填写软件版本");
        return false;
    }
    var apk = $("#apkFile").val();
    if(apk=="")
    {
        alert("请选择上传文件");
        return false;
    }
    var stuff = apk.substring(apk.lastIndexOf(".")+1);
    if(stuff!='apk')
    {
		alert('文件类型不正确，请选择.apk文件');
       	return false;
    }
    document.apkForm.action="softAction_uploadApk.action";
    document.apkForm.submit();
}