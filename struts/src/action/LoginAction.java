package action;

import java.util.Map;

import com.opensymphony.xwork2.ActionSupport;

import domain.User;

public class LoginAction extends ActionSupport {
	private Map<String, User> users;
	private String tip;

	public Map<String, User> getUsers() {
		return users;
	}

	public void setUsers(Map<String, User> users) {
		this.users = users;
	}

	public String getTip() {
		return tip;
	}

	public void setTip(String tip) {
		this.tip = tip;
	}

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		System.out.println(users);
		if (users.get("one").getName().equals("pfjia")
				&& users.get("one").getPass().equals("123")) {
			setTip("µÇÂ¼³É¹¦");
			return SUCCESS;
		} else {
			setTip("µÇÂ¼Ê§°Ü");
			return ERROR;
		}
	}

}
