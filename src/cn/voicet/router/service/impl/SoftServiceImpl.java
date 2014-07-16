package cn.voicet.router.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.voicet.router.dao.SoftDao;
import cn.voicet.router.service.SoftService;

@Transactional(readOnly=true)
@Service(SoftService.SERVICE_NAME)
public class SoftServiceImpl implements SoftService {
	@Resource(name=SoftDao.SERVICE_NAME)
	private SoftDao softDao;
}
