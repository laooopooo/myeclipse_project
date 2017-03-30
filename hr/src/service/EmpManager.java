package service;

import domain.Manager;

public interface EmpManager {

	// µÇÂ¼Ê§°Ü
	public static final int LOGIN_FAIL = 0;
	// ÆÕÍ¨Ô±¹¤µÇÂ¼
	public static final int LOGIN_EMP = 1;
	// ¾­ÀíµÇÂ¼
	public static final int LOGIN_MGR = 2;

	int validLogin(Manager manager);
}
