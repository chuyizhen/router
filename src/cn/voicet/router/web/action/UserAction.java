package cn.voicet.router.web.action;
import java.io.IOException;

import javax.annotation.Resource;

import net.sf.json.JSONObject;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.voicet.router.service.UserService;
import cn.voicet.router.util.DotSession;
import cn.voicet.router.web.form.UserForm;

import com.opensymphony.xwork2.ModelDriven;

@Controller("userAction")
@Scope(value="prototype")
@SuppressWarnings("serial")
public class UserAction extends BaseAction implements ModelDriven<UserForm>{
	private static Logger log = Logger.getLogger(UserAction.class);
	@Resource(name=UserService.SERVICE_NAME)
	private UserService userService;
	private UserForm userForm = new UserForm();
	
	public UserForm getModel() {
		return userForm;
	}
	
	public String ajaxlogin(){
		log.info("login username:"+userForm.getUsername()+", password:"+userForm.getPassword());
		String res = userService.userLogin(userForm);
		log.info("login result:"+res);
		JSONObject json = new JSONObject();
		if(null == request.getSession().getAttribute("vts"))
		{
			DotSession ds = new DotSession();
			request.getSession().setAttribute("vts", ds);
		}
		DotSession ds=DotSession.getVTSession(request);
		if(res.equalsIgnoreCase("ok"))
		{
			ds.username = userForm.getUsername();
			json.put("status", "ok");
			log.info(ds.username + " login success");
		}
		else{
			json.put("status", "error");
			log.info(userForm.getUsername() + " login failed for username or password error");
		}
		/*
		log.info("rand:"+request.getSession().getAttribute("rand"));
		*/
		try {
			response.setCharacterEncoding("UTF-8");
			response.getWriter().print(json.toString());
			response.getWriter().flush();
		} catch (IOException e) {
			log.error(e);
		}
		return null;
	}

	public String home(){
		log.info("has login");
		return "show_home";
	}
}
