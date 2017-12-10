package com.qhit.powell.account.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qhit.powell.account.service.AccountService;
import com.qhit.powell.account.service.IAccountService;
import com.qhit.powell.common.bean.PageBean;
import com.qhit.powell.common.service.CommonService;
import com.qhit.powell.common.service.ICommonService;
import com.qhit.powell.goods.bean.Goods;

public class AccountServlet extends HttpServlet {
	private ICommonService commonService = new CommonService();
	private IAccountService accountService = new AccountService();
	
	/**
		 * The doGet method of the servlet. <br>
		 *
		 * This method is called when a form has its tag value method equals to get.
		 * 
		 * @param request the request send by the client to the server
		 * @param response the response send by the server to the client
		 * @throws ServletException if an error occurred
		 * @throws IOException if an error occurred
		 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doPost(request, response);
	}

	/**
		 * The doPost method of the servlet. <br>
		 *
		 * This method is called when a form has its tag value method equals to post.
		 * 
		 * @param request the request send by the client to the server
		 * @param response the response send by the server to the client
		 * @throws ServletException if an error occurred
		 * @throws IOException if an error occurred
		 */
	public void doPost(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		
		String cmd = request.getParameter("cmd");
		
		switch (cmd) {
		case "getPageBean": //分页查询列表账单数据
			getPageBean(request,response);
			break;
		case "addAccount": //添加账单
			addAccount(request,response);
			break;
		case "getAccountByParam": //添加账单
			getAccountByParam(request,response);
			break;
		case "deleteAccount": //删除账单信息
			deleteAccount(request, response);
			break;
		case "updateAccount": //修改账单
			updateAccount(request, response);
			break;
		case "selectAccount": //查询数据
			selectAccount(request,response);
			break;
		
		default:
			break;
		}
	}

	/**
	 * @param request
	 * @param response
	 * 查询数据
	 */
	private void selectAccount(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @param request
	 * @param response
	 * 修改账单信息
	 * @throws IOException 
	 */
	private void updateAccount(HttpServletRequest request, 
			HttpServletResponse response) throws IOException {
		
		String accountId = request.getParameter("accountId");
		String providerId = request.getParameter("providerId");
		String isPayed = request.getParameter("isPayed");
		
		int row = accountService.upDateAccountById(
				Integer.parseInt(accountId), 
				Integer.parseInt(providerId), 
				Integer.parseInt(isPayed)
				);
		if(row > 0){
			//更新成功
			response.sendRedirect("account?cmd=getPageBean&&p=1");
		}else{
			//更新失败
			PrintWriter out = response.getWriter();
			out.print("<script>alert('更新失败');</script>");
		}
	}

	/**
	 * @param request
	 * @param response
	 * 删除账单信息
	 * @throws IOException 
	 */
	private void deleteAccount(HttpServletRequest request, 
			HttpServletResponse response) throws IOException {
		String accountId = request.getParameter("accountId");
		
		int row = accountService.delAccount(Integer.parseInt(accountId));
		
		if(row > 0){
			//删除成功
			response.sendRedirect("account?cmd=getPageBean&&p=1");
		}else{
			//删除失败
			PrintWriter out = response.getWriter();
			out.print("<script>alert('删除失败');</script>");
		}
		
	}

	/**
	 * @param request
	 * @param response
	 * @throws IOException 
	 */
	private void getAccountByParam(HttpServletRequest request, 
			HttpServletResponse response) throws IOException {
		String goodsName = request.getParameter("goodsName");
		String isPayed = request.getParameter("isPayed");
		List<String> wheres = new ArrayList<String>();
		List<String> values = new ArrayList<String>();
		if(goodsName != null && goodsName != ""){
			wheres.add("g.goodsName");
			values.add(goodsName);
		}
		if(isPayed != null && isPayed != ""){
			wheres.add("a.isPayed");
			values.add(isPayed);
		}
		
		PageBean pageBean = accountService.getPageBeanByParam(wheres, values);
		
		request.getSession().setAttribute("pageBean", pageBean);
		
		PrintWriter out = response.getWriter();
		out.print("<script>location.href = 'jsp/admin_bill_list.jsp'</script>");
	}

	/**
	 * @param request
	 * @param response
	 * 添加账单信息
	 * @throws ServletException 
	 */
	private void addAccount(HttpServletRequest request, 
			HttpServletResponse response) throws IOException, ServletException {
		
		Goods goods = (Goods) request.getAttribute("goods");
		String businessNum = request.getParameter("businessNum");
		String providerId = request.getParameter("providerId");
		String isPayed = request.getParameter("isPayed");
		
		int row = accountService.addAccount(
				goods, 
				Integer.parseInt(businessNum), 
				Integer.parseInt(providerId), 
				Integer.parseInt(isPayed));
		if(row > 0){
			//更新库存
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("goods?cmd=updateStore");
			requestDispatcher.forward(request, response);
		}else{
			//添加失败
			PrintWriter out = response.getWriter();
			out.print("<script>alert('添加失败');</script>");
		}
	}

	/**
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	private void getPageBean(HttpServletRequest request, 
			HttpServletResponse response) throws IOException {
		
		/**
		 * pagesize:5
		 * data:初始化
		 * count:1
		 * pagetotal:2
		 * p:3
		 * 分页查询列表账单数据
		 */
		PageBean pageBean = new PageBean();
		int count = commonService.getCount("tb_account", null, null);
		pageBean.setCount(count);
		
		String p =request.getParameter("p");
		if(p != null && p != ""){
			//有参数p
			pageBean.setP(Integer.parseInt(p));
		}else{
			//没有参数，第一次进入
			pageBean.setP(1);
		}
		
		pageBean = accountService.getPageBean(pageBean);
		//保存数据
		request.getSession().setAttribute("pageBean",pageBean);
		if(p != null && p != ""){
			//有参数P
			PrintWriter out = response.getWriter();
			out.print("<script>location.href = 'jsp/admin_bill_list.jsp'</script>");
		}else{
			response.sendRedirect("jsp/admin_index.jsp");
		}
	}
}
