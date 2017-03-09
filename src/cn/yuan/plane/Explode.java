package cn.yuan.plane;

import java.awt.Graphics;
import java.awt.Image;

import cn.yuan.modelutil.GameUtil;

/**爆炸类
 * 
 * @author yuanzhixiangsuse
 *
 */
public class Explode {
	double x,y;
	static Image[] igms=new Image[9];
	static
	{
		for (int i = 0; i <9; i++) {
			igms[i]=GameUtil.getImage("explode/"+(i+1)+".gif");
			igms[i].getWidth(null);
		}
	}
	int count;
	public void draw(Graphics g) {
		if(count<=15)
		{
		g.drawImage(igms[count], (int)x, (int)y, null);
		count++;
		}
	}
	public  Explode(double x,double y) {
		this.x=x;
		this.y=y;
	}
}
