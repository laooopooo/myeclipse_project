package s;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet("/upload")
@MultipartConfig
public class UploadServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setContentType("text/html;charset=GBK");
		PrintWriter out = resp.getWriter();
		String fileName = req.getParameter("name");
		Part part = req.getPart("file");
		out.println("文件类型：" + part.getContentType() + "<br>");
		out.println("文件大小：" + part.getSize() + "<br>");
		Collection<String> headerNames = part.getHeaderNames();
		for (String headerName : headerNames) {
			out.println(headerName + "--->" + part.getHeader(headerName)
					+ "<br>");
		}
		part.write(getServletContext().getRealPath("/uploadFiles") + "/"
				+ fileName);
	}
}
