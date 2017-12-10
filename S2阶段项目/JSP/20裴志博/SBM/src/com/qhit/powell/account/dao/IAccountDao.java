package com.qhit.powell.account.dao;

import java.util.List;

import com.qhit.powell.common.bean.PageBean;
import com.qhit.powell.goods.bean.Goods;

public interface IAccountDao {

	/**
	 * @param pageBean
	 * @return
	 * 分页数据的访问
	 */
	PageBean getPageBean(PageBean pageBean);
	
	/**
	 * @param goods
	 * @param businessNum
	 * @param providerId
	 * @param isPayed
	 * @return
	 * 添加账单
	 */
	int addAccount(Goods goods,int businessNum,int providerId,int isPayed);
	
	/**
	 * @param wheres
	 * @param values
	 * @return
	 * 根据参数查询
	 */
	PageBean getPageBeanByParam(List<String> wheres,List<String> values);
	
	/**
	 * @param accountId
	 * @return
	 * 删除账单
	 */
	int delAccount(int accountId);
	
	/**
	 * @param accountId
	 * @param providerId
	 * @param isPayed
	 * @return
	 * 更新
	 */
	int upDateAccountById(int accountId,int providerId,int isPayed);
}