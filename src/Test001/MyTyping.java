package Test001;

import java.awt.Frame;

public class MyTyping {
	/**
	 ˼·��
	  1.һ������
	  2.�ڴ������Ԫ�أ�������ֵ���ĸ��
	  3.�����̣߳�ʵ�ֶ�̬Ч������ĸ��׹��
	  4.�Ż��̣߳���ĸ����������������������ɣ�
	  5.��������¼�
	  6.�����������������
	  7.ƥ�����¼����ĸ����Ļ�ϵ���ĸ
	  	һ�£����������Ҵ���������������.����+
	  	��һ�£�������������-
	  	û¼�룺������������-
	  8.����<0,��Ϸ����
	 	���Ĵ������ô�࣬��ϰ��ϰ�߼��ͺ��ˣ����ĵĿ��Գ����Ż��£�
	 */
	public static void main(String[] args) {
		Frame f = new Frame();//����һ������
		f.setLocationRelativeTo(null);//��������
		f.setSize(300, 400);//���ô����С
		MyPanel p = new MyPanel();
		f.add(p);//��Ԫ�ط��봰����
		f.addKeyListener(p);//ע������¼�
		p.addKeyListener(p);//ע������¼�
		Thread t = new Thread(p);
		t.start();
		//f.show();//��ʾ���壬������ʱ
		f.setVisible(true);//��ʾ����
		
		
	}
	
}
