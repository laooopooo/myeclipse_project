package action.base;

import org.springframework.web.struts.ActionSupport;

import service.EmpManager;

public class EmpBaseAction extends ActionSupport {
	protected EmpManager mgr;

	public void setEmpManager(EmpManager mgr) {
		this.mgr = mgr;
	}

}
