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
		// ����һ��Person����
		Person p = new Person();
		// ����Person��NameΪYeeku�ַ���
		p.setFirst("pf");
		p.setLast("jia");
		p.setAge(29);
		session.save(p);
		// ����һ��Address����
		Set<Address> addresses = new HashSet<Address>();
		Address a = new Address("�������");
		addresses.add(a);
		// ����Person�����Address����
		p.setAddresses(addresses);
		tx.commit();
		HibernateUtil.closeSession();
	}

	public static void main(String[] args) {
		PersonManager mgr = new PersonManager();
		HibernateUtil.sessionFactory.close();
		System.out.println("ִ�����");
	}

}
