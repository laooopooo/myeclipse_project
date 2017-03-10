package ss;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns = "/s", asyncSupported = true)
public class AsyncServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = req.getSession();
		resp.setContentType("text/html;charset=GBK");
		PrintWriter out = resp.getWriter();
		out.println("进入servlet的时间:" + new Date() + "<br>");
		out.flush();
		AsyncContext actx = req.startAsync();
		actx.addListener(new MyAsyncListener());
		actx.setTimeout(30 * 1000);
		actx.start(new Executor(actx));
		out.println("结束servlet的时间：" + new Date() + "<br>");
		out.flush();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}
}
