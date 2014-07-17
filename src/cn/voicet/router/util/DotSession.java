package cn.voicet.router.util;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

public class DotSession {
	
	public String username;

	public Map<Object, Object> map;
	
	
	public DotSession() {
		username = "none";
		map = new HashMap<Object, Object>();
	}
	
	public static DotSession getVTSession(HttpServletRequest request) {
		DotSession ds = (DotSession)request.getSession().getAttribute("vts");
		return ds;
	}
	
	public static void putSessionMapDataByColName(DotSession ds, ResultSet rs){
		try {
			ResultSetMetaData rsm =rs.getMetaData();
			int colCount = rsm.getColumnCount();
			String colName;
			for(int i=1; i<=colCount; i++)
			{
				colName=rsm.getColumnName(i).toLowerCase();
				ds.map.put(colName, rs.getString(colName));
			}
		} catch (Exception e) {
		}
		
	}
}
