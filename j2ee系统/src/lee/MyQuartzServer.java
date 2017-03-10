package lee;

import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SimpleTrigger;
import org.quartz.Trigger;
import org.quartz.impl.StdSchedulerFactory;

public class MyQuartzServer {
	public static void main(String[] args) {
		MyQuartzServer server = new MyQuartzServer();
		try {
			server.startScheduler();
		} catch (SchedulerException e) {
			e.printStackTrace();
		}
	}

	private void startScheduler() throws SchedulerException {
		Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();

		JobDetail jobDetail = new JobDetail("dd", Scheduler.DEFAULT_GROUP,
				TestJob.class);

		Trigger trigger = new SimpleTrigger("dd", Scheduler.DEFAULT_GROUP, 50,
				20000);
		scheduler.scheduleJob(jobDetail, trigger);
		scheduler.start();
	}

}
