package cn.voicet.router.web.action;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.voicet.router.service.SoftService;
import cn.voicet.router.util.DotSession;
import cn.voicet.router.web.form.SoftForm;

import com.opensymphony.xwork2.ModelDriven;

@Controller("softAction")
@Scope(value="prototype")
@SuppressWarnings("serial")
public class SoftAction extends BaseAction implements ModelDriven<SoftForm>{
	private static Logger log = Logger.getLogger(SoftAction.class);
	@Resource(name=SoftService.SERVICE_NAME)
	private SoftService softService;
	private SoftForm softForm = new SoftForm();
	
	public SoftForm getModel() {
		return softForm;
	}
	
	public String home(){
		DotSession ds=DotSession.getVTSession(request);
		softService.getAppVersionInfo(ds);
		log.info("ds.map:"+ds.map);
		return "show_soft";
	}
	
	public String uploadApk() throws Exception {
		//基于myFile创建一个文件输入流  
        InputStream is = new FileInputStream(softForm.getApkFile());
        // 设置上传文件目录  
        String uploadPath = ServletActionContext.getServletContext().getRealPath("/download");
        /******** upload file to other dir start ********/
        //取得根目录路径  
        String rootPath = ServletActionContext.getServletContext().getRealPath("/");
        log.info("rootPath:"+rootPath);
        rootPath = rootPath.substring(0, rootPath.length()-7);
        log.info("sub rootPath:"+rootPath);
        uploadPath = rootPath + "myWiFi/download";
        log.info("add rootPath:"+rootPath);
        /******** upload file to other dir end ********/
        // 设置目标文件  
        File toFile = new File(uploadPath, softForm.getApkFileFileName());  
        // 创建一个输出流  
        OutputStream os = new FileOutputStream(toFile);  
        //设置缓存  
        byte[] buffer = new byte[1024];  
        int length = 0;  
        //读取myFile文件输出到toFile文件中  
        while ((length = is.read(buffer)) > 0) {  
            os.write(buffer, 0, length);  
        }  
        String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/"+"download/";
        log.info("upload file path:"+uploadPath);
        log.info("basePath:"+basePath);
        log.info("upload file name:"+softForm.getApkFileFileName());  
        log.info("upload file type:"+softForm.getApkFileContentType());  
        //关闭输入流  
        is.close();  
        //关闭输出流  
        os.close(); 
        log.info("------------------------");
        log.info("version:"+softForm.getVersion()+", apkname:"+softForm.getApkFileFileName()+", describe:"+softForm.getDescribe());
        softService.updateApkFile(softForm);
        log.info("----------- upload complete ------------");
		return "soft_home";
	}
}
