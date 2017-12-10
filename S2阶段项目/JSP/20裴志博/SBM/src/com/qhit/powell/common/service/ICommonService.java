package com.qhit.powell.common.service;

import java.util.List;

public interface ICommonService {
	/**
	 * @param tableName
	 * @param wheres
	 * @param values
	 * @return
	 * 总记录的业务
	 */
	public int getCount(String tableName,List<String> wheres,List<String> values);
}
