package action;

import java.util.Date;

import service.EmpManager;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ProcessPunchAction extends ActionSupport {
	private EmpManager empMgr;
	private String tip;

	public String getTip() {
		return tip;
	}

	public void setTip(String tip) {
		this.tip = tip;
	}

	public void setEmpMgr(EmpManager empMgr) {
		this.empMgr = empMgr;
	}

	// �����ϰ��
	public String come() throws Exception {
		return process(true);
	}

	// �����°��
	public String leave() throws Exception {
		return process(false);
	}

	private String process(boolean b) throws Exception {
		// TODO Auto-generated method stub
		ActionContext ctx = ActionContext.getContext();
		String user = (String) ctx.getSession().get(WebConstant.USER);
		System.out.println("---��---" + user);
		String dutyDay = new Date(System.currentTimeMillis()).toString();
		int result=empMgr.punch(user, dutyDay, isCome);
		
		switch(result){
		case pun
		}
	}
}
