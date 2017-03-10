package service;

import java.util.List;

import vo.AppBean;
import vo.EmpBean;
import vo.SalaryBean;
import domain.Employee;
import exception.HrException;

public interface MgrManager {

	/**
	 * 为一个部门增加一个员工
	 * 
	 * @param emp
	 * @param mgr
	 * @throws HrException
	 */
	void addEmp(Employee emp, String mgr) throws HrException;

	List<SalaryBean> getSalaryByMgr(String mgr) throws HrException;

	/**
	 * 根据经理名活动该部门所有的员工
	 * 
	 * @param mgr
	 * @return
	 * @throws HrException
	 */
	List<EmpBean> getEmpsByMgr(String mgr) throws HrException;

	/**
	 * 根据经理名返回该部门的所有没有批复的申请
	 * 
	 * @param mgr
	 *            经理名
	 * @return
	 * @throws HrException
	 */
	List<AppBean> getAppsByMgr(String mgr) throws HrException;

	void check(int appid, String mgrName, boolean checkResult);
}
