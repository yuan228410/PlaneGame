package cn.yuan.plane;

import java.awt.Color;
import java.awt.Graphics;

import cn.yuan.modelutil.Constant;

public class Bullet extends GameObject{
	double degree;
	public Bullet() {
		degree=Math.random()*Math.PI*2;
		x=Constant.FRAME_WIDETH/2;
		y=Constant.FRAME_HIGHTH/2;
		width=10;
		height=10;
		speed=3;
	}
	public void draw(Graphics g) {
		Color color=g.getColor();
		g.setColor(Color.yellow);
		g.fillOval((int)x, (int)y, width, height);
		x+=speed*Math.cos(degree);
		y+=speed*Math.sin(degree);
		if(y>Constant.FRAME_HIGHTH-height || y<height)
		{
			degree=-degree;
		}
		if(x<width || x>Constant.FRAME_WIDETH-width)
		{
			degree=Math.PI-degree;
		}
		g.setColor(color);
	}

}
