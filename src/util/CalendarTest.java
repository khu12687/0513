package util;

import java.util.Calendar;

public class CalendarTest {
	//�ڹٿ��� ��¥�� �ٷ���� Calendar �̿��ϸ�ȴ�
	public static void main(String[] args) {
		//�߻�Ŭ����������, static �޼���� �ν��Ͻ��� ��´�!!
		Calendar cal = Calendar.getInstance();
		System.out.println(cal.get(Calendar.YEAR));
		System.out.println(cal.get(Calendar.MONTH)+1);
		System.out.println(cal.get(Calendar.DATE));
	}
}
