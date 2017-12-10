package com.qhit.powell.provider.service;

import java.util.List;

import com.qhit.powell.common.bean.PageBean;
import com.qhit.powell.provider.bean.Provider;
import com.qhit.powell.provider.dao.ProviderDao;

public class ProviderService implements IProviderService {

	@Override
	public List<Provider> getAllProvider() {
		return new ProviderDao().getAllProvider();
	}

	@Override
	public PageBean getPageBean(PageBean pageBean) {
		// TODO Auto-generated method stub
		return new ProviderDao().getPageBean(pageBean);
	}

	@Override
	public int delProvider(int providerId) {
		// TODO Auto-generated method stub
		return new ProviderDao().delProvider(providerId);
	}

	@Override
	public int addProvider(Provider provider) {
		// TODO Auto-generated method stub
		return new ProviderDao().addProvider(provider);
	}

	@Override
	public Provider getProviderById(int providerId) {
		// TODO Auto-generated method stub
		return new ProviderDao().getProviderById(providerId);
	}

	@Override
	public int updProvider(Provider provider) {
		// TODO Auto-generated method stub
		return new ProviderDao().updProvider(provider);
	}

}
