package service.impl;

import service.EmpManager;
import dao.ApplicationDao;
import dao.AttendDao;
import dao.AttendTypeDao;
import dao.CheckBackDao;
import dao.EmployeeDao;
import dao.ManagerDao;
import dao.PaymentDao;
import domain.Manager;

public class EmpManagerImpl implements EmpManager {

	// ʹ��spring������ע��ע��Dao�����
	private ApplicationDao appDao;
	private AttendDao attendDao;
	private AttendTypeDao typeDao;
	private CheckBackDao checkDao;
	private EmployeeDao empDao;
	private ManagerDao mgrDao;

	private PaymentDao payDao;

	public void setAppDao(ApplicationDao appDao) {
		this.appDao = appDao;
	}

	public void setAttendDao(AttendDao attendDao) {
		this.attendDao = attendDao;
	}

	public void setTypeDao(AttendTypeDao typeDao) {
		this.typeDao = typeDao;
	}

	public void setCheckDao(CheckBackDao checkDao) {
		this.checkDao = checkDao;
	}

	public void setEmpDao(EmployeeDao empDao) {
		this.empDao = empDao;
	}

	public void setMgrDao(ManagerDao mgrDao) {
		this.mgrDao = mgrDao;
	}

	public void setPayDao(PaymentDao payDao) {
		this.payDao = payDao;
	}

	/**
	 * 
	 * @param manager
	 *            �����manager����ʵֻ�����������룬�����û������
	 * @return LOGIN_FAIL ��¼ʧ�� LOGIN_EMP Ա����¼ LOGIN_MGR �����¼
	 *         ��������������EmpManager������
	 */
	@Override
	public int validLogin(Manager manager) {
		// TODO Auto-generated method stub
		if (mgrDao.findByNameAndPass(manager)) {

		}
		return 0;
	}

}
