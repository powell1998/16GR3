package com.qhit.powell.goods.service;

import com.qhit.powell.goods.bean.Goods;
import com.qhit.powell.goods.dao.GoodsDao;

public class GoodsService implements IGoodsService {

	@Override
	public Goods getGoodsInfoByName(String goodsName) {
		// TODO Auto-generated method stub
		return new GoodsDao().getGoodsInfoByName(goodsName);
	}

	@Override
	public int updateStore(int num, int goodsId) {
		// TODO Auto-generated method stub
		return new GoodsDao().updateStore(num, goodsId);
	}
	
	
}
