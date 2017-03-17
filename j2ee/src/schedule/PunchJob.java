package schedule;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

import service.EmpManager;

public class PunchJob extends QuartzJobBean {
	private boolean isRunning = false;
	private EmpManager empMgr;

	@Override
	protected void executeInternal(JobExecutionContext arg0)
			throws JobExecutionException {
		// TODO Auto-generated method stub
		if (!isRunning) {
			System.out.println("��ʼ�����Զ���");
			isRunning = true;
			empMgr.autoPunch();
			isRunning = false;
		}
	}

	public EmpManager getEmpMgr() {
		return empMgr;
	}

	public void setEmpMgr(EmpManager empMgr) {
		this.empMgr = empMgr;
	}

}