package domain;

import java.io.Serializable;

public class Application implements Serializable {
	private Integer id;
	private String reason;
	private boolean result;// 标志此申请是否已经被批复，true表示已经批复，false表示还未批复，不是表示批复的结果，批复的结果是在checkback中
	private Attend attend;
	private AttendType type;
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
