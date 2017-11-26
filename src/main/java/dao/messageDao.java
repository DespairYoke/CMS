package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.management.RuntimeErrorException;

import entity.Message;
import util.DBUtil;

public class messageDao {
	public List<Message> findAll(){
		List<Message>list =new  ArrayList<Message>();
		Connection conn =null;
		try {
		    conn = DBUtil.getConnection();
			String sql  = "SELECT * FROM message";
			SimpleDateFormat sdf =  new SimpleDateFormat("yyyy-MM-dd");
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			
			while(rs.next()){
			
				Message m = new Message();
				m.setId(rs.getInt("id"));
				m.setUname(rs.getString("uname"));
				m.setTitle(rs.getString("title"));
				m.setEmail(rs.getString("email"));
				m.setMestime(rs.getDate("mestime"));
				m.setContent(rs.getString("content"));
				list.add(m);
				
				
			}
		} catch (SQLException e) {
		
			e.printStackTrace();
		}finally{
			DBUtil.close(conn);
		}
		
		
		
		return list;
		
	}
	
	public void delect(int id){
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			String sql = "delete  FROM message WHERE id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
		System.out.println(1);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally{
			DBUtil.close(conn);
		}
		
		
	}
	public Message findById(int id){
			Message m =new Message();
		Connection conn =null;
		try {
		    conn = DBUtil.getConnection();
			String sql  = "SELECT * FROM message WHERE id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				m.setId(rs.getInt("id"));
				m.setUname(rs.getString("uname"));
				m.setTitle(rs.getString("title"));
				m.setEmail(rs.getString("email"));
				m.setMestime(rs.getDate("mestime"));
				m.setContent(rs.getString("content"));	
			}
		} catch (SQLException e) {
		
			e.printStackTrace();
		}finally{
			DBUtil.close(conn);
		}
		return m;
		
	}

	public void addMsg(Message msg) throws SQLException {
		// TODO Auto-generated method stub
		Connection conn=null;
		String sql="insert into message(id,title,email,content,mestime,uname)values(msg_seq.nextval,?,?,?,?,?)";
		try {
			conn=DBUtil.getConnection();
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1,msg.getTitle());
			ps.setString(2,msg.getEmail());
			ps.setString(3, msg.getContent());
			try {
				ps.setDate(4, msg.getMestime());
				ps.setString(5,msg.getUname());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			ps.executeUpdate();
		
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			conn.close();
		}
	}
	
}
