package service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import service.MgrManager;
import vo.AppBean;
import vo.EmpBean;
import vo.SalaryBean;
import dao.ApplicationDao;
import dao.AttendDao;
import dao.AttendTypeDao;
import dao.CheckBackDao;
import dao.EmployeeDao;
import dao.ManagerDao;
import dao.PaymentDao;
import domain.Application;
import domain.Attend;
import domain.CheckBack;
import domain.Employee;
import domain.Manager;
import domain.Payment;
import exception.HrException;

public class MgrManagerImpl implements MgrManager {
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

	@Override
	public void addEmp(Employee emp, String mgr) throws HrException {
		// TODO Auto-generated method stub
		Manager m = mgrDao.findByName(mgr);
		if (m == null) {
			throw new HrException("新增员工的业务异常");
		}
		emp.setManager(m);
		empDao.save(m);
	}

	/**
	 * 根据经理名返回所在部门所有人的总工资，为什么要有这个方法，给谁用？难道是评最佳部门，最佳部门不应该是求平均吗？
	 */
	@Override
	public List<SalaryBean> getSalaryByMgr(String mgr) throws HrException {
		// TODO Auto-generated method stub
		Manager m = mgrDao.findByName(mgr);
		if (m == null) {
			throw new HrException("你他丫的是经理吗？？？？");
		}
		List<Employee> emps = empDao.findByManager(m);
		if (emps == null || emps.size() < 1) {
			throw new HrException("一个经理，管辖的部门竟然一个员工都没有！！！瓜皮");
		}
		Calendar c = Calendar.getInstance();
		c.add(Calendar.MONTH, -1);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
		String payMonth = sdf.format(c.getTime());
		List<SalaryBean> result = new ArrayList<SalaryBean>();
		for (Employee e : emps) {
			Payment p = payDao.findByMonthAndEmp(payMonth, e);
			if (p != null) {
				result.add(new SalaryBean(e.getName(), p.getAmount()));
			}
		}
		return result;

	}

	@Override
	public List<EmpBean> getEmpsByMgr(String mgr) throws HrException {
		// TODO Auto-generated method stub
		Manager m = mgrDao.findByName(mgr);

		if (m == null) {
			throw new HrException("你或许是个假经理?小伙子");
		}

		List<Employee> emps = empDao.findByManager(m);

		if (emps == null || emps.size() < 1) {
			throw new HrException("我更确信你是个假经理了，部门一个员工都没有");
		}

		List<EmpBean> result = new ArrayList<EmpBean>();
		for (Employee e : emps) {
			result.add(new EmpBean(e.getName(), e.getPass(), e.getSalary()));
		}
		return result;
	}

	/**
	 * 根据经理名返回该部门所有员工的申请记录中尚未批复的那一部分
	 */
	@Override
	public List<AppBean> getAppsByMgr(String mgr) throws HrException {
		// TODO Auto-generated method stub
		Manager m = mgrDao.findByName(mgr);

		if (m == null) {
			throw new HrException("你或许是个假经理?小伙子");
		}

		List<Employee> emps = empDao.findByManager(m);

		if (emps == null || emps.size() < 1) {
			throw new HrException("我更确信你是个假经理了，部门一个员工都没有");
		}

		List<AppBean> result = new ArrayList<AppBean>();
		for (Employee e : emps) {
			List<Application> apps = appDao.findByEmp(e);
			if (apps != null && apps.size() > 0) {
				for (Application app : apps) {
					if (app.isResult() == false) {
						Attend attend = app.getAttend();
						result.add(new AppBean(app.getId(), e.getName(), attend
								.getType().getName(), app.getType().getName(),
								app.getReason()));
					}
				}
			}
		}
		return result;
	}

	/**
	 * result 竟然是被传入的是否能通过的标志 应该改为checkResult
	 * 与Application中的result重名，但是applicatio中的result是申请是否被批复的结果
	 */
	@Override
	public void check(int appid, String mgrName, boolean checkResult) {
		// TODO Auto-generated method stub
		Application app = appDao.get(appid);
		CheckBack check = new CheckBack();
		check.setApp(app);

		if (checkResult) {
			check.setResult(true);
			app.setResult(true);

			// 修改申请对应的考勤的类型
			Attend attend = app.getAttend();
			attend.setType(app.getType());
			attendDao.update(attend);
		}
		// 没有通过申请
		else {
			check.setResult(false);
			app.setResult(true);
			appDao.save(app);
		}
		checkDao.save(check);
	}

}
