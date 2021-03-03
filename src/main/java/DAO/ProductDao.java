package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bean.ProductModel;
import bean.UserModel;

public class ProductDao extends JdbcForm implements IDao<ProductModel> {

	public ArrayList<ProductModel> getAll() {
		try {
			ArrayList<ProductModel> productModels = new ArrayList<ProductModel>();
			ResultSet resultSet = query("select * from betesterschema.product");
			while (resultSet.next()) {
				productModels.add(new ProductModel(
						resultSet.getInt("idProd")
						,resultSet.getString("_nameItem")
						,resultSet.getInt("_price")
						,resultSet.getString("_description")));
			}
			endQuery();
			return productModels;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		}
	}

	public ProductModel getById(int id) {
		try {
			//sql
			String sql = "select * from betesterschema.product where idProd = ?";
			//parameter
			ArrayList<Object> param = new ArrayList<Object>();
			param.add(id);
			//excute
			ResultSet resultSet = query(sql,param);
			if(resultSet.next()){
				return new ProductModel(
						resultSet.getInt("idProd")
						,resultSet.getString("_nameItem")
						,resultSet.getInt("_price")
						,resultSet.getString("_description"));
			}	
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
//				System.out.println("có close nhé");
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
	
	public ArrayList<String> getNames(){
		String sql = "select _nameItem from betesterschema.product ";
		ArrayList<String> names = new ArrayList<String>();
		try {
			ResultSet resultSet = query(sql);
			while (resultSet.next()) names.add(resultSet.getString("_nameItem"));
			return names;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				endQuery();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;

	}

}
