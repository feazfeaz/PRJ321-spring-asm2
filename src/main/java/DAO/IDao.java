package DAO;

import java.util.ArrayList;

public interface IDao<T> {
	public ArrayList<T> getAll();
	public T getById(int id);
}
