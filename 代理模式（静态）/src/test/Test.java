package test;

import proxy.Proxy;

/**
 *  ���ˣ��������ǵľ�̬����ʵ���ˣ�
 *  ��������Ҳ�������ˣ��۲������Է���ÿһ��������ֻ��Ϊһ���ӿڷ���
 *  һ��AccountProxy ��ʵ����һ��Account�ӿڣ�
 *  ��ô��Ҫ���ж���ӿڣ��ǲ���Ҫд���Proxy����֮��Ӧ��
 *  ����һ�����򿪷��б�Ȼ���������Ĵ���
 *  ���ң����еĴ���������˵��õķ�����һ��֮�⣬�����Ĳ�����һ�������ʱ�϶����ظ����롣
 *  �����һ������õ������ǿ���ͨ��һ�����������ȫ���Ĵ����ܣ��Ǿ����������ǵĶ�̬�����ˡ�
 * @author Administrator
 *
 */

public class Test {
	public static void main(String[] args) {
		Proxy proxy=new Proxy();
		
		proxy.queryAccount();
		proxy.updateAccount();
	}
}
