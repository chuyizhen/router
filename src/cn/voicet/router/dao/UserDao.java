package cn.voicet.router.dao;

public interface UserDao {
	public final static String SERVICE_NAME = "cn.voicet.router.dao.impl.UserDaoImpl";
	String userLogin();
}
