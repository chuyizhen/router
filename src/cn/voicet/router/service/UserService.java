package cn.voicet.router.service;

import cn.voicet.router.web.form.UserForm;

public interface UserService {
	public final static String SERVICE_NAME = "cn.voicet.router.service.impl.UserServiceImpl";
	public String userLogin(UserForm userForm);
}
