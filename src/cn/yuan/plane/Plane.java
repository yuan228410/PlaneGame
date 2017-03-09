package cn.yuan.plane;

import java.awt.Graphics;
import java.awt.event.KeyEvent;

import cn.yuan.modelutil.GameUtil;

public class Plane extends GameObject {
	private boolean left,up,right,down;
	private boolean live=true;
    private int score=100;
 
	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public boolean isLive() {
		return live;
	}

	public void setLive(boolean live) {
		this.live = live;
	}

	public Plane(String imgPath, double x, double y) {
		this.speed=10;
		this.img = GameUtil.getImage(imgPath);
		this.width=img.getWidth(null);
		this.height=img.getHeight(null);
		this.x = x;
		this.y = y;
	}

	public Plane() {
	}
	public void draw(Graphics g) {
		if(live)
		{
		g.drawImage(img, (int) x, (int) y, null);
		move();
		}
	}

	 void move() {
		if(left)
		{
			x-=speed;
		}
		if(right)
		{
			x+=speed;
		}
		if(up)
		{
			y-=speed;
		}
		if(down)
		{
			y+=speed;
		}
	}
	public void SetDirection(KeyEvent e,boolean isPress) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_LEFT:
			left=isPress;
			break;
		case KeyEvent.VK_RIGHT:
			right=isPress;
			break;
		case KeyEvent.VK_UP:
			up=isPress;
			break;
		case KeyEvent.VK_DOWN:
			down=isPress;
			break;
		default:
			break;
		}
	}
}
