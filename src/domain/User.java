package domain;

import java.sql.SQLException;

import DBUtils.UserDAO;

public class User {
	
	private String id;
	private String username;
	private String password;
	private String gander;
	
	public User() {
		super();
	}

	public User(String id, String username, String password, String gander) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.gander = gander;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
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

	public String getGander() {
		return gander;
	}

	public void setGander(String gander) {
		this.gander = gander;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((gander == null) ? 0 : gander.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (gander == null) {
			if (other.gander != null)
				return false;
		} else if (!gander.equals(other.gander))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", gander=" + gander + "]";
	}
	
	public static User isExist(User user) {
		return UserDAO.isExist(user);
	}

	public static User register(User user) {
		
		return UserDAO.register(user);

	}
	
	
	
	
	
}
