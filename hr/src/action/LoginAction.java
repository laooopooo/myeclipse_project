package action;

import service.EmpManager;
import action.base.EmpBaseAction;

import com.opensymphony.xwork2.ActionContext;

import domain.Manager;

public class LoginAction extends EmpBaseAction {
	// Ա����¼�ɹ�result��
	private final String EMP_RESULT = "emp";
	// �����¼�ɹ�result��
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

	// �����¼����
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		// ʹ��ActionContext����servlet API
		ActionContext ctx = ActionContext.getContext();

		// ��δʵ����֤�빦��
		String[] vercodes = (String[]) ctx.getParameters().get("vercode");
		String ver2 = (String) vercodes[0];

		// ��֤��������ȷ
		if (vercode.equalsIgnoreCase(ver2)) {
			int result = mgr.validLogin(getManager());

			// ��ͨԱ����¼
			if (result == EmpManager.LOGIN_EMP) {
				ctx.getSession().put(WebConstant.USER, manager.getName());
				ctx.getSession().put(WebConstant.LEVEL, WebConstant.EMP_LEVEL);
				setTip("���Ѿ��ɹ���¼ϵͳ");
				return EMP_RESULT;
			}

			// �����¼
			else if (result == EmpManager.LOGIN_MGR) {
				ctx.getSession().put(WebConstant.USER, manager.getName());
				ctx.getSession().put(WebConstant.LEVEL, WebConstant.MGR_LEVEL);
				setTip("���Ѿ��ɹ���¼ϵͳ");
				return MGR_RESULT;
			}

			// ��¼ʧ��
			else {
				setTip("��¼ʧ��");
				return ERROR;
			}
		}

		// ��֤�벻ƥ��
		else {
			setTip("��֤�벻ƥ�䣬����������");
			return ERROR;
		}
	}
}
