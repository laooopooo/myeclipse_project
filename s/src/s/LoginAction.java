package s;

import java.util.Map;

import com.opensymphony.xwork2.Action;

public class LoginAction implements Action {
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
		System.out.println(getUsers());
		if (getUsers().get("one").getName().equals("jpf")
				&& getUsers().get("one").getPass().equals("123")) {
			setTip("µÇÂ¼³É¹¦");
			return SUCCESS;
		} else {
			setTip("µÇÂ¼Ê§°Ü");
			return ERROR;
		}
	}

}
