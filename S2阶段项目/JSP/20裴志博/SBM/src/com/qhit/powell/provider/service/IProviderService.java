package com.qhit.powell.provider.service;

import java.util.List;

import com.qhit.powell.common.bean.PageBean;
import com.qhit.powell.provider.bean.Provider;

public interface IProviderService {
	
	/**
	 * @param pageBean
	 * @return
	 * 分页的业务
	 */
	public PageBean getPageBean(PageBean pageBean);

	/**
	 * @return
	 */
	public List<Provider> getAllProvider();
	
	/**
	 * @param user
	 * @return
	 * 删除
	 */
	public int delProvider(int providerId);
	
	/**
	 * @param user
	 * @return
	 * 添加用户
	 */
	public int addProvider(Provider provider);
	
	/**
	 * @param ProviderId
	 * @return
	 * 根据ID查询信息
	 */
	public Provider getProviderById(int providerId);
	
	/**
	 * @param provider
	 * @return
	 * 更新数据
	 */
	public int updProvider(Provider provider);
}