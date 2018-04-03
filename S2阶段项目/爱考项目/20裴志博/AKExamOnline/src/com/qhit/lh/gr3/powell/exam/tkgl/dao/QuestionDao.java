package com.qhit.lh.gr3.powell.exam.tkgl.dao;

import java.util.List;
import java.util.Map;

import com.qhit.lh.gr3.powell.exam.common.bean.PageBean;
import com.qhit.lh.gr3.powell.exam.kmgl.bean.Course;
import com.qhit.lh.gr3.powell.exam.tkgl.bean.WrittenQuestion;

public interface QuestionDao {
	
	/**
	 * @param parameter
	 * @return
	 * 题库列表
	 */
	public List<Course> getCourseInfo(Map parameter);
	
	/**
	 * 笔试题列表分页数据
	 * @param pageBean
	 * @param course
	 * @param pageIndex
	 * @return
	 */
	public PageBean<WrittenQuestion> getWrittenList(
			PageBean<WrittenQuestion> pageBean,
			Course course,
			int pageIndex);
	/**
	 * 添加笔试题
	 * @param writtenQuestion
	 */
	public void addWrittenQuestion(WrittenQuestion writtenQuestion);

}
