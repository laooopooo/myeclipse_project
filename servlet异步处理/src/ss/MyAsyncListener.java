package ss;

import java.io.IOException;

import javax.servlet.AsyncEvent;
import javax.servlet.AsyncListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class MyAsyncListener implements AsyncListener {

	@Override
	public void onComplete(AsyncEvent asyncevent) throws IOException {
		// TODO Auto-generated method stub
		System.out.println("�첽�������");
	}

	@Override
	public void onError(AsyncEvent asyncevent) throws IOException {
		// TODO Auto-generated method stub

	}

	@Override
	public void onStartAsync(AsyncEvent asyncevent) throws IOException {
		// TODO Auto-generated method stub
		System.out.println("�첽���ÿ�ʼ");
	}

	@Override
	public void onTimeout(AsyncEvent asyncevent) throws IOException {
		// TODO Auto-generated method stub

	}

}
