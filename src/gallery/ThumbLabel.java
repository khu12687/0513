package gallery;

import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

//�� Ŭ������ ������ JLabel�� ��ӹ޾�,
//���� ���ϴ� �����͸� �ֱ� ���� ������ ������ ����
public class ThumbLabel extends JLabel{
	int id; //�� ��ü�� �ĺ��� ��ȣ!!
	//�������� ������ ȣ��� �ĺ���ȣ�� �ѱ�� �ȴ�
	public ThumbLabel(int id,ImageIcon icon) {
		//�� ���� ����� ������ ������!!
		super(icon);

		this.id = id;
		
		setPreferredSize(new Dimension(70,60));
		
	}
}
