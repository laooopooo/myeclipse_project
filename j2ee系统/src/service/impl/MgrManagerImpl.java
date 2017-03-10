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
			throw new HrException("����Ա����ҵ���쳣");
		}
		emp.setManager(m);
		empDao.save(m);
	}

	/**
	 * ���ݾ������������ڲ��������˵��ܹ��ʣ�ΪʲôҪ�������������˭�ã��ѵ�������Ѳ��ţ���Ѳ��Ų�Ӧ������ƽ����
	 */
	@Override
	public List<SalaryBean> getSalaryByMgr(String mgr) throws HrException {
		// TODO Auto-generated method stub
		Manager m = mgrDao.findByName(mgr);
		if (m == null) {
			throw new HrException("����Ѿ���Ǿ����𣿣�����");
		}
		List<Employee> emps = empDao.findByManager(m);
		if (emps == null || emps.size() < 1) {
			throw new HrException("һ��������Ͻ�Ĳ��ž�Ȼһ��Ա����û�У�������Ƥ");
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
			throw new HrException("������Ǹ��پ���?С����");
		}

		List<Employee> emps = empDao.findByManager(m);

		if (emps == null || emps.size() < 1) {
			throw new HrException("�Ҹ�ȷ�����Ǹ��پ����ˣ�����һ��Ա����û��");
		}

		List<EmpBean> result = new ArrayList<EmpBean>();
		for (Employee e : emps) {
			result.add(new EmpBean(e.getName(), e.getPass(), e.getSalary()));
		}
		return result;
	}

	/**
	 * ���ݾ��������ظò�������Ա���������¼����δ��������һ����
	 */
	@Override
	public List<AppBean> getAppsByMgr(String mgr) throws HrException {
		// TODO Auto-generated method stub
		Manager m = mgrDao.findByName(mgr);

		if (m == null) {
			throw new HrException("������Ǹ��پ���?С����");
		}

		List<Employee> emps = empDao.findByManager(m);

		if (emps == null || emps.size() < 1) {
			throw new HrException("�Ҹ�ȷ�����Ǹ��پ����ˣ�����һ��Ա����û��");
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
	 * result ��Ȼ�Ǳ�������Ƿ���ͨ���ı�־ Ӧ�ø�ΪcheckResult
	 * ��Application�е�result����������applicatio�е�result�������Ƿ������Ľ��
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

			// �޸������Ӧ�Ŀ��ڵ�����
			Attend attend = app.getAttend();
			attend.setType(app.getType());
			attendDao.update(attend);
		}
		// û��ͨ������
		else {
			check.setResult(false);
			app.setResult(true);
			appDao.save(app);
		}
		checkDao.save(check);
	}

}
