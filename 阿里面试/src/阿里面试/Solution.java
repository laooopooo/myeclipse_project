package ��������;

public class Solution {

	/**
	 * ��һ������ָ�������֣���������ֵ֮����ȣ��ָ�����ֵ������
	 * 
	 * @param array
	 * @param start
	 *            ������ʼλ��
	 * @param end
	 *            ������ֹλ��
	 * @return �����Էֽ⣬���طָ���index�����ɷֽ⣬����-1
	 */
	public int splitToTwo(int[] array, int start, int end) {
		// ��һ���ֵĺͣ��͵ڶ����ֵĺ�
		int sun1 = 0;
		int sun2 = 0;
		while (start != end) {
			sun1 += array[start];
			sun2 += array[end];

			if (sun1 < sun2) {

			}
		}
		return start;
	}
}
