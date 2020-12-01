package scanerpac.dao;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

@Scope("singleton") // 默认是singleton 单例 prototype 多例 原型
@Repository
public class JdbcDatasourceDAO {
	@Value("#{jdbcproperties.driver}")
	private String driver;
	@Value("#{jdbcproperties.url}")
	private String url;
	@Value("#{jdbcproperties.username}")
	private String username;
	@Value("#{jdbcproperties.password}")
	private String pwd;

	public Connection getConnection() throws SQLException, ClassNotFoundException {
		Class.forName(driver);
		Connection connection = DriverManager.getConnection(url, username, pwd);
		return connection;
	}

	public void colseConnection(Connection connection) {
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getDriver() {
		return driver;
	}

	public void setDriver(String driver) {
		this.driver = driver;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
}
