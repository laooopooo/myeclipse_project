package action;

import service.EmpManager;
import action.base.EmpBaseAction;

import com.opensymphony.xwork2.ActionContext;

import domain.Manager;

public class LoginAction extends EmpBaseAction {
	private final static String EMP_RESULT = "emp";
	private final static String MGR_RESULT = "mgr";
	private Manager manager;
	// ��¼����֤��
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

			// ��¼���Ϊ��ͨԱ��
			if (result == EmpManager.LOGIN_EMP) {
				ctx.getSession().put(WebConstant.USER, manager.getName());
				ctx.getSession().put(WebConstant.LEVEL, WebConstant.EMP_LEVEL);
				setTip("���Ѿ��ɹ���¼ϵͳ");
				return EMP_RESULT;
			}
			// ��¼���Ϊ����
			else if (result == EmpManager.LOGIN_MGR) {
				ctx.getSession().put(WebConstant.USER, manager.getName());
				ctx.getSession().put(WebConstant.LEVEL, WebConstant.EMP_LEVEL);
				setTip("���Ѿ��ɹ���¼ϵͳ");
				return MGR_RESULT;
			}
			// �û��������벻ƥ��
			else {
				setTip("�û���/���벻ƥ��");
			}
		}
		// ��֤�벻ƥ��
		else {
			setTip("��֤�벻ƥ�䣬����������");
			return ERROR;
		}
		return null;

	}
}
