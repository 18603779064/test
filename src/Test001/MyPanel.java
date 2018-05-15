package Test001;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Panel;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * �̳�Panel�࣬Panel��Java�е�����ࡣ������Ҫ�������嶼��̳д���
 *
 */
public class MyPanel extends Panel implements Runnable,KeyListener{
	int x[] = new int[10];//���������ĸx��
	int y[] = new int[10];//���������ĸy��
	char c[] = new char[10];//���������ĸ
	int integral =1000;//��ʼ1000����
	Color p[] =new Color[10];//�����洢��ɫ
	public MyPanel() {
		for (int i = 0; i < 10; i++) {
			x[i]=(int)(Math.random()*300);
			y[i]=(int)(Math.random()*50);
			c[i]=(char)(Math.random()*26+97);
			p[i]=getRandColorCode();//�����ɫ
		}
	}
	/**
	 * ��дPanel���paint����
	 */
	public void paint(Graphics g) {
		if (integral>0) {//����ɼ�>0�����ܽ���
			for (int i = 0; i < 10; i++) {
				g.setColor(p[i]);//����Ԫ����ɫ
				g.setFont(new Font("TimesRoman", Font.PLAIN, 20)); //�������壬��С
				//1.���ֵ�Ԫ�أ�2.Ԫ�ص�x�ᣬ3.Ԫ�ص�y��
				g.drawString(new Character(c[i]).toString().toUpperCase(),x[i],y[i]);
			}   
			//��ʾ��������Ļ��
			g.setColor(Color.red);
			g.setFont(new Font("TimesRoman", Font.PLAIN, 20)); 
			g.drawString("��ĳɼ��ǣ�"+integral, 5, 15);
		}else {//�ɼ�<0,��Ϸ����
			g.setColor(Color.red);
			g.setFont(new Font("TimesRoman", Font.PLAIN, 30)); 
			g.drawString("GAME OVER", 50, 170);
		}
	}
	//��дrun����
	public void run() {
		while (integral>0) {//���ѭ���������߳�
			for (int i = 0; i < 10; i++) {
				y[i]++;//��ĸ��y�� ��1���������ƶ�1��λ��
				if (y[i]>370) {//����߿�ռ��һ�������أ���������370����
					y[i]=0;
					x[i]=(int)(Math.random()*300);
					c[i]=(char)(Math.random()*26+97);
					integral-=100;//����-100
				}
				try {
					Thread.sleep(5);//��ͣ5����
				} catch (InterruptedException e) {}
				repaint();//���»��ƻ���
			}
		}
	}
	
	//����¼��
	public void keyPressed(KeyEvent e) {
		char keyC = e.getKeyChar();
		int stat=-1;//�洢��������ĸ��ֵ
		int nowIndex=-1;//�洢��������ĸ���±�
		for (int i = 0; i < 10; i++) {
			if (keyC==c[i]) {
				if (y[i]>stat) {//��һ�ν���ʱ���ض����ڣ�
					stat=y[i];//��¼����ֵ
					nowIndex=i;//��¼��ĸ���±�
				}
			}
		}
		if (nowIndex!=-1) {
//�����=-1��֤������ˡ�nowIndexΪ���������ĸ���±꣬�������ɡ�����+100
			y[nowIndex]=0;
			x[nowIndex]=(int)(Math.random()*300);
			c[nowIndex]=(char)(Math.random()*26+97);
			integral+=100;//����+100
		}else {//���==-1��֤������ˡ�����-100
			integral-=100;//����-100
		}
		
	}
	
	/** 
     * ��ȡʮ�����Ƶ���ɫ����.����  "#6E36B4" ,
     * @return String 
     */  
	public static Color getRandColorCode(){  
		 int r,b,g;
		 r=(int)(Math.random()*250);
		 b=(int)(Math.random()*250);
		 g=(int)(Math.random()*250);
		  Color c =new Color(r, b, g);
	  return c;  
	 }
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
}
