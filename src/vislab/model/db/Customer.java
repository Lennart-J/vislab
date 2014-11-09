package vislab.model.db;

// Generated 13.03.2008 13:06:16 by Hibernate Tools 3.2.0.CR1

/**
 * Customer generated by hbm2java
 */
public class Customer implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String username;
	private String password;
	private String lastname;
	private String firstname;

	public Customer() {
	}

	public Customer(String username) {
		this.username = username;
	}

	public Customer(String username, String password, String lastname,
			String firstname) {
		this.username = username;
		this.password = password;
		this.lastname = lastname;
		this.firstname = firstname;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getLastname() {
		return this.lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getFirstname() {
		return this.firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

}
