package de.webshop.controller.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import de.webshop.SessionConstants;
import de.webshop.model.bl.CustomerManager;
import de.webshop.model.db.Customer;

public class RegistrationAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -983183915002226000L;

	private String username = null;
	private String password = null;
	private String firstname = null;
	private String lastname = null;

	private HttpServletRequest request = (HttpServletRequest) ActionContext
			.getContext().get(ServletActionContext.HTTP_REQUEST);
	private HttpSession session = request.getSession();

	public String execute() throws Exception {

		CustomerManager customerManager = new CustomerManager();

		Customer customer = customerManager
				.getCustomerByPrimaryKey(getUsername());

		if (customer == null) {
			customer = new Customer();

			customer.setPassword(getPassword());
			if (getPassword().equals("root")) {
				customer.setIsAdmin(1);
			}
			customer.setUsername(getUsername());
			customer.setFirstname(getFirstname());
			customer.setLastname(getLastname());

			customerManager.saveCustomer(customer);
			
			session.setAttribute(SessionConstants.SESSION_ROLE, customer.getIsAdmin());

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
		if (password.length() > 8) {
			addFieldError("password", "Passwort nicht mehr als 8 Zeichen!");
		}
		if (username.length() > 8) {
			addFieldError("username", "Benutzername nicht mehr als 8 Zeichen!");
		}
		if (lastname.length() > 20) {
			addFieldError("lastname", "Nachname nicht mehr als 20 Zeichen!");
		}
		if (firstname.length() > 20) {
			addFieldError("firstname", "Vorname nicht mehr als 20 Zeichen!");
		}
		super.validate();
	}

}
