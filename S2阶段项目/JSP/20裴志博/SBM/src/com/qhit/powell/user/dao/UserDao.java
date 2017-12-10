package com.qhit.powell.user.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.qhit.powell.account.bean.AccountDetail;
import com.qhit.powell.common.bean.PageBean;
import com.qhit.powell.user.bean.User;
import com.qhit.powell.utils.DBManage;

public class UserDao implements IUserDao {
	private User user = null;
	private Connection con;
	private PreparedStatement ps;
	
	/* (non-Javadoc)
	 * @see com.qhit.wjk.user.dao.IUserDao#doLogin(java.lang.String, java.lang.String)
	 * 登录
	 */
	@Override
	public User doLogin(String userName,String userPassword){
		con = DBManage.getConnection();
		String sql = "select * from tb_user where userName = ? and userPassword = ?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, userName);
			ps.setString(2, userPassword);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				user = new User(
						rs.getInt("userId"), 
						rs.getString("userName"), 
						rs.getString("userPassword"), 
						rs.getString("userSex"), 
						rs.getInt("userAge"), 
						rs.getString("telephone"), 
						rs.getString("address"), 
						rs.getString("pic"),
						rs.getInt("type"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBManage.close(con);
		}
		return user;
	}

	/* (non-Javadoc)
	 * @see com.qhit.wjk.user.dao.IUserDao#addUser(com.qhit.wjk.user.bean.User)
	 * 添加
	 */
	@Override
	public int addUser(User user) {
		con = DBManage.getConnection();
		String sql = "insert into tb_user values (?,?,?,?,?,?,?,?)";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, user.getUserName());
			ps.setString(2, user.getUserPassword());
			ps.setString(3, user.getUserSex());
			ps.setInt(4, user.getUserAge());
			ps.setString(5, user.getTelephone());
			ps.setString(6, user.getAddress());
			ps.setString(7, user.getPic());
			ps.setInt(8, user.getType());
			return ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBManage.close(con);
		}
		return 0;	
	}

	/* (non-Javadoc)
	 * @see com.qhit.wjk.user.dao.IUserDao#getPageBean(com.qhit.wjk.common.bean.PageBean)
	 * 分页
	 */
	@Override
	public PageBean getPageBean(PageBean pagebean) {
		// TODO 分页查询数据
		con = DBManage.getConnection();
		String sql = "select top "
				+ pagebean.getPagesize()
				+ " * from tb_user u  where u.userId not in (select top "
				+ pagebean.getPagesize()*(pagebean.getP()-1)
				+ " userId from tb_user)";
		try {
			ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				user = new User(
						rs.getInt("userId"), 
						rs.getString("userName"), 
						rs.getString("userSex"), 
						rs.getInt("userAge"), 
						rs.getString("telephone"), 
						rs.getString("address"), 
						rs.getInt("type"));
				pagebean.addData(user);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBManage.close(con);
		}
		return pagebean;
	}

	/* (non-Javadoc)
	 * @see com.qhit.wjk.user.dao.IUserDao#delUser(int)
	 * 删除
	 */
	@Override
	public int delUser(int userId) {
		con = DBManage.getConnection();
		String sql = "delete from tb_user where userId = ?";
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, userId);
			return ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	/* (non-Javadoc)
	 * @see com.qhit.wjk.user.dao.IUserDao#updUser(int)
	 * 更新
	 */
	@Override
	public int updUser(int userId) {
		con = DBManage.getConnection();
		String sql = "update tb_user set userName=?,userPassword=?,"
				+ "userSex=?,userAge,telephone=?,address=?,pic=?,type=? "
				+ "where userId = ?";
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, userId);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				user = new User(
						userId, 
						rs.getString("userName"), 
						rs.getString("userPassword"), 
						rs.getString("userSex"), 
						rs.getInt("userAge"), 
						rs.getString("telephone"), 
						rs.getString("address"), 
						rs.getString("pic"), 
						rs.getInt("type"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBManage.close(con);
		}
		return 0;
	}

	/* (non-Javadoc)
	 * @see com.qhit.wjk.user.dao.IUserDao#getUserById(java.lang.String)
	 * 通过ID查询
	 */
	@Override
	public User getUserById(String userId) {
		// TODO Auto-generated method stub
		int userid = Integer.parseInt(userId);
		con = DBManage.getConnection();
		String sql = "select * from tb_user where userId = ?";
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, Integer.parseInt(userId));
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				user = new User(
						rs.getInt("userId"), 
						rs.getString("userName"), 
						rs.getString("userSex"), 
						rs.getInt("userAge"), 
						rs.getString("telephone"), 
						rs.getString("address"), 
						rs.getInt("type"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBManage.close(con);
		}
		return user;
	}

	/* (non-Javadoc)
	 * @see com.qhit.wjk.user.dao.IUserDao#updUserpwd(com.qhit.wjk.user.bean.User, int)
	 * 修改密码
	 */
	@Override
	public int updUserpwd(User user,int userId) {
		// TODO Auto-generated method stub
		con = DBManage.getConnection();
		String sql = "update tb_user set userPassword=? where userId=?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, user.getUserPassword());
			ps.setInt(2, userId);
			return ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBManage.close(con);
		}
		return 0;
	}

	/* (non-Javadoc)
	 * @see com.qhit.wjk.user.dao.IUserDao#getUserByInfo(int)
	 * 通过ID查询用户信息
	 */
	@Override
	public User getUserByInfo(int userId) {
		// TODO Auto-generated method stub
		con = DBManage.getConnection();
		String sql = "select * from tb_user where userId=?";
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, userId);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				user = new User(
						rs.getString("userName"),
						rs.getString("userPassword"), 
						rs.getString("userSex"), 
						rs.getInt("userAge"), 
						rs.getString("telephone"), 
						rs.getString("address"), 
						rs.getString("pic"), 
						rs.getInt("type"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBManage.close(con);
		}
		return user;
	}

	@Override
	public PageBean getUserPageBean(PageBean pagebean, String userName) {
		// TODO Auto-generated method stub
		con = DBManage.getConnection();
		String sql = "select top "
				+ pagebean.getPagesize()
				+ " * from tb_user u where u.userName = ? and u.userId not in (select top "
				+ pagebean.getPagesize()*(pagebean.getP()-1)
				+ " userId from tb_user where userName = ?)";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, userName);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				user = new User(
						rs.getInt("userId"),
						rs.getString("userName"), 
						rs.getString("userPassword"),
						rs.getString("userSex"), 
						rs.getInt("userAge"), 
						rs.getString("telephone"), 
						rs.getString("address"), 
						rs.getString("pic"), 
						rs.getInt("type"));
				pagebean.addData(user);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBManage.close(con);
		}
		return pagebean;
	}
}