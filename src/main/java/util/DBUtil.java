package util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.commons.dbcp.BasicDataSource;

public class DBUtil {
	
	private static BasicDataSource ds;
	
	static {
		Properties p = new Properties();
		try {
			//读取参数
			p.load(DBUtil.class.getClassLoader()
				.getResourceAsStream("db.properties"));
			String driver = p.getProperty("driver");
			String url = p.getProperty("url");
			String user = p.getProperty("user");
			String pwd = p.getProperty("pwd");
			String initsize = p.getProperty("init_size");
			String maxsize = p.getProperty("max_size");
			//创建连接池
			ds = new BasicDataSource();
			//设置参数
			ds.setDriverClassName(driver);
			ds.setUrl(url);
			ds.setUsername(user);
			ds.setPassword(pwd);
			ds.setInitialSize(new Integer(initsize));
			ds.setMaxActive(new Integer(maxsize));
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException(
				"加载配置文件失败.", e);
		}
	}
	
	/**
	 * 本方法是采用BasicDataSource创建的连接,
	 * 则Connection接口是由DBCP实现的,而并非
	 * 由Oracle实现.当然DBCP的实现类中会调用
	 * Oracle的驱动类.
	 */
	public static Connection getConnection() 
		throws SQLException {
		return ds.getConnection();
	}
	
	/**
	 * 由DBCP所提供的连接对象的实现类,
	 * 其close方法的逻辑不是关闭连接,
	 * 而是归还连接,即它会将连接内包含的
	 * 数据清空,并且将连接的状态设置为空闲.
	 * */
	public static void close(Connection conn) {
		if(conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
				throw new RuntimeException(
					"关闭连接失败.", e);
			}
		}
	}

}






