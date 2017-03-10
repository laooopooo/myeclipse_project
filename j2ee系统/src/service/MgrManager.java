package service;

import java.util.List;

import vo.AppBean;
import vo.EmpBean;
import vo.SalaryBean;
import domain.Employee;
import exception.HrException;

public interface MgrManager {

	/**
	 * Ϊһ����������һ��Ա��
	 * 
	 * @param emp
	 * @param mgr
	 * @throws HrException
	 */
	void addEmp(Employee emp, String mgr) throws HrException;

	List<SalaryBean> getSalaryByMgr(String mgr) throws HrException;

	/**
	 * ���ݾ�������ò������е�Ա��
	 * 
	 * @param mgr
	 * @return
	 * @throws HrException
	 */
	List<EmpBean> getEmpsByMgr(String mgr) throws HrException;

	/**
	 * ���ݾ��������ظò��ŵ�����û������������
	 * 
	 * @param mgr
	 *            ������
	 * @return
	 * @throws HrException
	 */
	List<AppBean> getAppsByMgr(String mgr) throws HrException;

	void check(int appid, String mgrName, boolean checkResult);
}
