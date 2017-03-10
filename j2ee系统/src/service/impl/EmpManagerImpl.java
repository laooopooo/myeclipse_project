package service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import service.EmpManager;
import vo.AttendBean;
import vo.PaymentBean;
import dao.ApplicationDao;
import dao.AttendDao;
import dao.AttendTypeDao;
import dao.CheckBackDao;
import dao.EmployeeDao;
import dao.ManagerDao;
import dao.PaymentDao;
import domain.Application;
import domain.Attend;
import domain.AttendType;
import domain.Employee;
import domain.Manager;
import domain.Payment;

/**
 * 2017.3.9晚
 * 
 * @author pfjia
 * 
 *         完成了domain、dao层的代码编写工作，正在编写业务逻辑层，业务逻辑主要有员工和经理两种角色，需要实现两种不同的功能
 *         目前正在编写员工的业务逻辑， 1.service层也需要面向接口编程 2.大致理一下逻辑流程：
 *         （1）7点钟由系统自动进行打卡，但此时考勤类型为旷工 （2）判断员工是否可以打卡
 */
public class EmpManagerImpl implements EmpManager {
	private ApplicationDao appDao;
	private AttendDao attendDao;
	private AttendTypeDao attendTypeDao;
	private CheckBackDao checkBackDao;
	private PaymentDao paymentDao;
	private EmployeeDao employeeDao;
	private ManagerDao managerDao;

	/**
	 * 判断员工的类型，是普通员工或者是经理
	 */
	@Override
	public int validLogin(Manager mgr) {
		// TODO Auto-generated method stub
		if (managerDao.get(mgr.getId()) == mgr) {
			return LOGIN_MGR;
		} else if (employeeDao.get(mgr.getId()) == mgr) {
			return LOGIN_EMP;
		}
		return LOGIN_FAIL;
	}

	/**
	 * 在7点钟，自动插入旷工记录
	 */
	@Override
	public void autoPunch() {
		// TODO Auto-generated method stub
		System.out.println("自动插入旷工记录");
		List<Employee> emps = employeeDao.findAll();
		String dutyDay = new Date(System.currentTimeMillis()).toString();
		for (Employee e : emps) {
			// 获取旷工对应的出勤类型
			AttendType atype = attendTypeDao.get(6);

			// 为员工生成一个attend记录，但是此记录的punchTime未设置
			Attend a = new Attend();
			a.setDutyDay(dutyDay);
			a.setType(atype);
			if (Calendar.getInstance().get(Calendar.HOUR_OF_DAY) < AM_LIMIT) {
				a.setCome(true);
			} else {
				a.setCome(false);
			}
			a.setEmployee(e);
			attendDao.save(a);
		}
	}

	/**
	 * 自动结算工资
	 */
	@Override
	public void autoPay() {
		// TODO Auto-generated method stub
		System.out.println("自动插入工资结算");
		List<Employee> emps = employeeDao.findAll();
		Calendar c = Calendar.getInstance();
		// 今天减去15天，获得上一个月份
		c.add(Calendar.DAY_OF_MONTH, -15);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
		String payMonth = sdf.format(c.getTime());
		for (Employee e : emps) {
			Payment pay = new Payment();
			double amount = e.getSalary();
			List<Attend> attends = attendDao.findByEmp(e);
			// 在原有工资的基础上进行减法计算
			for (Attend a : attends) {
				amount += a.getType().getAmerce();
			}
			pay.setPayMonth(payMonth);
			pay.setEmployee(e);
			pay.setAmount(amount);
			paymentDao.save(pay);
		}
	}

