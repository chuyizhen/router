package cn.voicet.router.web.form;

import java.io.File;

public class SoftForm {
	// myFile属性用来封装上传的文件  
    private File apkFile;  
    // myFileContentType属性用来封装上传文件的类型  
    private String apkFileContentType;  
    // myFileFileName属性用来封装上传文件的文件名  
    private String apkFileFileName;
    private String version;
    private String describe;
	public File getApkFile() {
		return apkFile;
	}
	public void setApkFile(File apkFile) {
		this.apkFile = apkFile;
	}
	public String getApkFileContentType() {
		return apkFileContentType;
	}
	public void setApkFileContentType(String apkFileContentType) {
		this.apkFileContentType = apkFileContentType;
	}
	public String getApkFileFileName() {
		return apkFileFileName;
	}
	public void setApkFileFileName(String apkFileFileName) {
		this.apkFileFileName = apkFileFileName;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public String getDescribe() {
		return describe;
	}
	public void setDescribe(String describe) {
		this.describe = describe;
	}
}
