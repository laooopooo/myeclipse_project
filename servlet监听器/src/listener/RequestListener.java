package listener;

import java.sql.ResultSet;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import bean.DbDao;

public class RequestListener implements ServletRequestListener {

	@Override
	public void requestDestroyed(ServletRequestEvent servletrequestevent) {
		// TODO Auto-generated method stub

	}

	// 有新会话建立时查找数据库，如果有相应信息，更新数据库中的访问时间，如果没有则生成新条目
	@Override
	public void requestInitialized(ServletRequestEvent servletrequestevent) {
		// TODO Auto-generated method stub
		// 由event获得相关信息
		HttpServletRequest request = (HttpServletRequest) servletrequestevent
				.getServletRequest();
		HttpSession session = request.getSession();
		String sessionId = session.getId();
		String ip = request.getRemoteAddr();
		String page = request.getRequestURI();
		String user = (String) session.getAttribute("user");
		user = (user == null) ? "游客" : user;
		// 判断是否是新会话
		DbDao dd = new DbDao("com.mysql.jdbc.Driver",
				"jdbc:mysql://localhost:3306/myssh", "root", "");
		try {
			ResultSet rs = dd.query(
					"select * from online_inf where sessionId=?", sessionId);
			if (rs.next()) {
				rs.updateString("page", page);
				rs.updateLong("currentTime", System.currentTimeMillis());
				rs.updateRow();
				rs.close();
			} else {
				dd.update("insert into online_inf values('?,?,?,?,?)",
						sessionId, user, ip, page, System.currentTimeMillis());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
