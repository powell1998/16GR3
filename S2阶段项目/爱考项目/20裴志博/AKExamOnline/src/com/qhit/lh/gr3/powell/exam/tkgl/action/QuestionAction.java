package com.qhit.lh.gr3.powell.exam.tkgl.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionSupport;
import com.qhit.lh.gr3.powell.exam.common.bean.PageBean;
import com.qhit.lh.gr3.powell.exam.kmgl.bean.Course;
import com.qhit.lh.gr3.powell.exam.tkgl.bean.WrittenQuestion;
import com.qhit.lh.gr3.powell.exam.tkgl.service.QuestionService;
import com.qhit.lh.gr3.powell.exam.tkgl.service.QuestionServiceImpl;

public class QuestionAction extends ActionSupport {
	private QuestionService questionService = new QuestionServiceImpl();
	private Course course;//课程
	private String major;//专业方向
	private String stage;//阶段
	private WrittenQuestion writtenQuestion;//笔试题对象
	private List<Course> listCourses = new ArrayList<>();
	//试题列表分页数据
	private PageBean<WrittenQuestion> pageBean = new PageBean<>();
	private int pageIndex = 1;//指定页，初始化为1
	/**
	 * 题库列表
	 * @return
	 */
	public String getCourseInfo(){
		//设置参数
		Map<String, String> parameter = new HashMap<>();
		if(major != null && !"".equals(major)){
			parameter.put("major", major);
		}
		if(stage != null && !"".equals(stage)){
			parameter.put("stage", stage);
		}
		//查询题库列表数据
		listCourses = questionService.getCourseInfo(parameter);
		System.out.println("课程数量："+listCourses.size());
		return "listCourse";
	}
	
	/**
	 * 获取题库列表
	 * @return
	 */
	public String getWrittenList(){
		pageBean = questionService.getWrittenList(pageBean, course, pageIndex);
		System.out.println("数据大小："+pageBean.getItems().size());
		return "listWritten";
	}
	
	/**
	 * 添加笔试题
	 * @return
	 */
	public String addWrittenQuestion(){
		System.out.println(writtenQuestion.getCsId());
		//设置课程试题的关联
		writtenQuestion.setCourse(course);
		
		questionService.addWrittenQuestion(writtenQuestion);
		return "addWrittenQuestion";
		}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public String getStage() {
		return stage;
	}

	public void setStage(String stage) {
		this.stage = stage;
	}

	public List<Course> getListCourses() {
		return listCourses;
	}

	public void setListCourses(List<Course> listCourses) {
		this.listCourses = listCourses;
	}

}
