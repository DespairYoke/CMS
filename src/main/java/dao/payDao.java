package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entity.Order;
import util.DBUtil;

public class payDao {
	public void save(Order order)
	{
		Connection conn=null;
		try {
			conn=DBUtil.getConnection();
			String sql="insert into fruitorder values(?,?,?,?)";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, order.getUname());
			ps.setDouble(2,order.getPrice());
			ps.setString(3, order.getAddress());
			ps.setLong(4, order.getPhone());
			ps.executeUpdate();
		}  catch (SQLException e1) {
			e1.printStackTrace();
			throw new RuntimeException("数据异常", e1);
			} finally {
				DBUtil.close(conn);
			}
	}
	public List<Order> findAll(){
		Connection conn=null;
		List<Order> list=new ArrayList<Order>();
		try {
		conn=DBUtil.getConnection();
		String sql="select * from fruitorder";
		Statement state=conn.createStatement();
		ResultSet rs=state.executeQuery(sql);
		while(rs.next()){
			Order order=new Order();
			order.setUname(rs.getString(1));
			order.setPrice(rs.getDouble(2));
			order.setAddress(rs.getString(3));
			order.setPhone(rs.getLong(4));
			
			list.add(order);
		}
		}
		catch (SQLException e1) {
			e1.printStackTrace();
			throw new RuntimeException("数据异常", e1);
			} finally {
				DBUtil.close(conn);
			}
		return list;
	
	}
}
