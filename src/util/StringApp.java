package util;

public class StringApp {
	public static void main(String[] args) {
		//���԰����ڰ� ��Դ� �ڵ��� ��
		for(int i=0; i<10000; i++) {
			new String("korea");
		}
		
		//��Ʈ���� �Һ��̴�(=immutale) ��ü�Ұ�! ����Ұ�!
		//�ѹ������� ��Ʈ���� �����޵Ǳ� ������ �� �����͸� ����� ���� �� �� ����!
		//�޸� ȿ������ ���� �����Һ���, ���������ϰ� �ؾ��Ѵ�!!
		StringBuilder sb = new StringBuilder();
		
		sb.append("");
		String str = "korea";
		for(int i=1; i<=10000; i++) {
			//str = str+i; //10000���� �ν��Ͻ��� �޸𸮿� �Ҵ��; 10000���� ��ü����
			//��Ʈ���� = �����ڷ� �����Ϸ���������, �Ʒ�ó�� append �޼��带 �̿��Ѵ�
			//�ذ��?? StringBuilder
			sb.append("ko"+i);
		}
		
		String result = sb.toString();
		
	}
}
