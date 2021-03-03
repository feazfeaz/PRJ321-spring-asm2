package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bean.UserModel;

public class UserDao extends JdbcForm implements IDao<UserModel> {

	public ArrayList<UserModel> getAll() {
		try {
			ArrayList<UserModel> users = new ArrayList<UserModel>();
			ResultSet resultSet = query("select * from betesterschema.user");
			
			while (resultSet.next()) {
				users.add(new UserModel(
						resultSet.getInt("idUser")
						,resultSet.getString("_username")
						,resultSet.getString("_password")
						,resultSet.getString("_mail")
						,resultSet.getInt("_role")
						));
			}
			endQuery();
			return users;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	public UserModel getById(int id) {
		try {
			//sql
			String sql = "select * from betesterschema.user where idUser = ?";
			//parameter
			ArrayList<Object> param = new ArrayList<Object>();
			param.add(id);
			//excute
			ResultSet resultSet = query(sql,param);
			if(resultSet.next()){
				return new UserModel(
						resultSet.getInt("idUser")
						,resultSet.getString("_username")
						,resultSet.getString("_password")
						,resultSet.getString("_mail")
						,resultSet.getInt("_role")
						);
			}	
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				endQuery();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		try {
			endQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public UserModel login(String username, String password){
		try {
			String sql = "select u.IdUser from betesterschema.user as u where _username = ? && _password = ?";
			ArrayList<Object> param = new ArrayList<Object>();
			param.add(username.trim());
			param.add(password.trim());
			
			ResultSet resultSet = query(sql,param);
			if(resultSet.next()){
				System.out.println(resultSet.getInt("idUser"));

				return getById(resultSet.getInt("idUser"));
			}		
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
//			System.out.println("vẵn có chạy nhé");
			try {
				endQuery();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return null;

	}

}
