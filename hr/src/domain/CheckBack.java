package domain;

import java.io.Serializable;

public class CheckBack implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4770374747139911862L;

	// 标识属性
	private Integer id;
	// 是否同意申请
	private boolean result;
	// 批复理由
	private String reason;
	// 批复对应申请
	private Application app;
	// 批复经理
	private Manager manager;

	public CheckBack() {
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public boolean isResult() {
		return result;
	}

	public void setResult(boolean result) {
		this.result = result;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public Application getApp() {
		return app;
	}

	public void setApp(Application app) {
		this.app = app;
	}

	public Manager getManager() {
		return manager;
	}

	public void setManager(Manager manager) {
		this.manager = manager;
	}

	public CheckBack(Integer id, boolean result, String reason,
			Application app, Manager manager) {
		super();
		this.id = id;
		this.result = result;
		this.reason = reason;
		this.app = app;
		this.manager = manager;
	}

}
