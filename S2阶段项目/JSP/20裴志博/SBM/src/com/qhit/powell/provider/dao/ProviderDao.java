package com.qhit.powell.provider.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.qhit.powell.common.bean.PageBean;
import com.qhit.powell.provider.bean.Provider;
import com.qhit.powell.utils.DBManage;

public class ProviderDao implements IProviderDao {
	private Connection con = null;
	private PreparedStatement ps = null;
	
	/* (non-Javadoc)
	 * @see com.qhit.wjk.provider.dao.IProviderDao#getAllProvider()
	 * 查询所有供应商
	 */
	@Override
	public List<Provider> getAllProvider() {
		List<Provider> list = new ArrayList<Provider>();
		Provider provider = null;
		con = DBManage.getConnection();
		String sql = "select * from tb_provider";
		try {
			ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				provider = new Provider(
						rs.getInt("providerId"), 
						rs.getString("providerName"), 
						rs.getString("providerDetail"), 
						rs.getString("contact"), 
						rs.getString("telephone"), 
						rs.getString("facsimile"), 
						rs.getString("address"));
				list.add(provider);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	/* (non-Javadoc)
	 * @see com.qhit.wjk.provider.dao.IProviderDao#getPageBean(com.qhit.wjk.common.bean.PageBean)
	 * 分页查询所有数据
	 */
	@Override
	public PageBean getPageBean(PageBean pageBean) {
		Provider provider = null;
		con = DBManage.getConnection();
		String sql = "select top " 
		+ pageBean.getPagesize()
				+ " p.providerId,p.providerName,p.providerDetail,p.contact,p.telephone,p.address " 
				+ " from tb_provider p "
				+ " where p.providerId " 
				+ " not in ( " 
				+ " select top " 
				+ pageBean.getPagesize() * (pageBean.getP() - 1)
				+ " p.providerId  " 
				+ " from tb_provider p ) ; " ;

		try {
			ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				provider = new Provider(
						rs.getInt("providerId"), 
						rs.getString("providerName"),
						rs.getString("providerDetail"),
						rs.getString("contact"),
						rs.getString("telephone"),
						rs.getString("address")
						);

				pageBean.addData(provider);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManage.close(con);
		}
		return pageBean;

	}

	/* (non-Javadoc)
	 * @see com.qhit.wjk.provider.dao.IProviderDao#delProvider(int)
	 * 删除
	 */
	@Override
	public int delProvider(int providerId) {
		con = DBManage.getConnection();
		String sql = "delete from tb_provider where providerId = ?";
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, providerId);
			return ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	/* (non-Javadoc)
	 * @see com.qhit.wjk.provider.dao.IProviderDao#addUser(com.qhit.wjk.provider.bean.Provider)、
	 * 添加
	 */
	@Override
	public int addProvider(Provider provider) {
		con = DBManage.getConnection();
		String sql = "insert into tb_provider values (?,?,?,?,?,?)";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, provider.getProviderName());
			ps.setString(2, provider.getProviderDetail());
			ps.setString(3, provider.getContact());
			ps.setString(4, provider.getTelephone());
			ps.setString(5, provider.getFacsimile());
			ps.setString(6, provider.getAddress());
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
	 * @see com.qhit.wjk.provider.dao.IProviderDao#getProviderById(int)
	 */
	@Override
	public Provider getProviderById(int providerId) {
		Provider provider = null;
		con = DBManage.getConnection();
		String sql = "select * from tb_provider where providerId = ?";
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, providerId);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				provider = new Provider(
						rs.getInt("providerId"), 
						rs.getString("providerName"), 
						rs.getString("providerDetail"), 
						rs.getString("contact"), 
						rs.getString("telephone"), 
						rs.getString("facsimile"), 
						rs.getString("address"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBManage.close(con);
		}
			return provider;
	}

	@Override
	public int updProvider(Provider provider) {
		// TODO Auto-generated method stub
		con=DBManage.getConnection();
		String sql="update tb_provider set providerName = ?,providerDetail = ?,contact = ?,telephone = ?,facsimile = ?,address = ? where providerId = ?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1,provider.getProviderName()); 
			ps.setString(2,provider.getProviderDetail()); 
			ps.setString(3,provider.getContact()); 
			ps.setString(4,provider.getTelephone()); 
			ps.setString(5,provider.getFacsimile()); 
			ps.setString(6,provider.getAddress());
			ps.setInt(7,provider.getProviderId());
			return ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBManage.close(con);
		}
		return 0;
	}
}
