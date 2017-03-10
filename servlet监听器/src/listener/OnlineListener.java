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

	// 应用启动时启动定时器，定时清理数据库中过时信息
	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		Timer timer = new Timer();
		timer.schedule(new TimerTask() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					// 生成访问数据库的对象
					DbDao dd = new DbDao("com.mysql.jdbc.Driver",
							"jdbc:mysql://localhost:3306/myssh", "root", "");
					// 判断是否有超时的session在数据库中
					ResultSet rs = dd.query("select * from online_inf");
					// 使用beRemove暂存所有的过时信息，不用在发现过时时直接删除，减少访问数据库的次数
					StringBuffer beRemove = new StringBuffer("(");
					while (rs.next()) {
						Long time = rs.getLong("currentTime");
						if ((System.currentTimeMillis() - time) > MAX_MILLIS) {
							beRemove.append("'");
							beRemove.append(rs.getString("sessionId"));
							beRemove.append("', ");
						}
					}
					// 判断有无超时信息
					if (beRemove.length() >= 3) {
						beRemove.setLength(beRemove.length() - 3);
						beRemove.append(")");
						dd.update("delete from online_inf where sessionId in "
								+ beRemove.toString());
					}
					// 关闭数据库
					dd.closeConn();

				} catch (Exception e) {
					e.printStackTrace();
				}

			}
		}, 0, 5 * 1000);
		;
	}
}
