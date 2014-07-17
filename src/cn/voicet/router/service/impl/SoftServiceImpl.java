package cn.voicet.router.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.voicet.router.dao.SoftDao;
import cn.voicet.router.service.SoftService;
import cn.voicet.router.util.DotSession;
import cn.voicet.router.web.form.SoftForm;

@Transactional(readOnly=true)
@Service(SoftService.SERVICE_NAME)
public class SoftServiceImpl implements SoftService {
	
	@Resource(name=SoftDao.SERVICE_NAME)
	private SoftDao softDao;
	
	public void getAppVersionInfo(DotSession ds) {
		softDao.getAppVersionInfo(ds);
	}
	public void updateApkFile(SoftForm softForm) {
		softDao.updateApkFile(softForm);
	}
}
