package lee;

import java.util.Date;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class TestJob implements Job {

	private boolean isRunning = false;

	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		// TODO Auto-generated method stub
		if (!isRunning) {
			System.out.println(new Date() + "��ҵ������");
			for (int i = 0; i < 100; i++) {
				System.out.println("��ҵ���" + (i + 1) + "%");
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			System.out.println(new Date() + "��ҵ���Ƚ���");
		} else {
			System.out.println(new Date() + "�����˳�");
		}
	}

}
