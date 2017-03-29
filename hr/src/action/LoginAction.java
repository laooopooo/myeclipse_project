package action;

import service.EmpManager;
import action.base.EmpBaseAction;

import com.opensymphony.xwork2.ActionContext;

import domain.Manager;

public class LoginAction extends EmpBaseAction {
	// 员工登录成功result名
	private final String EMP_RESULT = "emp";
	// 经理登录成功result名
	private final String MGR_RESULT = "mgr";

	private Manager manager;

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

	// 处理登录请求
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		// 使用ActionContext访问servlet API
		ActionContext ctx = ActionContext.getContext();

		// 尚未实现验证码功能
		String[] vercodes = (String[]) ctx.getParameters().get("vercode");
		String ver2 = (String) vercodes[0];

		// 验证码输入正确
		if (vercode.equalsIgnoreCase(ver2)) {
			int result = mgr.validLogin(getManager());

			// 普通员工登录
			if (result == EmpManager.LOGIN_EMP) {
				ctx.getSession().put(WebConstant.USER, manager.getName());
				ctx.getSession().put(WebConstant.LEVEL, WebConstant.EMP_LEVEL);
				setTip("您已经成功登录系统");
				return EMP_RESULT;
			}

			// 经理登录
			else if (result == EmpManager.LOGIN_MGR) {
				ctx.getSession().put(WebConstant.USER, manager.getName());
				ctx.getSession().put(WebConstant.LEVEL, WebConstant.MGR_LEVEL);
				setTip("您已经成功登录系统");
				return MGR_RESULT;
			}

			// 登录失败
			else {
				setTip("登录失败");
				return ERROR;
			}
		}

		// 验证码不匹配
		else {
			setTip("验证码不匹配，请重新输入");
			return ERROR;
		}
	}
}
