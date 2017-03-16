package spring;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

public class EmailNotifier implements ApplicationListener {

	@Override
	public void onApplicationEvent(ApplicationEvent arg0) {
		// TODO Auto-generated method stub
		if (arg0 instanceof EmailEvent) {
			EmailEvent emailEvent = (EmailEvent) arg0;
			System.out.println("��Ҫ�����ʼ��Ľ��ܵ�ַ��" + emailEvent.getAddress());
			System.out.println("��Ҫ�����ʼ����ʼ����ģ�" + emailEvent.getText());
		} else {
			System.out.println("����������¼���" + arg0);
		}
	}

}
