package de.webshop.controller.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import de.webshop.SessionConstants;
import de.webshop.model.bl.CustomerManager;
import de.webshop.model.db.Customer;

public class LoginAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -983183915002226000L;

	private String username = null;
	private String password = null;
	private String firstname = "";
	private String lastname = "";
	
	private HttpServletRequest request = (HttpServletRequest) ActionContext
			.getContext().get(ServletActionContext.HTTP_REQUEST);
	private HttpSession session = request.getSession();


	public String execute() throws Exception {

		/**
		 * hier ist die Schnittstelle zur Geschäftslogik Verarbeitung der
		 * eingegebenen Daten, z.B. Überprüfen der Zugangsdaten, holen der
		 * Userdaten
		 */

		CustomerManager customerManager = new CustomerManager();

		Customer customer = customerManager
				.getCustomerByPrimaryKey(getUsername());

		if (customer == null) {
			customer = new Customer();

			customer.setPassword(getPassword());
			customer.setUsername(getUsername());

			addActionError(getText("error.username.register"));
			return "registrieren";
		} else {
			if (customer.getPassword().equals(getPassword())) {
				setFirstname(customer.getFirstname());
				setLastname(customer.getLastname());
				
				session.setAttribute(SessionConstants.SESSION_ROLE, String.valueOf(customer.getIsAdmin()));
				return SUCCESS;
			} else {
				addActionError(getText("error.user.passwordforgotten"));
				addActionError("Bitte geben Sie das richtige Passwort ein!");
				return "input";
			}
		}

	}

	public String getLastname() {
		return lastname;
	}

	private void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getFirstname() {
		return firstname;
	}

	private void setFirstname(String firstname) {
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
