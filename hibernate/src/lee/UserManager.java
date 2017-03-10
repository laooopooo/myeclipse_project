package lee;

import org.hibernate.Session;
import org.hibernate.Transaction;

import domain.User;

public class UserManager {

	private void addUser() throws Exception {
		Session session = HibernateUtil.currentSession();

		Transaction tx = session.beginTransaction();
		for (int i = 0; i < 1000000; i++) {
			User u1 = new User();
			session.save(u1);
			if (i % 20 == 0) {
				session.flush();
				session.clear();
			}
		}
		tx.commit();
		HibernateUtil.closeSession();
	}

	private void updateUsers() throws Exception {
		Session session = HibernateUtil.currentSession();
		Transaction tx = session.beginTransaction();
		/**
		 * 普通方式
		 */
		// ScrollableResults users = session.createQuery("from uesr")
		// .setCacheMode(CacheMode.IGNORE).scroll(ScrollMode.FORWARD_ONLY);
		// int count = 0;
		// while (users.next()) {
		// User u = (User) users.get(0);
		// if (++count % 20 == 0) {
		// session.flush();
		// session.clear();
		// }
		// }

		/**
		 * DML方式
		 */
		String hqlUpdate = "update User set name=:newName";
		int updateEntities = session.createQuery(hqlUpdate)
				.setString("newName", "新名字").executeUpdate();

		tx.commit();
		HibernateUtil.closeSession();
	}

	private void deleteUsers() throws Exception {
		Session session = HibernateUtil.currentSession();
		Transaction tx = session.beginTransaction();

		String hqlDelete = "delete User";
		int deleteEntities = session.createQuery(hqlDelete).executeUpdate();

		tx.commit();
		HibernateUtil.closeSession();
	}
}
