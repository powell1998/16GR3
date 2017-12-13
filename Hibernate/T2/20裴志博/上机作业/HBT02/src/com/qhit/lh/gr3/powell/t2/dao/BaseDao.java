package com.qhit.lh.gr3.powell.t2.dao;

import java.util.List;

/**
 * @author 裴志博
 * TODO
 * 2017年12月11日上午11:02:03
 */
public interface BaseDao {
	
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
	public Object getobjectById(Object obj, int id);

}
