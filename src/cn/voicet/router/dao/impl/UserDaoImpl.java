package cn.voicet.router.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

import oracle.jdbc.OracleTypes;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ConnectionCallback;
import org.springframework.stereotype.Repository;

import cn.voicet.router.dao.UserDao;
import cn.voicet.router.web.form.UserForm;

@Repository(UserDao.SERVICE_NAME)
public class UserDaoImpl extends BaseDaoImpl implements UserDao {

	public String userLogin(final UserForm userForm) {
		String res=(String) this.getJdbcTemplate().execute(new ConnectionCallback() {
			public Object doInConnection(Connection conn) throws SQLException,
					DataAccessException {
				CallableStatement cs = conn.prepareCall("{call smp_userlogin(?,?,?)}");
				cs.setString(1, userForm.getUsername());
				cs.setString(2, userForm.getPassword());
				cs.registerOutParameter(3, OracleTypes.VARCHAR);
				cs.execute();
				return cs.getString(3);
			}
		});
		return res;
	}
	
}
