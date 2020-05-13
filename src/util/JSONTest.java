package util;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JSONTest {
	public static void main(String[] args) {
		//�Ʒ��� �ڵ带 �ڹٴ� ���̽����� ���� �ʴ´�!!
		//�׳� ����ȭ�� �극�̽� �������� ����!!
		//���� �Ʒ��� �ڵ带 �ϴ� ���ڿ��� ǥ���غ���
		/*
		 * String json = "{"; json = json+"\"name\":\"batman\""; json=json+"}";
		 */
		//���� ��쿣 ��Ʈ�� ����� 3���� �����ȴ�!! ���� ���������� ��Ʈ������ �ذ��Ѵ�!!
		StringBuilder sb =new StringBuilder();
		sb.append("{");
		sb.append("\"name\":\"batman\"");
		sb.append("}");
		
		System.out.println(sb.toString()); //Stirng ���� ��ȯ!
		
		//�ڹ����α׷��� ������ �⺻������ JSON�� ���� �� �� ����!!
		//sun���� �⺻������ �������� �ʱ� ������ �ܺο��� ���̺귯���� �����ͼ� ó������!!
		//jar�� ����Ʈ �÷����� �̿��ߴٸ�, Ŭ�����н��� ����ؾ� �Ѵ�
		//������ ��Ŭ������ ��쿣 �� ��ü��
		
		JSONParser parser = new JSONParser();
		
		try {
			JSONObject obj = (JSONObject)parser.parse(sb.toString()); //���ڿ��� �Ұ��ߴ� sb�� ���̽����� �ؼ��̵�!!
			System.out.println(obj.get("name"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("���̽� ������ ������ �ֳ׿�..");
		}
		
		//���̽����� �ؼ��̵�!!
		//���� �� �������ʹ� ���� ���ڿ��� �Ұ��ߴ� sb�� ��ü����� �� �ִ�	
		//���!!
		//��� �ڹٰ� ���̽� ��ü�� ������ �� ������, jsonǥ������� �ۼ��� ���ڿ��� ��ġ ���̽� ó�� ���� ����
		//���̺귯���� �̿��� �� �ִ�!!		
	
	}
}
