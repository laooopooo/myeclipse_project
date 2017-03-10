package schedule;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

import service.EmpManager;

public class PayJob extends QuartzJobBean {
	private boolean isRunning = false;
	private EmpManager empMgr;

	@Override
	protected void executeInternal(JobExecutionContext context)
			throws JobExecutionException {
		// TODO Auto-generated method stub
		if (!isRunning) {
			System.out.println("开始调度自动结算工资");
			isRunning = true;
			empMgr.autoPay();
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
