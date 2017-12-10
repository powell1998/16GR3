package com.qhit.powell.common.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.qhit.powell.utils.DBManage;

public class CommonDao implements ICommonDao {
	private Connection con = null;
	private PreparedStatement ps = null;
	
	public int getCount(String tableName,List<String> wheres,List<String> values){
		con = DBManage.getConnection();
		String sql = "select count(*) as count from " + tableName + " ";
		if(wheres != null && wheres.size() > 0){
			sql += " where ";
			for(int i=0;i<wheres.size();i++){
				sql += wheres.get(i)+" = "+values.get(i)+" and ";
			}
			sql += "1 = 1";
		}
		try {
			ps = con.prepareCall(sql);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				return rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
}
