package gallery;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Gallery extends JFrame{
	JPanel p_west;
	JPanel p_center;
	JPanel p_canvas;
	Toolkit kit = Toolkit.getDefaultToolkit(); //�̹����� ��� ����� ���������� ������, �̹����� ��Ŷ�̿�
												//�߻�Ŭ�������� �޼���ΰ� new�ȵ�
	Image bigImage;// ū �̹��� ��ü
	JButton bt_prev;
	JButton bt_next;
	String dir="C:/images/";
	String[] path = {"i1.png","i2.png","i3.png","i4.png","i5.png","i6.png","i7.png","i8.png","i9.png","i10.png",""};
	ThumbLabel[] la_thumb;
	ImageIcon[] icon;
	JTextField t_id; //���� �����ִ� �̹����� id �������
	int cursor; //���� �����ִ� �̹��� �ε���!!
	
	public Gallery() {
		p_west = new JPanel();
		p_center = new JPanel();
		//.java �ҽ��� �и���Ű�� ���� ���۷����� �ְ�޾ƾ��ϴ� �������� �ֱ⶧����, �г��� ���� Ŭ������ �ɹ������� ����
		//���� �Ϸ��� �����͸����� ó������
		p_canvas = new JPanel() {
			public void paint(Graphics g) {
				g.drawImage(bigImage, 0, 0, 450, 400, this);
			}
		};
		bt_prev = new JButton("prev");
		bt_next = new JButton("next");
		t_id = new JTextField("0",5);
		
		//��Ÿ�Ϻο�
		p_west.setBackground(Color.YELLOW);
		p_center.setBackground(Color.CYAN);
		p_canvas.setBackground(Color.RED);
		p_west.setPreferredSize(new Dimension(100,400));
		p_canvas.setPreferredSize(new Dimension(500,300));
		t_id.setFont(new Font("����",Font.BOLD,45));
		
		p_center.add(bt_prev);
		p_center.add(bt_next);
		p_center.add(p_canvas);
		
		add(p_west,BorderLayout.WEST);
		add(p_center);
		p_center.add(t_id);
		
		createImg();
		for(int i=0; i<path.length; i++) {			
			p_west.add(la_thumb[i]);
			la_thumb[i].addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					//�̺�Ʈ�� ����Ų ���� ������Ʈ�� ������ �̺�Ʈ �ҽ�
					ThumbLabel obj = (ThumbLabel)e.getSource();
					//System.out.println(obj.id);
					//��Ģ�� �⺻�ڷ����� ��ü�ڷ����� ���� ����ȯ�� �Ұ����ϹǷ� Wrapper Ŭ������ �̿��ϸ�ȴ�
					cursor=obj.id;
					t_id.setText(Integer.toString(obj.id));
					showImage(obj.id); //������ ����ϰ� ��Ī�Ǵ� ū �̹��� �����ֱ�
				}
			});
		}
		
		//��ư�� �����ʿ���
		bt_prev.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				cursor--; //������������ Ŀ���� �̵�
				//cursor�� ����� 0���� ������ ��!!
				if(cursor <0) {
					JOptionPane.showMessageDialog(Gallery.this, "���� ������ ���׿�");
					cursor=0;
				}else {
					showImage(cursor);
					t_id.setText(Integer.toString(cursor));
				}
				
			}
		});
		
		bt_next.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				cursor++; //������������ Ŀ���� �̵�
				if(cursor >path.length-1) {
					JOptionPane.showMessageDialog(Gallery.this, "���� ������ ���׿�");
					cursor=path.length-1;
				}else {
					showImage(cursor);
					t_id.setText(Integer.toString(cursor));
				}
			}
		});
		
		setSize(600,700);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		}
	
	public void createImg() {
		//�̹��� �������� ����, �� 10�� ����!!
		la_thumb = new ThumbLabel[path.length];
		icon = new ImageIcon[path.length];
		for(int i=0; i<path.length;i++) {
			la_thumb[i] = new ThumbLabel(i,new ImageIcon(dir+path[i]));
		}
		
		//ū �̹��� ó��
		bigImage = kit.getImage(dir+path[0]);
	}
	
	//ū �̹��� ����ϴ� �޼��� �Ű������� ������� ������ȣ�� �Ѱܹ޴´�
	public void showImage(int id) {
		System.out.println(id+"���� ū �̹��� ����?");
		
		bigImage = kit.getImage(dir+path[id]);
		
		//�г��� �ٽ� �׸���
		p_canvas.repaint();
	}
	public static void main(String[] args) {
		new Gallery();
	}
}

