package action;

import java.text.SimpleDateFormat;
import java.util.Date;

import action.base.EmpBaseAction;

import com.opensymphony.xwork2.ActionContext;

/**
 * Description: <br/>
 * ��վ: <a href="http://www.crazyit.org">���Java����</a> <br/>
 * Copyright (C), 2001-2012, Yeeku.H.Lee <br/>
 * This program is protected by copyright laws. <br/>
 * Program Name: <br/>
 * Date:
 * 
 * @author Yeeku.H.Lee kongyeeku@163.com
 * @version 1.0
 */
public class PunchAction extends EmpBaseAction {
	// ��װ��������punchIsValid����
	private int punchIsValid;

	// punchIsValid���Ե�setter��getter����
	public void setPunchIsValid(int punchIsValid) {
		this.punchIsValid = punchIsValid;
	}

	public int getPunchIsValid() {
		return this.punchIsValid;
	}

	public String execute() throws Exception {
		// ����ActionContextʵ��
		ActionContext ctx = ActionContext.getContext();
		// ��ȡHttpSession�е�user����
		String user = (String) ctx.getSession().get(WebConstant.USER);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		// ��ʽ����ǰʱ��
		String dutyDay = sdf.format(new Date());
		// ����ҵ���߼����������û�����
		int result = mgr.validPunch(user, dutyDay);
		setPunchIsValid(result);
		return SUCCESS;
	}
}