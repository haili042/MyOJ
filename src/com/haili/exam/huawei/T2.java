package com.haili.exam.huawei;

public class T2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 1, 2, 3, 4, 7, 90, 91, 92, 110, 102, 106, 190 };
		t(arr);
	}

	public static void t(int[] arr) {

		int last = 0;
		int init = 0;
		String res = "";
		for (int i = 1; i < arr.length; i++) {
			if (arr[last] + 1 == arr[i]) {
			} else {
				res += arr[init] + ",";
				res += arr[last] + ",";
				init = i;
			}
			last = i;
		}
		System.out.println(res);
	}

	public static void tt(int[] arr) {

		// �ж���û�г���������
		int len = arr.length;
		for (int i = 0; i < len; i++) {
			int count = 0;// ���ڱ�ǳ��ֵ�������ʱ�򳬹���2����
			int j = 1;
			while (i + j < len && arr[i + j] == arr[i] + j) {
				count++;
				j++;
			}

			// ����������������Ͱѳ���ͷβ����Ķ���0
			if (count >= 3) {
				for (int k = i + 1; k < i + count; k++)
					arr[k] = 0;

			}
		}
		System.out.println(arr.toString());
	}

}
