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
 * 2017.3.9��
 * 
 * @author pfjia
 * 
 *         �����domain��dao��Ĵ����д���������ڱ�дҵ���߼��㣬ҵ���߼���Ҫ��Ա���;������ֽ�ɫ����Ҫʵ�����ֲ�ͬ�Ĺ���
 *         Ŀǰ���ڱ�дԱ����ҵ���߼��� 1.service��Ҳ��Ҫ����ӿڱ�� 2.������һ���߼����̣�
 *         ��1��7������ϵͳ�Զ����д򿨣�����ʱ��������Ϊ���� ��2���ж�Ա���Ƿ���Դ�
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
	 * �ж�Ա�������ͣ�����ͨԱ�������Ǿ���
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
	 * ��7���ӣ��Զ����������¼
	 */
	@Override
	public void autoPunch() {
		// TODO Auto-generated method stub
		System.out.println("�Զ����������¼");
		List<Employee> emps = employeeDao.findAll();
		String dutyDay = new Date(System.currentTimeMillis()).toString();
		for (Employee e : emps) {
			// ��ȡ������Ӧ�ĳ�������
			AttendType atype = attendTypeDao.get(6);

			// ΪԱ������һ��attend��¼�����Ǵ˼�¼��punchTimeδ����
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
	 * �Զ����㹤��
	 */
	@Override
	public void autoPay() {
		// TODO Auto-generated method stub
		System.out.println("�Զ����빤�ʽ���");
		List<Employee> emps = employeeDao.findAll();
		Calendar c = Calendar.getInstance();
		// �����ȥ15�죬�����һ���·�
		c.add(Calendar.DAY_OF_MONTH, -15);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
		String payMonth = sdf.format(c.getTime());
		for (Employee e : emps) {
			Payment pay = new Payment();
			double amount = e.getSalary();
			List<Attend> attends = attendDao.findByEmp(e);
			// ��ԭ�й��ʵĻ����Ͻ��м�������
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
	 * isCome ��֤ĳ��Ա���Ƿ���Դ򿨣���ȡ����Ŀ��ڼ�¼�����ݽ���Ŀ��ڼ�¼�����ж��Ƿ���Դ򿨣����ϰ�򿨣������°��
	 */
	@Override
	public int validPunch(String user, String dutyDay) {
		// TODO Auto-generated method stub
		// ���޴���
		Employee emp = employeeDao.findByName(user);
		if (emp == null) {
			return NO_PUNCH;
		}
		// ��ȡԱ������Ŀ��ڼ�¼
		List<Attend> attends = attendDao.findByEmpAndDutyDay(emp, dutyDay);
		// û�пմ򿨼�¼���޷���
		if (attends == null || attends.size() <= 0) {
			return NO_PUNCH;
		}
		// ֻ��һ�οմ򿨼�¼���ϰ��
		else if (attends.size() == 1 && attends.get(0).isCome()
				&& attends.get(0).getPunchTime() == null) {
			return COME_PUNCH;
		}
		// �°��
		else if (attends.size() == 1 && attends.get(0).getPunchTime() == null) {
			return LEAVE_PUNCH;
		}

		else if (attends.size() == 2) {
			// �������°��
			if (attends.get(0).getPunchTime() == null
					&& attends.get(1).getPunchTime() == null) {
				return BOTH_PUNCH;
			}
			// �����°��
			else if (attends.get(1).getPunchTime() == null) {
				return LEAVE_PUNCH;
			} else {
				return NO_PUNCH;
			}
		}

		return NO_PUNCH;
	}

	/**
	 * ��
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
		System.out.println("============��============");
		int punchHour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
		attend.setPunchTime(new Date());
		// �ϰ��
		if (isCome) {
			// 9��֮ǰ����
			if (punchHour < COME_LIMIT) {
				attend.setType(attendTypeDao.get(1));
			}
			// 9~11��ٵ�
			else if (punchHour < LATE_LIMIT) {
				attend.setType(attendTypeDao.get(4));
			}
		}

		// �°��
		else {
			// 18��֮��������
			if (punchHour >= LEAVE_LIMIT) {
				attend.setType(attendTypeDao.get(1));
			}
			// 16~18��������
			else if (punchHour >= EARLY_LIMIT) {
				attend.setType(attendTypeDao.get(5));
			}

			// 16��֮ǰ���ü�¼
		}
		attendDao.update(attend);
		return PUNCH_SUCC;
	}

	/**
	 * ����Ա�����������
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
	 * �鿴��������������
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
	 * �������
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
