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

	// 使用spring的依赖注入注入Dao层组件
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
	 *            传入的manager中其实只有姓名和密码，是由用户输入的
	 * @return LOGIN_FAIL 登录失败 LOGIN_EMP 员工登录 LOGIN_MGR 经理登录
	 *         上面三个常量在EmpManager中配置
	 */
	@Override
	public int validLogin(Manager manager) {
		// TODO Auto-generated method stub
		if (mgrDao.findByNameAndPass(manager)) {

		}
		return 0;
	}

}
