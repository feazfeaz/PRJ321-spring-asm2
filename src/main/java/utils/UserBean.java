package utils;

public class UserBean {

	private String username;
	private String password;
	
	public UserBean(){
		System.out.println(this.getClass().getName() + " contructor....");
	}
	
	public String getUsername() {
		return username == null ? "" : username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password == null ? "" : password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	//// class này vứt
	
}
