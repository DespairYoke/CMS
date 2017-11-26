package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbcp.DbcpException;

import entity.Fruit;
import util.DBUtil;

public class fruitDao {
		
	public List findAll(){
		List<Fruit> list=new ArrayList();
		try {
			Fruit f=null;
			String sql="select * from fruit";
			Connection conn=DBUtil.getConnection();
			Statement state=conn.createStatement();
			ResultSet rs=state.executeQuery(sql);
			while(rs.next())
			{
				f=new Fruit();
				f.setName(rs.getString("name"));
				f.setPrice(rs.getDouble("price"));
				f.setSellprice(rs.getDouble("sellprice"));
				f.setEvaluate(rs.getString("evaluate"));
				f.setNum(rs.getInt("num"));
				f.setCount(rs.getInt("count"));
				f.setPath(rs.getString("path"));
				f.setAdmin_name("admin_name");
				System.out.println(f);
				list.add(f);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
		
	}
	public Fruit findByName(String name){
		System.out.println("hello");
		Fruit f=null;
		try {
			Connection conn=DBUtil.getConnection();
			String sql="select * from fruit where name=?";
			PreparedStatement state=conn.prepareStatement(sql);
			System.out.println(name);
			state.setString(1, name);
			ResultSet rs=state.executeQuery();
			while(rs.next())
			{
				f=new Fruit();
				f.setName(rs.getString("name"));
				f.setPrice(rs.getDouble("price"));
				f.setSellprice(rs.getDouble("sellprice"));
				f.setEvaluate(rs.getString("evaluate"));
				f.setNum(rs.getInt("num"));
				f.setCount(rs.getInt("count"));
				f.setPath(rs.getString("path"));
				f.setAdmin_name(rs.getString("admin_name"));
				System.out.println(f.toString());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return f;
	}
	public void update_fruit(Fruit f) {
		// TODO Auto-generated method stub
		Connection conn=null;
		try {
			System.out.println(f);
			String sql="update fruit set price=?,sellprice=?,num=?,admin_name=? where name=?";
		    conn=DBUtil.getConnection();
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setDouble(1, f.getPrice());
			ps.setDouble(2, f.getSellprice());
			ps.setInt(3, f.getNum());
			ps.setString(4, f.getAdmin_name());
			ps.setString(5, f.getName());
			ps.executeUpdate();
			System.out.println(1111);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
