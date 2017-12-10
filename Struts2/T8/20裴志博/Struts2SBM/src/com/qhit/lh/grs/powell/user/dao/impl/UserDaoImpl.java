package com.qhit.lh.grs.powell.user.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.qhit.lh.grs.powell.user.bean.User;
import com.qhit.lh.grs.powell.user.dao.UserDao;
import com.qhit.lh.grs.powell.user.utils.DBManage;


public class UserDaoImpl implements UserDao {
	private User user = null;
	private Connection con;
	private PreparedStatement ps;
	
	/* (non-Javadoc)
	 * @see com.qhit.lh.grs.wjk.user.dao.UserDao#doLogin(java.lang.String, java.lang.String)
	 */
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
	 * @see com.qhit.lh.grs.wjk.user.dao.UserDao#addUser(com.qhit.lh.grs.wjk.user.bean.User)
	 */
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
	 * @see com.qhit.lh.grs.wjk.user.dao.UserDao#getAll()
	 */
	public List<User> getAll() throws Exception {
		List<User> users = new ArrayList<>();
		User user = null;
		con = DBManage.getConnection();
		String sql = "select * from tb_user";
		ps = con.prepareStatement(sql);
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
			users.add(user);
		}
		return users;
	}
}