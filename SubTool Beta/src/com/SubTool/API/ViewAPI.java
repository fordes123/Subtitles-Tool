package com.SubTool.API;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;
import javax.swing.plaf.basic.BasicScrollBarUI;
import javax.swing.text.BadLocationException;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;

import com.SubTool.Mod.Informations;
import com.SubTool.Mod.Replace;
import com.SubTool.Mod.Timeline;
import com.SubTool.UI.MainPanel;
import com.SubTool.UI.Message;
import com.SubTool.UI.Setting;
import com.SubTool.UI.Side;

public class ViewAPI {

	// 全局变量
	int first_x;
	int first_y;
	JFrame f;
	//public JTextPane jp;
	//public JLabel jl;
	
	
	public ViewAPI(JFrame f) {
		// TODO 自动生成的构造函数存根
		this.f=f;
	}
	
	
	
	
	
	
	// 读取主题配置
	public void SetTheme(Setting setting,DataAPI data,ColorAPI color,MainPanel MPanel,JFrame f) {
		
		if (setting.L2_j2.isSelected())// 判断主题混搭
		{// 开启

			// data.theme.sidecolor = color.RSC((String) setting.L2_j1.getSelectedItem());
			// data.theme.maincolor = (new Color(244, 244, 244,0));
			// 主题混搭开启

			if (setting.L2_j5.isSelected()) // 判断侧栏是否使用自定义颜色
				data.theme.sidecolor = setting.sidecolor;
			else
				data.theme.sidecolor = color.RSC((String) setting.L2_j3.getSelectedItem());
			if (setting.L2_j6.isSelected()) // 使用自定义颜色
			{
				data.theme.maincolor = setting.pancolor;
				// System.out.println("主界面自定义颜色"+data.theme.maincolor);
			} else 
				data.theme.maincolor = color.RMC((String) setting.L2_j4.getSelectedItem());
				
		} else {// 主题混搭未开启
			data.theme.sidecolor = color.RSC((String) setting.L2_j1.getSelectedItem());
			data.theme.maincolor = //color.RSC((String) setting.L2_j1.getSelectedItem());
					(new Color(244, 244, 244, 255));
		}

		// 字体颜色
		if (setting.L1_j4.isSelected())
			data.theme.fontcolor = setting.fontcolor;
		else
			data.theme.fontcolor = color.RFC((String) setting.L1_j3.getSelectedItem());

		// 字体风格
		data.theme.fontface = (String) setting.L1_j1.getSelectedItem();
		//System.out.println(data.theme.fontface);
		data.theme.fontsize = Integer.parseInt((String) setting.L1_j2.getSelectedItem());

		if (setting.L1_j6.isSelected()) {// 使用组合字体风格
			data.theme.Bold = setting.L1_j7.isSelected();
			data.theme.Italic = setting.L1_j8.isSelected();
			data.theme.Underline = setting.L1_j9.isSelected();
		} else// 不使用组合字体风格
		{
			switch ((String) setting.L1_j5.getSelectedItem()) {
			case "正常":
				data.theme.Bold = false;
				data.theme.Italic = false;
				data.theme.Underline = false;
				break;
			case "加粗":
				data.theme.Bold = true;
				data.theme.Italic = false;
				data.theme.Underline = false;
				break;
			case "斜体":
				data.theme.Bold = false;
				data.theme.Italic = true;
				data.theme.Underline = false;
				break;
			case "下划线":
				data.theme.Bold = false;
				data.theme.Italic = false;
				data.theme.Underline = true;
				break;
			default:
				data.theme.Bold = false;
				data.theme.Italic = false;
				data.theme.Underline = false;
				break;
			}
		}

		// 自定义背景图

		if (setting.L2_j7.isSelected()) {
			// 背景测试
			data.theme.maincolor = (new Color(244, 244, 244, 0));// 让主面板透明
			JPanel imagePanel = null;
			ImageIcon background;

			background = new ImageIcon(setting.bgfile.getPath());
			// (this.getClass().getClassLoader().getResource("/res/background_main.jpg"));//
			// 背景图片

			// ("C:\\Users\\Fordes\\Desktop\\1.png");
			JLabel label = new JLabel(background);// 把背景图片显示在一个标签里面
			// 置设置为图片刚好填充整个面板
			label.setBounds(MPanel.getX(), MPanel.getY(), background.getIconWidth(), background.getIconHeight());

			// 把内容窗格转化为JPanel，否则不能用方法setOpaque()来使内容窗格透明
			imagePanel = (JPanel) f.getContentPane();
			imagePanel.setOpaque(false);

			// 内容窗格默认的布局管理器为BorderLayout
			imagePanel.setLayout(new FlowLayout());
			f.getLayeredPane().setLayout(null);
			// 把背景图片添加到分层窗格的最底层作为背景
			f.getLayeredPane().add(label, new Integer(Integer.MIN_VALUE));
			// mf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		} else {
			// System.out.println("自定义背景关");
			// mf.getLayeredPane().add(mp, new Integer(Integer.MIN_VALUE));
		}

	}
	
	
	
	
	
	
	
