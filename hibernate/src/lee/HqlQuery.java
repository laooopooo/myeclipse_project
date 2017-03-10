package lee;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class HqlQuery {
	public static void main(String[] args) {

	}

	private void findPersons() {
		Session session = HibernateUtil.currentSession();
		Transaction tx = session.beginTransaction();

		List p = session
				.createQuery(
						"select distinct p from Person p "
								+ "join p.myEvents where title =:eventTitle")
				.setString("eventTitle", "很普通的事情").list();
		for (Iterator pit = p.iterator(); pit.hasNext();) {

		}
		tx.commit();
		HibernateUtil.closeSession();
	}
}
