package cn.voicet.router.web.action;
import java.io.IOException;

import javax.annotation.Resource;

import net.sf.json.JSONObject;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.voicet.router.service.UserService;
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
	
	@SuppressWarnings("unchecked")
	public String ajaxlogin(){
		log.info("account:"+userForm.getUsername()+", password:"+userForm.getPassword());
		
		JSONObject json = new JSONObject();
		/*if (request.getSession().getAttribute("vts")==null) {
			DotSession ds = new DotSession();
			request.getSession().setAttribute("vts", ds);
		}
		DotSession ds=DotSession.getVTSession(request);
		Map<String, String> map = userService.userLogin(userForm);
		log.info("user login: "+map);
		ds.map.put("name", map.get("username"));
		ds.username=map.get("username");
		ds.password = userForm.getPassword();
		ds.account=userForm.getAccount();
		ds.rbn = map.get("rbn");
		ds.rbm = map.get("rbm");
		ds.roleName = map.get("rolename");
		ds.roleID=map.get("roleid");
		ds.isedit = Integer.valueOf(map.get("isedit"));
		ds.workyear=Integer.valueOf(map.get("workyear"));
		ds.yearlock=Integer.valueOf(map.get("yearlock"));
		
		ds.curBM = ds.rbm;
		ds.subPathTitle.initPath();
		log.info("rand:"+request.getSession().getAttribute("rand"));
		*/
		json.put("status", "ok");
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
