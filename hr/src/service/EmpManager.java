package service;

import domain.Manager;

public interface EmpManager {

	// ��¼ʧ��
	public static final int LOGIN_FAIL = 0;
	// ��ͨԱ����¼
	public static final int LOGIN_EMP = 1;
	// �����¼
	public static final int LOGIN_MGR = 2;

	int validLogin(Manager manager);
}
