package domain;

import java.io.Serializable;

public class CheckBack implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4770374747139911862L;

	// ��ʶ����
	private Integer id;
	// �Ƿ�ͬ������
	private boolean result;
	// ��������
	private String reason;
	// ������Ӧ����
	private Application app;
	// ��������
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
