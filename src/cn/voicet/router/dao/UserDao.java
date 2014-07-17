package cn.voicet.router.dao;

import cn.voicet.router.web.form.UserForm;

public interface UserDao {
	public final static String SERVICE_NAME = "cn.voicet.router.dao.impl.UserDaoImpl";
	String userLogin(UserForm userForm);
}
