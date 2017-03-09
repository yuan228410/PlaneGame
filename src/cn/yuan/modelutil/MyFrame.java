package cn.yuan.modelutil;

import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MyFrame extends Frame {
	private static final long serialVersionUID = 1L;
	private Image iBuffer;
	private Graphics gBuffer;

	protected MyFrame(String title) {
		super(title);
	}

	public void launchFrame() {
		this.setSize(Constant.FRAME_WIDETH, Constant.FRAME_HIGHTH);
		this.setLocation(100, 4);
		this.setVisible(true);
		// 设置监听，关闭窗口
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		new FrameThread().start();// 开启线程
	}

	// JAVA双缓冲 ，防止屏幕闪烁
	public void update(Graphics scr) {
		if (iBuffer == null) {
			iBuffer = createImage(this.getSize().width, this.getSize().height);
			gBuffer = iBuffer.getGraphics();
		}
		gBuffer.setColor(getBackground());
		gBuffer.fillRect(0, 0, this.getSize().width, this.getSize().height);
		paint(gBuffer);
		scr.drawImage(iBuffer, 0, 0, this);
	}

	/**
	 * 
	 * 重画！！
	 * 
	 */
	class FrameThread extends Thread {
		public void run() {
			while (true) {// 死循环，不断重画
				repaint();
				try {
					Thread.sleep(40);// 间隔40ms画
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

}