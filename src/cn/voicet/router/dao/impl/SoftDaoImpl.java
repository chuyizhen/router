package cn.voicet.router.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import oracle.jdbc.OracleTypes;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ConnectionCallback;
import org.springframework.stereotype.Repository;

import cn.voicet.router.dao.SoftDao;
import cn.voicet.router.util.DotSession;
import cn.voicet.router.web.form.SoftForm;

@Repository(SoftDao.SERVICE_NAME)
@SuppressWarnings("static-access")
public class SoftDaoImpl extends BaseDaoImpl implements SoftDao {

	public void getAppVersionInfo(final DotSession ds) {
		this.getJdbcTemplate().execute(new ConnectionCallback() {
			public Object doInConnection(Connection conn) throws SQLException,
					DataAccessException {
				CallableStatement cs = conn.prepareCall("{call smp_get_appverinfo(?)}");
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

	public void updateApkFile(final SoftForm softForm) {
		this.getJdbcTemplate().execute(new ConnectionCallback() {
			public Object doInConnection(Connection conn) throws SQLException,
					DataAccessException {
				CallableStatement cs = conn.prepareCall("{call smp_put_appverinfo(?,?,?)}");
				cs.setString(1, softForm.getVersion());
				cs.setString(2, softForm.getApkFileFileName());
				cs.setString(3, softForm.getDescribe());
				cs.execute();
				return null;
			}
		});
	}
	
}
