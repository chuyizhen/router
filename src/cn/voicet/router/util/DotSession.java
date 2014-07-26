package cn.voicet.router.util;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

public class DotSession {
	
	private static Logger log = Logger.getLogger(DotSession.class);
	
	public String username;
	public Map<Object, Object> map;
	public List<Object> list;
	
	public DotSession() {
		username = "none";
		map = new HashMap<Object, Object>();
	}
	
	public void initListData() {
		list = new ArrayList<Object>();
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
			log.error("error:"+e.getMessage());
		}
	}
}
