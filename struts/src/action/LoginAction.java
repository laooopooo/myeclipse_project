package action;

import com.opensymphony.xwork2.ActionSupport;

import domain.User;

public class LoginAction extends ActionSupport {
	// tip��user����request��Χ��
	private User user;
	private String tip;

	public String getTip() {
		return tip;
	}

	public void setTip(String tip) {
		this.tip = tip;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("����loginaction��execute����");
		System.out.println(user.getName());
		return SUCCESS;
	}
}
