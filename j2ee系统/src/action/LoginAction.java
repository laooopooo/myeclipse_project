package action;

import service.EmpManager;
import action.base.EmpBaseAction;

import com.opensymphony.xwork2.ActionContext;

import domain.Manager;

public class LoginAction extends EmpBaseAction {
	private final static String EMP_RESULT = "emp";
	private final static String MGR_RESULT = "mgr";
	private Manager manager;
	// 登录的验证码
	private String vercode;
	private String tip;

	public Manager getManager() {
		return manager;
	}

	public void setManager(Manager manager) {
		this.manager = manager;
	}

	public String getVercode() {
		return vercode;
	}

	public void setVercode(String vercode) {
		this.vercode = vercode;
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
		ActionContext ctx = ActionContext.getContext();
		String ver2 = (String) ctx.getSession().get("rand");
		if (vercode.equalsIgnoreCase(ver2)) {
			int result = mgr.validLogin(getManager());

			// 登录结果为普通员工
			if (result == EmpManager.LOGIN_EMP) {
				ctx.getSession().put(WebConstant.USER, manager.getName());
				ctx.getSession().put(WebConstant.LEVEL, WebConstant.EMP_LEVEL);
				setTip("您已经成功登录系统");
				return EMP_RESULT;
			}
			// 登录结果为经理
			else if (result == EmpManager.LOGIN_MGR) {
				ctx.getSession().put(WebConstant.USER, manager.getName());
				ctx.getSession().put(WebConstant.LEVEL, WebConstant.EMP_LEVEL);
				setTip("您已经成功登录系统");
				return MGR_RESULT;
			}
			// 用户名与密码不匹配
			else {
				setTip("用户名/密码不匹配");
			}
		}
		// 验证码不匹配
		else {
			setTip("验证码不匹配，请重新输入");
			return ERROR;
		}
		return null;

	}
}
