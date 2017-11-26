package dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import java.util.List;

import entity.Emp;
import entity.Rms;
import util.DBUtil;

public class empDao {
	/**
	 * 保存新用户信息
	 */
		public void save(Emp emp) {
			Connection conn=null;
			try {
				conn=DBUtil.getConnection();
				String sql="insert into cms_emp values(cms_emp_seq.nextval,?,?,?,?,?,sysdate,?)";
				PreparedStatement ps=conn.prepareStatement(sql);
				ps.setString(1,emp.getUsername());
				ps.setString(2,emp.getName());
				ps.setString(3,emp.getDepartment());
				ps.setString(4,emp.getJob());
				ps.setString(5,emp.getStatus());
				ps.setString(6,emp.getPassword());
				ps.executeUpdate();
			}  catch (SQLException e1) {
				//步骤1.记日志(保留现场)
				e1.printStackTrace();
				/*
				 * 步骤2.看异常能否恢复.如果不能恢复,如数据库故障,网络中断称为系统异常,
				 * 要提示用户稍后重试.
				 * 如果能够恢复,则立即恢复
				 */
				throw new RuntimeException("保存员工信息失败,请重试", e1);
				} finally {
					DBUtil.close(conn);
				}
		}
		/**
		 * 查找所有员工信息的方法
		 */
		public List<Emp> findAll(){
			Connection conn=null;
			List<Emp> list=new ArrayList<Emp>();
			try {
				conn=DBUtil.getConnection();
				String sql="select id,username,name,department,job,status,hiredate,password,salary from cms_emp";
				PreparedStatement ps=conn.prepareStatement(sql);
				ResultSet rs=ps.executeQuery();
				while(rs.next()){
					Emp e=new Emp();
					e.setId(rs.getInt("id"));
					e.setUsername(rs.getString("username"));
					e.setName(rs.getString("name"));
					e.setDepartment(rs.getString("department"));
					e.setJob(rs.getString("job"));
					e.setStatus(rs.getString("status"));
					e.setHiredate(rs.getDate("hiredate"));
					e.setPassword(rs.getString("password"));
					e.setSalary(rs.getDouble("salary"));
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
		public Emp findById(int id){
			Connection conn=null;
			Emp e=null;
			try {
				//建立连接
				conn=DBUtil.getConnection();
				//数据库查询语句
				String sql="select id,username,name,department,job,salary,password from cms_emp where id=?";
				PreparedStatement ps=conn.prepareStatement(sql);
				ps.setInt(1,id);
				ResultSet rs=ps.executeQuery();
				while(rs.next()){
					e=new Emp();
					e.setId(id);
					e.setUsername(rs.getString("username"));
					e.setName(rs.getString("name"));
					e.setDepartment(rs.getString("department"));
					e.setJob(rs.getString("job"));
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
		public void update(Emp e){
			Connection conn=null;
			
			try {
				conn=DBUtil.getConnection();
			
				String sql="UPDATE cms_emp SET username=?,name=?,department=?,job=?,"
						+ "salary=?,password=?  where id=?";
				
				PreparedStatement ps=conn.prepareStatement(sql);
				ps.setString(1,e.getUsername());
				ps.setString(2,e.getName());
				ps.setString(3,e.getDepartment());
				ps.setString(4,e.getJob());
				ps.setDouble(5,e.getSalary());
				ps.setString(6, e.getPassword());
				ps.setInt(7,e.getId());
				ps.executeUpdate();
			}catch (SQLException e1) {
				e1.printStackTrace();
				throw new RuntimeException("修改员工信息失败,请重试", e1);
			}finally{
				DBUtil.close(conn);
			}
		}
		public List findByUserName(String username) {
			Connection conn=null;
	        List list=new ArrayList<Emp>();
			Emp emp=null;
			try {
				conn=DBUtil.getConnection();
				String sql="select * from cms_emp where name like ?";
				PreparedStatement ps=conn.prepareStatement(sql);
				ps.setString(1, '%'+username+'%');
				ResultSet rs=ps.executeQuery();
				while(rs.next()){
					
					emp=new Emp();
					emp.setId(rs.getInt("id"));
					emp.setUsername(rs.getString("username"));
					emp.setDepartment(rs.getString("name"));
					emp.setDepartment(rs.getString("department"));
					emp.setJob(rs.getString("job"));
					emp.setHiredate(rs.getDate("hiredate"));
					emp.setPassword(rs.getString("password"));
					emp.setSalary(rs.getDouble("salary"));
					list.add(emp);
				}
			} catch (SQLException e) {
				e.printStackTrace();
				throw new RuntimeException(e);
			}finally{
				DBUtil.close(conn);
			}
			return list;
		}
}
