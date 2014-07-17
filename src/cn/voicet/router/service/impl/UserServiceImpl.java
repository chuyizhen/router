package cn.voicet.router.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.voicet.router.dao.UserDao;
import cn.voicet.router.service.UserService;
import cn.voicet.router.web.form.UserForm;

@Transactional(readOnly=true)
@Service(UserService.SERVICE_NAME)
public class UserServiceImpl implements UserService {
	@Resource(name=UserDao.SERVICE_NAME)
	private UserDao userDao;

	public String userLogin(UserForm userForm) {
		return userDao.userLogin(userForm);
	}
}
