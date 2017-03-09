package cn.yuan.plane;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Date;

import cn.yuan.modelutil.GameUtil;
import cn.yuan.modelutil.MyFrame;

public class PlaneGameFrame extends MyFrame {
	private static final long serialVersionUID = 1L;
	Image bg;
	Plane plane;
	Explode explode=new Explode(50, 50);
	ArrayList<Bullet> bulletList;
	  Date startTime;
	  Date endTime;
	  int liveTime=0;
	protected PlaneGameFrame(String title) {
		super(title);
		bulletList = new ArrayList<Bullet>();
	
		plane = new Plane("images/plane.png", 50, 50);
		bg = GameUtil.getImage("images/bg8.jpg");
	}

	public static void main(String[] argc) {
		new PlaneGameFrame("战机游戏").launchFrame();
	}

	@Override
	public void launchFrame() {
		// TODO Auto-generated method stub
		super.launchFrame();
		// 添加键盘监听器
		addKeyListener(new KeyMonitor());
		// 生成一堆子弹
		for (int i = 0; i < 20; i++) {
			Bullet bullet = new Bullet();
			bulletList.add(bullet);
		}
		startTime=new Date();
	}

	@Override
	public void paint(Graphics g) {
		g.drawImage(bg, 0, 0, this.getWidth(), this.getHeight(), null);
		plane.draw(g);
		for (int i = 0; i < bulletList.size(); i++) {
			Bullet bullet = bulletList.get(i);
			bullet.draw(g);
			// 检测与飞机碰撞
			if (plane.isLive()) {
				if (bullet.getRect().intersects(plane.getRect())) {
					if(plane.getScore()==0)
					{
						plane.setLive(false);
						endTime=new Date();
						liveTime=(int)((endTime.getTime()-startTime.getTime())/1000);
						explode.draw(g);
					}	
					else
					{
						plane.setScore(plane.getScore()-1);
					}
				}
			} else {
				PrintGameInfo(g, "GameOver", 15,100,300,Color.red);
				PrintGameInfo(g, "共坚持时间:"+liveTime+"秒", 15,100,120,Color.green);
				switch (liveTime/10) {
				case 0:
				case 1:
					PrintGameInfo(g, "菜鸟:", 20,100,150,Color.green);
					break;
				case 2:
					PrintGameInfo(g, "小鸟:", 20,100,150,Color.green);
					break;
				case 3:
					PrintGameInfo(g, "大鸟:", 20,100,150,Color.green);
					break;
				case 4:
					PrintGameInfo(g, "鸟王子:", 20,100,150,Color.green);
					break;
				default:
					PrintGameInfo(g, "大神:", 20,100,150,Color.green);
					break;
				}
			}
			PrintGameInfo(g, "分数"+plane.getScore(), 15,100,100,Color.green);
		}
	}

	public void PrintGameInfo(Graphics g, String s, int size,int x,int y,Color color) {
		Font font = new Font("宋体", Font.BOLD, size);
		g.setFont(font);
		Color color1=g.getColor();
		g.setColor(color);
		g.drawString(s, x, y);
		g.setColor(color1);
	}

	// 定义为内部类，可以方便的访问外部类普通属性
	class KeyMonitor extends KeyAdapter {

		@Override
		public void keyPressed(KeyEvent e) {
			plane.SetDirection(e, true);
		}

		@Override
		public void keyReleased(KeyEvent e) {
			plane.SetDirection(e, false);
		}
	}

}
