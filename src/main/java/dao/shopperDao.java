package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entity.Shopper;
import util.DBUtil;

public class shopperDao {
	
	//注冊
	public void regist(String uname,String pwd){
		Connection conn=null;
		
		try {
			conn=DBUtil.getConnection();
			String sql="INSERT INTO shopper(uname,pwd) VALUES(?,?)";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, uname);
			ps.setString(2, pwd);
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.close(conn);
		}
	}
   //添加用户个人信息
	public void update(Shopper shopper){
		Connection conn=null;
		
		try {
			conn=DBUtil.getConnection();
			String sql="update shopper set gender=?,phone=?,address=?,cardnum=? where uname=?";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, shopper.getGender());
			ps.setLong(2, shopper.getPhone());
			ps.setString(3, shopper.getAddress());
			ps.setLong(4, shopper.getCardnum());
			ps.setString(5, shopper.getUname());
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.close(conn);
		}
	}
	
	//查找用户
	public List<Shopper> findShopper() {
		Connection conn=null;
		List<Shopper> list=new ArrayList<Shopper>();
		String sql="select uname,pwd from shopper";
		try {
			conn=DBUtil.getConnection();
			Statement state=conn.createStatement();
			ResultSet rs=state.executeQuery(sql);
			while(rs.next())
			{
				list.add(new Shopper(rs.getString(1),rs.getString(2)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("查询管理员失败,请重试", e);
		}
		return list;
	}
	//查找全体用户
		public List<Shopper> findAll() {
			Connection conn=null;
			List<Shopper> list=new ArrayList<Shopper>();
			String sql="select * from shopper";
			try {
				conn=DBUtil.getConnection();
				Statement state=conn.createStatement();
				ResultSet rs=state.executeQuery(sql);
				while(rs.next())
				{
					Shopper shop=new Shopper();
					shop.setUname(rs.getString("uname"));
					shop.setPwd(rs.getString("pwd"));
					shop.setGender(rs.getString("gender"));
					shop.setPhone(rs.getLong("phone"));
					shop.setAddress(rs.getString("address"));
					shop.setCardnum(rs.getLong("cardnum"));
					list.add(shop);
				}
			} catch (SQLException e) {
				e.printStackTrace();
				throw new RuntimeException("查询管理员失败,请重试", e);
			}
			return list;
		}
	//通过用户名查找用户
	public Shopper findByUName(String uname){
        Connection conn=null;
		Shopper shopper=null;
		try {
			conn=DBUtil.getConnection();
			String sql="select * from shopper where uname= ?";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, uname);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				
				shopper=new Shopper();
				
				shopper.setUname(rs.getString("uname"));
				shopper.setPwd(rs.getString("pwd"));
				shopper.setGender(rs.getString("gender"));
				shopper.setPhone(rs.getLong("phone"));
				shopper.setAddress(rs.getString("address"));
				shopper.setCardnum(rs.getLong("cardnum"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally{
			DBUtil.close(conn);
		}
		return shopper;
	}
	
	
	
}
