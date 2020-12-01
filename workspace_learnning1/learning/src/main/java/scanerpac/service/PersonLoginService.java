package scanerpac.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;

import scanerpac.ServiceInterface.PersonLogin;
import scanerpac.dao.JdbcDatasourceDAO;

@Service
public class PersonLoginService implements PersonLogin {

	@Resource
	private JdbcDatasourceDAO jdbcDatasourceDAO;

	/**
	 * 1 成功 ，其他表示失败
	 */
	public Integer dologin(String name, String pwd) {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement pst = null;
		ResultSet result = null;
		try {
			connection = jdbcDatasourceDAO.getConnection();
			String sql = "select count(1) from basic_account where loginname =? and pwd=? ";
			pst = connection.prepareStatement(sql);
			pst.setString(1, name);
			pst.setString(2, pwd);
			result = pst.executeQuery();
			if (result.next()) {
				return result.getInt(1);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			jdbcDatasourceDAO.colseConnection(connection);
			if (pst != null) {
				try {
					pst.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (result != null) {
				try {
					result.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		return 0;
	}

	public boolean Register(String name, String pwd) {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement pst = null;
		try {
			connection = jdbcDatasourceDAO.getConnection();
			String sql = "insert into  basic_account values (2,?,?) ";
			pst = connection.prepareStatement(sql);
			pst.setString(1, name);
			pst.setString(2, pwd);
			return pst.execute();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			jdbcDatasourceDAO.colseConnection(connection);
			if (pst != null) {
				try {
					pst.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}
		return false;
	}

}