	/**
	 * isCome 验证某个员工是否可以打卡，获取今天的考勤记录，根据今天的考勤记录次数判断是否可以打卡，是上班打卡，还是下班打卡
	 */
	@Override
	public int validPunch(String user, String dutyDay) {
		// TODO Auto-generated method stub
		// 查无此人
		Employee emp = employeeDao.findByName(user);
		if (emp == null) {
			return NO_PUNCH;
		}
		// 获取员工当天的考勤记录
		List<Attend> attends = attendDao.findByEmpAndDutyDay(emp, dutyDay);
		// 没有空打卡记录，无法打卡
		if (attends == null || attends.size() <= 0) {
			return NO_PUNCH;
		}
		// 只有一次空打卡记录，上班打卡
		else if (attends.size() == 1 && attends.get(0).isCome()
				&& attends.get(0).getPunchTime() == null) {
			return COME_PUNCH;
		}
		// 下班打卡
		else if (attends.size() == 1 && attends.get(0).getPunchTime() == null) {
			return LEAVE_PUNCH;
		}

		else if (attends.size() == 2) {
			// 可以上下班打卡
			if (attends.get(0).getPunchTime() == null
					&& attends.get(1).getPunchTime() == null) {
				return BOTH_PUNCH;
			}
			// 可以下班打卡
			else if (attends.get(1).getPunchTime() == null) {
				return LEAVE_PUNCH;
			} else {
				return NO_PUNCH;
			}
		}

		return NO_PUNCH;
	}

	/**
	 * 打卡
	 */
	@Override
	public int punch(String user, String dutyDay, boolean isCome) {
		// TODO Auto-generated method stub
		Employee emp = employeeDao.findByName(user);
		if (emp == null) {
			return PUNCH_FAIL;
		}

		Attend attend = attendDao.findByEmpAndDutyDayAndCome(emp, dutyDay,
				isCome);
		if (attend == null) {
			return PUNCH_FAIL;
		}

		if (attend.getPunchTime() != null) {
			return PUNCHED;
		}
		System.out.println("============打卡============");
		int punchHour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
		attend.setPunchTime(new Date());
		// 上班打卡
		if (isCome) {
			// 9点之前正常
			if (punchHour < COME_LIMIT) {
				attend.setType(attendTypeDao.get(1));
			}
			// 9~11算迟到
			else if (punchHour < LATE_LIMIT) {
				attend.setType(attendTypeDao.get(4));
			}
		}

		// 下班打卡
		else {
			// 18点之后算正常
			if (punchHour >= LEAVE_LIMIT) {
				attend.setType(attendTypeDao.get(1));
			}
			// 16~18点算早退
			else if (punchHour >= EARLY_LIMIT) {
				attend.setType(attendTypeDao.get(5));
			}

			// 16点之前不用记录
		}
		attendDao.update(attend);
		return PUNCH_SUCC;
	}

	/**
	 * 根据员工名浏览工资
	 */
	@Override
	public List<PaymentBean> empSalary(String empName) {
		// TODO Auto-generated method stub
		Employee emp = employeeDao.findByName(empName);
		List<Payment> pays = paymentDao.findByEmp(emp);
		List<PaymentBean> result = new ArrayList<PaymentBean>();

		for (Payment p : pays) {
			result.add(new PaymentBean(p.getPayMonth(), p.getAmount()));
		}
		return result;
	}

	/**
	 * 查看最近三天非正常打卡
	 */
	@Override
	public List<AttendBean> unAttend(String empName) {
		// TODO Auto-generated method stub
		AttendType type = attendTypeDao.get(1);
		Employee emp = employeeDao.findByName(empName);

		List<Attend> attends = attendDao.findByEmpUnAttend(emp, type);
		List<AttendBean> result = new ArrayList<AttendBean>();
		for (Attend a : attends) {
			result.add(new AttendBean(a.getId(), a.getDutyDay(), a.getType()
					.getName(), a.getPunchTime()));
		}
		return result;
	}

	@Override
	public List<AttendType> getAllType() {
		// TODO Auto-generated method stub
		return attendTypeDao.findAll();
	}

	/**
	 * 添加申请
	 */
	@Override
	public boolean addApplication(int attId, int typeId, String reason) {
		// TODO Auto-generated method stub
		Application app = new Application();
		app.setAttend(attendDao.get(attId));
		app.setType(attendTypeDao.get(typeId));
		if (reason != null) {
			app.setReason(reason);
		}
		appDao.save(app);
		return true;

	}

}
