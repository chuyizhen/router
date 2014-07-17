package cn.voicet.router.service;

import cn.voicet.router.util.DotSession;
import cn.voicet.router.web.form.SoftForm;

public interface SoftService {
	public final static String SERVICE_NAME = "cn.voicet.router.service.impl.SoftServiceImpl";
	void getAppVersionInfo(DotSession ds);
	void updateApkFile(SoftForm softForm);
}
