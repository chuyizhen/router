package cn.voicet.router.dao;

import cn.voicet.router.util.DotSession;
import cn.voicet.router.web.form.SoftForm;

public interface SoftDao {
	public final static String SERVICE_NAME = "cn.voicet.router.dao.impl.SoftDaoImpl";
	void getAppLastVersionInfo(DotSession ds);
	void getAppHistoryVersionInfo(DotSession ds);
	void updateApkFile(SoftForm softForm);
}
