package cn.voicet.router.util;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.Map;

import org.apache.log4j.Logger;

public class VTJime {
	private static Logger log = Logger.getLogger(VTJime.class);
	
	/**
	 * 根据列名取数据，放进map
	 * @param map 	存放数据
	 * @param rs	结果集
	 */
	public static void putMapDataByColName(Map<Object, Object> map,ResultSet rs) {
		String colName;
		try {
			//从元数据中获得列数 
			ResultSetMetaData rsm =rs.getMetaData();
			//所有字段的数目
			int col = rsm.getColumnCount();
			for(int i=1; i<=col; i++) {
				//根据字段的索引值取得字段的名称
				colName=rsm.getColumnName(i).toLowerCase();
				if(null!=rs.getString(i) && !rs.getString(i).equals("")){
					map.put(colName, rs.getString(i));
				}else{
					map.put(colName, "");
				}
			}
		} catch (Exception e) {
			log.error("error:"+e.getMessage());
		}
	}
}
