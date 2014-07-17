package cn.voicet.router.web.action;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@Controller("indexAction")
@Scope(value="prototype")
@SuppressWarnings("serial")
public class IndexAction extends BaseAction{
	
	public String index(){
		return "show_login";
	}
	
}
