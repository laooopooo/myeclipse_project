package domain;

import java.io.Serializable;

public class Application implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5842991171110013221L;
	// 标识属性
	private Integer id;
	// 申请理由
	private String reason;
	// 是否处理（result容易被理解为处理的结果,而处理的结果由关联的CheckBack代表，建议改为isCheck）
	private boolean result;
	// 关联的出勤
	private Attend attend;
	// 申请改为的出勤类型
	private AttendType type;
	// 申请的结果
	private CheckBack check;

	public Application() {
		// TODO Auto-generated constructor stub
	}

	public Application(Integer id, String reason, boolean result,
			Attend attend, AttendType type, CheckBack check) {
		super();
		this.id = id;
		this.reason = reason;
		this.result = result;
		this.attend = attend;
		this.type = type;
		this.check = check;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public boolean isResult() {
		return result;
	}

	public void setResult(boolean result) {
		this.result = result;
	}

	public Attend getAttend() {
		return attend;
	}

	public void setAttend(Attend attend) {
		this.attend = attend;
	}

	public AttendType getType() {
		return type;
	}

	public void setType(AttendType type) {
		this.type = type;
	}

	public CheckBack getCheck() {
		return check;
	}

	public void setCheck(CheckBack check) {
		this.check = check;
	}

}
