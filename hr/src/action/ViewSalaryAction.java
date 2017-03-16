package action;

import java.util.List;

import vo.PaymentBean;
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

public class ViewSalaryAction extends EmpBaseAction {
	// ��װ���з�н��Ϣ��List
	private List salarys;

	// salarys���Ե�setter��getter����
	public void setSalarys(List salarys) {
		this.salarys = salarys;
	}

	public List getSalarys() {
		return this.salarys;
	}

	// �����û�����ķ���
	public String execute() throws Exception {
		// ����ActionContextʵ��
		ActionContext ctx = ActionContext.getContext();
		// ��ȡHttpSession�е�user����
		String user = (String) ctx.getSession().get(WebConstant.USER);
		List<PaymentBean> salarys = mgr.empSalary(user);
		setSalarys(salarys);
		return SUCCESS;
	}
}