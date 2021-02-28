package utils;

public class Users {
	
	public static Users instance = new Users();
	
	private Users(){}
	public static Users getInstance(){
		return instance;
	}
	
	public String adminName = "adminday";
	public String adminPass = "passadminday";
	
	public String userName = "userday";
	public String password = "passwordday";
	
}
