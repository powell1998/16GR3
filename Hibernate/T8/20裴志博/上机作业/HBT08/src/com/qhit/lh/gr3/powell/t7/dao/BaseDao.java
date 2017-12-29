package com.qhit.lh.gr3.powell.t7.dao;

import java.util.List;

import com.qhit.lh.gr3.powell.t7.bean.Emp;

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
	public Object getobjectById(Class clazz, int id);
	
	/**
	 * @param name
	 * @return
	 * 根据名字查询Emp
	 */
	public List<Emp> getEmpByName(String name);

}