	// 界面重载
	public void Refresh(DataAPI data, Side SidePanel, MainPanel MPanel,Informations st_Mod,Timeline Tl_Mod,Replace Re_Mod) {

		// SetTheme();
		if (data.theme.sidecolor == null || data.theme.maincolor == null || data.theme.fontcolor == null) {
			new Message(f, "主题载入错误，将重置为默认主题~", 2000).start();
			SidePanel.setBackground(new Color(49, 54, 56, 255));
			// t1.setBackground(new Color(49, 54, 56, 255));
			MPanel.setBackground(new Color(244, 244, 244, 255));
		} else {
			SidePanel.setBackground(data.theme.sidecolor);
			// t1.setBackground(theme.sidecolor);
			MPanel.setBackground(data.theme.maincolor);
			 //System.out.println(data.theme.maincolor);
		}
		//模块面板颜色
		st_Mod.setBackground(data.theme.sidecolor);
		Tl_Mod.setBackground(data.theme.sidecolor);
		Re_Mod.setBackground(data.theme.sidecolor);
		
		MPanel.jta.setText(""); // 清空
		// 字体风格
		Style def = MPanel.jta.getStyledDocument().addStyle(null, null);
		StyleConstants.setFontFamily(def, data.theme.fontface);// 获取字体
		StyleConstants.setFontSize(def, data.theme.fontsize);// 字体大小
		Style normal = MPanel.jta.addStyle("normal", def);
		Style face = MPanel.jta.addStyle("face", normal);

		StyleConstants.setForeground(face, data.theme.fontcolor);// 字体颜色

		StyleConstants.setBold(def, data.theme.Bold); // 字体加粗
		StyleConstants.setItalic(def, data.theme.Italic);// 字体倾斜
		StyleConstants.setUnderline(def, data.theme.Underline);// 下划线

		try {
			MPanel.jta.getDocument().insertString(MPanel.jta.getDocument().getLength(), data.subtitles, face);
		} catch (BadLocationException e1) {
			// TODO 自动生成的 catch 块
			e1.printStackTrace();
		}

		MPanel.jta.setCaretPosition(0); // 默认显示顶端
		// t1.setBackground(theme.sidecolor);

		MPanel.jsp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);// 水平滚动条隐藏
		MPanel.jsp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

	}

	// 封装函数以快速设置按钮图标
	public void setIcon(String file, JButton iconButton, int w, int h) {
		ImageIcon icon1 = new ImageIcon(ViewAPI.class.getResource(file));
		icon1.setImage(icon1.getImage().getScaledInstance(w, h, Image.SCALE_DEFAULT));
		iconButton.setIcon(icon1);
	}

	// 封装函数，给窗口加上一个自写的可拖动标题栏
	public void titlebar(JFrame f, int w, int h, int layer) {
		// System.out.println("◎");
		JPanel titlebar = new JPanel();
		titlebar.setOpaque(false);
		titlebar.setBounds(0, 0, w, h);
		f.getLayeredPane().add(titlebar, new Integer(layer)); // 设置层级
		f.add(titlebar);
		titlebar.addMouseMotionListener(new MouseMotionListener() {

			@Override
			public void mouseMoved(MouseEvent arg0) {
				// TODO 自动生成的方法存根

			}

			@Override
			// 重写mouseDragged鼠标拖动方法
			public void mouseDragged(MouseEvent e) {
				// TODO 自动生成的方法存根
				int x = e.getX() - first_x;
				int y = e.getY() - first_y; // 取得位移(x,y)
				f.setBounds(f.getX() + x, f.getY() + y, f.getWidth(), f.getHeight());
			}
		});

		titlebar.addMouseListener(new MouseListener() { // 设置点击任意位置关闭窗口

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO 自动生成的方法存根
			}

			@Override
			// 重写mousePressed鼠标停留方法
			public void mousePressed(MouseEvent e) {
				// TODO 自动生成的方法存根
				first_x = e.getX();
				first_y = e.getY(); // 记录下位移的初点
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO 自动生成的方法存根

			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO 自动生成的方法存根

			}

			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO 自动生成的方法存根
			}
		});
	}

	public void textSet(JTextField field) {
		field.setBackground(new Color(255, 255, 255));
		field.setOpaque(false);
		field.setPreferredSize(new Dimension(150, 28));
		MatteBorder border = new MatteBorder(0, 0, 2, 0, new Color(250, 60, 19));
		field.setBorder(border);
	}

	// 重写TextField,添加圆角，同时于左侧添加一个图标，参数1为圆角弧度，2为图标
	public class UserTextField extends JTextField {
		private static final long serialVersionUID = -1946802815417758252L;
		private ImageIcon icon;

		public UserTextField(int columns, ImageIcon temp) {
			super(columns);
			icon = temp;
			setMargin(new Insets(0, 5, 0, 5));
			Insets insets = new Insets(0, 40, 0, 0);
			// 设置文本输入距左边20
			this.setMargin(insets);
		}

		@Override
		protected void paintBorder(Graphics g) {
			int h = getHeight();// 从JComponent类获取高宽
			int w = getWidth();
			Graphics2D g2d = (Graphics2D) g.create();
			Shape shape = g2d.getClip();
			g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
			g2d.setClip(shape);
			g2d.drawRoundRect(0, 0, w - 2, h - 2, h, h);
			g2d.dispose();
			super.paintBorder(g2d);
		}

		@Override
		public void paintComponent(Graphics g) {
			Insets insets = getInsets();
			super.paintComponent(g);
			int iconWidth = icon.getIconWidth();
			int iconHeight = icon.getIconHeight();
			int Height = this.getHeight();
			// 在文本框中画上之前图片
			icon.paintIcon(this, g, (insets.left - iconWidth) / 2, (Height - iconHeight) / 2);
		}
	}

	public class BackgroundPanel extends JPanel {

		private static final long serialVersionUID = 1L;
		// String name = "01.JPG"; // 将图片放在class类的同级文件夹里

		protected void paintComponent(Graphics g) { // 关键代码：重写绘制组件外观
			super.paintComponent(g);
			ImageIcon image = new ImageIcon(ViewAPI.class.getResource("/res/pan_main.jpg")); // 获取图片路径
			g.drawImage(image.getImage(), 0, 0, image.getIconWidth(), image.getIconHeight(), null);// 绘制图片与组件大小相同
		}
	}

	// ==========================================自定义滚动条UI==========================================================
	public class DemoScrollBarUI extends BasicScrollBarUI {

		@Override
		protected void configureScrollBarColors() {

			// 把手

			// thumbColor = Color.GRAY;

			// thumbHighlightColor = Color.BLUE;

			// thumbDarkShadowColor = Color.BLACK;

			// thumbLightShadowColor = Color.YELLOW;

			// 滑道

			trackColor = Color.black;

			setThumbBounds(0, 0, 3, 10);

			// trackHighlightColor = Color.GREEN;

		}

		/**
		 * 设置滚动条的宽度
		 */

		@Override
		public Dimension getPreferredSize(JComponent c) {

			// TODO Auto-generated method stub

			c.setPreferredSize(new Dimension(20, 0));

			return super.getPreferredSize(c);

		}

		// 重绘滑块的滑动区域背景

		public void paintTrack(Graphics g, JComponent c, Rectangle trackBounds) {

			Graphics2D g2 = (Graphics2D) g;

			GradientPaint gp = null;

			// 判断滚动条是垂直的 还是水平的

			if (this.scrollbar.getOrientation() == JScrollBar.VERTICAL) {

				// 设置画笔

				gp = new GradientPaint(0, 0, new Color(255, 255, 255, 0),

						trackBounds.width, 0, new Color(255, 255, 255, 0));

			}

			if (this.scrollbar.getOrientation() == JScrollBar.HORIZONTAL) {

				gp = new GradientPaint(0, 0, new Color(255, 255, 255, 0),

						trackBounds.height, 0, new Color(255, 255, 255, 0));

			}

			g2.setPaint(gp);

			// 填充Track

			g2.fillRect(trackBounds.x, trackBounds.y, trackBounds.width,

					trackBounds.height);

			// 绘制Track的边框
			/*
			 * g2.setColor(new Color(175, 155, 95)); g2.drawRect(trackBounds.x,
			 * trackBounds.y, trackBounds.width - 1, trackBounds.height - 1);
			 */

			if (trackHighlight == BasicScrollBarUI.DECREASE_HIGHLIGHT)

				this.paintDecreaseHighlight(g);

			if (trackHighlight == BasicScrollBarUI.INCREASE_HIGHLIGHT)

				this.paintIncreaseHighlight(g);

		}

		@Override
		protected void paintThumb(Graphics g, JComponent c, Rectangle thumbBounds) {

			// 把绘制区的x，y点坐标定义为坐标系的原点

			// 这句一定一定要加上啊，不然拖动就失效了

			g.translate(thumbBounds.x, thumbBounds.y);

			// 设置把手颜色

			g.setColor(new Color(80, 80, 80));

			// 画一个圆角矩形

			// 这里面前四个参数就不多讲了，坐标和宽高

			// 后两个参数需要注意一下，是用来控制角落的圆角弧度

			// g.drawRoundRect(0, 0, 5, thumbBounds.height - 1, 5, 5);

			// 消除锯齿

			Graphics2D g2 = (Graphics2D) g;

			RenderingHints rh = new RenderingHints(RenderingHints.KEY_ANTIALIASING,

					RenderingHints.VALUE_ANTIALIAS_ON);

			g2.addRenderingHints(rh);

			// 半透明

			g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER,

					0.5f));

			// 设置填充颜色，这里设置了渐变，由下往上

			// g2.setPaint(new GradientPaint(c.getWidth() / 2, 1, Color.GRAY,

			// c.getWidth() / 2, c.getHeight(), Color.GRAY));

			// 填充圆角矩形

			g2.fillRoundRect(0, 0, 40, thumbBounds.height - 1, 5, 5);

		}

		/**
		 * 创建滚动条上方的按钮
		 */

		protected JButton createIncreaseButton(int orientation) {

			JButton button = new JButton();

			button.setBorderPainted(false);

			button.setContentAreaFilled(false);

			button.setBorder(null);

			return button;

		}

		/**
		 * 创建滚动条下方的按钮
		 */

		protected JButton createDecreaseButton(int orientation) {

			JButton button = new JButton();

			button.setBorderPainted(false);

			button.setContentAreaFilled(false);

			button.setFocusable(false);

			button.setBorder(null);

			return button;

		}

	}

}
