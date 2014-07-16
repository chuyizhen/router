package cn.voicet.router.web.action;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.voicet.router.service.UserService;

@Controller("indexAction")
@Scope(value="prototype")
@SuppressWarnings("serial")
public class IndexAction extends BaseAction{
	@Resource(name=UserService.SERVICE_NAME)
	private UserService userService;
	public String index(){
		//String res = userService.userLogin();
		System.out.println();
		return "show_login";
	}
	
}
