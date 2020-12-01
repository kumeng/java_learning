package scanerpac.service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import scanerpac.dao.JdbcDatasourceDAO;
import scanerpac.entity.person;

/**
 * 默认名 personService 现在服务名是serviceperson
 */
@Service("serviceperson")
public class PersonService {
	@Resource
	private person p1;

	@Autowired
	private JdbcDatasourceDAO dao;

	public void createperson() {
		String sql = "create table person(id number,name varchar2(50) ,age number ) ";
		try {
			PreparedStatement pt = dao.getConnection().prepareStatement(sql);
			if (pt.execute()) {
				pt.executeUpdate();
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void insertperson() {
		String sql = "insert into person values(1,'timi' ,20 ) ";
		try {
			PreparedStatement pt = dao.getConnection().prepareStatement(sql);
			if (pt.execute()) {
				pt.executeUpdate();
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void selctperson() {
		String sql = "select * from person ";
		try {
			PreparedStatement pt = dao.getConnection().prepareStatement(sql);
			ResultSet executeQuery = pt.executeQuery();

			if (executeQuery.next()) {
				if (p1 != null) {
					p1.setName(executeQuery.getString(2));
					p1.setAge(executeQuery.getInt(3));
					System.out.println(p1.toString());
				}
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
