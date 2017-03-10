package lee;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;

import domain.Address;
import domain.Person;

public class PersonManager {

	private void testPerson() {
		Session session = HibernateUtil.currentSession();
		Transaction tx = session.beginTransaction();
		// 创建一个Person对象
		Person p = new Person();
		// 设置Person的Name为Yeeku字符串
		p.setFirst("pf");
		p.setLast("jia");
		p.setAge(29);
		session.save(p);
		// 创建一个Address对象
		Set<Address> addresses = new HashSet<Address>();
		Address a = new Address("广州天河");
		addresses.add(a);
		// 设置Person对象的Address属性
		p.setAddresses(addresses);
		tx.commit();
		HibernateUtil.closeSession();
	}

	public static void main(String[] args) {
		PersonManager mgr = new PersonManager();
		HibernateUtil.sessionFactory.close();
		System.out.println("执行完成");
	}

}
