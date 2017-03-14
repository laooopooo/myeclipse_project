package dao;

import java.util.List;

import domain.Attend;
import domain.AttendType;
import domain.Employee;

public interface AttendDao {
	Attend get(Integer id);

	Integer save(Attend attend);

	void update(Attend attend);

	void delete(Attend attend);

	void delete(Integer id);

	List<Attend> findAll();

	List<Attend> findByEmp(Employee employee);

	List<Attend> findByEmpAndDutyDay(Employee emp, String dutyDay);

	Attend findByEmpAndDutyDayAndCome(Employee emp, String dutyDay,
			boolean isCome);

	List<Attend> findByEmpUnAttend(Employee emp, AttendType type);

}
