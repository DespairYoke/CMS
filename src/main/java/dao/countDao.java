package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import entity.Count;
import entity.Rms;
import util.DBUtil;

public class countDao {
	

	public Count findCountByUname(String uname) {
		String time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
		Connection conn = null;
		Count count = null;
		try {
			conn = DBUtil.getConnection();
			String sql = "select * from admin_super where uname= ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, uname);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {

				count = new Count();
				count.setUname(rs.getString("uname"));
				count.setLasttime(rs.getString("lasttime"));
				count.setCount(rs.getInt("count"));
				
				System.out.println("上次登录时间为："+count.getLasttime());

				String sql2 = "update login_count set count=?,lasttime=? where uname= ?";
				PreparedStatement ps2 = conn.prepareStatement(sql2);
				int num = count.getCount();
				ps2.setInt(1, ++num);
				ps2.setString(2, time);
				ps2.setString(3, uname);
				ps2.executeUpdate();
				ResultSet rs2=ps2.executeQuery();
				if(rs2.next()){
					count.setUname(rs.getString("uname"));

					count.setLasttime(rs.getString("lasttime"));
					count.setCount(rs.getInt("count"));
					System.out.println("这是您第"+(count.getCount()+1)+"次登录");
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			DBUtil.close(conn);
		}
	
		return count;

	}

}
