package listener;

import java.sql.ResultSet;
import java.util.Timer;
import java.util.TimerTask;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import bean.DbDao;

@WebListener
public class OnlineListener implements ServletContextListener {
	private static final int MAX_MILLIS = 5 * 1000 * 60;

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub

	}

	// Ӧ������ʱ������ʱ������ʱ�������ݿ��й�ʱ��Ϣ
	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		Timer timer = new Timer();
		timer.schedule(new TimerTask() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					// ���ɷ������ݿ�Ķ���
					DbDao dd = new DbDao("com.mysql.jdbc.Driver",
							"jdbc:mysql://localhost:3306/myssh", "root", "");
					// �ж��Ƿ��г�ʱ��session�����ݿ���
					ResultSet rs = dd.query("select * from online_inf");
					// ʹ��beRemove�ݴ����еĹ�ʱ��Ϣ�������ڷ��ֹ�ʱʱֱ��ɾ�������ٷ������ݿ�Ĵ���
					StringBuffer beRemove = new StringBuffer("(");
					while (rs.next()) {
						Long time = rs.getLong("currentTime");
						if ((System.currentTimeMillis() - time) > MAX_MILLIS) {
							beRemove.append("'");
							beRemove.append(rs.getString("sessionId"));
							beRemove.append("', ");
						}
					}
					// �ж����޳�ʱ��Ϣ
					if (beRemove.length() >= 3) {
						beRemove.setLength(beRemove.length() - 3);
						beRemove.append(")");
						dd.update("delete from online_inf where sessionId in "
								+ beRemove.toString());
					}
					// �ر����ݿ�
					dd.closeConn();

				} catch (Exception e) {
					e.printStackTrace();
				}

			}
		}, 0, 5 * 1000);
		;
	}
}
