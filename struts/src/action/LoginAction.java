package action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import domain.User;

public class LoginAction extends ActionSupport {
	// tip��user����request��Χ��
	private User user;
	private String tip;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
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
		if (user.getName().equals("pfjia") && user.getPass().equals("123")) {
			ActionContext.getContext().getSession().put("user", user.getName());
			setTip("ת���ɹ�");
			return SUCCESS;
		} else {
			setTip("ת��ʧ��");
			return ERROR;
		}
	}

}
