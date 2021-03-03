package bean;

public class UserModel extends Model {
	int role;
	String username, password, name;

	public UserModel() {
	}

	public UserModel(int id, String username, String password, String name, int role) {
		this.username = username;
		this.password = password;
		this.name = name;
		this.id = id;
		this.role = role;
	}

	public UserModel(String username, String password, String name) {
		this.username = username;
		this.password = password;
		this.name = name;
//		this.id = null;
//		this.role = null;
	}

	public int getRole() {
		return role;
	}

	public void setRole(int role) {
		this.role = role;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
