package com.powell.t5.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.powell.t5.bean.User;
import com.powell.t5.dao.UserDao;
import com.powell.t5.utils.DBManager;

public class UserDaoImpl implements UserDao {
	private Connection con;
	private PreparedStatement ps;

	@Override
	public int addUser(User user) throws Exception {
		con = DBManager.getConnection();
		String sql = "insert into t_user values (?,?,?,?,?)";
		ps = con.prepareStatement(sql);
		ps.setString(1, user.getUname());
		ps.setString(2, user.getUpwd());
		ps.setString(4, user.getBirthday());
		ps.setString(3, user.getSex());
		ps.setInt(5, user.getEnable());
		int row = ps.executeUpdate();
		DBManager.closeConnection(con);
		return row;
	}

	@Override
	public int deleteUser(User user) throws Exception {
		// TODO Auto-generated method stub
		con = DBManager.getConnection();
		String sql = "delete from t_user where id = ?";
		ps = con.prepareStatement(sql);
		ps.setInt(1, user.getId());
		int row = ps.executeUpdate();
		DBManager.closeConnection(con);
		return row;
	}

	@Override
	public int upDateUser(User user) throws Exception {
		// TODO Auto-generated method stub
		con = DBManager.getConnection();
		String sql = "update t_user set uname = ?, upwd = ?, birthday = ?, sex = ?, enable = ? where id = ?";
		ps = con.prepareStatement(sql);
		ps.setString(1, user.getUname());
		ps.setString(2, user.getUpwd());
		ps.setString(3, user.getBirthday());
		ps.setString(4, user.getSex());
		ps.setInt(5, user.getEnable());
		ps.setInt(6, user.getId());
		int row = ps.executeUpdate();
		DBManager.closeConnection(con);
		return row;
	}

	@Override
	public List<User> getAllUser() throws Exception {
		User user = null;
		List<User> users = new ArrayList<>();
		con = DBManager.getConnection();
		String sql = "select * from t_user";
		ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			user = new User(
					rs.getInt("id"),
					rs.getString("uname"),
					rs.getString("upwd"),
					rs.getString("birthday"),
					rs.getString("sex"),
					rs.getInt("enable"));
			users.add(user);
		}
		DBManager.closeConnection(con);
		return users;
	}

	@Override
	public User getUserById(User user) throws Exception {
		// TODO Auto-generated method stub
		con = DBManager.getConnection();
		String sql = "select * from t_user where id = ?";
		ps = con.prepareStatement(sql);
		ps.setInt(1, user.getId());
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			user = new User(
					rs.getInt("id"), 
					rs.getString("uname"), 
					rs.getString("upwd"), 
					rs.getString("birthday"), 
					rs.getString("sex"), 
					rs.getInt("enable"));
		}
		DBManager.closeConnection(con);
		return user;
	}

}
