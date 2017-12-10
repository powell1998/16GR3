package com.qhit.powell.goods.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.qhit.powell.goods.bean.Goods;
import com.qhit.powell.utils.DBManage;

public class GoodsDao implements IGoodsDao {
	Connection con = null;
	PreparedStatement ps = null;
	
	/* (non-Javadoc)
	 * @see com.qhit.wjk.goods.dao.IGoodsDao#getGoodsInfoByName(java.lang.String)
	 * 根据商品名称查询
	 */
	@Override
	public Goods getGoodsInfoByName(String goodsName) {
		Goods goods = null;
		con = DBManage.getConnection();
		String sql = "select * from tb_goods where goodsName = ?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, goodsName);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				goods = new Goods(
						rs.getInt("goodsId"), 
						goodsName, 
						rs.getInt("goodsNum"), 
						rs.getFloat("goodsPrice"), 
						rs.getString("goodsUnit"), 
						rs.getString("goodsIntro")
						);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return goods;
	}

	@Override
	public int updateStore(int num, int goodsId) {
		con = DBManage.getConnection();
		String sql = "update tb_goods set goodsNum = ? where goodsId = ?";
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, num);
			ps.setInt(2, goodsId);
			return ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
}
