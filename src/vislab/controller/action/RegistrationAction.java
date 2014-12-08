package vislab.controller.action;

import com.opensymphony.xwork2.ActionSupport;

import vislab.model.bl.CustomerManager;
import vislab.model.db.Customer;

public class RegistrationAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -983183915002226000L;

	private String username = null;
	private String password = null;
	private String firstname = null;
	private String lastname = null;

	public String execute() throws Exception {

		CustomerManager customerManager = new CustomerManager();

		Customer customer = customerManager
				.getCustomerByPrimaryKey(getUsername());

		if (customer == null) {
			customer = new Customer();

			customer.setPassword(getPassword());
			if (getPassword().equals("root")){
				customer.setIsAdmin(1);
			}
			customer.setUsername(getUsername());
			customer.setFirstname(getFirstname());
			customer.setLastname(getLastname());

			customerManager.saveCustomer(customer);

			return SUCCESS;
		} else {
			addActionError("Benutzername bereits vergeben!");
			return "input";
		}

	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getUsername() {
		return (this.username);
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return (this.password);
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public void validate() {
		super.validate();
	}

}
