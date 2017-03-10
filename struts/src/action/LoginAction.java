package action;

import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport {
	private String user;
	private String pass;

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		return SUCCESS;
	}
}
