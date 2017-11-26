package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import util.DBUtil;
import entity.Emp;
import entity.Rms;

public class rmsDao {
	
	public void save(Rms rms){
		Connection conn=null;
		
		try {
			conn=DBUtil.getConnection();
			String sql="INSERT INTO admin_rms VALUES(seq_admin_rms.nextval,?,?,?,?,?,?,?,?)";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, rms.getUname());
			ps.setString(2, rms.getName());
			ps.setString(3, rms.getDepartment());
			ps.setInt(4, rms.getAge());
			ps.setString(5, rms.getGender());
			ps.setString(6, rms.getPassword());
			ps.setDate(7, rms.getRegistDate());
			ps.setDouble(8,rms.getSalary());
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.close(conn);
		}
	}
	
	
	
	public List<Rms> findRms() {
		Connection conn=null;
		List<Rms> list=new ArrayList<Rms>();
		String sql="select name,password from admin_rms";
		try {
			conn=DBUtil.getConnection();
			Statement state=conn.createStatement();
			ResultSet rs=state.executeQuery(sql);
			while(rs.next())
			{
				list.add(new Rms(rs.getString(1),rs.getString(2)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("查询管理员失败,请重试", e);
		}
		return list;
	}
	
	
	
	public List findByUserName(String uname){
        Connection conn=null;
        List list=new ArrayList<Rms>();
		Rms rms=null;
		try {
			conn=DBUtil.getConnection();
			String sql="select * from admin_rms where uname like ?";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, '%'+uname+'%');
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				
				rms=new Rms();
				rms.setId(rs.getInt("id"));
				rms.setUname(rs.getString("uname"));
				rms.setName(rs.getString("name"));
				rms.setPassword(rs.getString("password"));
				rms.setGender(rs.getString("gender"));
				rms.setAge(rs.getInt("age"));
				rms.setDepartment(rs.getString("department"));
				rms.setRegistDate(rs.getDate("registdate"));
				rms.setSalary(rs.getDouble("salary"));
				list.add(rms);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally{
			DBUtil.close(conn);
		}
		return list;
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
	public List<Rms> findSalary(){
		 Connection conn=null;
		 List<Rms> list=new ArrayList<Rms>();
		 Rms rms=null;
			try {
				conn=DBUtil.getConnection();
				String sql="select id,uname,department,salary from admin_rms order by salary desc";
				PreparedStatement ps=conn.prepareStatement(sql);
				ResultSet rs=ps.executeQuery();
				while(rs.next()){
					rms=new Rms();
					rms.setId(rs.getInt("id"));
					rms.setUname(rs.getString("uname"));
					rms.setDepartment(rs.getString("department"));
					rms.setSalary(rs.getDouble("salary"));
					list.add(rms);
				}
			} catch (SQLException e) {
				e.printStackTrace();
				throw new RuntimeException(e);
			}finally{
				DBUtil.close(conn);
			}
		return list;
	}
	/*public Rms findUnameSalary(String uname){
		 Connection conn=null;
		// List<Rms> list=new ArrayList<Rms>();
		 Rms rms=null;
			try {
				conn=DBUtil.getConnection();
				String sql="select id,uname,department,salary from admin_rms where uname=?";
				PreparedStatement ps=conn.prepareStatement(sql);
				ps.setString(1, uname);
				ResultSet rs=ps.executeQuery();
				while(rs.next()){
					rms=new Rms();
					rms.setId(rs.getInt("id"));
					rms.setDepartment(rs.getString("department"));
					rms.setSalary(rs.getDouble("salary"));
					//list.add(rms);
				}
			} catch (SQLException e) {
				e.printStackTrace();
				throw new RuntimeException(e);
			}finally{
				DBUtil.close(conn);
			}
		return rms;
	}
	
	*/

/**
 * 查找所有员工信息的方法
 */
public List<Rms> findAll(){
	Connection conn=null;
	List<Rms> list=new ArrayList<Rms>();
	try {
		conn=DBUtil.getConnection();
		System.out.println("findAll()");
		String sql="select id,uname,name,department,registdate,password,salary from admin_rms";
		PreparedStatement ps=conn.prepareStatement(sql);
		ResultSet rs=ps.executeQuery();
		while(rs.next()){
			
			Rms e=new Rms();
			e.setId(rs.getInt("id"));
			e.setUname(rs.getString("uname"));
			e.setName(rs.getString("name"));
			e.setDepartment(rs.getString("department"));
			e.setRegistDate(rs.getDate("registdate"));
			e.setPassword(rs.getString("password"));
			e.setSalary(rs.getDouble("salary"));
			System.out.println(e);
			list.add(e);
		}
		
	} catch (SQLException e1) {
		//步骤1.记日志(保留现场)
		e1.printStackTrace();
		/*
		 * 步骤2.看异常能否恢复.如果不能恢复,如数据库故障,网络中断称为系统异常,
		 * 要提示用户稍后重试.
		 * 如果能够恢复,则立即恢复
		 */
		throw new RuntimeException("查询员工信息失败,请重试", e1);
		} finally {
			DBUtil.close(conn);
		}
	return list;
	
}
/**
 * 删除员工的方法
 */
public void delete(int id){
	Connection conn=null;

	try {
		
		conn=DBUtil.getConnection();
		String sql="delete from  cms_emp where id=?";
		PreparedStatement ps=conn.prepareStatement(sql);
		ps.setInt(1,id);
		ps.executeUpdate();
		
	} catch (SQLException e1) {
		e1.printStackTrace();
		throw new RuntimeException("删除员工信息失败,请重试", e1);
	}finally{
		DBUtil.close(conn);
	}
}
/**
 * 修改员工信息方法
 */
public Rms findById(int id){
	Connection conn=null;
	Rms e=null;
	try {
		//建立连接
		conn=DBUtil.getConnection();
		//数据库查询语句
		String sql="select id,uname,name,department,salary,password from admin_rms where id=?";
		PreparedStatement ps=conn.prepareStatement(sql);
		ps.setInt(1,id);
		ResultSet rs=ps.executeQuery();
		while(rs.next()){
			e=new Rms();
			e.setId(id);
			e.setUname(rs.getString("uname"));
			e.setName(rs.getString("name"));
			e.setDepartment(rs.getString("department"));
			e.setSalary(Double.parseDouble(rs.getString("salary")));
			e.setPassword(rs.getString("password"));
		}
	} catch (SQLException e1) {
		e1.printStackTrace();
		throw new RuntimeException("修改员工信息失败,请重试", e1);
	}finally{
		DBUtil.close(conn);
	}
	return e;
}
/**
 * 更新员工信息方法
 */
public void update(Rms e){
	Connection conn=null;
	
	try {
		conn=DBUtil.getConnection();
	
		String sql="UPDATE admin_rms SET uname=?,name=?,department=?,salary=?,"
				+ "password=?  where id=?";
		
		PreparedStatement ps=conn.prepareStatement(sql);
		ps.setString(1,e.getUname());
		ps.setString(2,e.getName());
		ps.setString(3,e.getDepartment());
		ps.setDouble(4,e.getSalary());
		ps.setString(5, e.getPassword());
		ps.setInt(6,e.getId());
		ps.executeUpdate();
	}catch (SQLException e1) {
		e1.printStackTrace();
		throw new RuntimeException("修改员工信息失败,请重试", e1);
	}finally{
		DBUtil.close(conn);
	}
}
}
