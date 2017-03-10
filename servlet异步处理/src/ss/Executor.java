package ss;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.AsyncContext;
import javax.servlet.ServletRequest;
import javax.servlet.ServletRequestListener;

import org.omg.CosNaming.IstringHelper;

public class Executor implements Runnable {
	private AsyncContext actx;

	public Executor(AsyncContext asyncContext) {
		// TODO Auto-generated constructor stub
		actx = asyncContext;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			Thread.sleep(5 * 1000);
			ServletRequest request = actx.getRequest();
			List<String> books = new ArrayList<String>();
			books.add("·è¿ñjava½²Òå");
			request.setAttribute("books", books);
			actx.dispatch("/async.jsp");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
