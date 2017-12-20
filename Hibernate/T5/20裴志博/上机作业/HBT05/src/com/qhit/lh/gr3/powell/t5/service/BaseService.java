package com.qhit.lh.gr3.powell.t5.service;

import java.util.List;

public interface BaseService {
	/**
	 * @param obj
	 * 增
	 */
	public void add(Object obj);
	/**
	 * @param obj
	 * 删
	 */
	public void delete(Object obj);
	/**
	 * @param obj
	 * 改
	 */
	public void update(Object obj);
	/**
	 * 查 
	 */
	public List<Object> getAll(String fromObject);
	
	/**
	 * @param obj
	 * @param id
	 * @return
	 * 根据id查
	 */
	public Object getobjectById(Class clazz, int id);
}
