package cn.voicet.router.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import oracle.jdbc.OracleTypes;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ConnectionCallback;
import org.springframework.stereotype.Repository;

import cn.voicet.router.dao.SoftDao;
import cn.voicet.router.util.DotSession;
import cn.voicet.router.util.VTJime;
import cn.voicet.router.web.form.SoftForm;

@Repository(SoftDao.SERVICE_NAME)
@SuppressWarnings("static-access")
public class SoftDaoImpl extends BaseDaoImpl implements SoftDao {

	/** 获取最新app版本 */
	public void getAppLastVersionInfo(final DotSession ds) {
		this.getJdbcTemplate().execute(new ConnectionCallback() {
			public Object doInConnection(Connection conn) throws SQLException,
					DataAccessException {
				CallableStatement cs = conn.prepareCall("{call sap_get_appverinfo(?)}");
				cs.registerOutParameter(1, OracleTypes.CURSOR);
				cs.execute();
				ResultSet rs = (ResultSet) cs.getObject(1);
				if(null != rs)
				{
					while(rs.next()){
						ds.putSessionMapDataByColName(ds, rs);
					}
				}
				return null;
			}
		});
	}
	
	/** 获取app更新记录列表 */
	public void getAppHistoryVersionInfo(final DotSession ds) {
		this.getJdbcTemplate().execute(new ConnectionCallback() {
			public Object doInConnection(Connection conn) throws SQLException,
					DataAccessException {
				CallableStatement cs = conn.prepareCall("{call smp_get_appverinfo(?)}");
				cs.registerOutParameter(1, OracleTypes.CURSOR);
				cs.execute();
				ResultSet rs = (ResultSet) cs.getObject(1);
				ds.initListData();
				Map<Object, Object> map;
				if(null != rs)
				{
					while(rs.next()){
						map = new HashMap<Object, Object>();
						VTJime.putMapDataByColName(map, rs);
						ds.list.add(map);
					}
				}
				return null;
			}
		});
	}

	public void updateApkFile(final SoftForm softForm) {
		this.getJdbcTemplate().execute(new ConnectionCallback() {
			public Object doInConnection(Connection conn) throws SQLException,
					DataAccessException {
				CallableStatement cs = conn.prepareCall("{call smp_put_appverinfo(?,?,?,?)}");
				cs.setInt(1, 0);
				cs.setString(2, softForm.getVersion());
				cs.setString(3, softForm.getApkFileFileName());
				cs.setString(4, softForm.getDescribe());
				cs.execute();
				return null;
			}
		});
	}
	
}
