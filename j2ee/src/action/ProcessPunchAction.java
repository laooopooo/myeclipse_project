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

	// 处理上班打卡
	public String come() throws Exception {
		return process(true);
	}

	// 处理下班打卡
	public String leave() throws Exception {
		return process(false);
	}

	private String process(boolean b) throws Exception {
		// TODO Auto-generated method stub
		ActionContext ctx = ActionContext.getContext();
		String user = (String) ctx.getSession().get(WebConstant.USER);
		System.out.println("---打卡---" + user);
		String dutyDay = new Date(System.currentTimeMillis()).toString();
		int result=empMgr.punch(user, dutyDay, isCome);
		
		switch(result){
		case pun
		}
	}
}
