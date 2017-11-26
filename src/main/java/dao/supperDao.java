package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import util.DBUtil;
import entity.Count;
import entity.Supper;

public class supperDao {
	
	public void save(Supper supper ){
		Connection conn=null;
		
		try {
			conn=DBUtil.getConnection();
			String sql="INSERT INTO admin_supper VALUES(seq_admin_supper.nextval,?,?,?,?,?,?,?)";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, supper.getUname());
			ps.setString(2, supper.getName());
			ps.setString(3, supper.getDepartment());
			ps.setInt(4, supper.getAge());
			ps.setString(5, supper.getGender());
			ps.setString(6, supper.getPassword());
			ps.setDate(7, supper.getRegistDate());
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.close(conn);
		}
	}
	
	
	
	public List<Supper> findsupper() {
		Connection conn=null;
		List<Supper> list=new ArrayList<Supper>();
		String sql="select uname,password from admin_supper";
		try {
			conn=DBUtil.getConnection();
			Statement state=conn.createStatement();
			ResultSet rs=state.executeQuery(sql);
			while(rs.next())
			{
				list.add(new Supper(rs.getString(1),rs.getString(2)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("查询管理员失败,请重试", e);
		}
		return list;
	}
	
	
	
	public Supper findByUserName(String uname){
        Connection conn=null;
		Supper supper=null;
		try {
			conn=DBUtil.getConnection();
			String sql="select * from admin_supper where uname= ?";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, uname);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				
				supper=new Supper();
				supper.setId(rs.getInt("id"));
				supper.setUname(rs.getString("uname"));
				supper.setName(rs.getString("name"));
				supper.setPassword(rs.getString("pwd"));
				supper.setGender(rs.getString("gender"));
				supper.setAge(rs.getInt("age"));
				supper.setDepartment(rs.getString("department"));
				supper.setRegistDate(rs.getDate("registdate"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally{
			DBUtil.close(conn);
		}
		return supper;
	}
	public Count findCountByUname(String uname) {
		String time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
		Count count=new Count();
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			
			String sql = "select lasttime,count from admin_supper where uname= ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, uname);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				
				System.out.println("上次登录时间为："+rs.getString(1));
				count.setCount(rs.getInt(2));
				String sql2 = "update admin_supper set count=?,lasttime=? where uname= ?";
				PreparedStatement ps2 = conn.prepareStatement(sql2);
				ps2.setInt(1, (count.getCount()+1));
				ps2.setString(2, time);
				ps2.setString(3, uname);
				ps2.executeUpdate();
				System.out.println("这是您第"+(count.getCount()+1)+"次登录");
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			DBUtil.close(conn);
		}
	
		return count;

	}
	public void updatepassword(String pwd,String name) throws SQLException {
		Connection conn = null;
		try {
			System.out.println(name+"//"+pwd);
			conn = DBUtil.getConnection();
			Statement state=conn.createStatement();
			String sql="update admin_supper set password='"+pwd+"' where name='"+name+"'";
			state.executeUpdate(sql);
			System.out.println("update");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			conn.close();
		}
		
	}
	/**
	 * 查看人员薪资
	 */
	/*public List<Supper> findSalary(){
		 Connection conn=null;
		 List<Supper> list=new ArrayList<Supper>();
		 Supper supper=null;
			try {
				conn=DBUtil.getConnection();
				String sql="select id,uname,department,salary from admin_supper order by salary desc";
				PreparedStatement ps=conn.prepareStatement(sql);
				ResultSet rs=ps.executeQuery();
				while(rs.next()){
					supper=new Supper();
					supper.setId(rs.getInt("id"));
					supper.setUname(rs.getString("uname"));
					supper.setDepartment(rs.getString("department"));
					supper.setSalary(rs.getDouble("salary"));
					list.add(supper);
				}
			} catch (SQLException e) {
				e.printStackTrace();
				throw new RuntimeException(e);
			}finally{
				DBUtil.close(conn);
			}
		return list;
	}*/
	/*public supper findUnameSalary(String uname){
		 Connection conn=null;
		// List<supper> list=new ArrayList<supper>();
		 supper supper=null;
			try {
				conn=DBUtil.getConnection();
				String sql="select id,uname,department,salary from admin_supper where uname=?";
				PreparedStatement ps=conn.prepareStatement(sql);
				ps.setString(1, uname);
				ResultSet rs=ps.executeQuery();
				while(rs.next()){
					supper=new supper();
					supper.setId(rs.getInt("id"));
					supper.setDepartment(rs.getString("department"));
					supper.setSalary(rs.getDouble("salary"));
					//list.add(supper);
				}
			} catch (SQLException e) {
				e.printStackTrace();
				throw new RuntimeException(e);
			}finally{
				DBUtil.close(conn);
			}
		return supper;
	}
	
	*/

	
}
