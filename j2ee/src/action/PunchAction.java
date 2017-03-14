package action;

import java.text.SimpleDateFormat;
import java.util.Date;

import action.base.EmpBaseAction;

import com.opensymphony.xwork2.ActionContext;

public class PunchAction extends EmpBaseAction {
	private int punchIsVaild;

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		ActionContext ctx = ActionContext.getContext();
		String user = (String) ctx.getSession().get(WebConstant.USER);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String dutyDay = sdf.format(new Date());
		int result = mgr.validPunch(user, dutyDay);
		setPunchIsVaild(result);
		return SUCCESS;
	}

	public int getPunchIsVaild() {
		return punchIsVaild;
	}

	public void setPunchIsVaild(int punchIsVaild) {
		this.punchIsVaild = punchIsVaild;
	}

}
