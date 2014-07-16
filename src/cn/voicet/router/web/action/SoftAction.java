package cn.voicet.router.web.action;
import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.voicet.router.service.SoftService;
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
		return "show_soft";
	}
}
