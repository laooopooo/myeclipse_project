package domain;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Test {
	public static void main(String[] args) {
		Configuration conf = new Configuration().configure();
		SessionFactory sf = conf.buildSessionFactory();
		Session sess = sf.openSession();
		Transaction tx = sess.beginTransaction();
		Student s = new Student();
		s.setName("pfjia");
		Course c = new Course();
		c.setName("¸ßÊý");
		Set<Course> courses = new HashSet<Course>();
		courses.add(c);

		s.setCourses(courses);

		sess.save(c);
		sess.save(s);
		tx.commit();
		sess.close();
		sf.close();
	}

}
